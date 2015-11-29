package org.openweathermap.client.params;

/**
 * Created by beto on 28/11/2015.
 */
public enum Format {

  JSON(null),
  XML("xml"),
  HTML("html");

  private String format;

  Format(String format) {
    this.format = format;
  }

  public String getFormat() {
    return format;
  }
}
