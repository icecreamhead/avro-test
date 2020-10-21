package avro.proto;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

public class BasicPojo {

  private final long id;
  private final String name;
//  private final ZonedDateTime timestamp;
  private final BigDecimal[] rates;

  public BasicPojo(long id, String name, /*ZonedDateTime timestamp,*/ BigDecimal[] rates) {
    this.id = id;
    this.name = name;
//    this.timestamp = timestamp;
    this.rates = rates;
  }

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

//  public ZonedDateTime getTimestamp() {
//    return timestamp;
//  }

  public BigDecimal[] getRates() {
    return rates;
  }
}
