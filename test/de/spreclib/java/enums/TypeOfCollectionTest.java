package de.spreclib.java.enums;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import de.spreclib.java.interfaces.ICodePart;
import de.spreclib.java.interfaces.ISprecPart;
import de.spreclib.java.spreclib.CodePart;
import org.junit.Test;


public class TypeOfCollectionTest {

  @Test
  public void testGetCodeFromSprecPart() {
    ICodePart actual = TypeOfCollection.AUTOPSY_LESS_THAN_6_HOURS_POSTMORTEM.getCodeFromSprecPart();
    ICodePart expected = new CodePart("A06");
    assertNotNull(actual);
    assertEquals(expected.getStringRepresentation(), actual.getStringRepresentation());
    assertEquals(expected, actual);
  }

  @Test
  public void testGetSprecPartType() {
    ISprecPart sprecPartType = TypeOfCollection.AUTOPSY_LESS_THAN_6_HOURS_POSTMORTEM;
    assertEquals(SprecPartType.TYPE_OF_COLLECTION, sprecPartType.getSprecPartType());
  }
}