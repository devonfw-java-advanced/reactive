package com.capgemini.reactive.to;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Forecast {

    private Double latitude;
    private Double longitude;
    @JsonProperty("current_weather")
    private CurrentWeather currentWeather;

    @Data
    public static class CurrentWeather {
        private Double temperature;
    }
}
