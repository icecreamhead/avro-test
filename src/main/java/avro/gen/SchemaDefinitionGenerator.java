package avro.gen;

import org.apache.avro.Schema;
import org.apache.avro.SchemaBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SchemaDefinitionGenerator {

  public static void main(String[] args) throws IOException {

    Schema clientIdentifier = SchemaBuilder.record("ClientIdentifier")
        .namespace("avro.model")
        .fields().requiredString("hostName").requiredString("ipAddress")
        .endRecord();

    Schema avroHttpRequestV1 = SchemaBuilder.record("AvroHttpRequestV1")
        .namespace("avro.model")
        .fields().requiredInt("requestTime")
        .name("clientIdentifier")
        .type(clientIdentifier)
        .noDefault()
        .name("employeeNames")
        .type()
        .array()
        .items()
        .stringType()
        .arrayDefault(List.of())
        .name("active")
        .type()
        .enumeration("Active")
        .symbols("YES", "NO")
        .noDefault()
        .endRecord();

    Schema avroHttpRequestV2 = SchemaBuilder.record("AvroHttpRequestV2")
        .namespace("avro.model")
        .fields().requiredLong("requestTime")
        .name("clientIdentifier")
        .type(clientIdentifier)
        .noDefault()
        .name("employeeNames")
        .type()
        .array()
        .items()
        .stringType()
        .arrayDefault(List.of())
        .name("active")
        .type()
        .enumeration("Active")
        .symbols("YES", "NO")
        .noDefault()
        .name("department")
        .type()
        .stringType()
        .stringDefault("🤷🏼‍♂️")
        .endRecord();

    for (Schema schema : List.of(clientIdentifier, avroHttpRequestV1, avroHttpRequestV2)) {
      FileWriter writer = new FileWriter("src/main/resources/schemas/" + schema.getName() + ".avsc");
      writer.write(schema.toString(true));
      writer.flush();
      writer.close();
    }

  }

}
