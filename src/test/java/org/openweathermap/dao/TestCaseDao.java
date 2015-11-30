package org.openweathermap.dao;

import org.openweathermap.dto.OpenWeatherMapTestCase;
import org.openweathermap.exceptions.DaoException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * Created by betob_000 on 29/11/2015.
 */
public interface TestCaseDao {

  List<OpenWeatherMapTestCase> getTestCasesByCityName() throws DaoException;
  List<OpenWeatherMapTestCase> getTestCasesById() throws DaoException;
  List<OpenWeatherMapTestCase> getTestCasesByGeoCoords() throws DaoException;
  List<OpenWeatherMapTestCase> getTestCasesByZipCode() throws DaoException;

}
