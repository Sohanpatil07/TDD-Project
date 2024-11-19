package com.Calculator.controller;

import com.Calculator.exception.NegativeNumberException;
import com.Calculator.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NegativeNumberException.class)
    public ResponseEntity<ErrorResponse> handleNegativeNumberException(NegativeNumberException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), "Please provide a positive number.");
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}
