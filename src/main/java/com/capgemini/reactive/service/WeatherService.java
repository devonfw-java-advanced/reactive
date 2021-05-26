package com.capgemini.reactive.service;

import com.capgemini.reactive.to.City;
import com.capgemini.reactive.to.CityDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class WeatherService {

    private final WebClient weatherWebClient;

    public Flux<City> searchCities(String name) {
        return weatherWebClient.get()
                .uri(uriBuilder ->
                        uriBuilder
                            .path("/location/search/")
                                .queryParam("query", name)
                                .build())
                .retrieve()
                .bodyToFlux(City.class);
    }

    public Mono<CityDetails> getWeatherDetails(City city) {
        return weatherWebClient.get()
                .uri(uriBuilder ->
                        uriBuilder
                                .path("/location/{woeid}/")
                                .build(city.getWoeid()))
                .retrieve()
                .bodyToMono(CityDetails.class);
    }
}
