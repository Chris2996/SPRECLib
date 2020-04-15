package de.spreclib.api.lists;

import de.spreclib.api.exceptions.InvalidParameterCombinationException;
import de.spreclib.api.lists.options.FirstCentrifugationBrakingOption;
import de.spreclib.api.lists.options.FirstCentrifugationDurationOption;
import de.spreclib.api.lists.options.FirstCentrifugationOption;
import de.spreclib.api.lists.options.FirstCentrifugationSpeedOption;
import de.spreclib.api.lists.options.FirstCentrifugationTemperatureOption;
import de.spreclib.model.centrifugation.Centrifugation;
import de.spreclib.model.centrifugation.FirstCentrifugationList;
import java.util.ArrayList;
import java.util.List;

/**
 * ListProvider for FirstCentrifugationOptions.
 *
 * <p>Use the valueOf() method to receive a ListOption if a ListOption for the value can be found.
 *
 * @author Christopher Meyer
 * @version 1.0
 * @see de.spreclib.api.lists.options.FirstCentrifugationOption
 */
public final class FirstCentrifugationListProvider {

  private final List<FirstCentrifugationOption> firstCentrifugationOptions;

  public FirstCentrifugationListProvider() {
    this.firstCentrifugationOptions = generateList();
  }

  private List<FirstCentrifugationOption> generateList() {
    List<FirstCentrifugationOption> firstCentrifugationOptions = new ArrayList<>();
    for (Centrifugation firstCentrifugation : FirstCentrifugationList.CENTRIFUGATIONS) {
      FirstCentrifugationOption firstCentrifugationOption =
          new FirstCentrifugationOption(firstCentrifugation);
      firstCentrifugationOptions.add(firstCentrifugationOption);
    }
    return firstCentrifugationOptions;
  }

  public List<FirstCentrifugationOption> getList() {
    return this.firstCentrifugationOptions;
  }

  /**
   * Takes all parameters for FirstCentrifugation and returns an option if a FirstCentrifugation
   * with that combination is found. Returns null otherwise.
   *
   * @param firstCentrifugationTemperatureOption FirstCentrifugationTemperatureOption
   * @param firstCentrifugationDurationOption FirstCentrifugationDurationOption
   * @param firstCentrifugationSpeedOption FirstCentrifugationSpeedOption
   * @param firstCentrifugationBrakingOption FirstCentrifugationBrakingOption
   * @return FirstCentrifugationOption
   * @throws InvalidParameterCombinationException if parameter cannot be found in ListOptions
   * @throws IllegalArgumentException if parameter is null
   */
  public FirstCentrifugationOption valueOf(
      FirstCentrifugationTemperatureOption firstCentrifugationTemperatureOption,
      FirstCentrifugationDurationOption firstCentrifugationDurationOption,
      FirstCentrifugationSpeedOption firstCentrifugationSpeedOption,
      FirstCentrifugationBrakingOption firstCentrifugationBrakingOption) {

    if (firstCentrifugationTemperatureOption == null) {
      throw new IllegalArgumentException("FirstCentrifugationTemperatureOption cannot be null");
    }

    if (firstCentrifugationDurationOption == null) {
      throw new IllegalArgumentException("FirstCentrifugationDurationOption cannot be null");
    }

    if (firstCentrifugationSpeedOption == null) {
      throw new IllegalArgumentException("FirstCentrifugationSpeedOption cannot be null");
    }

    if (firstCentrifugationBrakingOption == null) {
      throw new IllegalArgumentException("FirstCentrifugationBrakingOption cannot be null");
    }

    for (FirstCentrifugationOption firstCentrifugationOption : this.firstCentrifugationOptions) {
      if (firstCentrifugationOption.hasFirstCentrifugation(
          firstCentrifugationTemperatureOption,
          firstCentrifugationDurationOption,
          firstCentrifugationSpeedOption,
          firstCentrifugationBrakingOption)) {
        return firstCentrifugationOption;
      }
    }
    throw new InvalidParameterCombinationException(
        "Parameter combination for FirstCentrifugation is no valid combination.");
  }
}