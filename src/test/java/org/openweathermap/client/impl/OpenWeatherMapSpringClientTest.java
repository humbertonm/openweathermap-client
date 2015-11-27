package org.openweathermap.client.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openweathermap.client.OpenWeatherMapClient;
import org.openweathermap.client.response.OpenWeatherMapClientResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
  public void verify(){
    OpenWeatherMapClientResponse response = client.getCurrentWeatherByCityName("Mexico%20City", null);
    LOG.debug("Response: {}", response);
  }


}
