package de.spreclib.api.lists.options;

import de.spreclib.model.enums.centrifugation.FirstCentrifugationDuration;

public final class FirstCentrifugationDurationOption extends AbstractListOption {

  private final FirstCentrifugationDuration firstCentrifugationDuration;

  public FirstCentrifugationDurationOption(
      FirstCentrifugationDuration firstCentrifugationDuration) {
    this.firstCentrifugationDuration = firstCentrifugationDuration;
  }

  @Override
  public String getStringRepresentation() {
    return NAMES_DEFAULT.getString(this.firstCentrifugationDuration.name());
  }

  @Override
  public FirstCentrifugationDuration getContainedObject() {
    return this.firstCentrifugationDuration;
  }
}
