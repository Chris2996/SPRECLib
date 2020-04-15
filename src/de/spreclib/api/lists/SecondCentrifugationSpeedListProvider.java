package de.spreclib.api.lists;

import de.spreclib.api.lists.options.SecondCentrifugationSpeedOption;
import de.spreclib.model.enums.centrifugation.SecondCentrifugationSpeed;
import java.util.ArrayList;
import java.util.List;

/**
 * ListProvider for SecondCentrifugationSpeedOptions.
 *
 * <p>Use the valueOf() method to receive a ListOption if a ListOption for the value can be found.
 *
 * @author Christopher Meyer
 * @version 1.0
 * @see de.spreclib.api.lists.options.SecondCentrifugationSpeedOption
 */
public final class SecondCentrifugationSpeedListProvider {

  private final List<SecondCentrifugationSpeedOption> secondCentrifugationSpeedOptions;

  public SecondCentrifugationSpeedListProvider() {
    this.secondCentrifugationSpeedOptions = generateList();
  }

  private List<SecondCentrifugationSpeedOption> generateList() {
    List<SecondCentrifugationSpeedOption> secondCentrifugationSpeedOptions = new ArrayList<>();
    for (SecondCentrifugationSpeed secondCentrifugationSpeed : SecondCentrifugationSpeed.values()) {
      SecondCentrifugationSpeedOption secondCentrifugationSpeedOption =
          new SecondCentrifugationSpeedOption(secondCentrifugationSpeed);
      secondCentrifugationSpeedOptions.add(secondCentrifugationSpeedOption);
    }
    return secondCentrifugationSpeedOptions;
  }

  public List<SecondCentrifugationSpeedOption> getList() {
    return this.secondCentrifugationSpeedOptions;
  }

  /**
   * Takes a speed in G integer and returns a SecondCentrifugationSpeedOption if a
   * SecondCentrifugationSpeedOption with that speed is found. Returns null otherwise.
   *
   * @param speed Centrifugation speed in g
   * @return SecondCentrifugationSpeedOption
   */
  public SecondCentrifugationSpeedOption valueOf(int speed) {
    for (SecondCentrifugationSpeedOption secondCentrifugationSpeedOption :
        this.secondCentrifugationSpeedOptions) {

      if (secondCentrifugationSpeedOption.hasSpeed(speed)) {
        return secondCentrifugationSpeedOption;
      }
    }
    return null;
  }
}