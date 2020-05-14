package de.spreclib.api.parameters;

public class Temperature {

  /**
   * Takes a temperature and returns the value in Celsius.
   *
   * <p>Can be extended to take other temperature values and convert them to degrees Celsius
   *
   * @author Christopher Meyer
   * @version 1.0
   */
  private final float temperatureCelsius;

  public Temperature(float temperatureCelsius) {

    temperatureCelsius = Math.round(temperatureCelsius);

    this.temperatureCelsius = temperatureCelsius;
  }

  public float getTemperatureCelsius() {
    return this.temperatureCelsius;
  }
}
