package org.opencb.biodata.tools.variant.stats;

import org.opencb.biodata.models.feature.AllelesCode;
import org.opencb.biodata.models.feature.Genotype;
import org.opencb.biodata.models.pedigree.Condition;
import org.opencb.biodata.models.pedigree.Individual;
import org.opencb.biodata.models.pedigree.Pedigree;
import org.opencb.biodata.models.variant.StudyEntry;
import org.opencb.biodata.models.variant.Variant;
import org.opencb.biodata.models.variant.stats.VariantStats;

import java.util.*;

/**
 * Created by jmmut on 2015-08-25.
 *
 * @author Jose Miguel Mut Lopez &lt;jmmut@ebi.ac.uk&gt;
 */
public class VariantStatsCalculator {

    public static void calculate(StudyEntry entry, Map<String, String> attributes,
                                 Pedigree pedigree, VariantStats variantStats) {
        calculate(entry, entry.getSamplesName(), attributes, pedigree, variantStats);
    }

    public static void calculate(StudyEntry study, Collection<String> sampleNames, Map<String, String> attributes,
                                 Pedigree pedigree, VariantStats variantStats) {
        int[] allelesCount = new int[2];
        int totalAllelesCount = 0, totalGenotypesCount = 0;

        float controlsDominant = 0, casesDominant = 0;
        float controlsRecessive = 0, casesRecessive = 0;

        variantStats.setNumSamples(sampleNames.size());
        variantStats.setMissingAlleles(0);
        variantStats.setMissingGenotypes(0);
        if (pedigree != null) {
            variantStats.setMendelianErrors(0);
        }

        Integer gtIdx = study.getFormatPositions().get("GT");
        LinkedHashMap<String, Integer> samplesPosition = study.getSamplesPosition();

        Map<String, Genotype> gts = new TreeMap<>(String::compareTo);
        for (String sampleName : sampleNames) {
            Integer sampleIdx = samplesPosition.get(sampleName);
            if (sampleIdx == null) {
                continue;
            }
            String genotype = study.getSamplesData().get(sampleIdx).get(gtIdx);
            Genotype g = gts.get(genotype);
            if (g == null) {
                g = new Genotype(genotype, variantStats.getRefAllele(), variantStats.getAltAllele());
                gts.put(genotype, g);
            }
//            String genotype = study.getSampleData(sampleName, "GT");
//            Genotype g = new Genotype(genotype, variantStats.getRefAllele(), variantStats.getAltAllele());
            variantStats.addGenotype(g, 1, false);

            // Check missing alleles and genotypes
            switch (g.getCode()) {
                case ALLELES_OK:
                    for (int i = 0; i < g.getPloidy(); i++) {
                        allelesCount[g.getAllele(i)]++;
                    }

                    totalAllelesCount += g.getPloidy();
                    totalGenotypesCount++;

                    // Counting genotypes for Hardy-Weinberg (all phenotypes)
                    //FIXME//FIXME//FIXME//FIXME
//                    if (g.isAlleleRef(0) && g.isAlleleRef(1)) { // 0|0
//                        variantStats.getHw().incN_AA();
//                    } else if ((g.isAlleleRef(0) && g.getAllele(1) == 1) || (g.getAllele(0) == 1 && g.isAlleleRef(1))) {  // 0|1, 1|0
//                        variantStats.getHw().incN_Aa();
//
//                    } else if (g.getAllele(0) == 1 && g.getAllele(1) == 1) {
//                        variantStats.getHw().incN_aa();
//                    }

                    break;
                case MULTIPLE_ALTERNATES:
                    // Alternate with different "index" than the one that is being handled
                    break;
                case ALLELES_MISSING:
                    // Missing genotype (one or both alleles missing)
                    variantStats.setMissingGenotypes(variantStats.getMissingGenotypes() + 1);
                    for (int i = 0; i < g.getPloidy(); i++) {
                        if (g.getAllele(i) < 0) {
                            variantStats.setMissingAlleles(variantStats.getMissingAlleles() + 1);
                        } else {
                            allelesCount[g.getAllele(i)]++;
                            totalAllelesCount++;
                        }
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Unknown allele code " + g.getCode());
            }

            // Include statistics that depend on pedigree information
            if (pedigree != null) {
                if (g.getCode() == AllelesCode.ALLELES_OK) {
                    Individual ind = pedigree.getIndividual(sampleName);
//                    if (MendelChecker.isMendelianError(ind, g, variant.getChromosome(), file.getSamplesDataAsMap())) {
//                        this.setMendelianErrors(this.getMendelianErrors() + 1);
//                    }
                    if (g.getCode() == AllelesCode.ALLELES_OK) {
                        // Check inheritance models
                        if (ind.getCondition() == Condition.UNAFFECTED) {
                            if (g.isAlleleRef(0) && g.isAlleleRef(1)) { // 0|0
                                controlsDominant++;
                                controlsRecessive++;

                            } else if ((g.isAlleleRef(0) && !g.isAlleleRef(1)) || (!g.isAlleleRef(0) || g.isAlleleRef(1))) { // 0|1 or 1|0
                                controlsRecessive++;

                            }
                        } else if (ind.getCondition() == Condition.AFFECTED) {
                            if (!g.isAlleleRef(0) && !g.isAlleleRef(1) && g.getAllele(0) == g.getAllele(1)) {// 1|1, 2|2, and so on
                                casesRecessive++;
                                casesDominant++;
                            } else if (!g.isAlleleRef(0) || !g.isAlleleRef(1)) { // 0|1, 1|0, 1|2, 2|1, 1|3, and so on
                                casesDominant++;

                            }
                        }

                    }
                }
            }

        }  // Finish all samples loop

        // Set counts for each allele
        variantStats.setRefAlleleCount(allelesCount[0]);
        variantStats.setAltAlleleCount(allelesCount[1]);

        // Calculate MAF and MGF
        calculateAlleleFrequencies(totalAllelesCount, variantStats);
        calculateGenotypeFrequencies(totalGenotypesCount, variantStats);

        // Calculate Hardy-Weinberg statistic       //FIXME
//        variantStats.getHw().calculate();

        // Update variables finally used to update file_stats_t structure
        if ("PASS".equalsIgnoreCase(attributes.get("FILTER"))) {
            variantStats.setPassedFilters(true);
        }

        if (attributes.containsKey("QUAL") && !(".").equals(attributes.get("QUAL"))) {
            float qualAux = Float.valueOf(attributes.get("QUAL"));
            if (qualAux >= 0) {
                variantStats.setQuality(qualAux);
            }
        }

        if (pedigree != null) {
            // Once all samples have been traversed, calculate % that follow inheritance model
            controlsDominant = controlsDominant * 100 / (variantStats.getNumSamples() - variantStats.getMissingGenotypes());
            casesDominant = casesDominant * 100 / (variantStats.getNumSamples() - variantStats.getMissingGenotypes());
            controlsRecessive = controlsRecessive * 100 / (variantStats.getNumSamples() - variantStats.getMissingGenotypes());
            casesRecessive = casesRecessive * 100 / (variantStats.getNumSamples() - variantStats.getMissingGenotypes());

            variantStats.setCasesPercentDominant(casesDominant);
            variantStats.setControlsPercentDominant(controlsDominant);
            variantStats.setCasesPercentRecessive(casesRecessive);
            variantStats.setControlsPercentRecessive(controlsRecessive);
        }
    }

    /**
     * Calculates the statistics for some variants read from a set of files, and
     * optionally given pedigree information. Some statistics like inheritance
     * patterns can only be calculated if pedigree information is provided.
     *
     * @param variants The variants whose statistics will be calculated
     * @param ped Optional pedigree information to calculate some statistics
     */
    public static void calculateStatsForVariantsList(List<Variant> variants, Pedigree ped) {
        for (Variant variant : variants) {
            for (StudyEntry entry : variant.getStudies()) {
                VariantStats stats = new VariantStats(variant);
                calculate(entry, entry.getAttributes(), ped, stats);
                entry.setStats(StudyEntry.DEFAULT_COHORT, stats);
            }
        }
    }

    private static void calculateAlleleFrequencies(int totalAllelesCount, VariantStats variantStats) {
        if (totalAllelesCount < 0) {
            throw new IllegalArgumentException("The number of alleles must be equals or greater than zero");
        }

        if (totalAllelesCount == 0) {
            // Nothing to calculate here
            variantStats.setMaf((float) -1);
            variantStats.setMafAllele(null);
            return;
        }

        variantStats.setRefAlleleFreq(variantStats.getRefAlleleCount() / (float) totalAllelesCount);
        variantStats.setAltAlleleFreq(variantStats.getAltAlleleCount() / (float) totalAllelesCount);

        if (variantStats.getRefAlleleFreq() <= variantStats.getAltAlleleFreq()) {
            variantStats.setMaf(variantStats.getRefAlleleFreq());
            variantStats.setMafAllele(variantStats.getRefAllele());
        } else {
            variantStats.setMaf(variantStats.getAltAlleleFreq());
            variantStats.setMafAllele(variantStats.getAltAllele());
        }
    }

    private static void calculateGenotypeFrequencies(int totalGenotypesCount, VariantStats variantStats) {
        if (totalGenotypesCount < 0) {
            throw new IllegalArgumentException("The number of genotypes must be equals or greater than zero");
        }

        if (variantStats.getGenotypesCount().isEmpty() || totalGenotypesCount == 0) {
            // Nothing to calculate here
            variantStats.setMgf((float) -1);
            variantStats.setMgfGenotype(null);
            return;
        }

        // Set all combinations of genotypes to zero
        Map<Genotype, Float> genotypesFreq = variantStats.getGenotypesFreq();
        genotypesFreq.put(new Genotype("0/0", variantStats.getRefAllele(), variantStats.getAltAllele()), 0.0f);
        genotypesFreq.put(new Genotype("0/1", variantStats.getRefAllele(), variantStats.getAltAllele()), 0.0f);
        genotypesFreq.put(new Genotype("1/1", variantStats.getRefAllele(), variantStats.getAltAllele()), 0.0f);

        // Insert the genotypes found in the file
        for (Map.Entry<Genotype, Integer> gtCount : variantStats.getGenotypesCount().entrySet()) {
            if (gtCount.getKey().getCode() == AllelesCode.ALLELES_MISSING) {
                // Missing genotypes shouldn't have frequencies calculated
                continue;
            }

            float freq = gtCount.getValue() /  (float) totalGenotypesCount;
            genotypesFreq.put(gtCount.getKey(), freq);
        }

        // Traverse the genotypes to see which one has the MGF
        float currMgf = Float.MAX_VALUE;
        Genotype currMgfGenotype = null;

        for (Map.Entry<Genotype, Float> gtCount : genotypesFreq.entrySet()) {
            float freq = gtCount.getValue();
            if (freq < currMgf) {
                currMgf = freq;
                currMgfGenotype = gtCount.getKey();
            }
        }

        if (currMgfGenotype != null) {
            variantStats.setMgf(currMgf);
            variantStats.setMgfGenotype(currMgfGenotype.toString());
        }
    }


}
