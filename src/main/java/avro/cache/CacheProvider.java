package avro.cache;

import org.apache.avro.Schema;
import org.apache.avro.message.SchemaStore;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CacheProvider {

  private static final Schema.Parser PARSER = new Schema.Parser();
  private static final SchemaStore.Cache CACHE = new SchemaStore.Cache();

  static {
    loadSchemas();
  }

  public static SchemaStore.Cache getCache() {
    return CACHE;
  }

  // Loads all the schemas from resources, appends them into a single string, and then parses it into the cache.
  //  The schemas are merged into a single string to avoid the duplicate definition problem
  private static void loadSchemas() throws RuntimeException {

    try (InputStream in = getResourceAsStream("/schemas");
         BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
      String resource;

      StringBuilder bob = new StringBuilder();
      while ((resource = br.readLine()) != null) {
        try (BufferedReader b = new BufferedReader(new InputStreamReader(getResourceAsStream("/schemas/" + resource)))) {
          String l;
          while ((l = b.readLine()) != null) {
            bob.append(l);
          }
        }
      }
      PARSER.parse(bob.toString());

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  private static InputStream getResourceAsStream(String resource) {
    final InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(resource);
    return in == null ? CacheProvider.class.getResourceAsStream(resource) : in;
  }

}
