package de.spreclib.model.postcentrifugation;

import de.spreclib.model.enums.postcentrifugation.PostCentrifugationDelay;
import de.spreclib.model.enums.postcentrifugation.PostCentrifugationTemperature;
import de.spreclib.model.enums.postcentrifugation.PostCentrifugationType;
import de.spreclib.model.sprec.CodePart;
import java.util.HashSet;
import java.util.Set;

public final class PostCentrifugationList {

  public static final Set<PostCentrifugation> POST_CENTRIFUGATIONS;

  static {
    POST_CENTRIFUGATIONS = new HashSet<>();
    POST_CENTRIFUGATIONS.add(
        new SpecialPostCentrifugation(PostCentrifugationType.NOT_APPLICABLE, new CodePart("N")));
    POST_CENTRIFUGATIONS.add(
        new SpecialPostCentrifugation(PostCentrifugationType.UNKNOWN, new CodePart("X")));
    POST_CENTRIFUGATIONS.add(
        new SpecialPostCentrifugation(PostCentrifugationType.OTHER, new CodePart("Z")));
    POST_CENTRIFUGATIONS.add(
        new NormalPostCentrifugation(
            PostCentrifugationType.DEFAULT,
            PostCentrifugationDelay.LESS_ONE_HOUR,
            PostCentrifugationTemperature.TWO_TO_TEN_DEGREES,
            new CodePart("A")));
    POST_CENTRIFUGATIONS.add(
        new NormalPostCentrifugation(
            PostCentrifugationType.DEFAULT,
            PostCentrifugationDelay.LESS_ONE_HOUR,
            PostCentrifugationTemperature.ROOM_TEMPERATURE,
            new CodePart("B")));
    POST_CENTRIFUGATIONS.add(
        new NormalPostCentrifugation(
            PostCentrifugationType.DEFAULT,
            PostCentrifugationDelay.ONE_TO_TWO_HOURS,
            PostCentrifugationTemperature.TWO_TO_TEN_DEGREES,
            new CodePart("C")));
    POST_CENTRIFUGATIONS.add(
        new NormalPostCentrifugation(
            PostCentrifugationType.DEFAULT,
            PostCentrifugationDelay.ONE_TO_TWO_HOURS,
            PostCentrifugationTemperature.ROOM_TEMPERATURE,
            new CodePart("D")));
    POST_CENTRIFUGATIONS.add(
        new NormalPostCentrifugation(
            PostCentrifugationType.DEFAULT,
            PostCentrifugationDelay.TWO_TO_EIGHT_HOURS,
            PostCentrifugationTemperature.TWO_TO_TEN_DEGREES,
            new CodePart("E")));
    POST_CENTRIFUGATIONS.add(
        new NormalPostCentrifugation(
            PostCentrifugationType.DEFAULT,
            PostCentrifugationDelay.TWO_TO_EIGHT_HOURS,
            PostCentrifugationTemperature.ROOM_TEMPERATURE,
            new CodePart("F")));
    POST_CENTRIFUGATIONS.add(
        new NormalPostCentrifugation(
            PostCentrifugationType.DEFAULT,
            PostCentrifugationDelay.EIGHT_TO_TWENTYFOUR_HOURS,
            PostCentrifugationTemperature.TWO_TO_TEN_DEGREES,
            new CodePart("G")));
    POST_CENTRIFUGATIONS.add(
        new NormalPostCentrifugation(
            PostCentrifugationType.DEFAULT,
            PostCentrifugationDelay.EIGHT_TO_TWENTYFOUR_HOURS,
            PostCentrifugationTemperature.ROOM_TEMPERATURE,
            new CodePart("H")));
    POST_CENTRIFUGATIONS.add(
        new NormalPostCentrifugation(
            PostCentrifugationType.DEFAULT,
            PostCentrifugationDelay.GREATER_TWENTYFOUR_HOURS,
            PostCentrifugationTemperature.TWO_TO_TEN_DEGREES,
            new CodePart("I")));
    POST_CENTRIFUGATIONS.add(
        new NormalPostCentrifugation(
            PostCentrifugationType.DEFAULT,
            PostCentrifugationDelay.GREATER_TWENTYFOUR_HOURS,
            PostCentrifugationTemperature.ROOM_TEMPERATURE,
            new CodePart("J")));
  }

  public static PostCentrifugation getNoApplicablePostCentrifugation() {
    for (PostCentrifugation postCentrifugation : POST_CENTRIFUGATIONS) {
      if (postCentrifugation.getPostCentrifugationType() == PostCentrifugationType.NOT_APPLICABLE) {
        return postCentrifugation;
      }
    }
    return null;
  }

  public static PostCentrifugation getUnknownPostCentrifugation() {
    for (PostCentrifugation postCentrifugation : POST_CENTRIFUGATIONS) {
      if (postCentrifugation.getPostCentrifugationType() == PostCentrifugationType.UNKNOWN) {
        return postCentrifugation;
      }
    }
    return null;
  }

  public static PostCentrifugation getOtherPostCentrifugation() {
    for (PostCentrifugation postCentrifugation : POST_CENTRIFUGATIONS) {
      if (postCentrifugation.getPostCentrifugationType() == PostCentrifugationType.OTHER) {
        return postCentrifugation;
      }
    }
    return null;
  }
}