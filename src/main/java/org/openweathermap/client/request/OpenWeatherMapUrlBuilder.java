package org.openweathermap.client.request;

import org.apache.commons.codec.net.URLCodec;
import org.openweathermap.client.params.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.BitSet;
import java.util.Locale;

/**
 * Created by betob_000 on 28/11/2015.
 */
public class OpenWeatherMapUrlBuilder {

  private static final Logger LOG = LoggerFactory.getLogger(OpenWeatherMapUrlBuilder.class);

  private static final String UTF_8 = "UTF-8";

  private static final String CITY_PARAM = "q";
  private static final String APP_ID_PARAM = "appid";
  private static final String SEARCH_ACCURACY_PARAM = "type";
  private static final String UNITS_PARAM = "units";
  private static final String LANGUAGE_PARAM = "lang";
  private static final String FORMAT_PARAM = "xml";
  private static final String ID_PARAM = "id";
  private static final String LAT_PARAM = "lat";
  private static final String LON_PARAM = "lon";
  private static final String ZIPCODE_PARAM = "zip";
  private static final String BBOX_PARAM = "bbox";
  private static final String CLUSTER_PARAM ="cluster";


  private OpenWeatherMapUrlBuilder(){

  }

  public static String buildCurrentWeatherByCityNameUrl(String url, String appId, String cityName, String countryCode, OtherFeatures features){
    StringBuilder fullUrl = new StringBuilder(url);
    fullUrl.append("weather");
    addParam(fullUrl, CITY_PARAM, cityName, true);
    if(countryCode != null && !"".equals(countryCode)){
      fullUrl.append(",");
      fullUrl.append(countryCode);
    }
    addParam(fullUrl, APP_ID_PARAM,appId,false);
    addOtherFeatures(fullUrl,features);

    return fullUrl.toString();
  }

  public static String buildCurrentWeatherByIdUrl(String url, Long id, String appId, OtherFeatures features){
    StringBuilder fullUrl = new StringBuilder(url);
    fullUrl.append("weather");
    addParam(fullUrl, ID_PARAM, id.toString(), true);
    addOtherFeatures(fullUrl, features);
    addParam(fullUrl, APP_ID_PARAM, appId, false);
    return fullUrl.toString();
  }

  public static String buildCurrentWeatherByGeoCoordsUrl(String url, Double lat, Double lon, String appId, OtherFeatures features){
    StringBuilder fullUrl = new StringBuilder(url);
    fullUrl.append("weather");
    addParam(fullUrl, LAT_PARAM, lat.toString(), true);
    addParam(fullUrl, LON_PARAM, lon.toString(), false);
    addOtherFeatures(fullUrl, features);
    addParam(fullUrl, APP_ID_PARAM, appId, false);
    return fullUrl.toString();
  }

  public static String buildCurrentWeatherByZipCodeUrl(String url, String zipCode, String countryCode, String appId, OtherFeatures features){
    StringBuilder fullUrl = new StringBuilder(url);
    fullUrl.append("weather");
    addParam(fullUrl, ZIPCODE_PARAM, zipCode, true);
    fullUrl.append(",");
    fullUrl.append(countryCode);
    addOtherFeatures(fullUrl, features);
    addParam(fullUrl, APP_ID_PARAM, appId, false);
    return fullUrl.toString();
  }

  public static String buildCurrentWeatherByBoundingBoxUrl(String url, BoundingBox box, Cluster cluster, String appId, OtherFeatures features){
    StringBuilder fullUrl = new StringBuilder(url);
    fullUrl.append("box/city");

    addParam(fullUrl, BBOX_PARAM, box.getLatTopLeft().toString(), true);
    fullUrl.append(",");
    fullUrl.append(box.getLonTopLeft());
    fullUrl.append(",");
    fullUrl.append(box.getLatBottomRight());
    fullUrl.append(",");
    fullUrl.append(box.getLonBottomRight());
    fullUrl.append(",");
    fullUrl.append(box.getZoom());

    addParam(fullUrl, CLUSTER_PARAM,cluster.getClusterOption(),false);

    addOtherFeatures(fullUrl, features);
    addParam(fullUrl, APP_ID_PARAM, appId, false);
    return fullUrl.toString();
  }

  private static void addOtherFeatures(StringBuilder fullUrl, OtherFeatures features){
    Format format = features.getFormat();
    SearchAccuracy searchAccuracy = features.getSearchAccuracy();
    UnitFormat unitFormat = features.getUnitFormat();
    Language language = features.getLanguage();
    if(format != null && format.getFormat() != null){
      addParam(fullUrl, FORMAT_PARAM, format.getFormat(), false);
    }
    if(searchAccuracy != null && searchAccuracy.getSearchAccuracy() != null){
      addParam(fullUrl,SEARCH_ACCURACY_PARAM,searchAccuracy.getSearchAccuracy(), false);
    }
    if(unitFormat != null && unitFormat.getFormat() != null){
      addParam(fullUrl,UNITS_PARAM,unitFormat.getFormat(), false);
    }
    if(language != null && language.getLang() != null){
      addParam(fullUrl,LANGUAGE_PARAM,language.getLang(), false);
    }
  }

  private static void addParam(StringBuilder builder, String param, String value, boolean firstParam){
    if(param!=null){
      if(firstParam){
        builder.append("?");
      }else {
        builder.append("&");
      }
      builder.append(param);
      builder.append("=");
      try{
        builder.append(URLEncoder.encode(value, UTF_8));
      }catch (UnsupportedEncodingException e) {
        LOG.error("Error encoding value: {}", value ,e);
      }
    }
  }

}
