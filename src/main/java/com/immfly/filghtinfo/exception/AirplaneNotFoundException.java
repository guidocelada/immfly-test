package com.immfly.filghtinfo.exception;

public class AirplaneNotFoundException extends RuntimeException {

    private final String tailNumber;

    public AirplaneNotFoundException(String tailNumber) {
        this.tailNumber = tailNumber;
    }

    public String getTailNumber() {
        return tailNumber;
    }
}
