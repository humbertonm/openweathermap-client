
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
        "speed",
        "deg"
})
public class Wind {

  @JsonProperty("speed")
  private Double speed;
  @JsonProperty("deg")
  private Integer deg;

  /**
   * No args constructor for use in serialization
   *
   */
  public Wind() {
  }

  /**
   *
   * @param speed
   * @param deg
   */
  public Wind(Double speed, Integer deg) {
    this.speed = speed;
    this.deg = deg;
  }

  /**
   *
   * @return
   *     The speed
   */
  @JsonProperty("speed")
  public Double getSpeed() {
    return speed;
  }

  /**
   *
   * @param speed
   *     The speed
   */
  @JsonProperty("speed")
  public void setSpeed(Double speed) {
    this.speed = speed;
  }

  /**
   *
   * @return
   *     The deg
   */
  @JsonProperty("deg")
  public Integer getDeg() {
    return deg;
  }

  /**
   *
   * @param deg
   *     The deg
   */
  @JsonProperty("deg")
  public void setDeg(Integer deg) {
    this.deg = deg;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }

}
