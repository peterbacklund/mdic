package rma;

import org.joda.time.Duration;

public class Frekvens {
  private int ggr;
  private Duration tid;

  private Frekvens(int ggr, Duration tid) {
    this.ggr = ggr;
    this.tid = tid;
  }

  public static Frekvens ggrPerDygn(int ggr) {
    return new Frekvens(ggr, Duration.standardDays(1));
  }

  @Override
  public String toString() {
    int timmar = tid.toPeriod().getHours();
    return ggr + " ggr per " + timmar + " timmar";
  }
  
}
