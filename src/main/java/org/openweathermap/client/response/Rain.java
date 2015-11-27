
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
        "3h"
})
public class Rain {

    @JsonProperty("3h")
    private Integer _3h;

    /**
     * No args constructor for use in serialization
     *
     */
    public Rain() {
    }

    /**
     *
     * @param _3h
     */
    public Rain(Integer _3h) {
        this._3h = _3h;
    }

    /**
     *
     * @return
     *     The _3h
     */
    @JsonProperty("3h")
    public Integer get3h() {
        return _3h;
    }

    /**
     *
     * @param _3h
     *     The 3h
     */
    @JsonProperty("3h")
    public void set3h(Integer _3h) {
        this._3h = _3h;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
