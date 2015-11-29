package org.openweathermap.client.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openweathermap.client.OpenWeatherMapClient;
import org.openweathermap.client.params.*;
import org.openweathermap.client.response.OpenWeatherMapClientResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Locale;

/**
 * Created by beto on 26/11/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class OpenWeatherMapSpringClientTest {

  private static final Logger LOG = LoggerFactory.getLogger(OpenWeatherMapSpringClientTest.class);

  @Autowired
  OpenWeatherMapClient client;

  @Test
  public void verifyResponseFromExistingCity(){
    OtherFeatures features = new OtherFeatures(Format.JSON, SearchAccuracy.DEFAULT, UnitFormat.STANDARD, Language.ENGLISH);
    OpenWeatherMapClientResponse response = client.getCurrentWeatherByCityName("Mexico", "", features);
    LOG.debug("Response: {}", response);
  }

  @Test
  public void verifyResponseFromExistingCityAndLocale(){
    OtherFeatures features = new OtherFeatures(Format.JSON, SearchAccuracy.DEFAULT, UnitFormat.STANDARD, Language.ENGLISH);
    OpenWeatherMapClientResponse response = client.getCurrentWeatherByCityName("Mexico City", "XX", features);
    LOG.debug("Response: {}", response);
  }

  @Test
  public void verifyResponseNoExistingCity(){
    OtherFeatures features = new OtherFeatures(Format.JSON, SearchAccuracy.DEFAULT, UnitFormat.STANDARD, Language.ENGLISH);
    OpenWeatherMapClientResponse response = client.getCurrentWeatherByCityName("Invalid ", null, features);
    LOG.debug("Response: {}", response);
  }

  @Test
  public void verifySearchByIdResponse(){
    OtherFeatures features = new OtherFeatures(Format.JSON, SearchAccuracy.DEFAULT, UnitFormat.STANDARD, Language.ENGLISH);
    OpenWeatherMapClientResponse response = client.getCurrentWeatherById(2172797L, features);
    LOG.debug("Response: {}", response);
  }

  @Test
  public void verifySearchByGeoCoordsResponse(){
    OtherFeatures features = new OtherFeatures(Format.JSON, SearchAccuracy.DEFAULT, UnitFormat.STANDARD, Language.ENGLISH);
    OpenWeatherMapClientResponse response = client.getCurrentWeatherByGeographicCoordinates(-16.92, 145.77, features);
    LOG.debug("Response: {}", response);
  }

  @Test
  public void validateBadResponseWhenInvalidGeoCoordsRequest(){
    OtherFeatures features = new OtherFeatures(Format.JSON, SearchAccuracy.DEFAULT, UnitFormat.STANDARD, Language.ENGLISH);
    OpenWeatherMapClientResponse response = client.getCurrentWeatherByGeographicCoordinates(-1000.0,360.0, features);
    LOG.debug("Response: {}", response);
    Assert.assertEquals("404", response.getCod());
    Assert.assertEquals("Error: Not found city", response.getMessage());
  }

  @Test
  public void verifySearchByZipCodeResponse(){
    OtherFeatures features = new OtherFeatures(Format.JSON, SearchAccuracy.DEFAULT, UnitFormat.STANDARD, Language.ENGLISH);
    OpenWeatherMapClientResponse response = client.getCurrentWeatherByZipCode("94040", "us", features);
    LOG.debug("Response: {}", response);
  }

  @Test
  public void validateBadResponseWhenInvalidZipCodeRequest(){
    OtherFeatures features = new OtherFeatures(Format.JSON, SearchAccuracy.DEFAULT, UnitFormat.STANDARD, Language.ENGLISH);
    OpenWeatherMapClientResponse response = client.getCurrentWeatherByZipCode("00000", "XX", features);
    LOG.debug("Response: {}", response);
    Assert.assertEquals("404", response.getCod());
    Assert.assertEquals("Error: Not found city", response.getMessage());
  }



}
