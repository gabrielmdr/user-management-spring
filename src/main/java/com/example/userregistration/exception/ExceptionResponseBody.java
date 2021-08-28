package com.example.userregistration.exception;

import java.time.ZonedDateTime;

public class ExceptionResponseBody {
    private final String error;
    private final int httpStatus;
    private final String message;
    private final String path;
    private final ZonedDateTime timestamp;

    public ExceptionResponseBody(String error, int httpStatus, String message, String path, ZonedDateTime timestamp) {
        this.error = error;
        this.httpStatus = httpStatus;
        this.message = message;
        this.path = path;
        this.timestamp = timestamp;
    }

    public String getError() {
        return error;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }
}
