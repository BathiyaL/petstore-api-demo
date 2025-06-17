package com.tecnimbus.petstore_api.exception;

import org.springframework.http.ResponseEntity;

public class ResponseEntityBuilder {
    public static ResponseEntity<Object> build(RestApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}
