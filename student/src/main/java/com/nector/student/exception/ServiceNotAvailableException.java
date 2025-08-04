package com.nector.student.exception;

public class ServiceNotAvailableException extends RuntimeException{
    public ServiceNotAvailableException(String msg) {
        super(msg);
    }
}
