package avro;

import org.apache.avro.Schema;
import org.apache.avro.message.SchemaStore;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import avro.cache.CacheProvider;
import avro.model.DumbIntRequest;
import avro.model.DumbIntRequest2;

import static avro.util.ByteUtil.xxd;
import static org.assertj.core.api.Assertions.assertThat;

class ModelEncodingTest {

  private static final boolean PRINT_BYTES = false;

  private final SchemaStore.Cache cache = CacheProvider.getCache();
  private final ByteArrayOutputStream buffer = new ByteArrayOutputStream();

  @Test
  void canSerializeAndDeserializeSameSchema() throws IOException {

    DumbIntRequest in = new DumbIntRequest(42L);
    DumbIntRequest.getEncoder().encode(in, buffer);

    inspect();

    DumbIntRequest out = DumbIntRequest.getDecoder().decode(buffer.toByteArray(), null);

    assertThat(out).isEqualTo(in);
  }

  @Test
  void canSerializeOldSchemaAndDeserializeNewSchema() throws IOException {
    DumbIntRequest in = new DumbIntRequest(42L);

    DumbIntRequest.getEncoder().encode(in, buffer);

    inspect();

    DumbIntRequest2 out = DumbIntRequest2.createDecoder(cache).decode(buffer.toByteArray());

    assertThat(out).isEqualToComparingOnlyGivenFields(in, "val1");
    assertThat(out.getVal2()).isEqualTo(-1);
  }

  @AfterEach
  void tearDown() {
    buffer.reset();
  }

  private void inspect() {
    if (PRINT_BYTES) {
      System.out.println(xxd(buffer.toByteArray()));
    }
  }
}