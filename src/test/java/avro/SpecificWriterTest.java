package avro;

import org.apache.avro.io.DecoderFactory;
import org.apache.avro.io.Encoder;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import avro.model.Active;
import avro.model.AvroHttpRequestV1;
import avro.model.AvroHttpRequestV2;
import avro.model.ClientIdentifier;

import static org.assertj.core.api.Assertions.assertThat;

class SpecificWriterTest {

  private static final SpecificDatumWriter<AvroHttpRequestV1> WRITER = new SpecificDatumWriter<>(AvroHttpRequestV1.class);
  private static final SpecificDatumReader<AvroHttpRequestV2> READER = new SpecificDatumReader<>(AvroHttpRequestV1.getClassSchema(), AvroHttpRequestV2.getClassSchema());

  private final ByteArrayOutputStream buffer = new ByteArrayOutputStream();

  @Test
  void canWriteAndReadUsingSpecificWriter() throws IOException {
    AvroHttpRequestV1 in = AvroHttpRequestV1.newBuilder()
        .setRequestTime(54321)
        .setClientIdentifier(ClientIdentifier.newBuilder()
            .setHostName("I AM A HOST")
            .setIpAddress("10.10.10.10")
            .build()
        )
        .setEmployeeNames(List.of("Alice", "Bob", "Eve"))
        .setActive(Active.YES)
        .build();

    Encoder encoder = EncoderFactory.get().binaryEncoder(buffer, null);
    WRITER.write(in, encoder);
    encoder.flush();

    AvroHttpRequestV2 out = READER.read(null, DecoderFactory.get().binaryDecoder(buffer.toByteArray(), null));


    // some weirdness with CharSequences on the generated models
    assertThat(out.getRequestTime()).isEqualTo(54321L);
    assertThat(out.getDepartment()).asString().isEqualTo("🤷🏼‍♂️");
    assertThat(out.getClientIdentifier().getHostName()).asString().isEqualTo("I AM A HOST");
  }

  @AfterEach
  void tearDown() {
    buffer.reset();
  }
}