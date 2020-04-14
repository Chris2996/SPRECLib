package de.spreclib.api.lists.options;

import de.spreclib.model.enums.postcentrifugation.PostCentrifugationDelay;

/**
 * PostCentrifugationDelayOption
 *
 * <p>To obtain the name of the ListOption e.g. for usage in GUIs use getStringRepresentation()
 *
 * @author Christopher Meyer
 * @version 1.0
 */
public final class PostCentrifugationDelayOption extends AbstractListOption {

  private final PostCentrifugationDelay postCentrifugationDelay;

  public PostCentrifugationDelayOption(PostCentrifugationDelay postCentrifugationDelay) {
    this.postCentrifugationDelay = postCentrifugationDelay;
  }

  @Override
  public String getStringRepresentation() {
    return NAMES_DEFAULT.getString(this.postCentrifugationDelay.name());
  }

  @Override
  public PostCentrifugationDelay getContainedObject() {
    return this.postCentrifugationDelay;
  }

  public boolean hasDelay(int delayMinutes) {
    if (this.postCentrifugationDelay.hasValueFor(delayMinutes)) {
      return true;
    } else {
      return false;
    }
  }
}
