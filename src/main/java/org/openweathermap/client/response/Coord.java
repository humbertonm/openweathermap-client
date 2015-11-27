
package org.openweathermap.client.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by beto on 26/11/15.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "lon",
        "lat"
})
public class Coord {

  @JsonProperty("lon")
  private Double lon;
  @JsonProperty("lat")
  private Double lat;

  /**
   * No args constructor for use in serialization
   *
   */
  public Coord() {
  }

  /**
   *
   * @param lon
   * @param lat
   */
  public Coord(Double lon, Double lat) {
    this.lon = lon;
    this.lat = lat;
  }

  /**
   *
   * @return
   *     The lon
   */
  @JsonProperty("lon")
  public Double getLon() {
    return lon;
  }

  /**
   *
   * @param lon
   *     The lon
   */
  @JsonProperty("lon")
  public void setLon(Double lon) {
    this.lon = lon;
  }

  /**
   *
   * @return
   *     The lat
   */
  @JsonProperty("lat")
  public Double getLat() {
    return lat;
  }

  /**
   *
   * @param lat
   *     The lat
   */
  @JsonProperty("lat")
  public void setLat(Double lat) {
    this.lat = lat;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }

}
