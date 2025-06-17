package com.tecnimbus.petstore_api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController extends BaseController{

    static int RETRYING_COUNT = 1;
    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        RETRYING_COUNT = RETRYING_COUNT + 1;
        if (RETRYING_COUNT < 8 ){
            return ResponseEntity
                    .status(HttpStatus.SERVICE_UNAVAILABLE)
                    .body("Service Unavailable - Maintenance Mode"); // Just for test simulation
        } else {
            return ResponseEntity.ok("{\"status\":\"UP\"}");
        }
    }
}
