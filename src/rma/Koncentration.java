package rma;

import org.jscience.physics.amount.Amount;

import javax.measure.quantity.Mass;
import javax.measure.unit.BaseUnit;
import static javax.measure.unit.SI.*;

public class Koncentration {
  private double faktor;

  public Koncentration(Amount<Mass> substansvikt, BaseUnit<Mass> perEnhet) {
    this.faktor = substansvikt.doubleValue(perEnhet);
  }

  public static Koncentration mgPerKgKroppsvikt(int antalMilligram) {
    return new Koncentration(Amount.valueOf(antalMilligram, MILLI(GRAM)), KILOGRAM);
  }

  public Amount<Mass> milligramGivetKroppsvikt(Amount<Mass> kroppsvikt) {
    return kroppsvikt.times(faktor).to(MILLI(GRAM));
  }

  public double promille() {
    return faktor * 1000;
  }

  public double relativt(Koncentration koncentration) {
    return this.faktor / koncentration.faktor;
  }

  @Override
  public String toString() {
    return String.format("%.4g \u2030", promille());
  }

}
