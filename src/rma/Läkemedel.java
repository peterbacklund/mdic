package rma;

import org.jscience.physics.amount.Amount;

import javax.measure.quantity.VolumetricDensity;
import javax.measure.quantity.Volume;
import javax.measure.quantity.Mass;
import static javax.measure.unit.SI.*;
import static javax.measure.unit.NonSI.*;

public class Läkemedel {
  private String namn;
  private Koncentration koncentration;
  private Amount<VolumetricDensity> densitet;

  public Läkemedel(String namn, Koncentration koncentration, Amount<VolumetricDensity> densitet) {
    this.namn = namn;
    this.koncentration = koncentration;
    this.densitet = densitet;
  }

  public String namn() {
    return namn;
  }

  public Koncentration rekommenderadKoncentration() {
    return koncentration;
  }

  public Amount<Volume> milliliterFör(Amount<Mass> massa) {
    return massa.divide(densitet).to(MILLI(LITER));
  }

  @Override
  public String toString() {
    return namn;
  }
}
