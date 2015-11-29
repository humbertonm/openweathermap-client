package org.openweathermap.dto;

import org.openweathermap.client.params.OtherFeatures;
import org.openweathermap.client.response.OpenWeatherMapClientResponse;

/**
 * Created by beto on 29/11/2015.
 */
public class OpenWeatherMapTestCase {

  private Long testCaseId;
  private String description;
  private TestCaseType type;
  private String cityName;
  private String countryCode;
  private Long cityId;
  private Double lat;
  private Double lon;
  private String zipCode;
  private OtherFeatures features;

  private OpenWeatherMapClientResponse expectedResult;

  public OpenWeatherMapTestCase() {
  }


  public Long getTestCaseId() {
    return testCaseId;
  }

  public void setTestCaseId(Long testCaseId) {
    this.testCaseId = testCaseId;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getCityName() {
    return cityName;
  }

  public void setCityName(String cityName) {
    this.cityName = cityName;
  }

  public String getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  public Long getCityId() {
    return cityId;
  }

  public void setCityId(Long cityId) {
    this.cityId = cityId;
  }

  public Double getLat() {
    return lat;
  }

  public void setLat(Double lat) {
    this.lat = lat;
  }

  public Double getLon() {
    return lon;
  }

  public void setLon(Double lon) {
    this.lon = lon;
  }

  public String getZipCode() {
    return zipCode;
  }

  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  public OtherFeatures getFeatures() {
    return features;
  }

  public void setFeatures(OtherFeatures features) {
    this.features = features;
  }

  public OpenWeatherMapClientResponse getExpectedResult() {
    return expectedResult;
  }

  public void setExpectedResult(OpenWeatherMapClientResponse expectedResult) {
    this.expectedResult = expectedResult;
  }

  public TestCaseType getType() {
    return type;
  }

  public void setType(TestCaseType type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return "OpenWeatherMapTestCase{" +
        "testCaseId=" + testCaseId +
        ", description='" + description + '\'' +
        ", type=" + type +
        ", cityName='" + cityName + '\'' +
        ", countryCode='" + countryCode + '\'' +
        ", cityId=" + cityId +
        ", lat=" + lat +
        ", lon=" + lon +
        ", zipCode='" + zipCode + '\'' +
        ", features=" + features +
        ", expectedResult=" + expectedResult +
        '}';
  }
}
