package com.immfly.filghtinfo.controller;

import com.immfly.filghtinfo.controller.resource.ErrorResource;
import com.immfly.filghtinfo.exception.AirplaneNotFoundException;
import com.immfly.filghtinfo.exception.FlightNotFoundException;
import com.immfly.filghtinfo.exception.InvalidRequestParameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.util.Arrays;
import java.util.stream.Collectors;

import static com.immfly.filghtinfo.controller.resource.ErrorResourceCodes.*;

@RestControllerAdvice
public class ErrorResponseControllerAdvice {

    private final Logger LOGGER = LoggerFactory.getLogger(ErrorResponseControllerAdvice.class);

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResource handleException(HttpServletRequest request, NoHandlerFoundException ex) {

        LOGGER.warn(ex.getMessage());

        return new ErrorResource(NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler(AirplaneNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResource handleException(HttpServletRequest request, AirplaneNotFoundException ex) {

        LOGGER.warn(ex.getMessage());

        return new ErrorResource(NOT_FOUND, "The airplane with tail number " + ex.getTailNumber() + " was not found");
    }

    @ExceptionHandler(FlightNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResource handleException(HttpServletRequest request, FlightNotFoundException ex) {

        LOGGER.warn(ex.getMessage());

        return new ErrorResource(NOT_FOUND, "The airplane with flight number " + ex.getFlightNumber() + " was not found");
    }


    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResource handleException(HttpServletRequest request, MethodArgumentTypeMismatchException ex) {

        LOGGER.warn(ex.getMessage());

        return new ErrorResource(INVALID_PARAMETERS, "Invalid parameters: '" + ex.getValue() + "' is not a valid '" + ex.getName() + "'.");
    }

    @ExceptionHandler(InvalidRequestParameters.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResource handleException(HttpServletRequest request, InvalidRequestParameters ex) {

        LOGGER.warn(ex.getMessage());

        return new ErrorResource(INVALID_PARAMETERS, "Invalid parameters.");
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResource constraintViolationException(ConstraintViolationException ex) {

        LOGGER.warn("Invalid parameters", ex);

        String msg = ex.getConstraintViolations().stream()
                .map(cv -> cv == null ? "null" : Arrays.stream(cv.getPropertyPath().toString().split("\\."))
                        .reduce((first, second) -> second)
                        .orElse("null") +
                        ": " + cv.getMessage())
                .collect(Collectors.joining(", "));

        return new ErrorResource(INVALID_PARAMETERS, msg);
    }

    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResource invalidPropertyException(BindException ex) {

        LOGGER.warn("Invalid parameters", ex);

        String msg = ex.getFieldErrors().stream()
                .map(error -> error.getField() + " " + error.getDefaultMessage())
                .collect(Collectors.joining(", "));

        return new ErrorResource(INVALID_PARAMETERS, msg);
    }


    //Keep it last
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResource handleException(HttpServletRequest request, Exception ex) {

        LOGGER.error("Unexpected error", ex);

        return new ErrorResource(UNEXPECTED, "Unexpected error.");
    }
}
