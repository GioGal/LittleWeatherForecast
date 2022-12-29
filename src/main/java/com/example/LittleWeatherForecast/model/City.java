package com.example.LittleWeatherForecast.model;

import lombok.Data;

/**
 * 2022/12/29
 *
 * @author Sirius
 */
@Data
public class City {
    private String name;
    private Double lat;
    private Double lon;
}
