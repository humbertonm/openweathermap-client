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

import java.util.Locale;

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
    String fullUrl = OpenWeatherMapUrlBuilder.buildCurrentWeatherById(url, id, appId, features);
    return restTemplate.getForObject(fullUrl, OpenWeatherMapClientResponse.class);
  }

}
