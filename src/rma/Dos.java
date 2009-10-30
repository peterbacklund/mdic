package rma;

import org.jscience.physics.amount.Amount;

import javax.measure.quantity.Mass;
import javax.measure.quantity.Volume;

public class Dos {

  private Läkemedel läkemedel;
  private Amount<Volume> mängdPerMedicinering;
  private double relativtRekommendation;

  public Dos(Läkemedel läkemedel, Koncentration koncentration, Amount<Mass> kroppsvikt) {
    this.läkemedel = läkemedel;
    Amount<Mass> mgLäkemedel = koncentration.milligramGivetKroppsvikt(kroppsvikt);
    this.mängdPerMedicinering = läkemedel.milliliterFör(mgLäkemedel);
    this.relativtRekommendation = koncentration.relativt(läkemedel.rekommenderadKoncentration());
  }

  public Läkemedel läkemedel() {
    return läkemedel;
  }

  public Amount<Volume> mängdPerTillfälle() {
    return mängdPerMedicinering;
  }

  public double relativtRekommendation() {
    return relativtRekommendation;
  }

  public boolean överdosering() {
    return relativtRekommendation > 1.0;
  }

  public boolean underdosering() {
    return relativtRekommendation < 1.0;
  }

  @Override
  public String toString() {
    return mängdPerMedicinering + " " + läkemedel + " (" + relativtRekommendation * 100 + " % av rekommenderad dos)";
  }
}
