package com.nector.student.exceptionHandler;

import com.nector.student.dto.ResponseDTO;
import com.nector.student.exception.EntityNecessaryFieldsNullException;
import com.nector.student.exception.ErrorGettingResponseThroughHttpRequest;
import com.nector.student.exception.ServiceNotAvailableException;
import com.nector.student.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class StudentExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    @ResponseBody
    public ResponseEntity<ResponseDTO<Void>> handleValueShouldNotBeNull(StudentNotFoundException studentNotFoundException) {
        return ResponseEntity.status(studentNotFoundException.getHttpStatus()).body(new ResponseDTO<>(studentNotFoundException.getMessage()));
    }

    @ExceptionHandler(EntityNecessaryFieldsNullException.class)
    @ResponseBody
    public ResponseEntity<ResponseDTO<Void>> handleValueShouldNotBeNull(EntityNecessaryFieldsNullException entityNecessaryFieldsNullException) {
        return ResponseEntity.status(entityNecessaryFieldsNullException.getHttpStatus()).body(new ResponseDTO<>(entityNecessaryFieldsNullException.getMessage(), entityNecessaryFieldsNullException.getShortMessage()));
    }

    @ExceptionHandler(ErrorGettingResponseThroughHttpRequest.class)
    @ResponseBody
    public ResponseEntity<ResponseDTO<Void>> handleErrorGettingResponseThroughHttpRequest(ErrorGettingResponseThroughHttpRequest errorGettingResponseThroughHttpRequest) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(new ResponseDTO<>(errorGettingResponseThroughHttpRequest.getMessage()));
    }

    @ExceptionHandler(ServiceNotAvailableException.class)
    @ResponseBody
    public ResponseEntity<ResponseDTO<Void>> handleerviceNotAvailableException(ServiceNotAvailableException serviceNotAvailableException) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(new ResponseDTO<>(serviceNotAvailableException.getMessage()));
    }
}
