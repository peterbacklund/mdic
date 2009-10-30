package rma;

import static org.hamcrest.core.Is.is;
import org.joda.time.LocalDate;
import org.jscience.physics.amount.Amount;
import static org.jscience.physics.amount.Amount.valueOf;
import static org.junit.Assert.*;
import org.junit.Test;

import javax.measure.quantity.Mass;
import javax.measure.quantity.Volume;
import static javax.measure.unit.NonSI.LITER;
import static javax.measure.unit.SI.KILOGRAM;
import static javax.measure.unit.SI.MILLI;

public class Blog {

  @Test
  public void ordinationEnligtRekommendation() {
    Läkemedel läkemedel = FASS.slåUpp("Magnecyl");

    Personnummer personnummer = new Personnummer(new LocalDate(1950, 1, 2), 1234);
    Amount<Mass> kroppsvikt = valueOf(75, KILOGRAM);
    Patient patient = new Patient(personnummer, kroppsvikt);

    Koncentration koncentration = Koncentration.mgPerKgKroppsvikt(20);
    Frekvens frekvens = Frekvens.ggrPerDygn(4);
    Ordination ordination = new Ordination(läkemedel, koncentration, frekvens);

    Dos dos = patient.dosVidOrdination(ordination);

    assertThat(dos.läkemedel(), is(läkemedel));

    Amount<Volume> förväntadMängd = valueOf(300, 0.001, MILLI(LITER));
    assertTrue(dos.mängdPerTillfälle().approximates(förväntadMängd));

    assertThat(dos.relativtRekommendation(), is(1.0));
    assertFalse(dos.överdosering());
    assertFalse(dos.underdosering());

    System.out.println("Patient: " + patient);
    System.out.println("Läkemedel: " + läkemedel);
    System.out.println("Ordination: " + ordination);
    System.out.println("Dos: " + dos);
  }

}
