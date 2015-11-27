package org.openweathermap.client;

import org.openweathermap.client.response.OpenWeatherMapClientResponse;

/**
 * Created by beto on 26/11/15.
 */
public interface OpenWeatherMapClient {

  OpenWeatherMapClientResponse getCurrentWeatherByCityName(String cityName, String countryCode);
}
