package de.spreclib.api.lists;

import de.spreclib.api.exceptions.UndefinedValueException;
import de.spreclib.api.parameters.Timespan;
import de.spreclib.model.enums.FixationTime;
import java.util.ArrayList;
import java.util.List;

/**
 * ListProvider for FixationTimeOptions.
 *
 * <p>Use the valueOf() method to receive a ListOption if a ListOption for the value can be found.
 *
 * @author Christopher Meyer
 * @version 1.0
 * @see de.spreclib.api.lists.FixationOption
 */
public final class FixationTimeListProvider extends AbstractListProvider<FixationTimeOption> {

  public FixationTimeListProvider() {
    super();
  }

  @Override
  protected List<FixationTimeOption> generateList() {
    List<FixationTimeOption> fixationTimeOptions = new ArrayList<>();
    for (FixationTime fixationTime : FixationTime.values()) {
      FixationTimeOption fixationOption = new FixationTimeOption(fixationTime);
      fixationTimeOptions.add(fixationOption);
    }
    return fixationTimeOptions;
  }

  /**
   * Takes two timestamps milliseconds EPOCH time and returns a FixationTimeOption if a
   * FixationTimeOption with that timespan is found.
   *
   * @param startOfFixationTimeMillis timestamp milliseconds EPOCH time
   * @param endOfFixationTimeMillis timestamp milliseconds EPOCH time
   * @return FixationTimeOption
   * @throws UndefinedValueException if value for the duration cannot be found in ListOptions
   * @see #valueOf(int)
   * @see de.spreclib.api.parameters.timespan
   */
  public FixationTimeOption valueOf(long startOfFixationTimeMillis, long endOfFixationTimeMillis)
      throws UndefinedValueException {

    int durationMinutes =
        new Timespan(startOfFixationTimeMillis, endOfFixationTimeMillis).getTimespanMinutes();

    return this.valueOf(durationMinutes);
  }

  /**
   * Takes a duration in minutes and returns a FixationTimeOption if a FixationTimeOption with that
   * duration is found.
   *
   * @param durationMinutes durationMinutes
   * @return FixationTimeOption
   * @throws UndefinedValueException if value for the duration cannot be found in ListOptions
   */
  public FixationTimeOption valueOf(int durationMinutes) throws UndefinedValueException {

    for (FixationTimeOption fixationTimeOption : listOptions) {

      if (fixationTimeOption.hasDuration(durationMinutes)) {
        return fixationTimeOption;
      }
    }
    throw new UndefinedValueException(
        durationMinutes,
        "FixationTime",
        "Value " + durationMinutes + "minutes undefined for FixationTime.");
  }
}
