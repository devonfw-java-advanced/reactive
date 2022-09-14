package com.capgemini.reactive.controller;

import com.capgemini.reactive.service.WeatherService;
import com.capgemini.reactive.to.Forecast;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
public class WeatherController {

    final WeatherService weatherService;

    // TODO: Please implement endpoint to get weather for city with provided name. To do so please use service from https://www.open-meteo.com.com/.
    //  Geocoding API: https://open-meteo.com/en/docs/geocoding-api
    //  Weather Forecast API: https://open-meteo.com/en/docs
    //  To do so you need to invoke two api endpoints. First to search for cities for provided name, and then for every found City get weather details.
    //  Please implement service methods appropriately.
    //  Example:
    //  https://geocoding-api.open-meteo.com/v1/search?name=Berlin&count=1
    //  https://api.open-meteo.com/v1/forecast?latitude=52.52&longitude=13.41&current_weather=true
    @GetMapping( "/weather")
    public Flux<Forecast> weather(@RequestParam String city) {
        return null;
    }
}
