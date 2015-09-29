/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package org.opencb.biodata.models.variant.avro;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class VariantSourceEntry extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"VariantSourceEntry\",\"namespace\":\"org.opencb.biodata.models.variant.avro\",\"fields\":[{\"name\":\"studyId\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}]},{\"name\":\"fileId\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}]},{\"name\":\"secondaryAlternates\",\"type\":[\"null\",{\"type\":\"array\",\"items\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}],\"default\":null},{\"name\":\"formatList\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}},{\"name\":\"samplesDataList\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"array\",\"items\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}}},{\"name\":\"stats\",\"type\":{\"type\":\"map\",\"values\":{\"type\":\"record\",\"name\":\"VariantStats\",\"fields\":[{\"name\":\"refAllele\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}]},{\"name\":\"altAllele\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}]},{\"name\":\"refAlleleCount\",\"type\":[\"null\",\"int\"]},{\"name\":\"altAlleleCount\",\"type\":[\"null\",\"int\"]},{\"name\":\"genotypesCount\",\"type\":{\"type\":\"map\",\"values\":\"int\",\"avro.java.string\":\"String\"}},{\"name\":\"genotypesFreq\",\"type\":{\"type\":\"map\",\"values\":\"float\",\"avro.java.string\":\"String\"}},{\"name\":\"missingAlleles\",\"type\":[\"null\",\"int\"]},{\"name\":\"missingGenotypes\",\"type\":[\"null\",\"int\"]},{\"name\":\"refAlleleFreq\",\"type\":[\"null\",\"float\"]},{\"name\":\"altAlleleFreq\",\"type\":[\"null\",\"float\"]},{\"name\":\"maf\",\"type\":[\"null\",\"float\"]},{\"name\":\"mgf\",\"type\":[\"null\",\"float\"]},{\"name\":\"mafAllele\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}]},{\"name\":\"mgfGenotype\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}]},{\"name\":\"passedFilters\",\"type\":[\"null\",\"boolean\"]},{\"name\":\"mendelianErrors\",\"type\":[\"null\",\"int\"]},{\"name\":\"casesPercentDominant\",\"type\":[\"null\",\"float\"]},{\"name\":\"controlsPercentDominant\",\"type\":[\"null\",\"float\"]},{\"name\":\"casesPercentRecessive\",\"type\":[\"null\",\"float\"]},{\"name\":\"controlsPercentRecessive\",\"type\":[\"null\",\"float\"]},{\"name\":\"quality\",\"type\":[\"null\",\"float\"]},{\"name\":\"numSamples\",\"type\":[\"null\",\"int\"]},{\"name\":\"variantType\",\"type\":{\"type\":\"enum\",\"name\":\"VariantType\",\"doc\":\"* Type of variation, which depends mostly on its length.\\r\\n     * <ul>\\r\\n     * <li>SNVs involve a single nucleotide, without changes in length</li>\\r\\n     * <li>MNVs involve multiple nucleotides, without changes in length</li>\\r\\n     * <li>Indels are insertions or deletions of less than SV_THRESHOLD (50) nucleotides</li>\\r\\n     * <li>Structural variations are large changes of more than SV_THRESHOLD nucleotides</li>\\r\\n     * <li>Copy-number variations alter the number of copies of a region</li>\\r\\n     * </ul>\",\"symbols\":[\"SNP\",\"SNV\",\"MNP\",\"MNV\",\"INDEL\",\"SV\",\"CNV\",\"NO_VARIATION\",\"SYMBOLIC\",\"MIXED\"]}},{\"name\":\"hw\",\"type\":{\"type\":\"record\",\"name\":\"VariantHardyWeinbergStats\",\"fields\":[{\"name\":\"chi2\",\"type\":[\"null\",\"float\"]},{\"name\":\"pValue\",\"type\":[\"null\",\"float\"]},{\"name\":\"n\",\"type\":[\"null\",\"int\"]},{\"name\":\"n_AA_11\",\"type\":[\"null\",\"int\"]},{\"name\":\"n_Aa_10\",\"type\":[\"null\",\"int\"]},{\"name\":\"n_aa_00\",\"type\":[\"null\",\"int\"]},{\"name\":\"e_AA_11\",\"type\":[\"null\",\"float\"]},{\"name\":\"e_Aa_10\",\"type\":[\"null\",\"float\"]},{\"name\":\"e_aa_00\",\"type\":[\"null\",\"float\"]},{\"name\":\"p\",\"type\":[\"null\",\"float\"]},{\"name\":\"q\",\"type\":[\"null\",\"float\"]}]}}]},\"avro.java.string\":\"String\"}},{\"name\":\"attributes\",\"type\":{\"type\":\"map\",\"values\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"avro.java.string\":\"String\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
   private java.lang.String studyId;
   private java.lang.String fileId;
   private java.util.List<java.lang.String> secondaryAlternates;
   private java.util.List<java.lang.String> formatList;
   private java.util.List<java.util.List<java.lang.String>> samplesDataList;
   private java.util.Map<java.lang.String,org.opencb.biodata.models.variant.avro.VariantStats> stats;
   private java.util.Map<java.lang.String,java.lang.String> attributes;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public VariantSourceEntry() {}

  /**
   * All-args constructor.
   */
  public VariantSourceEntry(java.lang.String studyId, java.lang.String fileId, java.util.List<java.lang.String> secondaryAlternates, java.util.List<java.lang.String> formatList, java.util.List<java.util.List<java.lang.String>> samplesDataList, java.util.Map<java.lang.String,org.opencb.biodata.models.variant.avro.VariantStats> stats, java.util.Map<java.lang.String,java.lang.String> attributes) {
    this.studyId = studyId;
    this.fileId = fileId;
    this.secondaryAlternates = secondaryAlternates;
    this.formatList = formatList;
    this.samplesDataList = samplesDataList;
    this.stats = stats;
    this.attributes = attributes;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return studyId;
    case 1: return fileId;
    case 2: return secondaryAlternates;
    case 3: return formatList;
    case 4: return samplesDataList;
    case 5: return stats;
    case 6: return attributes;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: studyId = (java.lang.String)value$; break;
    case 1: fileId = (java.lang.String)value$; break;
    case 2: secondaryAlternates = (java.util.List<java.lang.String>)value$; break;
    case 3: formatList = (java.util.List<java.lang.String>)value$; break;
    case 4: samplesDataList = (java.util.List<java.util.List<java.lang.String>>)value$; break;
    case 5: stats = (java.util.Map<java.lang.String,org.opencb.biodata.models.variant.avro.VariantStats>)value$; break;
    case 6: attributes = (java.util.Map<java.lang.String,java.lang.String>)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'studyId' field.
   */
  public java.lang.String getStudyId() {
    return studyId;
  }

  /**
   * Sets the value of the 'studyId' field.
   * @param value the value to set.
   */
  public void setStudyId(java.lang.String value) {
    this.studyId = value;
  }

  /**
   * Gets the value of the 'fileId' field.
   */
  public java.lang.String getFileId() {
    return fileId;
  }

  /**
   * Sets the value of the 'fileId' field.
   * @param value the value to set.
   */
  public void setFileId(java.lang.String value) {
    this.fileId = value;
  }

  /**
   * Gets the value of the 'secondaryAlternates' field.
   */
  public java.util.List<java.lang.String> getSecondaryAlternates() {
    return secondaryAlternates;
  }

  /**
   * Sets the value of the 'secondaryAlternates' field.
   * @param value the value to set.
   */
  public void setSecondaryAlternates(java.util.List<java.lang.String> value) {
    this.secondaryAlternates = value;
  }

  /**
   * Gets the value of the 'formatList' field.
   */
  public java.util.List<java.lang.String> getFormatList() {
    return formatList;
  }

  /**
   * Sets the value of the 'formatList' field.
   * @param value the value to set.
   */
  public void setFormatList(java.util.List<java.lang.String> value) {
    this.formatList = value;
  }

  /**
   * Gets the value of the 'samplesDataList' field.
   */
  public java.util.List<java.util.List<java.lang.String>> getSamplesDataList() {
    return samplesDataList;
  }

  /**
   * Sets the value of the 'samplesDataList' field.
   * @param value the value to set.
   */
  public void setSamplesDataList(java.util.List<java.util.List<java.lang.String>> value) {
    this.samplesDataList = value;
  }

  /**
   * Gets the value of the 'stats' field.
   */
  public java.util.Map<java.lang.String,org.opencb.biodata.models.variant.avro.VariantStats> getStats() {
    return stats;
  }

  /**
   * Sets the value of the 'stats' field.
   * @param value the value to set.
   */
  public void setStats(java.util.Map<java.lang.String,org.opencb.biodata.models.variant.avro.VariantStats> value) {
    this.stats = value;
  }

  /**
   * Gets the value of the 'attributes' field.
   */
  public java.util.Map<java.lang.String,java.lang.String> getAttributes() {
    return attributes;
  }

  /**
   * Sets the value of the 'attributes' field.
   * @param value the value to set.
   */
  public void setAttributes(java.util.Map<java.lang.String,java.lang.String> value) {
    this.attributes = value;
  }

  /** Creates a new VariantSourceEntry RecordBuilder */
  public static org.opencb.biodata.models.variant.avro.VariantSourceEntry.Builder newBuilder() {
    return new org.opencb.biodata.models.variant.avro.VariantSourceEntry.Builder();
  }
  
  /** Creates a new VariantSourceEntry RecordBuilder by copying an existing Builder */
  public static org.opencb.biodata.models.variant.avro.VariantSourceEntry.Builder newBuilder(org.opencb.biodata.models.variant.avro.VariantSourceEntry.Builder other) {
    return new org.opencb.biodata.models.variant.avro.VariantSourceEntry.Builder(other);
  }
  
  /** Creates a new VariantSourceEntry RecordBuilder by copying an existing VariantSourceEntry instance */
  public static org.opencb.biodata.models.variant.avro.VariantSourceEntry.Builder newBuilder(org.opencb.biodata.models.variant.avro.VariantSourceEntry other) {
    return new org.opencb.biodata.models.variant.avro.VariantSourceEntry.Builder(other);
  }
  
  /**
   * RecordBuilder for VariantSourceEntry instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<VariantSourceEntry>
    implements org.apache.avro.data.RecordBuilder<VariantSourceEntry> {

    private java.lang.String studyId;
    private java.lang.String fileId;
    private java.util.List<java.lang.String> secondaryAlternates;
    private java.util.List<java.lang.String> formatList;
    private java.util.List<java.util.List<java.lang.String>> samplesDataList;
    private java.util.Map<java.lang.String,org.opencb.biodata.models.variant.avro.VariantStats> stats;
    private java.util.Map<java.lang.String,java.lang.String> attributes;

    /** Creates a new Builder */
    private Builder() {
      super(org.opencb.biodata.models.variant.avro.VariantSourceEntry.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(org.opencb.biodata.models.variant.avro.VariantSourceEntry.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.studyId)) {
        this.studyId = data().deepCopy(fields()[0].schema(), other.studyId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.fileId)) {
        this.fileId = data().deepCopy(fields()[1].schema(), other.fileId);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.secondaryAlternates)) {
        this.secondaryAlternates = data().deepCopy(fields()[2].schema(), other.secondaryAlternates);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.formatList)) {
        this.formatList = data().deepCopy(fields()[3].schema(), other.formatList);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.samplesDataList)) {
        this.samplesDataList = data().deepCopy(fields()[4].schema(), other.samplesDataList);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.stats)) {
        this.stats = data().deepCopy(fields()[5].schema(), other.stats);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.attributes)) {
        this.attributes = data().deepCopy(fields()[6].schema(), other.attributes);
        fieldSetFlags()[6] = true;
      }
    }
    
    /** Creates a Builder by copying an existing VariantSourceEntry instance */
    private Builder(org.opencb.biodata.models.variant.avro.VariantSourceEntry other) {
            super(org.opencb.biodata.models.variant.avro.VariantSourceEntry.SCHEMA$);
      if (isValidValue(fields()[0], other.studyId)) {
        this.studyId = data().deepCopy(fields()[0].schema(), other.studyId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.fileId)) {
        this.fileId = data().deepCopy(fields()[1].schema(), other.fileId);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.secondaryAlternates)) {
        this.secondaryAlternates = data().deepCopy(fields()[2].schema(), other.secondaryAlternates);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.formatList)) {
        this.formatList = data().deepCopy(fields()[3].schema(), other.formatList);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.samplesDataList)) {
        this.samplesDataList = data().deepCopy(fields()[4].schema(), other.samplesDataList);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.stats)) {
        this.stats = data().deepCopy(fields()[5].schema(), other.stats);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.attributes)) {
        this.attributes = data().deepCopy(fields()[6].schema(), other.attributes);
        fieldSetFlags()[6] = true;
      }
    }

    /** Gets the value of the 'studyId' field */
    public java.lang.String getStudyId() {
      return studyId;
    }
    
    /** Sets the value of the 'studyId' field */
    public org.opencb.biodata.models.variant.avro.VariantSourceEntry.Builder setStudyId(java.lang.String value) {
      validate(fields()[0], value);
      this.studyId = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'studyId' field has been set */
    public boolean hasStudyId() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'studyId' field */
    public org.opencb.biodata.models.variant.avro.VariantSourceEntry.Builder clearStudyId() {
      studyId = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'fileId' field */
    public java.lang.String getFileId() {
      return fileId;
    }
    
    /** Sets the value of the 'fileId' field */
    public org.opencb.biodata.models.variant.avro.VariantSourceEntry.Builder setFileId(java.lang.String value) {
      validate(fields()[1], value);
      this.fileId = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'fileId' field has been set */
    public boolean hasFileId() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'fileId' field */
    public org.opencb.biodata.models.variant.avro.VariantSourceEntry.Builder clearFileId() {
      fileId = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'secondaryAlternates' field */
    public java.util.List<java.lang.String> getSecondaryAlternates() {
      return secondaryAlternates;
    }
    
    /** Sets the value of the 'secondaryAlternates' field */
    public org.opencb.biodata.models.variant.avro.VariantSourceEntry.Builder setSecondaryAlternates(java.util.List<java.lang.String> value) {
      validate(fields()[2], value);
      this.secondaryAlternates = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the 'secondaryAlternates' field has been set */
    public boolean hasSecondaryAlternates() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the 'secondaryAlternates' field */
    public org.opencb.biodata.models.variant.avro.VariantSourceEntry.Builder clearSecondaryAlternates() {
      secondaryAlternates = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /** Gets the value of the 'formatList' field */
    public java.util.List<java.lang.String> getFormatList() {
      return formatList;
    }
    
    /** Sets the value of the 'formatList' field */
    public org.opencb.biodata.models.variant.avro.VariantSourceEntry.Builder setFormatList(java.util.List<java.lang.String> value) {
      validate(fields()[3], value);
      this.formatList = value;
      fieldSetFlags()[3] = true;
      return this; 
    }
    
    /** Checks whether the 'formatList' field has been set */
    public boolean hasFormatList() {
      return fieldSetFlags()[3];
    }
    
    /** Clears the value of the 'formatList' field */
    public org.opencb.biodata.models.variant.avro.VariantSourceEntry.Builder clearFormatList() {
      formatList = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /** Gets the value of the 'samplesDataList' field */
    public java.util.List<java.util.List<java.lang.String>> getSamplesDataList() {
      return samplesDataList;
    }
    
    /** Sets the value of the 'samplesDataList' field */
    public org.opencb.biodata.models.variant.avro.VariantSourceEntry.Builder setSamplesDataList(java.util.List<java.util.List<java.lang.String>> value) {
      validate(fields()[4], value);
      this.samplesDataList = value;
      fieldSetFlags()[4] = true;
      return this; 
    }
    
    /** Checks whether the 'samplesDataList' field has been set */
    public boolean hasSamplesDataList() {
      return fieldSetFlags()[4];
    }
    
    /** Clears the value of the 'samplesDataList' field */
    public org.opencb.biodata.models.variant.avro.VariantSourceEntry.Builder clearSamplesDataList() {
      samplesDataList = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /** Gets the value of the 'stats' field */
    public java.util.Map<java.lang.String,org.opencb.biodata.models.variant.avro.VariantStats> getStats() {
      return stats;
    }
    
    /** Sets the value of the 'stats' field */
    public org.opencb.biodata.models.variant.avro.VariantSourceEntry.Builder setStats(java.util.Map<java.lang.String,org.opencb.biodata.models.variant.avro.VariantStats> value) {
      validate(fields()[5], value);
      this.stats = value;
      fieldSetFlags()[5] = true;
      return this; 
    }
    
    /** Checks whether the 'stats' field has been set */
    public boolean hasStats() {
      return fieldSetFlags()[5];
    }
    
    /** Clears the value of the 'stats' field */
    public org.opencb.biodata.models.variant.avro.VariantSourceEntry.Builder clearStats() {
      stats = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    /** Gets the value of the 'attributes' field */
    public java.util.Map<java.lang.String,java.lang.String> getAttributes() {
      return attributes;
    }
    
    /** Sets the value of the 'attributes' field */
    public org.opencb.biodata.models.variant.avro.VariantSourceEntry.Builder setAttributes(java.util.Map<java.lang.String,java.lang.String> value) {
      validate(fields()[6], value);
      this.attributes = value;
      fieldSetFlags()[6] = true;
      return this; 
    }
    
    /** Checks whether the 'attributes' field has been set */
    public boolean hasAttributes() {
      return fieldSetFlags()[6];
    }
    
    /** Clears the value of the 'attributes' field */
    public org.opencb.biodata.models.variant.avro.VariantSourceEntry.Builder clearAttributes() {
      attributes = null;
      fieldSetFlags()[6] = false;
      return this;
    }

    @Override
    public VariantSourceEntry build() {
      try {
        VariantSourceEntry record = new VariantSourceEntry();
        record.studyId = fieldSetFlags()[0] ? this.studyId : (java.lang.String) defaultValue(fields()[0]);
        record.fileId = fieldSetFlags()[1] ? this.fileId : (java.lang.String) defaultValue(fields()[1]);
        record.secondaryAlternates = fieldSetFlags()[2] ? this.secondaryAlternates : (java.util.List<java.lang.String>) defaultValue(fields()[2]);
        record.formatList = fieldSetFlags()[3] ? this.formatList : (java.util.List<java.lang.String>) defaultValue(fields()[3]);
        record.samplesDataList = fieldSetFlags()[4] ? this.samplesDataList : (java.util.List<java.util.List<java.lang.String>>) defaultValue(fields()[4]);
        record.stats = fieldSetFlags()[5] ? this.stats : (java.util.Map<java.lang.String,org.opencb.biodata.models.variant.avro.VariantStats>) defaultValue(fields()[5]);
        record.attributes = fieldSetFlags()[6] ? this.attributes : (java.util.Map<java.lang.String,java.lang.String>) defaultValue(fields()[6]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
