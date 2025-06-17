package com.tecnimbus.petstore_api;

import com.tecnimbus.petstore_api.config.LoggingInterceptor;
import com.tecnimbus.petstore_api.service.external.PetStoreExternalService;
import com.tecnimbus.petstore_api.service.pet.PetServiceRouter;
import org.h2.tools.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.sql.SQLException;


@SpringBootApplication
public class PetStoreApiApplication {

    public static void main(String[] args) throws SQLException {

        // Starts H2 server to allow external clients like DBeaver
//        Server.createTcpServer(
//                "-tcp",
//                "-tcpAllowOthers",
//                "-tcpPort", "9092",
//                "-ifNotExists"
//        ).start();

        SpringApplication.run(PetStoreApiApplication.class, args);
    }


    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate(
                new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory())
        );
        restTemplate.getInterceptors().add(new LoggingInterceptor());
        return restTemplate;
    }


    @Bean
    public PetServiceRouter petService() {
        return new PetServiceRouter();
    }

    @Bean
    public PetStoreExternalService petStoreExternalService() {
        return new PetStoreExternalService();
    }
}
