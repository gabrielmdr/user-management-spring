package com.example.userregistration.user.exception;

import com.example.userregistration.exception.ApiException;
import org.springframework.http.HttpStatus;

public class UserMissingFieldException extends ApiException {
    public UserMissingFieldException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
