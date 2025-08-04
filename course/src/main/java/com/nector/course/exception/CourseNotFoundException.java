package com.nector.course.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CourseNotFoundException extends RuntimeException {
    private final HttpStatus httpStatus;

    public CourseNotFoundException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

}
