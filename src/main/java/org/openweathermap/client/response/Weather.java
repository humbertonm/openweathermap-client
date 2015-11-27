
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
        "id",
        "main",
        "description",
        "icon"
})
public class Weather {

  @JsonProperty("id")
  private Integer id;
  @JsonProperty("main")
  private String main;
  @JsonProperty("description")
  private String description;
  @JsonProperty("icon")
  private String icon;

  /**
   * No args constructor for use in serialization
   *
   */
  public Weather() {
  }

  /**
   *
   * @param id
   * @param icon
   * @param description
   * @param main
   */
  public Weather(Integer id, String main, String description, String icon) {
    this.id = id;
    this.main = main;
    this.description = description;
    this.icon = icon;
  }

  /**
   *
   * @return
   *     The id
   */
  @JsonProperty("id")
  public Integer getId() {
    return id;
  }

  /**
   *
   * @param id
   *     The id
   */
  @JsonProperty("id")
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   *
   * @return
   *     The main
   */
  @JsonProperty("main")
  public String getMain() {
    return main;
  }

  /**
   *
   * @param main
   *     The main
   */
  @JsonProperty("main")
  public void setMain(String main) {
    this.main = main;
  }

  /**
   *
   * @return
   *     The description
   */
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  /**
   *
   * @param description
   *     The description
   */
  @JsonProperty("description")
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   *
   * @return
   *     The icon
   */
  @JsonProperty("icon")
  public String getIcon() {
    return icon;
  }

  /**
   *
   * @param icon
   *     The icon
   */
  @JsonProperty("icon")
  public void setIcon(String icon) {
    this.icon = icon;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }

}
