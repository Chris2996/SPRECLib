package de.spreclib.api.lists.options;

import de.spreclib.model.enums.centrifugation.CentrifugationBraking;
import de.spreclib.model.enums.centrifugation.CentrifugationType;
import de.spreclib.model.enums.centrifugation.SecondCentrifugationDuration;
import de.spreclib.model.enums.centrifugation.SecondCentrifugationSpeed;
import de.spreclib.model.enums.centrifugation.SecondCentrifugationTemperature;
import de.spreclib.model.spreclib.centrifugation.Centrifugation;
import de.spreclib.model.spreclib.centrifugation.NormalCentrifugation;

public final class SecondCentrifugationOption extends AbstractListOption {

  private final Centrifugation secondCentrifugation;

  public SecondCentrifugationOption(Centrifugation secondCentrifugation) {
    this.secondCentrifugation = secondCentrifugation;
  }

  @Override
  public String getStringRepresentation() {
    StringBuilder name = new StringBuilder();

    CentrifugationType centrifugationType = this.secondCentrifugation.getCentrifugationType();

    name.append(NAMES_DEFAULT.getString(centrifugationType.name()));

    if (this.secondCentrifugation.isNormalCentrifugation()) {

      NormalCentrifugation normalCentrifugation = (NormalCentrifugation) this.secondCentrifugation;

      SecondCentrifugationTemperature centrifugationTemperature =
          (SecondCentrifugationTemperature) normalCentrifugation.getCentrifugationTemperature();
      SecondCentrifugationDuration centrifugationDuration =
          (SecondCentrifugationDuration) normalCentrifugation.getCentrifugationDuration();
      SecondCentrifugationSpeed centrifugationSpeed =
          (SecondCentrifugationSpeed) normalCentrifugation.getCentrifugationSpeed();
      CentrifugationBraking centrifugationBraking = normalCentrifugation.getCentrifugationBraking();

      name.append(NAMES_DEFAULT.getString(centrifugationTemperature.name()))
          .append(" ")
          .append(NAMES_DEFAULT.getString(centrifugationDuration.name()))
          .append(" ")
          .append(NAMES_DEFAULT.getString(centrifugationSpeed.name()))
          .append(" ")
          .append(NAMES_DEFAULT.getString(centrifugationBraking.name()));
    }

    return name.toString();
  }

  @Override
  public Centrifugation getContainedObject() {
    return this.secondCentrifugation;
  }
}
