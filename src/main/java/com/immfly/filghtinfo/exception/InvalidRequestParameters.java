package com.immfly.filghtinfo.exception;

public class InvalidRequestParameters extends RuntimeException {

    private String parameter;
    private String value;

    public InvalidRequestParameters(String parameter, String value) {
        this.parameter = parameter;
        this.value = value;
    }

    public InvalidRequestParameters() {
    }

    public String getMessage() {

        if (parameter == null) {
            return "Invalid request parameters.";
        }

        return "Invalid request parameters: " + value + " is not a valid " + parameter + ".";
    }
}
