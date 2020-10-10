package com.immfly.filghtinfo.client.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AirportDTO implements Serializable {

    private String code;
    private String city;
    @JsonProperty("alternate_ident")
    private String alternateIdent;
    @JsonProperty("airport_name")
    private String airportName;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAlternateIdent() {
        return alternateIdent;
    }

    public void setAlternateIdent(String alternateIdent) {
        this.alternateIdent = alternateIdent;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }
}
