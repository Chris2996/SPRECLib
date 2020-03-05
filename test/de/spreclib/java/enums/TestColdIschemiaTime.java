package de.spreclib.java.enums;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import de.spreclib.java.interfaces.ICodePart;
import de.spreclib.java.interfaces.ISprecPart;
import de.spreclib.java.spreclib.CodePart;

public class TestColdIschemiaTime {

  @Test
  public void testGetCodeFromSprecPart() {
    ICodePart codePart = ColdIschemiaTime.LESS_THAN_TWO_MINUTES.getCodeFromSprecPart();
    ICodePart expected = new CodePart("A");
    assertNotNull(codePart);
    assertEquals(expected.getStringRepresentation(), codePart.getStringRepresentation());
  }

  @Test
  public void testGetSprecPartType() {
    ISprecPart sprecPartType = ColdIschemiaTime.LESS_THAN_TWO_MINUTES;
    assertEquals(SprecPartType.COLD_ISCHEMIA_TIME, sprecPartType.getSprecPartType());
  }
}
