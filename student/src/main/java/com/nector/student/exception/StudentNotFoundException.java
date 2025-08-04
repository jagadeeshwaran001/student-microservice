package com.nector.student.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class StudentNotFoundException extends RuntimeException {
    private final HttpStatus httpStatus;

    public StudentNotFoundException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

}
