/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package avro.model;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class AvroHttpRequestV2 extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -1571062347250249809L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"AvroHttpRequestV2\",\"namespace\":\"avro.model\",\"fields\":[{\"name\":\"requestTime\",\"type\":\"long\"},{\"name\":\"clientIdentifier\",\"type\":{\"type\":\"record\",\"name\":\"ClientIdentifier\",\"fields\":[{\"name\":\"hostName\",\"type\":\"string\"},{\"name\":\"ipAddress\",\"type\":\"string\"}]}},{\"name\":\"employeeNames\",\"type\":{\"type\":\"array\",\"items\":\"string\"},\"default\":[]},{\"name\":\"active\",\"type\":{\"type\":\"enum\",\"name\":\"Active\",\"symbols\":[\"YES\",\"NO\"]}},{\"name\":\"department\",\"type\":\"string\",\"default\":\"🤷🏼‍♂️\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<AvroHttpRequestV2> ENCODER =
      new BinaryMessageEncoder<AvroHttpRequestV2>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<AvroHttpRequestV2> DECODER =
      new BinaryMessageDecoder<AvroHttpRequestV2>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<AvroHttpRequestV2> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<AvroHttpRequestV2> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<AvroHttpRequestV2> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<AvroHttpRequestV2>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this AvroHttpRequestV2 to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a AvroHttpRequestV2 from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a AvroHttpRequestV2 instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static AvroHttpRequestV2 fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

   private long requestTime;
   private avro.model.ClientIdentifier clientIdentifier;
   private java.util.List<java.lang.CharSequence> employeeNames;
   private avro.model.Active active;
   private java.lang.CharSequence department;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public AvroHttpRequestV2() {}

  /**
   * All-args constructor.
   * @param requestTime The new value for requestTime
   * @param clientIdentifier The new value for clientIdentifier
   * @param employeeNames The new value for employeeNames
   * @param active The new value for active
   * @param department The new value for department
   */
  public AvroHttpRequestV2(java.lang.Long requestTime, avro.model.ClientIdentifier clientIdentifier, java.util.List<java.lang.CharSequence> employeeNames, avro.model.Active active, java.lang.CharSequence department) {
    this.requestTime = requestTime;
    this.clientIdentifier = clientIdentifier;
    this.employeeNames = employeeNames;
    this.active = active;
    this.department = department;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return requestTime;
    case 1: return clientIdentifier;
    case 2: return employeeNames;
    case 3: return active;
    case 4: return department;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: requestTime = (java.lang.Long)value$; break;
    case 1: clientIdentifier = (avro.model.ClientIdentifier)value$; break;
    case 2: employeeNames = (java.util.List<java.lang.CharSequence>)value$; break;
    case 3: active = (avro.model.Active)value$; break;
    case 4: department = (java.lang.CharSequence)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'requestTime' field.
   * @return The value of the 'requestTime' field.
   */
  public long getRequestTime() {
    return requestTime;
  }


  /**
   * Sets the value of the 'requestTime' field.
   * @param value the value to set.
   */
  public void setRequestTime(long value) {
    this.requestTime = value;
  }

  /**
   * Gets the value of the 'clientIdentifier' field.
   * @return The value of the 'clientIdentifier' field.
   */
  public avro.model.ClientIdentifier getClientIdentifier() {
    return clientIdentifier;
  }


  /**
   * Sets the value of the 'clientIdentifier' field.
   * @param value the value to set.
   */
  public void setClientIdentifier(avro.model.ClientIdentifier value) {
    this.clientIdentifier = value;
  }

  /**
   * Gets the value of the 'employeeNames' field.
   * @return The value of the 'employeeNames' field.
   */
  public java.util.List<java.lang.CharSequence> getEmployeeNames() {
    return employeeNames;
  }


  /**
   * Sets the value of the 'employeeNames' field.
   * @param value the value to set.
   */
  public void setEmployeeNames(java.util.List<java.lang.CharSequence> value) {
    this.employeeNames = value;
  }

  /**
   * Gets the value of the 'active' field.
   * @return The value of the 'active' field.
   */
  public avro.model.Active getActive() {
    return active;
  }


  /**
   * Sets the value of the 'active' field.
   * @param value the value to set.
   */
  public void setActive(avro.model.Active value) {
    this.active = value;
  }

  /**
   * Gets the value of the 'department' field.
   * @return The value of the 'department' field.
   */
  public java.lang.CharSequence getDepartment() {
    return department;
  }


  /**
   * Sets the value of the 'department' field.
   * @param value the value to set.
   */
  public void setDepartment(java.lang.CharSequence value) {
    this.department = value;
  }

  /**
   * Creates a new AvroHttpRequestV2 RecordBuilder.
   * @return A new AvroHttpRequestV2 RecordBuilder
   */
  public static avro.model.AvroHttpRequestV2.Builder newBuilder() {
    return new avro.model.AvroHttpRequestV2.Builder();
  }

  /**
   * Creates a new AvroHttpRequestV2 RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new AvroHttpRequestV2 RecordBuilder
   */
  public static avro.model.AvroHttpRequestV2.Builder newBuilder(avro.model.AvroHttpRequestV2.Builder other) {
    if (other == null) {
      return new avro.model.AvroHttpRequestV2.Builder();
    } else {
      return new avro.model.AvroHttpRequestV2.Builder(other);
    }
  }

  /**
   * Creates a new AvroHttpRequestV2 RecordBuilder by copying an existing AvroHttpRequestV2 instance.
   * @param other The existing instance to copy.
   * @return A new AvroHttpRequestV2 RecordBuilder
   */
  public static avro.model.AvroHttpRequestV2.Builder newBuilder(avro.model.AvroHttpRequestV2 other) {
    if (other == null) {
      return new avro.model.AvroHttpRequestV2.Builder();
    } else {
      return new avro.model.AvroHttpRequestV2.Builder(other);
    }
  }

  /**
   * RecordBuilder for AvroHttpRequestV2 instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<AvroHttpRequestV2>
    implements org.apache.avro.data.RecordBuilder<AvroHttpRequestV2> {

    private long requestTime;
    private avro.model.ClientIdentifier clientIdentifier;
    private avro.model.ClientIdentifier.Builder clientIdentifierBuilder;
    private java.util.List<java.lang.CharSequence> employeeNames;
    private avro.model.Active active;
    private java.lang.CharSequence department;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(avro.model.AvroHttpRequestV2.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.requestTime)) {
        this.requestTime = data().deepCopy(fields()[0].schema(), other.requestTime);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.clientIdentifier)) {
        this.clientIdentifier = data().deepCopy(fields()[1].schema(), other.clientIdentifier);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (other.hasClientIdentifierBuilder()) {
        this.clientIdentifierBuilder = avro.model.ClientIdentifier.newBuilder(other.getClientIdentifierBuilder());
      }
      if (isValidValue(fields()[2], other.employeeNames)) {
        this.employeeNames = data().deepCopy(fields()[2].schema(), other.employeeNames);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.active)) {
        this.active = data().deepCopy(fields()[3].schema(), other.active);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.department)) {
        this.department = data().deepCopy(fields()[4].schema(), other.department);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
    }

    /**
     * Creates a Builder by copying an existing AvroHttpRequestV2 instance
     * @param other The existing instance to copy.
     */
    private Builder(avro.model.AvroHttpRequestV2 other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.requestTime)) {
        this.requestTime = data().deepCopy(fields()[0].schema(), other.requestTime);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.clientIdentifier)) {
        this.clientIdentifier = data().deepCopy(fields()[1].schema(), other.clientIdentifier);
        fieldSetFlags()[1] = true;
      }
      this.clientIdentifierBuilder = null;
      if (isValidValue(fields()[2], other.employeeNames)) {
        this.employeeNames = data().deepCopy(fields()[2].schema(), other.employeeNames);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.active)) {
        this.active = data().deepCopy(fields()[3].schema(), other.active);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.department)) {
        this.department = data().deepCopy(fields()[4].schema(), other.department);
        fieldSetFlags()[4] = true;
      }
    }

    /**
      * Gets the value of the 'requestTime' field.
      * @return The value.
      */
    public long getRequestTime() {
      return requestTime;
    }


    /**
      * Sets the value of the 'requestTime' field.
      * @param value The value of 'requestTime'.
      * @return This builder.
      */
    public avro.model.AvroHttpRequestV2.Builder setRequestTime(long value) {
      validate(fields()[0], value);
      this.requestTime = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'requestTime' field has been set.
      * @return True if the 'requestTime' field has been set, false otherwise.
      */
    public boolean hasRequestTime() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'requestTime' field.
      * @return This builder.
      */
    public avro.model.AvroHttpRequestV2.Builder clearRequestTime() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'clientIdentifier' field.
      * @return The value.
      */
    public avro.model.ClientIdentifier getClientIdentifier() {
      return clientIdentifier;
    }


    /**
      * Sets the value of the 'clientIdentifier' field.
      * @param value The value of 'clientIdentifier'.
      * @return This builder.
      */
    public avro.model.AvroHttpRequestV2.Builder setClientIdentifier(avro.model.ClientIdentifier value) {
      validate(fields()[1], value);
      this.clientIdentifierBuilder = null;
      this.clientIdentifier = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'clientIdentifier' field has been set.
      * @return True if the 'clientIdentifier' field has been set, false otherwise.
      */
    public boolean hasClientIdentifier() {
      return fieldSetFlags()[1];
    }

    /**
     * Gets the Builder instance for the 'clientIdentifier' field and creates one if it doesn't exist yet.
     * @return This builder.
     */
    public avro.model.ClientIdentifier.Builder getClientIdentifierBuilder() {
      if (clientIdentifierBuilder == null) {
        if (hasClientIdentifier()) {
          setClientIdentifierBuilder(avro.model.ClientIdentifier.newBuilder(clientIdentifier));
        } else {
          setClientIdentifierBuilder(avro.model.ClientIdentifier.newBuilder());
        }
      }
      return clientIdentifierBuilder;
    }

    /**
     * Sets the Builder instance for the 'clientIdentifier' field
     * @param value The builder instance that must be set.
     * @return This builder.
     */
    public avro.model.AvroHttpRequestV2.Builder setClientIdentifierBuilder(avro.model.ClientIdentifier.Builder value) {
      clearClientIdentifier();
      clientIdentifierBuilder = value;
      return this;
    }

    /**
     * Checks whether the 'clientIdentifier' field has an active Builder instance
     * @return True if the 'clientIdentifier' field has an active Builder instance
     */
    public boolean hasClientIdentifierBuilder() {
      return clientIdentifierBuilder != null;
    }

    /**
      * Clears the value of the 'clientIdentifier' field.
      * @return This builder.
      */
    public avro.model.AvroHttpRequestV2.Builder clearClientIdentifier() {
      clientIdentifier = null;
      clientIdentifierBuilder = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'employeeNames' field.
      * @return The value.
      */
    public java.util.List<java.lang.CharSequence> getEmployeeNames() {
      return employeeNames;
    }


    /**
      * Sets the value of the 'employeeNames' field.
      * @param value The value of 'employeeNames'.
      * @return This builder.
      */
    public avro.model.AvroHttpRequestV2.Builder setEmployeeNames(java.util.List<java.lang.CharSequence> value) {
      validate(fields()[2], value);
      this.employeeNames = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'employeeNames' field has been set.
      * @return True if the 'employeeNames' field has been set, false otherwise.
      */
    public boolean hasEmployeeNames() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'employeeNames' field.
      * @return This builder.
      */
    public avro.model.AvroHttpRequestV2.Builder clearEmployeeNames() {
      employeeNames = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'active' field.
      * @return The value.
      */
    public avro.model.Active getActive() {
      return active;
    }


    /**
      * Sets the value of the 'active' field.
      * @param value The value of 'active'.
      * @return This builder.
      */
    public avro.model.AvroHttpRequestV2.Builder setActive(avro.model.Active value) {
      validate(fields()[3], value);
      this.active = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'active' field has been set.
      * @return True if the 'active' field has been set, false otherwise.
      */
    public boolean hasActive() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'active' field.
      * @return This builder.
      */
    public avro.model.AvroHttpRequestV2.Builder clearActive() {
      active = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'department' field.
      * @return The value.
      */
    public java.lang.CharSequence getDepartment() {
      return department;
    }


    /**
      * Sets the value of the 'department' field.
      * @param value The value of 'department'.
      * @return This builder.
      */
    public avro.model.AvroHttpRequestV2.Builder setDepartment(java.lang.CharSequence value) {
      validate(fields()[4], value);
      this.department = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'department' field has been set.
      * @return True if the 'department' field has been set, false otherwise.
      */
    public boolean hasDepartment() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'department' field.
      * @return This builder.
      */
    public avro.model.AvroHttpRequestV2.Builder clearDepartment() {
      department = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public AvroHttpRequestV2 build() {
      try {
        AvroHttpRequestV2 record = new AvroHttpRequestV2();
        record.requestTime = fieldSetFlags()[0] ? this.requestTime : (java.lang.Long) defaultValue(fields()[0]);
        if (clientIdentifierBuilder != null) {
          try {
            record.clientIdentifier = this.clientIdentifierBuilder.build();
          } catch (org.apache.avro.AvroMissingFieldException e) {
            e.addParentField(record.getSchema().getField("clientIdentifier"));
            throw e;
          }
        } else {
          record.clientIdentifier = fieldSetFlags()[1] ? this.clientIdentifier : (avro.model.ClientIdentifier) defaultValue(fields()[1]);
        }
        record.employeeNames = fieldSetFlags()[2] ? this.employeeNames : (java.util.List<java.lang.CharSequence>) defaultValue(fields()[2]);
        record.active = fieldSetFlags()[3] ? this.active : (avro.model.Active) defaultValue(fields()[3]);
        record.department = fieldSetFlags()[4] ? this.department : (java.lang.CharSequence) defaultValue(fields()[4]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<AvroHttpRequestV2>
    WRITER$ = (org.apache.avro.io.DatumWriter<AvroHttpRequestV2>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<AvroHttpRequestV2>
    READER$ = (org.apache.avro.io.DatumReader<AvroHttpRequestV2>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeLong(this.requestTime);

    this.clientIdentifier.customEncode(out);

    long size0 = this.employeeNames.size();
    out.writeArrayStart();
    out.setItemCount(size0);
    long actualSize0 = 0;
    for (java.lang.CharSequence e0: this.employeeNames) {
      actualSize0++;
      out.startItem();
      out.writeString(e0);
    }
    out.writeArrayEnd();
    if (actualSize0 != size0)
      throw new java.util.ConcurrentModificationException("Array-size written was " + size0 + ", but element count was " + actualSize0 + ".");

    out.writeEnum(this.active.ordinal());

    out.writeString(this.department);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.requestTime = in.readLong();

      if (this.clientIdentifier == null) {
        this.clientIdentifier = new avro.model.ClientIdentifier();
      }
      this.clientIdentifier.customDecode(in);

      long size0 = in.readArrayStart();
      java.util.List<java.lang.CharSequence> a0 = this.employeeNames;
      if (a0 == null) {
        a0 = new SpecificData.Array<java.lang.CharSequence>((int)size0, SCHEMA$.getField("employeeNames").schema());
        this.employeeNames = a0;
      } else a0.clear();
      SpecificData.Array<java.lang.CharSequence> ga0 = (a0 instanceof SpecificData.Array ? (SpecificData.Array<java.lang.CharSequence>)a0 : null);
      for ( ; 0 < size0; size0 = in.arrayNext()) {
        for ( ; size0 != 0; size0--) {
          java.lang.CharSequence e0 = (ga0 != null ? ga0.peek() : null);
          e0 = in.readString(e0 instanceof Utf8 ? (Utf8)e0 : null);
          a0.add(e0);
        }
      }

      this.active = avro.model.Active.values()[in.readEnum()];

      this.department = in.readString(this.department instanceof Utf8 ? (Utf8)this.department : null);

    } else {
      for (int i = 0; i < 5; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.requestTime = in.readLong();
          break;

        case 1:
          if (this.clientIdentifier == null) {
            this.clientIdentifier = new avro.model.ClientIdentifier();
          }
          this.clientIdentifier.customDecode(in);
          break;

        case 2:
          long size0 = in.readArrayStart();
          java.util.List<java.lang.CharSequence> a0 = this.employeeNames;
          if (a0 == null) {
            a0 = new SpecificData.Array<java.lang.CharSequence>((int)size0, SCHEMA$.getField("employeeNames").schema());
            this.employeeNames = a0;
          } else a0.clear();
          SpecificData.Array<java.lang.CharSequence> ga0 = (a0 instanceof SpecificData.Array ? (SpecificData.Array<java.lang.CharSequence>)a0 : null);
          for ( ; 0 < size0; size0 = in.arrayNext()) {
            for ( ; size0 != 0; size0--) {
              java.lang.CharSequence e0 = (ga0 != null ? ga0.peek() : null);
              e0 = in.readString(e0 instanceof Utf8 ? (Utf8)e0 : null);
              a0.add(e0);
            }
          }
          break;

        case 3:
          this.active = avro.model.Active.values()[in.readEnum()];
          break;

        case 4:
          this.department = in.readString(this.department instanceof Utf8 ? (Utf8)this.department : null);
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










