package com.nector.course.exceptionHandler;

import com.nector.course.dto.ResponseDTO;
import com.nector.course.exception.CourseNotFoundException;
import com.nector.course.exception.EntityNecessaryFieldsNullException;
import com.nector.course.exception.MarkNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class CourseExceptionHandler {

    @ExceptionHandler(CourseNotFoundException.class)
    @ResponseBody
    public ResponseEntity<ResponseDTO<Void>> handleValueShouldNotBeNull(CourseNotFoundException courseNotFoundException) {
        return ResponseEntity.status(courseNotFoundException.getHttpStatus()).body(new ResponseDTO<Void>(courseNotFoundException.getMessage()));
    }

    @ExceptionHandler(EntityNecessaryFieldsNullException.class)
    @ResponseBody
    public ResponseEntity<ResponseDTO<Void>> handleValueShouldNotBeNull(EntityNecessaryFieldsNullException entityNecessaryFieldsNullException) {
        return ResponseEntity.status(entityNecessaryFieldsNullException.getHttpStatus()).body(new ResponseDTO<Void>(entityNecessaryFieldsNullException.getMessage(), entityNecessaryFieldsNullException.getShortMessage()));
    }

    @ExceptionHandler(MarkNotFoundException.class)
    @ResponseBody
    public ResponseEntity<ResponseDTO<Void>> handleValueShouldNotBeNull(MarkNotFoundException markNotFoundException) {
        return ResponseEntity.status(markNotFoundException.getHttpStatus()).body(new ResponseDTO<Void>(markNotFoundException.getMessage()));
    }
}
