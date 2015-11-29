package org.openweathermap.client.impl;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.openweathermap.client.OpenWeatherMapClient;
import org.openweathermap.client.params.*;
import org.openweathermap.client.response.OpenWeatherMapClientResponse;
import org.openweathermap.dao.TestCaseDao;
import org.openweathermap.dto.OpenWeatherMapTestCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * Created by beto on 26/11/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class OpenWeatherMapSpringClientTest {

  private static final Logger LOG = LoggerFactory.getLogger(OpenWeatherMapSpringClientTest.class);

  @Rule
  public TestRule testWatcher = new TestWatcher() {
    @Override
    public void failed(Throwable t, Description test) {
      LOG.debug("test case failed: {}", testCase);
    }
  };

  @Autowired
  private OpenWeatherMapClient client;

  @Autowired
  private TestCaseDao testCaseDao;

  private OpenWeatherMapTestCase testCase;

  @Test
  public void validateSearchByNameResponseFromDao() throws IOException {
    List<OpenWeatherMapTestCase> testCases = testCaseDao.getTestCasesByCityName();
    for(OpenWeatherMapTestCase testCase : testCases){
      this.testCase = testCase;
      OtherFeatures features = testCase.getFeatures();
      OpenWeatherMapClientResponse response = client.getCurrentWeatherByCityName(testCase.getCityName(), testCase.getCountryCode(), features);
      OpenWeatherMapClientResponse expected = testCase.getExpectedResult();
      LOG.debug("Response: {}", response);
      compareResponse(expected,response);
    }
  }

  @Test
  public void validateSearchByIdResponseFromDao() throws IOException {
    List<OpenWeatherMapTestCase> testCases = testCaseDao.getTestCasesById();
    for(OpenWeatherMapTestCase testCase : testCases){
      this.testCase = testCase;
      OtherFeatures features = testCase.getFeatures();
      OpenWeatherMapClientResponse response = client.getCurrentWeatherById(testCase.getCityId(), features);
      OpenWeatherMapClientResponse expected = testCase.getExpectedResult();
      LOG.debug("Response: {}", response);
      switch (testCase.getType()){
        case CORRECT:
          compareResponse(expected, response);
          break;
        case INVALID_DATA:
          compareResponseInvalidData(expected,response);
          break;
        default:
          LOG.error("Not Implemented");
      }
    }
  }

  @Test
  public void validateSearchByGeoCoordsResponseFromDao() throws IOException {
    List<OpenWeatherMapTestCase> testCases = testCaseDao.getTestCasesByGeoCoords();
    for(OpenWeatherMapTestCase testCase : testCases){
      this.testCase = testCase;
      OtherFeatures features = testCase.getFeatures();
      OpenWeatherMapClientResponse response = client.getCurrentWeatherByGeographicCoordinates(testCase.getLat(), testCase.getLon(), features);
      OpenWeatherMapClientResponse expected = testCase.getExpectedResult();
      LOG.debug("Response: {}", response);
      switch (testCase.getType()){
        case CORRECT:
          compareResponse(expected, response);
          break;
        case INVALID_DATA:
          compareResponseInvalidData(expected,response);
          break;
        default:
          LOG.error("Not Implemented");
      }
    }
  }

  @Test
  public void validateSearchByZipCodeResponseFromDao() throws IOException {
    List<OpenWeatherMapTestCase> testCases = testCaseDao.getTestCasesByZipCode();
    for(OpenWeatherMapTestCase testCase : testCases){
      this.testCase = testCase;
      OtherFeatures features = testCase.getFeatures();
      OpenWeatherMapClientResponse response = client.getCurrentWeatherByZipCode(testCase.getZipCode(), testCase.getCountryCode(), features);
      OpenWeatherMapClientResponse expected = testCase.getExpectedResult();
      LOG.debug("Response: {}", response);
      switch (testCase.getType()){
        case CORRECT:
          compareResponse(expected, response);
          break;
        case INVALID_DATA:
          compareResponseInvalidData(expected,response);
          break;
        default:
          LOG.error("Not Implemented");
      }
    }
  }

  private void compareResponse(OpenWeatherMapClientResponse expected, OpenWeatherMapClientResponse response){
    //Only Data that we know can be compared. Out of scope dinamic data
    //TODO: Create Hamcrest Matcher
    Assert.assertEquals(expected.getCod(), response.getCod());
    Assert.assertNull(response.getMessage());
    Assert.assertEquals(expected.getId(), response.getId());
    Assert.assertEquals(expected.getName(), response.getName());

  }

  private void compareResponseInvalidData(OpenWeatherMapClientResponse expected, OpenWeatherMapClientResponse response){
    //Only Data that we know can be compared. Out of scope dinamic data
    //TODO: Create Hamcrest Matcher
    Assert.assertEquals(expected.getCod(), response.getCod());
    Assert.assertEquals(expected.getMessage(), response.getMessage());
    //TODO: Other values to null
  }



}
