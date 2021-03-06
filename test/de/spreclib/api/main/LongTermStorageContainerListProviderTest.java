package de.spreclib.api.main;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import de.spreclib.api.main.interfaces.IListOption;
import de.spreclib.model.longtermstorage.enums.LongTermStorageContainer;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class LongTermStorageContainerListProviderTest {

  private LongTermStorageContainerListProvider longTermStorageContainerListProvider;
  private List<LongTermStorageContainerOption> longTermStorageContainerList;

  @Before
  public void setUp() {
    this.longTermStorageContainerListProvider = new LongTermStorageContainerListProvider();
    this.longTermStorageContainerList = longTermStorageContainerListProvider.getList();
  }

  @Test
  public void testListNotEmpty() {
    assertFalse(this.longTermStorageContainerList.isEmpty());
  }

  @Test
  public void testOptionStringRepresentation() {
    for (IListOption option : this.longTermStorageContainerList) {
      assertNotNull(option.getStringRepresentation());
    }
  }

  @Test
  public void testFullListSize() {
    int expected = LongTermStorageContainer.values().length;
    int actual = longTermStorageContainerList.size();

    assertEquals(expected, actual);
  }
}
