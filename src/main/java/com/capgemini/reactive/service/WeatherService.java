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
        return geoWebClient.get()
                .uri(uriBuilder ->
                        uriBuilder
                                .path("/search")
                                .queryParam("name", name)
                                .queryParam("count", 1)
                                .build())
                .retrieve()
                .bodyToMono(CityResult.class);
    }

    public Mono<Forecast> getForecast(CityResult.City city) {
        return weatherWebClient.get()
                .uri(uriBuilder ->
                        uriBuilder
                                .path("/forecast")
                                .queryParam("latitude", city.getLatitude())
                                .queryParam("longitude", city.getLongitude())
                                .queryParam("current_weather", true)
                                .build())
                .retrieve()
                .bodyToMono(Forecast.class);
    }
}
