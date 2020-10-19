package avro.cache;

import org.apache.avro.Schema;
import org.apache.avro.SchemaParseException;
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

  // Loads all the schemas from resources and parses them into the cache. Duplicates are ignored.
  private static void loadSchemas() throws RuntimeException {

    try (InputStream in = getResourceAsStream("/schemas"); BufferedReader br = new BufferedReader(new InputStreamReader(in))) {

      String resource;
      while ((resource = br.readLine()) != null) {
        try {
          CACHE.addSchema(PARSER.parse(getResourceAsStream("/schemas/" + resource)));
        } catch (SchemaParseException spe) {
          if (!spe.getMessage().startsWith("Can't redefine")) {
            throw spe;
          }
          // otherwise do nothing
        }
      }

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  private static InputStream getResourceAsStream(String resource) {
    return CacheProvider.class.getResourceAsStream(resource);
  }

}
