package de.spreclib.api.main;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import de.spreclib.api.main.exceptions.UndefinedValueException;
import de.spreclib.api.main.interfaces.IListOption;
import de.spreclib.model.centrifugation.enums.CentrifugationBraking;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class SecondCentrifugationBrakingListProviderTest {

  private SecondCentrifugationBrakingListProvider secondCentrifugationBrakingListProvider;
  private List<SecondCentrifugationBrakingOption> secondCentrifugationBrakingList;

  @Before
  public void setUp() {
    this.secondCentrifugationBrakingListProvider = new SecondCentrifugationBrakingListProvider();
    this.secondCentrifugationBrakingList = secondCentrifugationBrakingListProvider.getList();
  }

  @Test
  public void testListNotEmpty() {
    assertFalse(this.secondCentrifugationBrakingList.isEmpty());
  }

  @Test
  public void testOptionStringRepresentation() {
    for (IListOption option : this.secondCentrifugationBrakingList) {
      assertNotNull(option.getStringRepresentation());
    }
  }

  @Test
  public void testFullListSize() {
    int expected = CentrifugationBraking.values().length;
    int actual = secondCentrifugationBrakingList.size();

    assertEquals(expected, actual);
  }

  @Test
  public void testWithValidValue() throws UndefinedValueException {

    SecondCentrifugationBrakingOption brakingOption =
        this.secondCentrifugationBrakingListProvider.valueOf(true);

    assertNotNull(brakingOption);
  }

  @Test
  public void testValueOfShouldReturnWithBraking() throws UndefinedValueException {

    SecondCentrifugationBrakingOption brakingOption =
        secondCentrifugationBrakingListProvider.valueOf(true);

    assertEquals(CentrifugationBraking.WITH_BRAKING, brakingOption.getContainedObject());
  }

  @Test
  public void testValueOfShouldReturnNoBraking() throws UndefinedValueException {

    SecondCentrifugationBrakingOption brakingOption =
        secondCentrifugationBrakingListProvider.valueOf(false);

    assertEquals(CentrifugationBraking.NO_BRAKING, brakingOption.getContainedObject());
  }
}
