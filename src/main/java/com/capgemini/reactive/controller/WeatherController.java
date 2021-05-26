package com.capgemini.reactive.controller;

import com.capgemini.reactive.service.WeatherService;
import com.capgemini.reactive.to.CityDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
public class WeatherController {

    final WeatherService weatherService;

    // TODO: Please implement endpoint to get weather for city with provided name. To do so please use service from https://www.metaweather.com/.
    //  To do so you need to invoke two api endpoints. First to search for cities for provided name, and then for every found City get weather details.
    //  Please implement service methods appropriately.
    @GetMapping( "/weather")
    public Flux<CityDetails> weather(@RequestParam String city) {
        return null;
    }
}
