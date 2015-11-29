package org.openweathermap.client.params;

/**
 * Created by beto on 28/11/2015.
 */
public enum Language {

  ENGLISH("en"),
  RUSSIAN("ru"),
  ITALIAN("it"),
  SPANISH("es"),
  SPANISH_SP("sp"),
  UKRAINIAN_UK("uk"),
  UKRAINIAN_UA("ua"),
  GERMAN("de"),
  PORTUGUESE("pt"),
  ROMANIAN("ro"),
  POLISH("pl"),
  FINNISH("fi"),
  DUTCH("nl"),
  FRENCH("fr"),
  BULGARIAN("bg"),
  SWEDISH_SV("sv"),
  SWEDISH_SE("se"),
  CHINESE_TRADITIONAL("zh_tw"),
  CHINESE_SIMPLIFIED_ZH("zh"),
  CHINESE_SIMPLIFIED_ZH_CN("zh_cn"),
  TURKISH("tr"),
  CROATIAN("hr"),
  CATALAN("ca");

  private String lang;

  Language(String lang) {
    this.lang = lang;
  }

  public String getLang() {
    return lang;
  }
}
