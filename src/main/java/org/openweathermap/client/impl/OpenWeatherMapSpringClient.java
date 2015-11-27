package org.openweathermap.client.impl;

import org.openweathermap.client.OpenWeatherMapClient;
import org.openweathermap.client.response.OpenWeatherMapClientResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by beto on 26/11/15.
 */
@Component
public class OpenWeatherMapSpringClient implements OpenWeatherMapClient{

  @Value("${url}")
  private String url;
  @Value("${appId}")
  private String appId;

  public OpenWeatherMapClientResponse getCurrentWeatherByCityName(String cityName, String countryCode) {
    RestTemplate restTemplate = new RestTemplate();
    StringBuilder fullUrl = new StringBuilder(url);
    fullUrl.append("weather?q=");
    fullUrl.append(cityName);
    if(countryCode != null){
      fullUrl.append(",");
      fullUrl.append(countryCode);
    }
    fullUrl.append("&appid=");
    fullUrl.append(appId);

    return restTemplate.getForObject(fullUrl.toString(), OpenWeatherMapClientResponse.class);
  }
}
