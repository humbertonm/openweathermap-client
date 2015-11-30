package org.openweathermap.client;

import org.openweathermap.client.params.*;
import org.openweathermap.client.response.OpenWeatherMapClientResponse;
import org.openweathermap.client.response.OpenWeatherMapListResponse;

import java.util.Locale;

/**
 * Created by beto on 26/11/15.
 */
public interface OpenWeatherMapClient {

  OpenWeatherMapClientResponse getCurrentWeatherByCityName(String cityName, String countryCode, OtherFeatures features);
  OpenWeatherMapClientResponse getCurrentWeatherById(Long id, OtherFeatures features);
  OpenWeatherMapClientResponse getCurrentWeatherByGeographicCoordinates(Double lat, Double lon, OtherFeatures features);
  OpenWeatherMapClientResponse getCurrentWeatherByZipCode(String zipCode, String countryCode, OtherFeatures features);
  OpenWeatherMapListResponse getCurrentWeatherFromCitiesWithinRectangleZone(BoundingBox bbox, Cluster cluster, OtherFeatures features);
}
