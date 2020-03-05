package de.spreclib.java.enums;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;

import de.spreclib.java.interfaces.ICodePart;
import de.spreclib.java.interfaces.ISprecPart;
import de.spreclib.java.spreclib.CodePart;

class TestFluidSampleType {

  @Test
  public void testGetCodeFromSprecPart() {
    ICodePart codePart = FluidSampleType.ASCITIES_FLUID.getCodeFromSprecPart();
    ICodePart expected = new CodePart("ASC");
    assertNotNull(codePart);
    assertEquals(expected.getStringRepresentation(), codePart.getStringRepresentation());
  }

  @Test
  public void testGetSprecPartType() {
    ISprecPart sprecPartType = FluidSampleType.ASCITIES_FLUID;
    assertEquals(SprecPartType.FLUID_SAMPLE_TYPE, sprecPartType.getSprecPartType());
  }
}
