package de.spreclib.model.enums.precentrifugation;

public enum PreCentrifugationTemperature {
  ROOM_TEMPERATURE(18, 28),
  TWO_TO_TEN_DEGREES(2, 10),
  THIRTYFIVE_TO_THIRTYEIGHT_DEGREES(35, 38);

  PreCentrifugationTemperature(long lowerBound, long upperBound) {
    // TODO Bounds überarbeiten
  }
}
