package com.capgemini.reactive.to;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CityDetails {

    @JsonProperty("title")
    private String title;
    @JsonProperty("location_type")
    private String locationType;
    @JsonProperty("timezone_name")
    private String timezoneName;
    @JsonProperty("consolidated_weather")
    private List<ConsolidatedWeather> consolidatedWeather;

    static class ConsolidatedWeather {
        @JsonProperty("weather_state_name")
        private String weatherStateName;
        @JsonProperty("air_pressure")
        private String airPressure;
        @JsonProperty("humidity")
        private String humidity;
        @JsonProperty("the_temp")
        private String temp;
    }
}
