
package org.openweathermap.client.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by beto on 26/11/15.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "all"
})
public class Clouds {

  @JsonProperty("all")
  private Integer all;

  /**
   * No args constructor for use in serialization
   *
   */
  public Clouds() {
  }

  /**
   *
   * @param all
   */
  public Clouds(Integer all) {
    this.all = all;
  }

  /**
   *
   * @return
   *     The all
   */
  @JsonProperty("all")
  public Integer getAll() {
    return all;
  }

  /**
   *
   * @param all
   *     The all
   */
  @JsonProperty("all")
  public void setAll(Integer all) {
    this.all = all;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }

}
