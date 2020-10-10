package com.immfly.filghtinfo.exception;

public class FlightNotFoundException extends RuntimeException {

    private final String flightNumber;

    public FlightNotFoundException(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getFlightNumber() {
        return flightNumber;
    }
}
