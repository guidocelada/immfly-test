package com.immfly.filghtinfo.exception;

public class ExternalTimeoutException extends RuntimeException {

    public ExternalTimeoutException(Exception ex) {
        super(ex);
    }
}
