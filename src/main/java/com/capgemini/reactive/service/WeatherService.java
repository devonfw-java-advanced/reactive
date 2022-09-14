package com.capgemini.reactive.service;

import com.capgemini.reactive.to.CityResult;
import com.capgemini.reactive.to.Forecast;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class WeatherService {

    private final WebClient weatherWebClient;

    private final WebClient geoWebClient;

    public Mono<CityResult> searchCities(String name) {
        return null;
    }

    public Mono<Forecast> getForecast(CityResult.City city) {
        return null;
    }
}
