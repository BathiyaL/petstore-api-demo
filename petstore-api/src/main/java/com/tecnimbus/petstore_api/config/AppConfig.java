package com.tecnimbus.petstore_api.config;

import com.tecnimbus.petstore_api.constants.OperationMode;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app")
public class AppConfig {

    private OperationMode dataMode;

    public OperationMode getDataMode() {
        return dataMode;
    }

    public void setDataMode(OperationMode dataMode) {
        this.dataMode = dataMode;
    }
}