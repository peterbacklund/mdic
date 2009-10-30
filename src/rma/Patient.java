package rma;

import org.jscience.physics.amount.Amount;
import org.joda.time.Period;
import org.joda.time.LocalDate;

import javax.measure.quantity.Mass;

public class Patient {
  private Personnummer personnummer;
  private Amount<Mass> kroppsvikt;

  public Patient(Personnummer personnummer, Amount<Mass> kroppsvikt) {
    this.personnummer = personnummer;
    this.kroppsvikt = kroppsvikt;
  }

  public Personnummer personnummer() {
    return personnummer;
  }

  public Dos dosVidOrdination(Ordination ordination) {
    return new Dos(ordination.läkemedel(), ordination.koncentration(), this.kroppsvikt);
  }

  public int ålder() {
    return new Period(personnummer.datum(), new LocalDate()).getYears();
  }

  @Override
  public String toString() {
    return personnummer + " (" + ålder() + " år), vikt: " + kroppsvikt;
  }

}
