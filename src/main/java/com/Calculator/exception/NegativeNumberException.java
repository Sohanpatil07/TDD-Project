package com.Calculator.exception;

import org.springframework.stereotype.Component;


public class NegativeNumberException extends Exception {
    public NegativeNumberException(String message) {
        super(message);
    }
}
