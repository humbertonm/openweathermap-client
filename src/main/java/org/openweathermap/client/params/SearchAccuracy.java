package org.openweathermap.client.params;

/**
 * Created by betob_000 on 28/11/2015.
 */
public enum SearchAccuracy {
  DEFAULT(null),
  LIKE("like"),
  ACCURATE("accurate");

  private String searchAccuracy;

  SearchAccuracy(String searchAccuracy) {
    this.searchAccuracy = searchAccuracy;
  }

  public String getSearchAccuracy() {
    return searchAccuracy;
  }
}
