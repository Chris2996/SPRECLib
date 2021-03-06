package de.spreclib.api.main;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import de.spreclib.api.main.exceptions.UndefinedValueException;
import de.spreclib.api.main.interfaces.IListOption;
import de.spreclib.api.parameters.Temperature;
import de.spreclib.model.centrifugation.enums.FirstCentrifugationTemperature;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class FirstCentrifugationTemperatureListProviderTest {

  private FirstCentrifugationTemperatureListProvider firstCentrifugationTemperatureListProvider;
  private List<FirstCentrifugationTemperatureOption> firstCentrifugationTemperatureList;

  @Before
  public void setUp() {
    this.firstCentrifugationTemperatureListProvider =
        new FirstCentrifugationTemperatureListProvider();
    this.firstCentrifugationTemperatureList = firstCentrifugationTemperatureListProvider.getList();
  }

  @Test
  public void testListNotEmpty() {
    assertFalse(this.firstCentrifugationTemperatureList.isEmpty());
  }

  @Test
  public void testOptionStringRepresentation() {
    for (IListOption option : this.firstCentrifugationTemperatureList) {
      assertNotNull(option.getStringRepresentation());
    }
  }

  @Test
  public void testFullListSize() {
    int expected = FirstCentrifugationTemperature.values().length;
    int actual = firstCentrifugationTemperatureList.size();

    assertEquals(expected, actual);
  }

  @Test
  public void testValueOfWithValidValue() throws UndefinedValueException {

    Temperature temperature = new Temperature(20.9999f);

    FirstCentrifugationTemperatureOption firstCentrifugationTemperatureOption =
        this.firstCentrifugationTemperatureListProvider.valueOf(temperature);

    assertNotNull(firstCentrifugationTemperatureOption);
  }

  @Test(expected = UndefinedValueException.class)
  public void testValueOfWithInvalidValue() throws UndefinedValueException {

    Temperature temperature = new Temperature(-20f);

    this.firstCentrifugationTemperatureListProvider.valueOf(temperature);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testValueOfWithNullValue() throws UndefinedValueException {

    this.firstCentrifugationTemperatureListProvider.valueOf(null);
  }

  @Test
  public void testValueOfShouldReturnRoomTemperature() throws UndefinedValueException {

    Temperature temperature = new Temperature(28.49f);

    FirstCentrifugationTemperatureOption firstCentrifugationTemperatureOption =
        this.firstCentrifugationTemperatureListProvider.valueOf(temperature);

    assertEquals(
        FirstCentrifugationTemperature.ROOM_TEMPERATURE,
        firstCentrifugationTemperatureOption.getContainedObject());
  }

  @Test
  public void testValueOfShouldReturnTwoToTenDegreesUpperBound() throws UndefinedValueException {

    Temperature temperature = new Temperature(10.49f);

    FirstCentrifugationTemperatureOption firstCentrifugationTemperatureOption =
        this.firstCentrifugationTemperatureListProvider.valueOf(temperature);

    assertEquals(
        FirstCentrifugationTemperature.TWO_TO_TEN_DEGREES,
        firstCentrifugationTemperatureOption.getContainedObject());
  }

  @Test
  public void testValueOfShouldReturnTwoToTenDegreesLowerBound() throws UndefinedValueException {

    Temperature temperature = new Temperature(1.5f);

    FirstCentrifugationTemperatureOption firstCentrifugationTemperatureOption =
        this.firstCentrifugationTemperatureListProvider.valueOf(temperature);

    assertEquals(
        FirstCentrifugationTemperature.TWO_TO_TEN_DEGREES,
        firstCentrifugationTemperatureOption.getContainedObject());
  }
}
