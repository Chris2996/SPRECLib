package de.spreclib.api.lists;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import de.spreclib.api.lists.interfaces.IListOption;
import de.spreclib.api.lists.options.SecondCentrifugationBrakingOption;
import de.spreclib.api.lists.options.SecondCentrifugationDurationOption;
import de.spreclib.api.lists.options.SecondCentrifugationOption;
import de.spreclib.api.lists.options.SecondCentrifugationSpeedOption;
import de.spreclib.api.lists.options.SecondCentrifugationTemperatureOption;
import de.spreclib.api.parameters.Temperature;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class SecondCentrifugationListProviderTest {

  private SecondCentrifugationListProvider secondCentrifugationListProvider;
  private List<SecondCentrifugationOption> secondCentrifugationList;

  @Before
  public void setUp() {
    this.secondCentrifugationListProvider = new SecondCentrifugationListProvider();
    this.secondCentrifugationList = secondCentrifugationListProvider.getList();
  }

  @Test
  public void testListNotEmpty() {
    assertFalse(this.secondCentrifugationList.isEmpty());
  }

  @Test
  public void testOptionStringRepresentation() {
    for (IListOption option : this.secondCentrifugationList) {
      assertNotNull(option.getStringRepresentation());
    }
  }

  @Test
  public void testValueOfWithValidValues() {

    Temperature temperature = new Temperature(20f);

    SecondCentrifugationTemperatureOption secondCentrifugationTemperatureOption =
        new SecondCentrifugationTemperatureListProvider().valueOf(temperature);
    SecondCentrifugationDurationOption secondCentrifugationDurationOption =
        new SecondCentrifugationDurationListProvider().valueOf(15);
    SecondCentrifugationSpeedOption secondCentrifugationSpeedOption =
        new SecondCentrifugationSpeedListProvider().valueOf(3000);
    SecondCentrifugationBrakingOption secondCentrifugationBrakingOption =
        new SecondCentrifugationBrakingListProvider().valueOf(true);

    SecondCentrifugationOption secondCentrifugationOption =
        this.secondCentrifugationListProvider.valueOf(
            secondCentrifugationTemperatureOption,
            secondCentrifugationDurationOption,
            secondCentrifugationSpeedOption,
            secondCentrifugationBrakingOption);

    assertNotNull(secondCentrifugationOption);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testWithTemperatureOptionIsNull() {

    SecondCentrifugationDurationOption secondCentrifugationDurationOption =
        new SecondCentrifugationDurationListProvider().valueOf(15);
    SecondCentrifugationSpeedOption secondCentrifugationSpeedOption =
        new SecondCentrifugationSpeedListProvider().valueOf(3000);
    SecondCentrifugationBrakingOption secondCentrifugationBrakingOption =
        new SecondCentrifugationBrakingListProvider().valueOf(true);

    this.secondCentrifugationListProvider.valueOf(
        null,
        secondCentrifugationDurationOption,
        secondCentrifugationSpeedOption,
        secondCentrifugationBrakingOption);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testWithDurationOptionIsNull() {

    Temperature temperature = new Temperature(20f);

    SecondCentrifugationTemperatureOption secondCentrifugationTemperatureOption =
        new SecondCentrifugationTemperatureListProvider().valueOf(temperature);
    SecondCentrifugationSpeedOption secondCentrifugationSpeedOption =
        new SecondCentrifugationSpeedListProvider().valueOf(3000);
    SecondCentrifugationBrakingOption secondCentrifugationBrakingOption =
        new SecondCentrifugationBrakingListProvider().valueOf(true);

    this.secondCentrifugationListProvider.valueOf(
        secondCentrifugationTemperatureOption,
        null,
        secondCentrifugationSpeedOption,
        secondCentrifugationBrakingOption);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testWithSpeedOptionIsNull() {

    Temperature temperature = new Temperature(20f);

    SecondCentrifugationTemperatureOption secondCentrifugationTemperatureOption =
        new SecondCentrifugationTemperatureListProvider().valueOf(temperature);
    SecondCentrifugationDurationOption secondCentrifugationDurationOption =
        new SecondCentrifugationDurationListProvider().valueOf(15);
    SecondCentrifugationBrakingOption secondCentrifugationBrakingOption =
        new SecondCentrifugationBrakingListProvider().valueOf(true);

    this.secondCentrifugationListProvider.valueOf(
        secondCentrifugationTemperatureOption,
        secondCentrifugationDurationOption,
        null,
        secondCentrifugationBrakingOption);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testWithBrakingOptionIsNull() {

    Temperature temperature = new Temperature(20f);

    SecondCentrifugationTemperatureOption secondCentrifugationTemperatureOption =
        new SecondCentrifugationTemperatureListProvider().valueOf(temperature);
    SecondCentrifugationDurationOption secondCentrifugationDurationOption =
        new SecondCentrifugationDurationListProvider().valueOf(15);
    SecondCentrifugationSpeedOption secondCentrifugationSpeedOption =
        new SecondCentrifugationSpeedListProvider().valueOf(100);

    this.secondCentrifugationListProvider.valueOf(
        secondCentrifugationTemperatureOption,
        secondCentrifugationDurationOption,
        secondCentrifugationSpeedOption,
        null);
  }
}