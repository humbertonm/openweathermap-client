package org.openweathermap.client.impl;

import org.openweathermap.client.OpenWeatherMapClient;
import org.openweathermap.client.params.*;
import org.openweathermap.client.request.OpenWeatherMapUrlBuilder;
import org.openweathermap.client.response.OpenWeatherMapClientResponse;
import org.openweathermap.client.response.OpenWeatherMapListResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by beto on 26/11/15.
 */
@Component
public class OpenWeatherMapSpringClient implements OpenWeatherMapClient{

  private static final Logger LOG = LoggerFactory.getLogger(OpenWeatherMapSpringClient.class);

  @Value("${url}")
  private String url;
  @Value("${appId}")
  private String appId;

  public OpenWeatherMapClientResponse getCurrentWeatherByCityName(String cityName, String countryCode, OtherFeatures features) {
    RestTemplate restTemplate = new RestTemplate();
    String fullUrl = OpenWeatherMapUrlBuilder.buildCurrentWeatherByCityNameUrl(url, appId, cityName, countryCode, features);
    LOG.debug("GET Request: {}", fullUrl);
    return restTemplate.getForObject(fullUrl, OpenWeatherMapClientResponse.class);
  }

  public OpenWeatherMapClientResponse getCurrentWeatherById(Long id, OtherFeatures features) {
    RestTemplate restTemplate = new RestTemplate();
    String fullUrl = OpenWeatherMapUrlBuilder.buildCurrentWeatherByIdUrl(url, id, appId, features);
    LOG.debug("GET Request: {}", fullUrl);
    return restTemplate.getForObject(fullUrl, OpenWeatherMapClientResponse.class);
  }

  public OpenWeatherMapClientResponse getCurrentWeatherByGeographicCoordinates(Double lat, Double lon, OtherFeatures features) {
    RestTemplate restTemplate = new RestTemplate();
    String fullUrl = OpenWeatherMapUrlBuilder.buildCurrentWeatherByGeoCoordsUrl(url, lat, lon, appId, features);
    LOG.debug("GET Request: {}", fullUrl);
    return restTemplate.getForObject(fullUrl, OpenWeatherMapClientResponse.class);
  }

  public OpenWeatherMapClientResponse getCurrentWeatherByZipCode(String zipCode, String countryCode, OtherFeatures features) {
    RestTemplate restTemplate = new RestTemplate();
    String fullUrl = OpenWeatherMapUrlBuilder.buildCurrentWeatherByZipCodeUrl(url, zipCode, countryCode, appId, features);
    LOG.debug("GET Request: {}", fullUrl);
    return restTemplate.getForObject(fullUrl, OpenWeatherMapClientResponse.class);
  }

  public OpenWeatherMapListResponse getCurrentWeatherFromCitiesWithinRectangleZone(BoundingBox bbox, Cluster cluster, OtherFeatures features) {
    RestTemplate restTemplate = new RestTemplate();
    String fullUrl = OpenWeatherMapUrlBuilder.buildCurrentWeatherByBoundingBoxUrl(url, bbox, cluster, appId, features);
    LOG.debug("GET Request: {}", fullUrl);
    return restTemplate.getForObject(fullUrl, OpenWeatherMapListResponse.class);
  }
}
