package org.openweathermap.client.params;

/**
 * Created by beto on 28/11/2015.
 */
public enum UnitFormat {
  IMPERIAL("imperial", "Fahrenheit", "For temperature in Fahrenheit use units=imperial"),
  METRIC("metric", "Celsius", "For temperature in Celsius use units=metric"),
  STANDARD(null, "Kelvin", "Temperature in Kelvin is used by default, no need to use units parameter in API call");

  private String format;
  private String unit;
  private String description;

  UnitFormat(String format, String unit, String description) {
    this.format = format;
    this.unit = unit;
    this.description = description;
  }

  public String getFormat() {
    return format;
  }

  public String getUnit() {
    return unit;
  }

  public String getDescription() {
    return description;
  }
}
