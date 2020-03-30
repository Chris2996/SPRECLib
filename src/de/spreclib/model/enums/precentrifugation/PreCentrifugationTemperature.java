package de.spreclib.model.enums.precentrifugation;

import de.spreclib.model.interfaces.IListObject;

public enum PreCentrifugationTemperature implements IListObject {
  ROOM_TEMPERATURE(18, 28),
  TWO_TO_TEN_DEGREES(2, 10),
  THIRTYFIVE_TO_THIRTYEIGHT_DEGREES(35, 38);

  PreCentrifugationTemperature(float lowerBound, float upperBound) {
    // TODO Bounds überarbeiten
  }
}
