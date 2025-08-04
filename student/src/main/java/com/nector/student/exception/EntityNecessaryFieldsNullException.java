package com.nector.student.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class EntityNecessaryFieldsNullException extends RuntimeException{

    private final String entityName;
    private final String shortMessage;
    private final HttpStatus httpStatus;

    public EntityNecessaryFieldsNullException(String message, String entityName, String shortMessage, HttpStatus httpStatus) {
        super(message);
        this.entityName = entityName;
        this.shortMessage = shortMessage;
        this.httpStatus = httpStatus;
    }
}
