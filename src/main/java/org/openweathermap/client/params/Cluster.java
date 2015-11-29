package org.openweathermap.client.params;

/**
 * Created by beto on 28/11/2015.
 */
public enum Cluster {

  YES("yes"),
  NO("no");

  private String clusterOption;

  Cluster(String clusterOption) {
    this.clusterOption = clusterOption;
  }

  public String getClusterOption() {
    return clusterOption;
  }
}
