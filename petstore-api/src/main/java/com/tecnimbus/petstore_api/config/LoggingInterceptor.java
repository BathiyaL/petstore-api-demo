package com.tecnimbus.petstore_api.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.HttpRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class LoggingInterceptor implements ClientHttpRequestInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(LoggingInterceptor.class);

    @Override
    public ClientHttpResponse intercept(
            HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {

        logRequestDetails(request, body);

        ClientHttpResponse response = execution.execute(request, body);

        logResponseDetails(response);

        return response;
    }

    private void logRequestDetails(HttpRequest request, byte[] body) {
        logger.info("=== [RestTemplate] Request ===");
        logger.info("URI     : {}", request.getURI());
        logger.info("Method  : {}", request.getMethod());
        logger.info("Headers : {}", request.getHeaders());
        logger.info("Body    : {}", new String(body, StandardCharsets.UTF_8));
    }

    private void logResponseDetails(ClientHttpResponse response) throws IOException {
        StringBuilder inputStringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(response.getBody(), StandardCharsets.UTF_8))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                inputStringBuilder.append(line);
            }
        }

        logger.info("=== [RestTemplate] Response ===");
        logger.info("Status code  : {}", response.getStatusCode());
        logger.info("Status text  : {}", response.getStatusText());
        logger.info("Headers      : {}", response.getHeaders());
        logger.info("Body         : {}", inputStringBuilder.toString());
    }
}
