package org.openweathermap.client.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

/**
 * Created by betob_000 on 28/11/2015.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cod",
    "calctime",
    "ctn",
    "list"
})
public class OpenWeatherMapListResponse {

  @JsonProperty("cod")
  private String cod;
  @JsonProperty("calctime")
  private Double calctime;
  @JsonProperty("cnt")
  private Long cnt;
  @JsonProperty("list")
  private List<OpenWeatherMapClientResponse> list;

  public OpenWeatherMapListResponse() {
  }

  public OpenWeatherMapListResponse(String cod, Double calctime, Long cnt, List<OpenWeatherMapClientResponse> list) {
    this.cod = cod;
    this.calctime = calctime;
    this.cnt = cnt;
    this.list = list;
  }

  public String getCod() {
    return cod;
  }

  public void setCod(String cod) {
    this.cod = cod;
  }

  public Double getCalctime() {
    return calctime;
  }

  public void setCalctime(Double calctime) {
    this.calctime = calctime;
  }

  public Long getCnt() {
    return cnt;
  }

  public void setCnt(Long cnt) {
    this.cnt = cnt;
  }

  public List<OpenWeatherMapClientResponse> getList() {
    return list;
  }

  public void setList(List<OpenWeatherMapClientResponse> list) {
    this.list = list;
  }
}
