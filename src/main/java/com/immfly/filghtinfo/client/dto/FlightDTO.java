package com.immfly.filghtinfo.client.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FlightDTO implements Serializable {

    private String ident;
    private String faFlightID;
    private String airline;
    @JsonProperty("airline_iata")
    private String airlineIata;
    private String flightnumber;
    private String tailnumber;
    private String type;
    private String codeshares;
    private Boolean blocked;
    private Boolean diverted;
    private Boolean cancelled;
    private AirportDTO origin;
    private AirportDTO destination;

    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    public String getFaFlightID() {
        return faFlightID;
    }

    public void setFaFlightID(String faFlightID) {
        this.faFlightID = faFlightID;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getAirlineIata() {
        return airlineIata;
    }

    public void setAirlineIata(String airlineIata) {
        this.airlineIata = airlineIata;
    }

    public String getFlightnumber() {
        return flightnumber;
    }

    public void setFlightnumber(String flightnumber) {
        this.flightnumber = flightnumber;
    }

    public String getTailnumber() {
        return tailnumber;
    }

    public void setTailnumber(String tailnumber) {
        this.tailnumber = tailnumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCodeshares() {
        return codeshares;
    }

    public void setCodeshares(String codeshares) {
        this.codeshares = codeshares;
    }

    public Boolean getBlocked() {
        return blocked;
    }

    public void setBlocked(Boolean blocked) {
        this.blocked = blocked;
    }

    public Boolean getDiverted() {
        return diverted;
    }

    public void setDiverted(Boolean diverted) {
        this.diverted = diverted;
    }

    public Boolean getCancelled() {
        return cancelled;
    }

    public void setCancelled(Boolean cancelled) {
        this.cancelled = cancelled;
    }

    public AirportDTO getOrigin() {
        return origin;
    }

    public void setOrigin(AirportDTO origin) {
        this.origin = origin;
    }

    public AirportDTO getDestination() {
        return destination;
    }

    public void setDestination(AirportDTO destination) {
        this.destination = destination;
    }
}
