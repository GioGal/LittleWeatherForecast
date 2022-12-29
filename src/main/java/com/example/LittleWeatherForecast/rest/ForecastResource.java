package com.example.LittleWeatherForecast.rest;

/**
 * 2022/12/28
 *
 */

import com.example.LittleWeatherForecast.model.City;
import com.example.LittleWeatherForecast.model.Forecast;
import com.example.LittleWeatherForecast.service.ForecastService;
import org.slf4j.Logger;


import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * REST controller for managing the weather forecast.
 */
@RestController
@RequestMapping("/api")
public class ForecastResource {

    private final ForecastService forecastService;

    private final Logger log = LoggerFactory.getLogger(ForecastResource.class);

    public ForecastResource(ForecastService forecastService) {
        this.forecastService = forecastService;
    }

    /**
     * GET  /account : get the current user.
     *
     * @return the current user
     * @throws RuntimeException 500 (Internal Server Error) if the user couldn't be returned
     */
    @GetMapping("/forecast")
    public Forecast getCityWeatherForecast(String cityName) {
        forecastService.setRestTemplate(new RestTemplate());

        City city = forecastService.getCoordinatesByCityName(cityName);

        return forecastService.getForecastByCity(city);
    }
}
