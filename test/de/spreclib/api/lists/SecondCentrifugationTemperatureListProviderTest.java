package de.spreclib.api.lists;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import de.spreclib.api.lists.interfaces.IListOption;
import de.spreclib.api.lists.options.SecondCentrifugationTemperatureOption;
import de.spreclib.api.parameters.Temperature;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class SecondCentrifugationTemperatureListProviderTest {

  private SecondCentrifugationTemperatureListProvider secondCentrifugationTemperatureListProvider;
  private List<SecondCentrifugationTemperatureOption> secondCentrifugationTemperatureList;

  @Before
  public void setUp() {
    this.secondCentrifugationTemperatureListProvider =
        new SecondCentrifugationTemperatureListProvider();
    this.secondCentrifugationTemperatureList =
        secondCentrifugationTemperatureListProvider.getList();
  }

  @Test
  public void testListNotEmpty() {
    assertFalse(this.secondCentrifugationTemperatureList.isEmpty());
  }

  @Test
  public void testOptionStringRepresentation() {
    for (IListOption option : this.secondCentrifugationTemperatureList) {
      assertNotNull(option.getStringRepresentation());
    }
  }

  @Test
  public void testValueOfWithValidValue() {

    Temperature temperature = new Temperature(20f);

    SecondCentrifugationTemperatureOption secondCentrifugationTemperatureOption =
        this.secondCentrifugationTemperatureListProvider.valueOf(temperature);

    assertNotNull(secondCentrifugationTemperatureOption);
  }

  @Test
  public void testValueOfWithInvalidValue() {

    Temperature temperature = new Temperature(-20f);

    SecondCentrifugationTemperatureOption secondCentrifugationTemperatureOption =
        this.secondCentrifugationTemperatureListProvider.valueOf(temperature);

    assertNull(secondCentrifugationTemperatureOption);
  }

  @Test
  public void testValueOfWithNullValue() {

    SecondCentrifugationTemperatureOption secondCentrifugationTemperatureOption =
        this.secondCentrifugationTemperatureListProvider.valueOf(null);

    assertNull(secondCentrifugationTemperatureOption);
  }
}