package de.spreclib.api.lists;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import de.spreclib.api.exceptions.InvalidParameterCombinationException;
import de.spreclib.api.lists.interfaces.IListOption;
import de.spreclib.api.lists.options.FirstCentrifugationBrakingOption;
import de.spreclib.api.lists.options.FirstCentrifugationDurationOption;
import de.spreclib.api.lists.options.FirstCentrifugationOption;
import de.spreclib.api.lists.options.FirstCentrifugationSpeedOption;
import de.spreclib.api.lists.options.FirstCentrifugationTemperatureOption;
import de.spreclib.api.parameters.Temperature;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class FirstCentrifugationListProviderTest {

  private FirstCentrifugationListProvider firstCentrifugationListProvider;
  private List<FirstCentrifugationOption> firstCentrifugationList;

  @Before
  public void setUp() {
    this.firstCentrifugationListProvider = new FirstCentrifugationListProvider();
    this.firstCentrifugationList = firstCentrifugationListProvider.getList();
  }

  @Test
  public void testListNotEmpty() {
    assertFalse(firstCentrifugationList.isEmpty());
  }

  @Test
  public void testOptionStringRepresentation() {
    for (IListOption option : firstCentrifugationList) {
      assertNotNull(option.getStringRepresentation());
    }
  }

  @Test
  public void testValueOfWithValidValues() {

    Temperature temperature = new Temperature(20f);

    FirstCentrifugationTemperatureOption firstCentrifugationTemperatureOption =
        new FirstCentrifugationTemperatureListProvider().valueOf(temperature);
    FirstCentrifugationDurationOption firstCentrifugationDurationOption =
        new FirstCentrifugationDurationListProvider().valueOf(15);
    FirstCentrifugationSpeedOption firstCentrifugationSpeedOption =
        new FirstCentrifugationSpeedListProvider().valueOf(3000);
    FirstCentrifugationBrakingOption firstCentrifugationBrakingOption =
        new FirstCentrifugationBrakingListProvider().valueOf(true);

    FirstCentrifugationOption firstCentrifugationOption =
        this.firstCentrifugationListProvider.valueOf(
            firstCentrifugationTemperatureOption,
            firstCentrifugationDurationOption,
            firstCentrifugationSpeedOption,
            firstCentrifugationBrakingOption);

    assertNotNull(firstCentrifugationOption);
  }

  @Test(expected = InvalidParameterCombinationException.class)
  public void testValueOfWithInvalidParameterCombination() {

    Temperature temperature = new Temperature(20f);

    FirstCentrifugationTemperatureOption firstCentrifugationTemperatureOption =
        new FirstCentrifugationTemperatureListProvider().valueOf(temperature);
    FirstCentrifugationDurationOption firstCentrifugationDurationOption =
        new FirstCentrifugationDurationListProvider().valueOf(15);
    // Speed 100g is invalid in this combination
    FirstCentrifugationSpeedOption firstCentrifugationSpeedOption =
        new FirstCentrifugationSpeedListProvider().valueOf(100);
    FirstCentrifugationBrakingOption firstCentrifugationBrakingOption =
        new FirstCentrifugationBrakingListProvider().valueOf(true);

    this.firstCentrifugationListProvider.valueOf(
        firstCentrifugationTemperatureOption,
        firstCentrifugationDurationOption,
        firstCentrifugationSpeedOption,
        firstCentrifugationBrakingOption);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testWithTemperatureOptionIsNull() {

    FirstCentrifugationDurationOption firstCentrifugationDurationOption =
        new FirstCentrifugationDurationListProvider().valueOf(15);
    FirstCentrifugationSpeedOption firstCentrifugationSpeedOption =
        new FirstCentrifugationSpeedListProvider().valueOf(3000);
    FirstCentrifugationBrakingOption firstCentrifugationBrakingOption =
        new FirstCentrifugationBrakingListProvider().valueOf(true);

    this.firstCentrifugationListProvider.valueOf(
        null,
        firstCentrifugationDurationOption,
        firstCentrifugationSpeedOption,
        firstCentrifugationBrakingOption);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testWithDurationOptionIsNull() {

    Temperature temperature = new Temperature(20f);

    FirstCentrifugationTemperatureOption firstCentrifugationTemperatureOption =
        new FirstCentrifugationTemperatureListProvider().valueOf(temperature);
    FirstCentrifugationSpeedOption firstCentrifugationSpeedOption =
        new FirstCentrifugationSpeedListProvider().valueOf(3000);
    FirstCentrifugationBrakingOption firstCentrifugationBrakingOption =
        new FirstCentrifugationBrakingListProvider().valueOf(true);

    this.firstCentrifugationListProvider.valueOf(
        firstCentrifugationTemperatureOption,
        null,
        firstCentrifugationSpeedOption,
        firstCentrifugationBrakingOption);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testWithSpeedOptionIsNull() {

    Temperature temperature = new Temperature(20f);

    FirstCentrifugationTemperatureOption firstCentrifugationTemperatureOption =
        new FirstCentrifugationTemperatureListProvider().valueOf(temperature);
    FirstCentrifugationDurationOption firstCentrifugationDurationOption =
        new FirstCentrifugationDurationListProvider().valueOf(15);
    FirstCentrifugationBrakingOption firstCentrifugationBrakingOption =
        new FirstCentrifugationBrakingListProvider().valueOf(true);

    this.firstCentrifugationListProvider.valueOf(
        firstCentrifugationTemperatureOption,
        firstCentrifugationDurationOption,
        null,
        firstCentrifugationBrakingOption);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testWithBrakingOptionIsNull() {

    Temperature temperature = new Temperature(20f);

    FirstCentrifugationTemperatureOption firstCentrifugationTemperatureOption =
        new FirstCentrifugationTemperatureListProvider().valueOf(temperature);
    FirstCentrifugationDurationOption firstCentrifugationDurationOption =
        new FirstCentrifugationDurationListProvider().valueOf(15);
    FirstCentrifugationSpeedOption firstCentrifugationSpeedOption =
        new FirstCentrifugationSpeedListProvider().valueOf(100);

    this.firstCentrifugationListProvider.valueOf(
        firstCentrifugationTemperatureOption,
        firstCentrifugationDurationOption,
        firstCentrifugationSpeedOption,
        null);
  }
}
