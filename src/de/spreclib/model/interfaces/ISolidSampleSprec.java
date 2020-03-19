package de.spreclib.model.interfaces;

public interface ISolidSampleSprec {

  ISprecPart getSolidSampleType();

  ISprecPart getTypeOfCollection();

  ISprecPart getWarmIschemiaTime();

  ISprecPart getColdIschemiaTime();

  ISprecPart getFixation();

  ISprecPart getFixationTime();
}