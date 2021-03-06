package de.spreclib.model.precentrifugation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import de.spreclib.model.interfaces.ICodePart;
import de.spreclib.model.precentrifugation.enums.PreCentrifugationDelay;
import de.spreclib.model.precentrifugation.enums.PreCentrifugationTemperature;
import de.spreclib.model.precentrifugation.enums.PreCentrifugationType;
import de.spreclib.model.sprec.CodePart;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Before;
import org.junit.Test;

public class ParameterizedPreCentrifugationTest {

  ParameterizedPreCentrifugation parameterizedPreCentrifugation;

  @Before
  public void setUp() {
    parameterizedPreCentrifugation =
        new ParameterizedPreCentrifugation(
            PreCentrifugationDelay.LESS_TWO_HOURS,
            PreCentrifugationTemperature.ROOM_TEMPERATURE,
            new CodePart("A"));
  }

  @Test
  public void testGetPreCentrifugationType() {
    PreCentrifugationType expected = PreCentrifugationType.DEFAULT;

    assertEquals(expected, parameterizedPreCentrifugation.getPreCentrifugationType());
  }

  @Test
  public void testGetCodeFromSprecPart() {
    ICodePart expected = new CodePart("A");
    ICodePart actual = parameterizedPreCentrifugation.getCodeFromSprecFactor();

    assertEquals(expected, actual);
  }

  @Test
  public void testContainsShouldReturnTrue() {

    assertTrue(
        parameterizedPreCentrifugation.contains(
            PreCentrifugationDelay.LESS_TWO_HOURS, PreCentrifugationTemperature.ROOM_TEMPERATURE));
  }

  @Test
  public void testContainsShouldReturnFalse() {

    assertFalse(
        parameterizedPreCentrifugation.contains(
            PreCentrifugationDelay.LESS_TWO_HOURS, PreCentrifugationTemperature.THIRTYFIVE_TO_THIRTYEIGHT_DEGREES));
  }

  @Test
  public void testEquals() {
    EqualsVerifier.forClass(ParameterizedPreCentrifugation.class)
        .withRedefinedSuperclass()
        .verify();
  }
}
