package com.capgemini.reactive.to;

import lombok.Data;

import java.util.List;

@Data
public class CityResult {

    List<City> results;

    @Data
    public static class City {
        private Integer id;
        private String name;
        private Double latitude;
        private Double longitude;
    }
}
