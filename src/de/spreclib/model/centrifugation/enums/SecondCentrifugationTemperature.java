package de.spreclib.model.centrifugation.enums;

import de.spreclib.model.interfaces.IListProvideable;

public enum SecondCentrifugationTemperature
    implements ICentrifugationTemperature, IListProvideable {
  ROOM_TEMPERATURE(18, 28),
  TWO_TO_TEN_DEGREES(2, 10);

  private final float lowerBoundCelsius;
  private final float upperBoundCelsius;

  SecondCentrifugationTemperature(float lowerBound, float upperBound) {
    this.lowerBoundCelsius = lowerBound;
    this.upperBoundCelsius = upperBound;
  }

  public boolean hasValue(float temperatureCelsius) {

    if (temperatureCelsius >= this.lowerBoundCelsius
        && temperatureCelsius < this.upperBoundCelsius + 1) {
      return true;
    } else {
      return false;
    }
  }
}
