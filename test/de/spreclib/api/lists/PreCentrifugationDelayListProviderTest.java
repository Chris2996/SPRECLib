package de.spreclib.api.lists;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import de.spreclib.api.lists.interfaces.IListOption;
import de.spreclib.api.lists.options.PreCentrifugationDelayOption;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class PreCentrifugationDelayListProviderTest {

  private PreCentrifugationDelayListProvider preCentrifugationDelayListProvider;
  private List<PreCentrifugationDelayOption> preCentrifugationDelayList;

  @Before
  public void setUp() {
    this.preCentrifugationDelayListProvider = new PreCentrifugationDelayListProvider();
    this.preCentrifugationDelayList = preCentrifugationDelayListProvider.getList();
  }

  @Test
  public void testListNotEmpty() {
    assertFalse(preCentrifugationDelayList.isEmpty());
  }

  @Test
  public void testOptionStringRepresentation() {
    for (IListOption option : preCentrifugationDelayList) {
      assertNotNull(option.getStringRepresentation());
    }
  }

  @Test
  public void testValueOfWithValidValue() {

    PreCentrifugationDelayOption delayOption = this.preCentrifugationDelayListProvider.valueOf(15);

    assertNotNull(delayOption);
  }

  @Test
  public void testValueOfWithInvalidValue() {

    PreCentrifugationDelayOption delayOption = this.preCentrifugationDelayListProvider.valueOf(-1);

    assertNull(delayOption);
  }

  @Test
  public void testValueOfWithTimestamps() {

    long startTime = 1577836800000L;
    long fifteenMinutesLater = 1577837700000L;

    PreCentrifugationDelayOption preCentrifugationDurationOption =
        this.preCentrifugationDelayListProvider.valueOf(startTime, fifteenMinutesLater);

    assertNotNull(preCentrifugationDurationOption);
  }
}