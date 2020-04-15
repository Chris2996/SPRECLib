package de.spreclib.api.lists.options;

import de.spreclib.model.enums.centrifugation.SecondCentrifugationTemperature;

/**
 * SecondCentrifugationTemperatureOption
 *
 * <p>To obtain the name of the ListOption e.g. for usage in GUIs use getStringRepresentation()
 *
 * @author Christopher Meyer
 * @version 1.0
 */
public final class SecondCentrifugationTemperatureOption extends AbstractListOption {

  private final SecondCentrifugationTemperature secondCentrifugationTemperature;

  public SecondCentrifugationTemperatureOption(
      SecondCentrifugationTemperature secondCentrifugationTemperature) {
    this.secondCentrifugationTemperature = secondCentrifugationTemperature;
  }

  @Override
  public String getStringRepresentation() {
    return NAMES_DEFAULT.getString(this.secondCentrifugationTemperature.name());
  }

  @Override
  public SecondCentrifugationTemperature getContainedObject() {
    return this.secondCentrifugationTemperature;
  }

  public boolean hasTemperature(float temperatureCelsius) {
    if (this.secondCentrifugationTemperature.hasValueFor(temperatureCelsius)) {
      return true;
    } else {
      return false;
    }
  }
}