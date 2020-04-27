package de.spreclib.api.main;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import de.spreclib.api.main.FluidSampleTypeListProvider;
import de.spreclib.api.main.FluidSampleTypeOption;
import de.spreclib.api.main.interfaces.IListOption;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class FluidSampleTypeListProviderTest {

  private FluidSampleTypeListProvider fluidSampleTypeListProvider;
  private List<FluidSampleTypeOption> fluidSampleTypeList;

  @Before
  public void setUp() {
    this.fluidSampleTypeListProvider = new FluidSampleTypeListProvider();
    this.fluidSampleTypeList = this.fluidSampleTypeListProvider.getList();
  }

  @Test
  public void testListNotEmpty() {
    assertFalse(this.fluidSampleTypeList.isEmpty());
  }

  @Test
  public void testOptionStringRepresentation() {
    for (IListOption option : this.fluidSampleTypeList) {
      assertNotNull(option.getStringRepresentation());
    }
  }
}