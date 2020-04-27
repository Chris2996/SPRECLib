package de.spreclib.api.main;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import de.spreclib.api.main.PrimaryContainerListProvider;
import de.spreclib.api.main.PrimaryContainerOption;
import de.spreclib.api.main.interfaces.IListOption;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class PrimaryContainerListProviderTest {

  private PrimaryContainerListProvider primaryContainerListProvider;
  private List<PrimaryContainerOption> primaryContainerList;

  @Before
  public void setUp() {
    this.primaryContainerListProvider = new PrimaryContainerListProvider();
    this.primaryContainerList = primaryContainerListProvider.getList();
  }

  @Test
  public void testListNotEmpty() {
    assertFalse(this.primaryContainerList.isEmpty());
  }

  @Test
  public void testOptionStringRepresentation() {
    for (IListOption option : this.primaryContainerList) {
      assertNotNull(option.getStringRepresentation());
    }
  }
}