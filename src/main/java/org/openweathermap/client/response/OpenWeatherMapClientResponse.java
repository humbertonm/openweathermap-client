
package org.openweathermap.client.response;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "coord",
        "weather",
        "base",
        "main",
        "visibility",
        "wind",
        "clouds",
        "rain",
        "snow",
        "dt",
        "sys",
        "id",
        "name",
        "cod",
        "message"
        })
public class OpenWeatherMapClientResponse {

  @JsonProperty("coord")
  private Coord coord;
  @JsonProperty("weather")
  private List<Weather> weather = new ArrayList<Weather>();
  @JsonProperty("base")
  private String base;
  @JsonProperty("main")
  private Main main;
  @JsonProperty("visibility")
  private Integer visibility;
  @JsonProperty("wind")
  private Wind wind;
  @JsonProperty("clouds")
  private Clouds clouds;
  @JsonProperty("rain")
  private Rain rain;
  @JsonProperty("dt")
  private Integer dt;
  @JsonProperty("sys")
  private Sys sys;
  @JsonProperty("id")
  private String id;
  @JsonProperty("name")
  private String name;
  @JsonProperty("cod")
  private String cod;
  @JsonProperty("message")
  private String message;

  /**
   * No args constructor for use in serialization
   *
   */
  public OpenWeatherMapClientResponse() {
  }

  /**
   *
   * @param id
   * @param dt
   * @param clouds
   * @param coord
   * @param wind
   * @param cod
   * @param sys
   * @param name
   * @param base
   * @param weather
   * @param rain
   * @param main
   */
  public OpenWeatherMapClientResponse(Coord coord, List<Weather> weather, String base, Main main, Wind wind, Clouds clouds, Rain rain, Integer dt, Sys sys, String id, String name, String cod) {
    this.coord = coord;
    this.weather = weather;
    this.base = base;
    this.main = main;
    this.wind = wind;
    this.clouds = clouds;
    this.rain = rain;
    this.dt = dt;
    this.sys = sys;
    this.id = id;
    this.name = name;
    this.cod = cod;
  }

  /**
   *
   * @return
   *     The coord
   */
  @JsonProperty("coord")
  public Coord getCoord() {
    return coord;
  }

  /**
   *
   * @param coord
   *     The coord
   */
  @JsonProperty("coord")
  public void setCoord(Coord coord) {
    this.coord = coord;
  }

  /**
   *
   * @return
   *     The weather
   */
  @JsonProperty("weather")
  public List<Weather> getWeather() {
    return weather;
  }

  /**
   *
   * @param weather
   *     The weather
   */
  @JsonProperty("weather")
  public void setWeather(List<Weather> weather) {
    this.weather = weather;
  }

  /**
   *
   * @return
   *     The base
   */
  @JsonProperty("base")
  public String getBase() {
    return base;
  }

  /**
   *
   * @param base
   *     The base
   */
  @JsonProperty("base")
  public void setBase(String base) {
    this.base = base;
  }

  /**
   *
   * @return
   *     The main
   */
  @JsonProperty("main")
  public Main getMain() {
    return main;
  }

  /**
   *
   * @param main
   *     The main
   */
  @JsonProperty("main")
  public void setMain(Main main) {
    this.main = main;
  }

  /**
   *
   * @return
   *     The wind
   */
  @JsonProperty("wind")
  public Wind getWind() {
    return wind;
  }

  /**
   *
   * @param wind
   *     The wind
   */
  @JsonProperty("wind")
  public void setWind(Wind wind) {
    this.wind = wind;
  }

  /**
   *
   * @return
   *     The clouds
   */
  @JsonProperty("clouds")
  public Clouds getClouds() {
    return clouds;
  }

  /**
   *
   * @param clouds
   *     The clouds
   */
  @JsonProperty("clouds")
  public void setClouds(Clouds clouds) {
    this.clouds = clouds;
  }

  /**
   *
   * @return
   *     The rain
   */
  @JsonProperty("rain")
  public Rain getRain() {
    return rain;
  }

  /**
   *
   * @param rain
   *     The rain
   */
  @JsonProperty("rain")
  public void setRain(Rain rain) {
    this.rain = rain;
  }

  /**
   *
   * @return
   *     The dt
   */
  @JsonProperty("dt")
  public Integer getDt() {
    return dt;
  }

  /**
   *
   * @param dt
   *     The dt
   */
  @JsonProperty("dt")
  public void setDt(Integer dt) {
    this.dt = dt;
  }

  /**
   *
   * @return
   *     The sys
   */
  @JsonProperty("sys")
  public Sys getSys() {
    return sys;
  }

  /**
   *
   * @param sys
   *     The sys
   */
  @JsonProperty("sys")
  public void setSys(Sys sys) {
    this.sys = sys;
  }

  /**
   *
   * @return
   *     The id
   */
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  /**
   *
   * @param id
   *     The id
   */
  @JsonProperty("id")
  public void setId(String id) {
    this.id = id;
  }

  /**
   *
   * @return
   *     The name
   */
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  /**
   *
   * @param name
   *     The name
   */
  @JsonProperty("name")
  public void setName(String name) {
    this.name = name;
  }

  /**
   *
   * @return
   *     The cod
   */
  @JsonProperty("cod")
  public String getCod() {
    return cod;
  }

  /**
   *
   * @param cod
   *     The cod
   */
  @JsonProperty("cod")
  public void setCod(String cod) {
    this.cod = cod;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Integer getVisibility() {
    return visibility;
  }

  public void setVisibility(Integer visibility) {
    this.visibility = visibility;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }

}
