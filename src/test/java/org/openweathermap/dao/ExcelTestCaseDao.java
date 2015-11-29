package org.openweathermap.dao;

import com.google.common.base.CharMatcher;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openweathermap.client.params.*;
import org.openweathermap.client.response.OpenWeatherMapClientResponse;
import org.openweathermap.dto.OpenWeatherMapTestCase;
import org.openweathermap.dto.TestCaseType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by beto on 29/11/2015.
 */
@Component
public class ExcelTestCaseDao implements TestCaseDao {

  private static final Logger LOG = LoggerFactory.getLogger(ExcelTestCaseDao.class);

  private static final int HEADER_ROWS = 1;
  public static final int FEATURES_SIZE = 4;

  @Value("${testcases.filename}")
  private String testCasesFileName;
  @Value("${testcases.bycityname.sheet}")
  private String testCasesByCityNameSheet;
  @Value("${testcases.byid.sheet}")
  private String testCasesByIdSheet;
  @Value("${testcases.bygeocoords.sheet}")
  private String testCasesByGeoCoordsSheet;
  @Value("${testcases.byzipcode.sheet}")
  private String testCasesByZipCodeSheet;

  public List<OpenWeatherMapTestCase> getTestCasesByCityName() throws IOException {
    List<OpenWeatherMapTestCase> testCases = new ArrayList<OpenWeatherMapTestCase>();
    File f = new File(testCasesFileName);
    LOG.debug("Reading file: {}" , f.getAbsoluteFile());

    FileInputStream file = new FileInputStream(f);
    XSSFWorkbook workbook = new XSSFWorkbook(file);

    XSSFSheet sheet = workbook.getSheet(testCasesByCityNameSheet);

    if (sheet == null) {
      return testCases;
    }

    FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();

    LOG.debug("Row Count {}: ", (sheet.getLastRowNum() + 1));

    Iterator<Row> rowIterator = sheet.iterator();
    while (rowIterator.hasNext()) {
      Row row = rowIterator.next();
      int rowNum = row.getRowNum();
      if(rowNum < HEADER_ROWS) {  // skip headers
        continue;
      }

      OpenWeatherMapTestCase testCase = new OpenWeatherMapTestCase();

      int i = 0;
      testCase.setTestCaseId(getLongValue(row.getCell(i++), evaluator));
      testCase.setDescription(getStringValue(row.getCell(i++), evaluator));
      testCase.setType(TestCaseType.valueOf(getStringValue(row.getCell(i++), evaluator)));

      testCase.setCityName(getStringValue(row.getCell(i++), evaluator));
      testCase.setCountryCode(getStringValue(row.getCell(i++), evaluator));

      testCase.setFeatures(buildFeatures(row, i, evaluator));
      //Move index
      i+= FEATURES_SIZE;

      testCase.setExpectedResult(buildExpectedResult(row, i, evaluator));

      testCases.add(testCase);
    }

    file.close();

    return testCases;
  }

  public List<OpenWeatherMapTestCase> getTestCasesById() throws IOException {
    List<OpenWeatherMapTestCase> testCases = new ArrayList<OpenWeatherMapTestCase>();
    File f = new File(testCasesFileName);
    LOG.debug("Reading file: {}" , f.getAbsoluteFile());

    FileInputStream file = new FileInputStream(f);
    XSSFWorkbook workbook = new XSSFWorkbook(file);

    XSSFSheet sheet = workbook.getSheet(testCasesByIdSheet);

    if (sheet == null) {
      return testCases;
    }

    FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();

    LOG.debug("Row Count {}: ", (sheet.getLastRowNum() + 1));

    Iterator<Row> rowIterator = sheet.iterator();
    while (rowIterator.hasNext()) {
      Row row = rowIterator.next();
      int rowNum = row.getRowNum();
      if(rowNum < HEADER_ROWS) {  // skip headers
        continue;
      }

      OpenWeatherMapTestCase testCase = new OpenWeatherMapTestCase();

      int i = 0;
      testCase.setTestCaseId(getLongValue(row.getCell(i++), evaluator));
      testCase.setDescription(getStringValue(row.getCell(i++), evaluator));
      testCase.setType(TestCaseType.valueOf(getStringValue(row.getCell(i++), evaluator)));

      testCase.setCityId(getLongValue(row.getCell(i++), evaluator));

      testCase.setFeatures(buildFeatures(row, i, evaluator));
      //Move index
      i+= FEATURES_SIZE;

      testCase.setExpectedResult(buildExpectedResult(row, i, evaluator));

      testCases.add(testCase);
    }

    file.close();

    return testCases;
  }

  public List<OpenWeatherMapTestCase> getTestCasesByGeoCoords() throws IOException {
    List<OpenWeatherMapTestCase> testCases = new ArrayList<OpenWeatherMapTestCase>();
    File f = new File(testCasesFileName);
    LOG.debug("Reading file: {}" , f.getAbsoluteFile());

    FileInputStream file = new FileInputStream(f);
    XSSFWorkbook workbook = new XSSFWorkbook(file);

    XSSFSheet sheet = workbook.getSheet(testCasesByGeoCoordsSheet);

    if (sheet == null) {
      return testCases;
    }

    FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();

    LOG.debug("Row Count {}: ", (sheet.getLastRowNum() + 1));

    Iterator<Row> rowIterator = sheet.iterator();
    while (rowIterator.hasNext()) {
      Row row = rowIterator.next();
      int rowNum = row.getRowNum();
      if(rowNum < HEADER_ROWS) {  // skip headers
        continue;
      }

      OpenWeatherMapTestCase testCase = new OpenWeatherMapTestCase();

      int i = 0;
      testCase.setTestCaseId(getLongValue(row.getCell(i++), evaluator));
      testCase.setDescription(getStringValue(row.getCell(i++), evaluator));
      testCase.setType(TestCaseType.valueOf(getStringValue(row.getCell(i++), evaluator)));

      testCase.setLat(getDoubleValue(row.getCell(i++), evaluator));
      testCase.setLon(getDoubleValue(row.getCell(i++), evaluator));

      testCase.setFeatures(buildFeatures(row, i, evaluator));
      //Move index
      i+= FEATURES_SIZE;

      testCase.setExpectedResult(buildExpectedResult(row, i, evaluator));

      testCases.add(testCase);
    }

    file.close();

    return testCases;
  }

  public List<OpenWeatherMapTestCase> getTestCasesByZipCode() throws IOException {
    List<OpenWeatherMapTestCase> testCases = new ArrayList<OpenWeatherMapTestCase>();
    File f = new File(testCasesFileName);
    LOG.debug("Reading file: {}" , f.getAbsoluteFile());

    FileInputStream file = new FileInputStream(f);
    XSSFWorkbook workbook = new XSSFWorkbook(file);

    XSSFSheet sheet = workbook.getSheet(testCasesByZipCodeSheet);

    if (sheet == null) {
      return testCases;
    }

    FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();

    LOG.debug("Row Count {}: ", (sheet.getLastRowNum() + 1));

    Iterator<Row> rowIterator = sheet.iterator();
    while (rowIterator.hasNext()) {
      Row row = rowIterator.next();
      int rowNum = row.getRowNum();
      if(rowNum < HEADER_ROWS) {  // skip headers
        continue;
      }

      OpenWeatherMapTestCase testCase = new OpenWeatherMapTestCase();

      int i = 0;
      testCase.setTestCaseId(getLongValue(row.getCell(i++), evaluator));
      testCase.setDescription(getStringValue(row.getCell(i++), evaluator));
      testCase.setType(TestCaseType.valueOf(getStringValue(row.getCell(i++), evaluator)));

      testCase.setZipCode(getStringValue(row.getCell(i++), evaluator));
      testCase.setCountryCode(getStringValue(row.getCell(i++), evaluator));

      testCase.setFeatures(buildFeatures(row, i, evaluator));
      //Move index
      i+= FEATURES_SIZE;

      testCase.setExpectedResult(buildExpectedResult(row, i, evaluator));

      testCases.add(testCase);
    }

    file.close();

    return testCases;
  }

  private String getStringValue(Cell cell, FormulaEvaluator evaluator) {

    if (cell == null) {
      return "";
    }

    String cellValue = "";

    switch (evaluator.evaluateInCell(cell).getCellType()) {
      case Cell.CELL_TYPE_BLANK:
        break;
      case Cell.CELL_TYPE_NUMERIC:
        cellValue = String.format("%1.0f", cell.getNumericCellValue());
        break;
      default:
        cellValue = cell.getStringCellValue();
        break;
    }

    return CharMatcher.WHITESPACE.trimFrom(cellValue);
  }

  private Double getDoubleValue(Cell cell, FormulaEvaluator evaluator) {
    Double value = 0.0;

    if (cell == null) {
      return value;
    }

    switch (evaluator.evaluateInCell(cell).getCellType()) {
      case Cell.CELL_TYPE_BLANK:
        break;
      case Cell.CELL_TYPE_NUMERIC:
        value = cell.getNumericCellValue();
        break;
      default:
        try {
          value = cell.getNumericCellValue();
        }catch (Exception e) {
          LOG.error("Unsupported conversion to double, cell value: {}", cell.getStringCellValue(), e);
        }
        break;
    }

    return value;
  }

  private Long getLongValue(Cell cell, FormulaEvaluator evaluator) {
    Long value = 0L;

    if (cell == null) {
      return value;
    }

    switch (evaluator.evaluateInCell(cell).getCellType()) {
      case Cell.CELL_TYPE_BLANK:
        break;
      case Cell.CELL_TYPE_NUMERIC:
        value = Long.parseLong(String.format("%1.0f", cell.getNumericCellValue()));
        break;
      default:
        try {
          value = Long.parseLong(String.format("%1.0f", cell.getNumericCellValue()));
        }catch (Exception e) {
          LOG.error("Unsupported conversion to long, cell value: {}", cell.getStringCellValue(), e);
        }
        break;
    }

    return value;
  }

  private OtherFeatures buildFeatures(Row row, int i, FormulaEvaluator evaluator){
    OtherFeatures features = new OtherFeatures();
    features.setFormat(Format.valueOf(getStringValue(row.getCell(i++), evaluator)));
    features.setSearchAccuracy(SearchAccuracy.valueOf(getStringValue(row.getCell(i++), evaluator)));
    features.setUnitFormat(UnitFormat.valueOf(getStringValue(row.getCell(i++), evaluator)));
    features.setLanguage(Language.valueOf(getStringValue(row.getCell(i++), evaluator)));
    return features;
  }

  private OpenWeatherMapClientResponse buildExpectedResult(Row row, int i, FormulaEvaluator evaluator){
    OpenWeatherMapClientResponse expectedResult = new OpenWeatherMapClientResponse();
    expectedResult.setCod(getStringValue(row.getCell(i++), evaluator));
    expectedResult.setMessage(getStringValue(row.getCell(i++), evaluator));
    expectedResult.setId(getStringValue(row.getCell(i++), evaluator));
    expectedResult.setName(getStringValue(row.getCell(i++), evaluator));
    return expectedResult;
  }
}
