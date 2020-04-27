package de.spreclib.model.centrifugation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import de.spreclib.model.enums.centrifugation.CentrifugationBraking;
import de.spreclib.model.enums.centrifugation.CentrifugationType;
import de.spreclib.model.enums.centrifugation.FirstCentrifugationDuration;
import de.spreclib.model.enums.centrifugation.FirstCentrifugationSpeed;
import de.spreclib.model.enums.centrifugation.FirstCentrifugationTemperature;
import de.spreclib.model.enums.centrifugation.ICentrifugationDuration;
import de.spreclib.model.enums.centrifugation.ICentrifugationSpeed;
import de.spreclib.model.enums.centrifugation.ICentrifugationTemperature;
import de.spreclib.model.interfaces.ICodePart;
import de.spreclib.model.sprec.CodePart;
import org.junit.Before;
import org.junit.Test;

public class ParameterizedCentrifugationTest {

  ParameterizedCentrifugation parameterizedCentrifugation;

  @Before
  public void setUp() {
    parameterizedCentrifugation =
        new ParameterizedCentrifugation(
            FirstCentrifugationTemperature.ROOM_TEMPERATURE,
            FirstCentrifugationDuration.TEN_TO_FIFTEEN_MINUTES,
            FirstCentrifugationSpeed.LESS_THREETHOUSAND_G,
            CentrifugationBraking.NO_BRAKING,
            new CodePart("A"));
  }

  @Test
  public void testGetCentrifugationType() {
    CentrifugationType expected = CentrifugationType.DEFAULT;

    assertEquals(expected, parameterizedCentrifugation.getCentrifugationType());
  }

  @Test
  public void testGetCentrifugationTemperature() {
    ICentrifugationTemperature expected = FirstCentrifugationTemperature.ROOM_TEMPERATURE;

    assertEquals(expected, parameterizedCentrifugation.getCentrifugationTemperature());
  }

  @Test
  public void testGetCentrifugationDuration() {
    ICentrifugationDuration expected = FirstCentrifugationDuration.TEN_TO_FIFTEEN_MINUTES;

    assertEquals(expected, parameterizedCentrifugation.getCentrifugationDuration());
  }

  @Test
  public void testGetCentrifugationSpeed() {
    ICentrifugationSpeed expected = FirstCentrifugationSpeed.LESS_THREETHOUSAND_G;

    assertEquals(expected, parameterizedCentrifugation.getCentrifugationSpeed());
  }

  @Test
  public void testGetCentrifugationBraking() {
    CentrifugationBraking expected = CentrifugationBraking.NO_BRAKING;

    assertEquals(expected, parameterizedCentrifugation.getCentrifugationBraking());
  }

  @Test
  public void testContainsShouldReturnTrue() {

    assertTrue(
        parameterizedCentrifugation.contains(
            FirstCentrifugationTemperature.ROOM_TEMPERATURE,
            FirstCentrifugationDuration.TEN_TO_FIFTEEN_MINUTES,
            FirstCentrifugationSpeed.LESS_THREETHOUSAND_G,
            CentrifugationBraking.NO_BRAKING));
  }
  
  @Test
  public void testContainsShouldReturnFalse() {

    assertFalse(
        parameterizedCentrifugation.contains(
            FirstCentrifugationTemperature.TWO_TO_TEN_DEGREES,
            FirstCentrifugationDuration.TEN_TO_FIFTEEN_MINUTES,
            FirstCentrifugationSpeed.LESS_THREETHOUSAND_G,
            CentrifugationBraking.NO_BRAKING));
  }

  @Test
  public void testGetCodeFromSprecPart() {
    ICodePart expected = new CodePart("A");
    ICodePart actual = parameterizedCentrifugation.getCodeFromSprecPart();

    assertEquals(expected, actual);
  }

  @Test
  public void testIsDefaultCentrifugation() {

    assertTrue(parameterizedCentrifugation.isParameterizedCentrifugation());
  }
}