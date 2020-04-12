package de.spreclib.api.lists.options;

import de.spreclib.model.enums.ColdIschemiaTime;

public final class ColdIschemiaTimeOption extends AbstractListOption {

  private final ColdIschemiaTime coldIschemiaTime;

  public ColdIschemiaTimeOption(ColdIschemiaTime coldIschemiaTime) {
    this.coldIschemiaTime = coldIschemiaTime;
  }

  @Override
  public String getStringRepresentation() {
    return NAMES_DEFAULT.getString(this.coldIschemiaTime.name());
  }


  @Override
  public ColdIschemiaTime getContainedObject() {
    return this.coldIschemiaTime;
  }

  public boolean hasDuration(int durationMinutes) {
    if (this.coldIschemiaTime.hasValueFor(durationMinutes)) {
      return true;
    } else {
      return false;
    }
  }
}
