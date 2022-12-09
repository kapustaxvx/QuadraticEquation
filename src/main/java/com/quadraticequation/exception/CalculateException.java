package com.quadraticequation.exception;

public class CalculateException extends RuntimeException{
    public CalculateException() {
        super();
    }

    public CalculateException(String message) {
        super(message);
    }
}
