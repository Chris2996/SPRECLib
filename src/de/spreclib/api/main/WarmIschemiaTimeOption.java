package de.spreclib.api.main;

import de.spreclib.model.enums.WarmIschemiaTime;

/**
 * WarmIschemiaTimeOption
 *
 * <p>To obtain the name of the ListOption e.g. for usage in GUIs use getStringRepresentation()
 *
 * @author Christopher Meyer
 * @version 1.0
 */
public final class WarmIschemiaTimeOption extends AbstractListOption {

  private final WarmIschemiaTime warmIschemiaTime;

  WarmIschemiaTimeOption(WarmIschemiaTime warmIschemiaTime) {
    this.warmIschemiaTime = warmIschemiaTime;
  }

  @Override
  public String getStringRepresentation() {
    return NAMES_DEFAULT.getString(this.warmIschemiaTime.name());
  }

  @Override
  protected WarmIschemiaTime getContainedObject() {
    return this.warmIschemiaTime;
  }

  protected boolean hasDuration(int durationMinutes) {
    if (this.warmIschemiaTime.hasValue(durationMinutes)) {
      return true;
    } else {
      return false;
    }
  }
}