package de.spreclib.api.main;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import de.spreclib.api.main.interfaces.IListOption;
import de.spreclib.model.solidsampletype.SolidSampleType;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class SolidSampleTypeListProviderTest {

  private SolidSampleTypeListProvider solidSampleTypeListProvider;
  private List<SolidSampleTypeOption> solidSampleTypeList;

  @Before
  public void setUp() {
    this.solidSampleTypeListProvider = new SolidSampleTypeListProvider();
    this.solidSampleTypeList = solidSampleTypeListProvider.getList();
  }

  @Test
  public void testListNotEmpty() {
    assertFalse(this.solidSampleTypeList.isEmpty());
  }

  @Test
  public void testOptionStringRepresentation() {
    for (IListOption option : this.solidSampleTypeList) {
      assertNotNull(option.getStringRepresentation());
    }
  }

  @Test
  public void testFullListSize() {
    int expected = SolidSampleType.values().length;
    int actual = solidSampleTypeList.size();

    assertEquals(expected, actual);
  }

  @Test
  public void testGetOptionFromCodeString() {

    assertNotNull(this.solidSampleTypeListProvider.getOptionFromCodeString("CEN"));
  }

  @Test
  public void testGetOptionFromCodeStringReturnNull() {

    assertNull(this.solidSampleTypeListProvider.getOptionFromCodeString("AA"));
  }
}
