package com.example.userregistration.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<Object> handleException(ApiException ex, WebRequest request) {
        HttpStatus httpStatus = ex.getHttpStatus();
        ExceptionResponseBody exceptionResponseBody = new ExceptionResponseBody(
                splitCamelCase(ex.getClass().getSimpleName()),
                httpStatus.value(),
                ex.getMessage(),
                ((ServletWebRequest)request).getRequest().getRequestURI(),
                ZonedDateTime.now()
        );
        return new ResponseEntity<>(exceptionResponseBody, httpStatus);
    }

    static String splitCamelCase(String s) {
        return s.replaceAll(
                String.format("%s|%s|%s",
                        "(?<=[A-Z])(?=[A-Z][a-z])",
                        "(?<=[^A-Z])(?=[A-Z])",
                        "(?<=[A-Za-z])(?=[^A-Za-z])"
                ),
                " "
        );
    }
}
