
package org.openweathermap.client.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

/**
 * Created by beto on 26/11/15.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "type",
        "id",
        "message",
        "country",
        "sunrise",
        "sunset"
})
public class Sys {

  @JsonProperty("type")
  private Integer type;
  @JsonProperty("id")
  private Integer id;
  @JsonProperty("message")
  private Double message;
  @JsonProperty("country")
  private String country;
  @JsonProperty("sunrise")
  private Date sunrise;
  @JsonProperty("sunset")
  private Date sunset;

  /**
   * No args constructor for use in serialization
   *
   */
  public Sys() {
  }

  /**
   *
   * @param message
   * @param id
   * @param sunset
   * @param sunrise
   * @param type
   * @param country
   */
  public Sys(Integer type, Integer id, Double message, String country, Date sunrise, Date sunset) {
    this.type = type;
    this.id = id;
    this.message = message;
    this.country = country;
    this.sunrise = sunrise;
    this.sunset = sunset;
  }

  /**
   *
   * @return
   *     The type
   */
  @JsonProperty("type")
  public Integer getType() {
    return type;
  }

  /**
   *
   * @param type
   *     The type
   */
  @JsonProperty("type")
  public void setType(Integer type) {
    this.type = type;
  }

  /**
   *
   * @return
   *     The id
   */
  @JsonProperty("id")
  public Integer getId() {
    return id;
  }

  /**
   *
   * @param id
   *     The id
   */
  @JsonProperty("id")
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   *
   * @return
   *     The message
   */
  @JsonProperty("message")
  public Double getMessage() {
    return message;
  }

  /**
   *
   * @param message
   *     The message
   */
  @JsonProperty("message")
  public void setMessage(Double message) {
    this.message = message;
  }

  /**
   *
   * @return
   *     The country
   */
  @JsonProperty("country")
  public String getCountry() {
    return country;
  }

  /**
   *
   * @param country
   *     The country
   */
  @JsonProperty("country")
  public void setCountry(String country) {
    this.country = country;
  }

  /**
   *
   * @return
   *     The sunrise
   */
  @JsonProperty("sunrise")
  public Date getSunrise() {
    return sunrise;
  }

  /**
   *
   * @param sunrise
   *     The sunrise
   */
  @JsonProperty("sunrise")
  public void setSunrise(Date sunrise) {
    this.sunrise = sunrise;
  }

  /**
   *
   * @return
   *     The sunset
   */
  @JsonProperty("sunset")
  public Date getSunset() {
    return sunset;
  }

  /**
   *
   * @param sunset
   *     The sunset
   */
  @JsonProperty("sunset")
  public void setSunset(Date sunset) {
    this.sunset = sunset;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }

}
