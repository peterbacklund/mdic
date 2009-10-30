package rma;

public class Ordination {

  private Läkemedel läkemedel;
  private Koncentration koncentration;
  private Frekvens frekvens;

  public Ordination(Läkemedel läkemedel, Koncentration koncentration, Frekvens frekvens) {
    this.läkemedel = läkemedel;
    this.koncentration = koncentration;
    this.frekvens = frekvens;
  }

  public Läkemedel läkemedel() {
    return läkemedel;
  }

  public Koncentration koncentration() {
    return koncentration;
  }

  public Frekvens frekvens() {
    return frekvens;
  }

  @Override
  public String toString() {
    return koncentration + " " + läkemedel + ", " + frekvens;
  }
}
