package com.capgemini.reactive.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebConfiguration {

    @Bean
    public WebClient weatherWebClient() {
        return WebClient.builder()
                .baseUrl("https://www.metaweather.com/api/")
                .build();
    }

    @Bean
    public WebClient localClient() {
        return WebClient.builder()
                .baseUrl("http://localhost:8080/")
                .build();
    }
}
