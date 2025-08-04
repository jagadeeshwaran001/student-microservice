package com.nector.student.exception;

public class ErrorGettingResponseThroughHttpRequest extends RuntimeException{
    public ErrorGettingResponseThroughHttpRequest(String message) {
        super(message);
    }
}
