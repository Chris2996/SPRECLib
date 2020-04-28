package de.spreclib.api.main;

import de.spreclib.model.typeofcollection.TypeOfCollection;

/**
 * TypeOfCollectionOption
 *
 * <p>To obtain the name of the ListOption e.g. for usage in GUIs use getStringRepresentation()
 *
 * @author Christopher Meyer
 * @version 1.0
 */
public final class TypeOfCollectionOption extends AbstractListOption {

  private final TypeOfCollection typeOfCollection;

  TypeOfCollectionOption(TypeOfCollection typeOfCollection) {
    this.typeOfCollection = typeOfCollection;
  }

  @Override
  public String getStringRepresentation() {
    return NAMES_DEFAULT.getString(this.typeOfCollection.name());
  }

  @Override
  protected TypeOfCollection getContainedObject() {
    return this.typeOfCollection;
  }
}
