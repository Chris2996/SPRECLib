package de.spreclib.api.lists;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import de.spreclib.api.exceptions.InvalidValueCombinationException;
import de.spreclib.api.lists.interfaces.IListOption;
import de.spreclib.api.parameters.Temperature;
import de.spreclib.model.sprec.CodePart;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class PreCentrifugationListProviderTest {

  private PreCentrifugationListProvider preCentrifugationListProvider;
  private List<PreCentrifugationOption> preCentrifugationList;

  @Before
  public void setUp() {
    this.preCentrifugationListProvider = new PreCentrifugationListProvider();
    this.preCentrifugationList = preCentrifugationListProvider.getList();
  }

  @Test
  public void testListNotEmpty() {
    assertFalse(this.preCentrifugationList.isEmpty());
  }

  @Test
  public void testOptionStringRepresentation() {
    for (IListOption option : this.preCentrifugationList) {
      assertNotNull(option.getStringRepresentation());
    }
  }

  @Test
  public void testValueOfWithValidValues() {

    PreCentrifugationTemperatureOption temperatureOption =
        new PreCentrifugationTemperatureListProvider().valueOf(new Temperature(10f));

    PreCentrifugationDelayOption delayOption = new PreCentrifugationDelayListProvider().valueOf(15);

    PreCentrifugationOption preCentrifugationOption =
        this.preCentrifugationListProvider.valueOf(delayOption, temperatureOption);

    assertNotNull(preCentrifugationOption);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testValueOfWithTemperatureOptionisNull() {

    PreCentrifugationDelayOption delayOption = new PreCentrifugationDelayListProvider().valueOf(15);

    this.preCentrifugationListProvider.valueOf(delayOption, null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testValueOfWithDelayOptionisNull() {

    PreCentrifugationTemperatureOption temperatureOption =
        new PreCentrifugationTemperatureListProvider().valueOf(new Temperature(10f));

    this.preCentrifugationListProvider.valueOf(null, temperatureOption);
  }

  @Test(expected = InvalidValueCombinationException.class)
  public void testWithInvalidParameterCombination() {

    PreCentrifugationTemperatureOption temperatureOption =
        new PreCentrifugationTemperatureListProvider().valueOf(new Temperature(35f));

    PreCentrifugationDelayOption delayOption =
        new PreCentrifugationDelayListProvider().valueOf(300);

    this.preCentrifugationListProvider.valueOf(delayOption, temperatureOption);
  }

  @Test
  public void testValueOfShouldReturnCodeA() {

    PreCentrifugationTemperatureOption temperatureOption =
        new PreCentrifugationTemperatureListProvider().valueOf(new Temperature(18f));

    PreCentrifugationDelayOption delayOption = new PreCentrifugationDelayListProvider().valueOf(59);

    PreCentrifugationOption preCentrifugationOption =
        this.preCentrifugationListProvider.valueOf(delayOption, temperatureOption);

    assertEquals(
        new CodePart("A"), preCentrifugationOption.getContainedObject().getCodeFromSprecPart());
  }

  @Test
  public void testValueOfShouldReturnCodeN() {

    PreCentrifugationTemperatureOption temperatureOption =
        new PreCentrifugationTemperatureListProvider().valueOf(new Temperature(10f));

    PreCentrifugationDelayOption delayOption =
        new PreCentrifugationDelayListProvider().valueOf(2880);

    PreCentrifugationOption preCentrifugationOption =
        this.preCentrifugationListProvider.valueOf(delayOption, temperatureOption);

    assertEquals(
        new CodePart("N"), preCentrifugationOption.getContainedObject().getCodeFromSprecPart());
  }
}
