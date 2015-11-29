package org.openweathermap.client.params;

/**
 * Created by beto on 28/11/2015.
 */
public class OtherFeatures {

  private Format format;
  private SearchAccuracy searchAccuracy;
  private UnitFormat unitFormat;
  private Language language;

  public OtherFeatures() {
  }

  public OtherFeatures(Format format, SearchAccuracy searchAccuracy, UnitFormat unitFormat, Language language) {
    this.format = format;
    this.searchAccuracy = searchAccuracy;
    this.unitFormat = unitFormat;
    this.language = language;
  }

  public Format getFormat() {
    return format;
  }

  public void setFormat(Format format) {
    this.format = format;
  }

  public SearchAccuracy getSearchAccuracy() {
    return searchAccuracy;
  }

  public void setSearchAccuracy(SearchAccuracy searchAccuracy) {
    this.searchAccuracy = searchAccuracy;
  }

  public UnitFormat getUnitFormat() {
    return unitFormat;
  }

  public void setUnitFormat(UnitFormat unitFormat) {
    this.unitFormat = unitFormat;
  }

  public Language getLanguage() {
    return language;
  }

  public void setLanguage(Language language) {
    this.language = language;
  }
}
