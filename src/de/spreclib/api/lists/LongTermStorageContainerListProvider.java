package de.spreclib.api.lists;

import de.spreclib.api.lists.options.LongTermStorageContainerOption;
import de.spreclib.model.enums.longtermstorage.LongTermStorageContainer;
import java.util.ArrayList;
import java.util.List;

/**
 * ListProvider for LongTermStorageContainerOptions.
 *
 * @author Christopher Meyer
 * @version 1.0
 * @see de.spreclib.api.lists.LongTermStorageContainerOption
 */
public final class LongTermStorageContainerListProvider {

  private final List<LongTermStorageContainerOption> longTermStorageContainerOptions;

  public LongTermStorageContainerListProvider() {
    this.longTermStorageContainerOptions = generateList();
  }

  private List<LongTermStorageContainerOption> generateList() {
    List<LongTermStorageContainerOption> longTermStorageContainerOptions = new ArrayList<>();
    for (LongTermStorageContainer longTermStorageContainer : LongTermStorageContainer.values()) {
      LongTermStorageContainerOption longTermStorageContainerOption =
          new LongTermStorageContainerOption(longTermStorageContainer);
      longTermStorageContainerOptions.add(longTermStorageContainerOption);
    }
    return longTermStorageContainerOptions;
  }

  public List<LongTermStorageContainerOption> getList() {
    return this.longTermStorageContainerOptions;
  }
}