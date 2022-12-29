package com.example.LittleWeatherForecast.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 2022/12/28
 *
 * @author Sirius
 */
@Data
public class Forecast {
    private City city;
    private List<Day> list = new ArrayList<>();
}
