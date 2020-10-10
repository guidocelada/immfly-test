package com.immfly.filghtinfo.controller.resource;

public class ErrorResource {

    private String code;
    private String reason;

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
