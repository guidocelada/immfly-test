package com.immfly.filghtinfo.model;

import com.immfly.filghtinfo.client.dto.AirportDTO;

public class Flight {

    private String ident;
    private String faFlightID;
    private String airline;
    private String airline_iata;
    private String flightnumber;
    private String tailnumber;
    private String type;
    private String codeshares;
    private Boolean blocked;
    private Boolean diverted;
    private Boolean cancelled;
    private Airport origin;
    private Airport destination;

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

    public String getAirline_iata() {
        return airline_iata;
    }

    public void setAirline_iata(String airline_iata) {
        this.airline_iata = airline_iata;
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

    public Airport getOrigin() {
        return origin;
    }

    public void setOrigin(Airport origin) {
        this.origin = origin;
    }

    public Airport getDestination() {
        return destination;
    }

    public void setDestination(Airport destination) {
        this.destination = destination;
    }
}
