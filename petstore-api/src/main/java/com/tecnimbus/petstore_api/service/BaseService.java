package com.tecnimbus.petstore_api.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;

public class BaseService {

    @Value("${app.data-mode}")
    protected String dataMode;

    protected HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        return headers;
    }

}
