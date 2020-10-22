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
import java.math.BigDecimal;
import java.util.List;

import avro.model.Active;
import avro.model.AvroHttpRequestV1;
import avro.model.AvroHttpRequestV2;
import avro.model.ClientIdentifier;

import static org.assertj.core.api.Assertions.assertThat;

class SpecificWriterTest {

  private static final SpecificDatumWriter<AvroHttpRequestV1> WRITER_V1 = new SpecificDatumWriter<>(AvroHttpRequestV1.class);
  private static final SpecificDatumWriter<AvroHttpRequestV2> WRITER_V2 = new SpecificDatumWriter<>(AvroHttpRequestV2.class);
  private static final SpecificDatumReader<AvroHttpRequestV2> V1_TO_V2_READER = new SpecificDatumReader<>(AvroHttpRequestV1.getClassSchema(), AvroHttpRequestV2.getClassSchema());
  private static final SpecificDatumReader<AvroHttpRequestV2> V2_READER = new SpecificDatumReader<>(AvroHttpRequestV2.class);

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
    WRITER_V1.write(in, encoder);
    encoder.flush();

    AvroHttpRequestV2 out = V1_TO_V2_READER.read(null, DecoderFactory.get().binaryDecoder(buffer.toByteArray(), null));

    assertThat(out.getRequestTime()).isEqualTo(54321L);
    assertThat(out.getDepartment()).isEqualTo("🤷🏼‍♂️");
    assertThat(out.getClientIdentifier().getHostName()).isEqualTo("I AM A HOST");
  }

  @Test
  void canSerializeBigDecimal() throws IOException {
    AvroHttpRequestV2 in = AvroHttpRequestV2.newBuilder()
        .setRequestTime(123L)
        .setClientIdentifier(
            ClientIdentifier.newBuilder()
                .setHostName("foo")
                .setIpAddress("bar")
                .build()
        )
        .setActive(Active.YES)
        .setAmount(new BigDecimal("9.97"))
        .build();

    Encoder encoder = EncoderFactory.get().binaryEncoder(buffer, null);
    WRITER_V2.write(in, encoder);
    encoder.flush();

    AvroHttpRequestV2 out = V2_READER.read(null, DecoderFactory.get().binaryDecoder(buffer.toByteArray(), null));

    assertThat(out.getAmount()).isEqualTo(new BigDecimal("9.97"));
  }

  @AfterEach
  void tearDown() {
    buffer.reset();
  }
}