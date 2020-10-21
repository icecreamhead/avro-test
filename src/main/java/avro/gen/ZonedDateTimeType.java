package avro.gen;

import org.apache.avro.LogicalType;
import org.apache.avro.Schema;

public class ZonedDateTimeType extends LogicalType {
  public ZonedDateTimeType() {
    super("zoned-date-time");
  }

  @Override
  public void validate(Schema schema) {
    super.validate(schema);
  }
}
