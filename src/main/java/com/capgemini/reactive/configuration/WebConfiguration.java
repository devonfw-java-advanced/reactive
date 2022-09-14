package com.capgemini.reactive.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

@Configuration
public class WebConfiguration {

    @Bean
    public WebClient weatherWebClient() {
        return WebClient.builder()
                .baseUrl("https://api.open-meteo.com/v1/")
                .build();
    }

    @Bean
    public WebClient geoWebClient() {
        return WebClient.builder()
                .baseUrl("https://geocoding-api.open-meteo.com/v1/")
                .build();
    }

    @Bean
    public WebClient localClient() {
        return WebClient.builder()
                .baseUrl("http://localhost:8080/")
                .build();
    }
}
