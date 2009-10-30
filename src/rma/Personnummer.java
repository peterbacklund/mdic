package rma;

import org.joda.time.LocalDate;

public class Personnummer {
  private int fyraSista;
  private LocalDate datum;

  public Personnummer(LocalDate datum, int fyraSista) {
    this.datum = datum;
    this.fyraSista = fyraSista;
  }

  public LocalDate datum() {
    return datum;
  }

  @Override
  public String toString() {
    return datum.toString("yyyyMMdd") + "-" + fyraSista;
  }
}
