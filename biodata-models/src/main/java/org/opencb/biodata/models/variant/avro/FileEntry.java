/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package org.opencb.biodata.models.variant.avro;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class FileEntry extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"FileEntry\",\"namespace\":\"org.opencb.biodata.models.variant.avro\",\"fields\":[{\"name\":\"fileId\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"* Unique identifier of the source file.\"},{\"name\":\"call\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"* Original call position for the variant, if the file was normalized.\\n         *\\n         * {position}:{reference}:{alternate}(,{other_alternate})*:{allele_index}\"},{\"name\":\"attributes\",\"type\":{\"type\":\"map\",\"values\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"avro.java.string\":\"String\"},\"doc\":\"* Optional attributes that probably depend on the format of the file the\\n         * variant was initially read from.\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  /** * Unique identifier of the source file. */
   private java.lang.String fileId;
  /** * Original call position for the variant, if the file was normalized.
         *
         * {position}:{reference}:{alternate}(,{other_alternate})*:{allele_index} */
   private java.lang.String call;
  /** * Optional attributes that probably depend on the format of the file the
         * variant was initially read from. */
   private java.util.Map<java.lang.String,java.lang.String> attributes;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public FileEntry() {}

  /**
   * All-args constructor.
   */
  public FileEntry(java.lang.String fileId, java.lang.String call, java.util.Map<java.lang.String,java.lang.String> attributes) {
    this.fileId = fileId;
    this.call = call;
    this.attributes = attributes;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return fileId;
    case 1: return call;
    case 2: return attributes;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: fileId = (java.lang.String)value$; break;
    case 1: call = (java.lang.String)value$; break;
    case 2: attributes = (java.util.Map<java.lang.String,java.lang.String>)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'fileId' field.
   * * Unique identifier of the source file.   */
  public java.lang.String getFileId() {
    return fileId;
  }

  /**
   * Sets the value of the 'fileId' field.
   * * Unique identifier of the source file.   * @param value the value to set.
   */
  public void setFileId(java.lang.String value) {
    this.fileId = value;
  }

  /**
   * Gets the value of the 'call' field.
   * * Original call position for the variant, if the file was normalized.
         *
         * {position}:{reference}:{alternate}(,{other_alternate})*:{allele_index}   */
  public java.lang.String getCall() {
    return call;
  }

  /**
   * Sets the value of the 'call' field.
   * * Original call position for the variant, if the file was normalized.
         *
         * {position}:{reference}:{alternate}(,{other_alternate})*:{allele_index}   * @param value the value to set.
   */
  public void setCall(java.lang.String value) {
    this.call = value;
  }

  /**
   * Gets the value of the 'attributes' field.
   * * Optional attributes that probably depend on the format of the file the
         * variant was initially read from.   */
  public java.util.Map<java.lang.String,java.lang.String> getAttributes() {
    return attributes;
  }

  /**
   * Sets the value of the 'attributes' field.
   * * Optional attributes that probably depend on the format of the file the
         * variant was initially read from.   * @param value the value to set.
   */
  public void setAttributes(java.util.Map<java.lang.String,java.lang.String> value) {
    this.attributes = value;
  }

  /** Creates a new FileEntry RecordBuilder */
  public static org.opencb.biodata.models.variant.avro.FileEntry.Builder newBuilder() {
    return new org.opencb.biodata.models.variant.avro.FileEntry.Builder();
  }
  
  /** Creates a new FileEntry RecordBuilder by copying an existing Builder */
  public static org.opencb.biodata.models.variant.avro.FileEntry.Builder newBuilder(org.opencb.biodata.models.variant.avro.FileEntry.Builder other) {
    return new org.opencb.biodata.models.variant.avro.FileEntry.Builder(other);
  }
  
  /** Creates a new FileEntry RecordBuilder by copying an existing FileEntry instance */
  public static org.opencb.biodata.models.variant.avro.FileEntry.Builder newBuilder(org.opencb.biodata.models.variant.avro.FileEntry other) {
    return new org.opencb.biodata.models.variant.avro.FileEntry.Builder(other);
  }
  
  /**
   * RecordBuilder for FileEntry instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<FileEntry>
    implements org.apache.avro.data.RecordBuilder<FileEntry> {

    private java.lang.String fileId;
    private java.lang.String call;
    private java.util.Map<java.lang.String,java.lang.String> attributes;

    /** Creates a new Builder */
    private Builder() {
      super(org.opencb.biodata.models.variant.avro.FileEntry.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(org.opencb.biodata.models.variant.avro.FileEntry.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.fileId)) {
        this.fileId = data().deepCopy(fields()[0].schema(), other.fileId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.call)) {
        this.call = data().deepCopy(fields()[1].schema(), other.call);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.attributes)) {
        this.attributes = data().deepCopy(fields()[2].schema(), other.attributes);
        fieldSetFlags()[2] = true;
      }
    }
    
    /** Creates a Builder by copying an existing FileEntry instance */
    private Builder(org.opencb.biodata.models.variant.avro.FileEntry other) {
            super(org.opencb.biodata.models.variant.avro.FileEntry.SCHEMA$);
      if (isValidValue(fields()[0], other.fileId)) {
        this.fileId = data().deepCopy(fields()[0].schema(), other.fileId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.call)) {
        this.call = data().deepCopy(fields()[1].schema(), other.call);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.attributes)) {
        this.attributes = data().deepCopy(fields()[2].schema(), other.attributes);
        fieldSetFlags()[2] = true;
      }
    }

    /** Gets the value of the 'fileId' field */
    public java.lang.String getFileId() {
      return fileId;
    }
    
    /** Sets the value of the 'fileId' field */
    public org.opencb.biodata.models.variant.avro.FileEntry.Builder setFileId(java.lang.String value) {
      validate(fields()[0], value);
      this.fileId = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'fileId' field has been set */
    public boolean hasFileId() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'fileId' field */
    public org.opencb.biodata.models.variant.avro.FileEntry.Builder clearFileId() {
      fileId = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'call' field */
    public java.lang.String getCall() {
      return call;
    }
    
    /** Sets the value of the 'call' field */
    public org.opencb.biodata.models.variant.avro.FileEntry.Builder setCall(java.lang.String value) {
      validate(fields()[1], value);
      this.call = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'call' field has been set */
    public boolean hasCall() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'call' field */
    public org.opencb.biodata.models.variant.avro.FileEntry.Builder clearCall() {
      call = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'attributes' field */
    public java.util.Map<java.lang.String,java.lang.String> getAttributes() {
      return attributes;
    }
    
    /** Sets the value of the 'attributes' field */
    public org.opencb.biodata.models.variant.avro.FileEntry.Builder setAttributes(java.util.Map<java.lang.String,java.lang.String> value) {
      validate(fields()[2], value);
      this.attributes = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the 'attributes' field has been set */
    public boolean hasAttributes() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the 'attributes' field */
    public org.opencb.biodata.models.variant.avro.FileEntry.Builder clearAttributes() {
      attributes = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    public FileEntry build() {
      try {
        FileEntry record = new FileEntry();
        record.fileId = fieldSetFlags()[0] ? this.fileId : (java.lang.String) defaultValue(fields()[0]);
        record.call = fieldSetFlags()[1] ? this.call : (java.lang.String) defaultValue(fields()[1]);
        record.attributes = fieldSetFlags()[2] ? this.attributes : (java.util.Map<java.lang.String,java.lang.String>) defaultValue(fields()[2]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
