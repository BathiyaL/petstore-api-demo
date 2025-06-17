package com.tecnimbus.petstore_api.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    @Value("${external.pet-store.url}")
    private String remotePetStore;
}
