package de.spreclib.model.spreclib.postcentrifugation;

import de.spreclib.model.enums.postcentrifugation.PostCentrifugationDelay;
import de.spreclib.model.enums.postcentrifugation.PostCentrifugationTemperature;
import de.spreclib.model.enums.postcentrifugation.PostCentrifugationType;
import de.spreclib.model.interfaces.ICodePart;

public final class NormalPostCentrifugation extends PostCentrifugation {

  private final PostCentrifugationDelay postCentrifugationDelay;
  private final PostCentrifugationTemperature postCentrifugationTemperature;

  /**
   * Constructor for NormalPostCentrifugation.
   *
   * @param postCentrifugationType enum PostCentrifugationType
   * @param postCentrifugationDelay enum PostCentrifugationDelay
   * @param postCentrifugationTemperature enum PostCentrifugationTemperature
   * @param codePart object CodePart
   */
  public NormalPostCentrifugation(
      PostCentrifugationType postCentrifugationType,
      PostCentrifugationDelay postCentrifugationDelay,
      PostCentrifugationTemperature postCentrifugationTemperature,
      ICodePart codePart) {
    super(postCentrifugationType, codePart);
    this.postCentrifugationDelay = postCentrifugationDelay;
    this.postCentrifugationTemperature = postCentrifugationTemperature;
  }

  public PostCentrifugationDelay getPostCentrifugationDelay() {
    return this.postCentrifugationDelay;
  }

  public PostCentrifugationTemperature getPostCentrifugationTemperature() {
    return this.postCentrifugationTemperature;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result =
        prime * result
            + ((postCentrifugationDelay == null) ? 0 : postCentrifugationDelay.hashCode());
    result =
        prime * result
            + ((postCentrifugationTemperature == null)
                ? 0
                : postCentrifugationTemperature.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!super.equals(obj)) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    NormalPostCentrifugation other = (NormalPostCentrifugation) obj;
    if (postCentrifugationDelay != other.postCentrifugationDelay) {
      return false;
    }
    if (postCentrifugationTemperature != other.postCentrifugationTemperature) {
      return false;
    }
    return true;
  }
}