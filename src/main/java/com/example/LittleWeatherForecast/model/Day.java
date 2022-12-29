package com.example.LittleWeatherForecast.model;

import lombok.Data;

import java.time.Instant;

/**
 * 2022/12/29
 *
 * @author Sirius
 */
@Data
public class Day {
    private Instant dt;
    private Main main;
}
