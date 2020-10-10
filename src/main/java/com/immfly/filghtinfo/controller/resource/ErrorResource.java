package com.immfly.filghtinfo.controller.resource;

public class ErrorResource {

    private final String code;
    private final String reason;

    public ErrorResource(String code, String reason) {
        this.code = code;
        this.reason = reason;
    }

    public String getCode() {
        return code;
    }

    public String getReason() {
        return reason;
    }
}
