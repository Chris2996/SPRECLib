package de.spreclib.java.spreclib.centrifugation;

import java.util.HashSet;
import java.util.Set;

import de.spreclib.java.enums.SprecPartType;
import de.spreclib.java.enums.centrifugation.CentrifugationBraking;
import de.spreclib.java.enums.centrifugation.CentrifugationDuration;
import de.spreclib.java.enums.centrifugation.CentrifugationSpeed;
import de.spreclib.java.enums.centrifugation.CentrifugationTemperature;
import de.spreclib.java.enums.centrifugation.CentrifugationType;
import de.spreclib.java.spreclib.CodePart;

public abstract class FirstCentrifugationList {

  public static final Set<Centrifugation> centrifugations;

  static {
    centrifugations = new HashSet<>();
    centrifugations.add(
        new SpecialCentrifugation(
            CentrifugationType.NO, new CodePart("N"), SprecPartType.FIRST_CENTRIFUGATION));
    centrifugations.add(
        new SpecialCentrifugation(
            CentrifugationType.UNKNOWN, new CodePart("X"), SprecPartType.FIRST_CENTRIFUGATION));
    centrifugations.add(
        new SpecialCentrifugation(
            CentrifugationType.OTHER, new CodePart("Z"), SprecPartType.FIRST_CENTRIFUGATION));
    centrifugations.add(
        new NormalCentrifugation(
            CentrifugationType.DEFAULT,
            CentrifugationDuration.TEN_TO_FIFTEEN_MINUTES,
            CentrifugationSpeed.LESS_THREETHOUSAND_G,
            CentrifugationTemperature.ROOM_TEMPERATURE,
            CentrifugationBraking.NO_BRAKING,
            new CodePart("A"),
            SprecPartType.FIRST_CENTRIFUGATION));
    centrifugations.add(
        new NormalCentrifugation(
            CentrifugationType.DEFAULT,
            CentrifugationDuration.TEN_TO_FIFTEEN_MINUTES,
            CentrifugationSpeed.LESS_THREETHOUSAND_G,
            CentrifugationTemperature.ROOM_TEMPERATURE,
            CentrifugationBraking.NO_BRAKING,
            new CodePart("B"),
            SprecPartType.FIRST_CENTRIFUGATION));
    centrifugations.add(
        new NormalCentrifugation(
            CentrifugationType.DEFAULT,
            CentrifugationDuration.TEN_TO_FIFTEEN_MINUTES,
            CentrifugationSpeed.LESS_THREETHOUSAND_G,
            CentrifugationTemperature.TWO_TO_TEN_DEGREES,
            CentrifugationBraking.NO_BRAKING,
            new CodePart("C"),
            SprecPartType.FIRST_CENTRIFUGATION));
    centrifugations.add(
        new NormalCentrifugation(
            CentrifugationType.DEFAULT,
            CentrifugationDuration.TEN_TO_FIFTEEN_MINUTES,
            CentrifugationSpeed.LESS_THREETHOUSAND_G,
            CentrifugationTemperature.TWO_TO_TEN_DEGREES,
            CentrifugationBraking.WITH_BRAKING,
            new CodePart("D"),
            SprecPartType.FIRST_CENTRIFUGATION));
    centrifugations.add(
        new NormalCentrifugation(
            CentrifugationType.DEFAULT,
            CentrifugationDuration.TEN_TO_FIFTEEN_MINUTES,
            CentrifugationSpeed.THREETHOUSAND_TO_SIXTHOUSAND_G,
            CentrifugationTemperature.ROOM_TEMPERATURE,
            CentrifugationBraking.WITH_BRAKING,
            new CodePart("E"),
            SprecPartType.FIRST_CENTRIFUGATION));
    centrifugations.add(
        new NormalCentrifugation(
            CentrifugationType.DEFAULT,
            CentrifugationDuration.TEN_TO_FIFTEEN_MINUTES,
            CentrifugationSpeed.THREETHOUSAND_TO_SIXTHOUSAND_G,
            CentrifugationTemperature.TWO_TO_TEN_DEGREES,
            CentrifugationBraking.WITH_BRAKING,
            new CodePart("F"),
            SprecPartType.FIRST_CENTRIFUGATION));
    centrifugations.add(
        new NormalCentrifugation(
            CentrifugationType.DEFAULT,
            CentrifugationDuration.TEN_TO_FIFTEEN_MINUTES,
            CentrifugationSpeed.SIXTHOUSAND_TO_TENTHOUSAND_G,
            CentrifugationTemperature.ROOM_TEMPERATURE,
            CentrifugationBraking.WITH_BRAKING,
            new CodePart("G"),
            SprecPartType.FIRST_CENTRIFUGATION));
    centrifugations.add(
        new NormalCentrifugation(
            CentrifugationType.DEFAULT,
            CentrifugationDuration.TEN_TO_FIFTEEN_MINUTES,
            CentrifugationSpeed.SIXTHOUSAND_TO_TENTHOUSAND_G,
            CentrifugationTemperature.TWO_TO_TEN_DEGREES,
            CentrifugationBraking.WITH_BRAKING,
            new CodePart("F"),
            SprecPartType.FIRST_CENTRIFUGATION));
    centrifugations.add(
        new NormalCentrifugation(
            CentrifugationType.DEFAULT,
            CentrifugationDuration.TEN_TO_FIFTEEN_MINUTES,
            CentrifugationSpeed.GREATER_TENTHOUSAND_G,
            CentrifugationTemperature.ROOM_TEMPERATURE,
            CentrifugationBraking.WITH_BRAKING,
            new CodePart("I"),
            SprecPartType.FIRST_CENTRIFUGATION));
    centrifugations.add(
        new NormalCentrifugation(
            CentrifugationType.DEFAULT,
            CentrifugationDuration.TEN_TO_FIFTEEN_MINUTES,
            CentrifugationSpeed.GREATER_TENTHOUSAND_G,
            CentrifugationTemperature.TWO_TO_TEN_DEGREES,
            CentrifugationBraking.WITH_BRAKING,
            new CodePart("J"),
            SprecPartType.FIRST_CENTRIFUGATION));
    centrifugations.add(
        new NormalCentrifugation(
            CentrifugationType.DEFAULT,
            CentrifugationDuration.THIRY_MINUTES,
            CentrifugationSpeed.LESS_THOUSAND_G,
            CentrifugationTemperature.ROOM_TEMPERATURE,
            CentrifugationBraking.NO_BRAKING,
            new CodePart("M"),
            SprecPartType.FIRST_CENTRIFUGATION));
  }
}