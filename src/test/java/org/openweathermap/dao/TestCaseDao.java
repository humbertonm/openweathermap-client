package org.openweathermap.dao;

import org.openweathermap.dto.OpenWeatherMapTestCase;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * Created by betob_000 on 29/11/2015.
 */
public interface TestCaseDao {

  List<OpenWeatherMapTestCase> getTestCasesByCityName() throws IOException;
  List<OpenWeatherMapTestCase> getTestCasesById() throws IOException;
  List<OpenWeatherMapTestCase> getTestCasesByGeoCoords();
  List<OpenWeatherMapTestCase> getTestCasesByZipCode();

}
