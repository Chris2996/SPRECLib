package de.spreclib.api.main;

import de.spreclib.api.main.exceptions.UndefinedValueCombinationException;
import de.spreclib.api.main.interfaces.IFactorListProvider;
import de.spreclib.model.centrifugation.Centrifugation;
import de.spreclib.model.centrifugation.SecondCentrifugationList;
import java.util.ArrayList;
import java.util.List;

/**
 * ListProvider for SecondCentrifugationOptions.
 *
 * <p>Use the valueOf() method to receive a ListOption if a ListOption for the value can be found.
 *
 * @author Christopher Meyer
 * @version 1.0
 * @see de.spreclib.api.main.SecondCentrifugationOption
 */
public final class SecondCentrifugationListProvider
    extends AbstractListProvider<SecondCentrifugationOption>
    implements IFactorListProvider<SecondCentrifugationOption> {

  public SecondCentrifugationListProvider() {
    super();
  }

  @Override
  List<SecondCentrifugationOption> generateList() {
    List<SecondCentrifugationOption> secondCentrifugationOptions = new ArrayList<>();
    for (Centrifugation secondCentrifugation : SecondCentrifugationList.SECOND_CENTRIFUGATIONS) {
      SecondCentrifugationOption secondCentrifugationOption =
          new SecondCentrifugationOption(secondCentrifugation);
      secondCentrifugationOptions.add(secondCentrifugationOption);
    }
    return secondCentrifugationOptions;
  }

  /**
   * Takes all parameters for SecondCentrifugation and returns an option if a SecondCentrifugation
   * with that combination is found.
   *
   * @param secondCentrifugationTemperatureOption SecondCentrifugationTemperatureOption
   * @param secondCentrifugationDurationOption SecondCentrifugationDurationOption
   * @param secondCentrifugationSpeedOption SecondCentrifugationSpeedOption
   * @param secondCentrifugationBrakingOption SecondCentrifugationBrakingOption
   * @return SecondCentrifugationOption
   * @throws UndefinedValueCombinationException if parameter cannot be found in ListOptions
   * @throws IllegalArgumentException if parameter is null
   */
  public SecondCentrifugationOption valueOf(
      SecondCentrifugationTemperatureOption secondCentrifugationTemperatureOption,
      SecondCentrifugationDurationOption secondCentrifugationDurationOption,
      SecondCentrifugationSpeedOption secondCentrifugationSpeedOption,
      SecondCentrifugationBrakingOption secondCentrifugationBrakingOption)
      throws UndefinedValueCombinationException {

    if (secondCentrifugationTemperatureOption == null) {
      throw new IllegalArgumentException("SecondCentrifugationTemperatureOption cannot be null.");
    }

    if (secondCentrifugationDurationOption == null) {
      throw new IllegalArgumentException("SecondCentrifugationDurationOption cannot be null.");
    }

    if (secondCentrifugationSpeedOption == null) {
      throw new IllegalArgumentException("SecondCentrifugationSpeedOption cannot be null.");
    }

    if (secondCentrifugationBrakingOption == null) {
      throw new IllegalArgumentException("SecondCentrifugationBrakingOption cannot be null.");
    }

    for (SecondCentrifugationOption secondCentrifugationOption : this.listOptions) {
      if (secondCentrifugationOption.hasSecondCentrifugation(
          secondCentrifugationTemperatureOption,
          secondCentrifugationDurationOption,
          secondCentrifugationSpeedOption,
          secondCentrifugationBrakingOption)) {
        return secondCentrifugationOption;
      }
    }
    throw new UndefinedValueCombinationException(
        "Parameter combination for SecondCentrifugation is undefined in SPREC.");
  }

  @Override
public SecondCentrifugationOption getOptionFromCodeString(String codeString) {
    for (SecondCentrifugationOption secondCentrifugationOption : this.listOptions) {
      if (secondCentrifugationOption.hasCodeString(codeString)) {
        return secondCentrifugationOption;
      }
    }
    return null;
  }
}
