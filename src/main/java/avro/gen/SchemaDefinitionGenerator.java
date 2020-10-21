package avro.gen;

import org.apache.avro.LogicalTypes;
import org.apache.avro.Schema;
import org.apache.avro.SchemaBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SchemaDefinitionGenerator {

  public static void main(String[] args) throws IOException {

    Schema active = SchemaBuilder.enumeration("Active")
        .namespace("avro.model")
        .symbols("YES", "NO");

    Schema clientIdentifier = SchemaBuilder.record("ClientIdentifier")
        .namespace("avro.model")
        .fields().requiredString("hostName").requiredString("ipAddress")
        .endRecord();

    Schema avroHttpRequestV1 = SchemaBuilder.record("AvroHttpRequestV1")

        .namespace("avro.model")
        .fields().requiredInt("requestTime")
        .name("clientIdentifier")
        .type(clientIdentifier.getValueType())
        .noDefault()
        .name("employeeNames")
        .type()
        .array()
        .items()
        .stringType()
        .arrayDefault(List.of())
        .name("active")
        .type(active.getValueType())
        .noDefault()
        .endRecord();

    Schema avroHttpRequestV2 = SchemaBuilder.record("AvroHttpRequestV2")
        .namespace("avro.model")
        .fields().requiredLong("requestTime")
        .name("clientIdentifier")
        .type(clientIdentifier.getValueType())
        .noDefault()
        .name("employeeNames")
        .type()
        .array()
        .items()
        .stringType()
        .arrayDefault(List.of())
        .name("active")
        .type(active.getValueType())
        .noDefault()
        .name("department")
        .type()
        .stringType()
        .stringDefault("🤷🏼‍♂️")
        .name("amount")
        .type(LogicalTypes.decimal(19, 2).addToSchema(Schema.create(Schema.Type.BYTES)))
        .withDefault("0.00")
        .endRecord();

    Schema zonedDateTime = new ZonedDateTimeType().addToSchema(Schema.create(Schema.Type.LONG));

    Schema timestampedEvent = SchemaBuilder.record("TimestampedEvent")
        .namespace("avro.model")
        .fields()
        .name("zonedDateTime")
        .type(zonedDateTime)
        .noDefault()
        .endRecord();

    for (Schema schema : List.of(active, clientIdentifier, avroHttpRequestV1, avroHttpRequestV2, timestampedEvent)) {
      FileWriter writer = new FileWriter("src/main/resources/schemas/" + schema.getName() + ".avsc");
      writer.write(schema.toString(true));
      writer.flush();
      writer.close();
    }

  }

}
