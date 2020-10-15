package avro.gen;

import org.apache.avro.Schema;
import org.apache.avro.SchemaBuilder;

import java.util.List;

public class SchemaDefinitionGenerator {

    public static void main(String[] args) {

        Schema clientIdentifier = SchemaBuilder.record("ClientIdentifier")
                .namespace("avro.model")
                .fields().requiredString("hostName").requiredString("ipAddress")
                .endRecord();

        Schema avroHttpRequest = SchemaBuilder.record("AvroHttpRequest")
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
                .endRecord();

        System.out.println(clientIdentifier.toString(true));
        System.out.println(avroHttpRequest.toString(true));

    }

}
