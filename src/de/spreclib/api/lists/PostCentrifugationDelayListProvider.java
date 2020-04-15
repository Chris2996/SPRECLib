package de.spreclib.api.lists;

import de.spreclib.api.lists.options.PostCentrifugationDelayOption;
import de.spreclib.api.parameters.Timespan;
import de.spreclib.model.enums.postcentrifugation.PostCentrifugationDelay;
import java.util.ArrayList;
import java.util.List;

/**
 * ListProvider for PostCentrifugationDelayOptions.
 *
 * <p>Use the valueOf() method to receive a ListOption if a ListOption for the value can be found.
 *
 * @author Christopher Meyer
 * @version 1.0
 * @see de.spreclib.api.lists.options.PostCentrifugationDelayOption
 */
public final class PostCentrifugationDelayListProvider {

  private final List<PostCentrifugationDelayOption> postCentrifugationDelayOptions;

  public PostCentrifugationDelayListProvider() {
    this.postCentrifugationDelayOptions = generateList();
  }

  private List<PostCentrifugationDelayOption> generateList() {
    List<PostCentrifugationDelayOption> postCentrifugationDelayOptions = new ArrayList<>();
    for (PostCentrifugationDelay postCentrifugationDelay : PostCentrifugationDelay.values()) {
      PostCentrifugationDelayOption postCentrifugationDelayOption =
          new PostCentrifugationDelayOption(postCentrifugationDelay);
      postCentrifugationDelayOptions.add(postCentrifugationDelayOption);
    }
    return postCentrifugationDelayOptions;
  }

  public List<PostCentrifugationDelayOption> getList() {
    return this.postCentrifugationDelayOptions;
  }

  /**
   * Takes two timestamps milliseconds EPOCH time and returns a PostCentrifugationDelayOption if a
   * PostCentrifugationDelayOption with that timespan is found. Returns null otherwise.
   *
   * @param lastCentrifugationStartTimeMillis timestamp milliseconds EPOCH time
   * @param longTermStorageStartTimeMillis timestamp milliseconds EPOCH time
   * @return PostCentrifugationDelayOption
   * @see #valueOf(int)
   */
  public PostCentrifugationDelayOption valueOf(
      long lastCentrifugationStartTimeMillis, long longTermStorageStartTimeMillis) {

    int delayMinutes =
        new Timespan(lastCentrifugationStartTimeMillis, longTermStorageStartTimeMillis)
            .getTimespanMinutes();

    return this.valueOf(delayMinutes);
  }

  /**
   * Takes a duration in minutes and returns a PostCentrifugationDelayOption if a
   * PostCentrifugationDelayOption with that duration is found. Returns null otherwise
   *
   * @param delayMinutes delay in Minutes
   * @return PostCentrifugationDelayOption
   */
  public PostCentrifugationDelayOption valueOf(int delayMinutes) {

    for (PostCentrifugationDelayOption postCentrifugationDelayOption :
        this.postCentrifugationDelayOptions) {

      if (postCentrifugationDelayOption.hasDelay(delayMinutes)) {
        return postCentrifugationDelayOption;
      }
    }
    return null;
  }
}