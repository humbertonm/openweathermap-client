package org.openweathermap.client.impl;

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
    OpenWeatherMapClientResponse response = client.getCurrentWeatherByCityName("Mexico City", "mx", features);
    LOG.debug("Response: {}", response);
  }

  @Test
  public void verifyResponseNoExistingCity(){
    OtherFeatures features = new OtherFeatures(Format.JSON, SearchAccuracy.DEFAULT, UnitFormat.STANDARD, Language.ENGLISH);
    OpenWeatherMapClientResponse response = client.getCurrentWeatherByCityName("Invalid", null, features);
    LOG.debug("Response: {}", response);
  }

  @Test
  public void x(){
    Locale l = new Locale("es","mx");
    LOG.debug("country: {}", l.getCountry());

  }


}
