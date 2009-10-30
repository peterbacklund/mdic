package rma;

import org.jscience.physics.amount.Amount;

import javax.measure.quantity.VolumetricDensity;

public class FASS {

  private static final Läkemedel MAGNECYL = new Läkemedel(
    "Magnecyl", Koncentration.mgPerKgKroppsvikt(20), Amount.valueOf(5, VolumetricDensity.UNIT)
  );

  public static Läkemedel slåUpp(String namn) {
    if (MAGNECYL.namn().equals(namn)) {
      return MAGNECYL;
    }

    return null;
  }
}
