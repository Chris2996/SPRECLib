package de.spreclib.java.spreclib.postcentrifugation;

import de.spreclib.java.enums.SprecPartType;
import de.spreclib.java.enums.postcentrifugation.PostCentrifugationType;
import de.spreclib.java.interfaces.ICodePart;
import de.spreclib.java.interfaces.ISprecPart;

public abstract class PostCentrifugation implements ISprecPart {

  private final SprecPartType sprecPartType = SprecPartType.POST_CENTRIFUGATION;
  private PostCentrifugationType postCentrifugationType;
  private ICodePart codePart;

  public PostCentrifugation(PostCentrifugationType postCentrifugationType, ICodePart codePart) {
    this.postCentrifugationType = postCentrifugationType;
    this.codePart = codePart;
  }

  @Override
  public ICodePart getCodeFromSprecPart() {
    return this.codePart;
  }

  @Override
  public SprecPartType getSprecPartType() {
    return this.sprecPartType;
  }

  public PostCentrifugationType getPostCentrifugationType() {
    return this.postCentrifugationType;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((codePart == null) ? 0 : codePart.hashCode());
    result =
        prime * result + ((postCentrifugationType == null) ? 0 : postCentrifugationType.hashCode());
    result = prime * result + ((sprecPartType == null) ? 0 : sprecPartType.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    PostCentrifugation other = (PostCentrifugation) obj;
    if (codePart == null) {
      if (other.codePart != null) return false;
    } else if (!codePart.equals(other.codePart)) return false;
    if (postCentrifugationType != other.postCentrifugationType) return false;
    if (sprecPartType != other.sprecPartType) return false;
    return true;
  }
}
