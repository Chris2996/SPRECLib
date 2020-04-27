package de.spreclib.api.main;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import de.spreclib.api.main.FixationListProvider;
import de.spreclib.api.main.FixationOption;
import de.spreclib.api.main.interfaces.IListOption;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class FixationListProviderTest {

  private FixationListProvider fixationListProvider;
  private List<FixationOption> fixationList;

  @Before
  public void setUp() {
    this.fixationListProvider = new FixationListProvider();
    this.fixationList = fixationListProvider.getList();
  }

  @Test
  public void testListNotEmpty() {
    assertFalse(this.fixationList.isEmpty());
  }

  @Test
  public void testOptionStringRepresentation() {
    for (IListOption option : this.fixationList) {
      assertNotNull(option.getStringRepresentation());
    }
  }
}