package de.spreclib.model.longtermstorage;

import de.spreclib.model.enums.longtermstorage.LongTermStorageType;
import de.spreclib.model.interfaces.ICodePart;

public final class SpecialLongTermStorage extends LongTermStorage {

  SpecialLongTermStorage(LongTermStorageType longTermStorageType, ICodePart codePart) {
    super(longTermStorageType, codePart);
  }

  @Override
  public boolean isNormalLongTermStorage() {
    return false;
  }

  @Override
  public boolean isSpecialLongTermStorage() {
    return true;
  }
}
