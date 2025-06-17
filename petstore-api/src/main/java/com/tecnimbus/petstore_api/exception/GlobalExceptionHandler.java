package com.tecnimbus.petstore_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFound(ResourceNotFoundException ex) {
        List<String> details = new ArrayList<>();
        details.add(ex.getMessage());

        RestApiError err = new RestApiError(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND,
                ex.getMessage(),
                details);
        return ResponseEntityBuilder.build(err);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleIllegalArgument(
            IllegalArgumentException ex) {

        List<String> details = new ArrayList<>();
        details.add(ex.getMessage());

        RestApiError err = new RestApiError(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST,
                ex.getMessage(),
                details);

        return ResponseEntityBuilder.build(err);
    }
}
