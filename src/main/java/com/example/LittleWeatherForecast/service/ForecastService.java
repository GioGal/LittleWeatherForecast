package com.example.LittleWeatherForecast.service;

import com.example.LittleWeatherForecast.model.City;
import com.example.LittleWeatherForecast.model.Forecast;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * 2022/12/28
 *
 * @author Sirius
 */
@Service
public class ForecastService {

    private RestTemplate restTemplate;

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Allows to get coordinates of a city
     *
     * @param cityName the city to obtain the coordinates
     * @return the Coordinates of the city searched
     */
    public City getCoordinatesByCityName(String cityName) {

        final String uri = "http://api.openweathermap.org/geo/1.0/direct?q=" + cityName
            + "&APPID=5ce9a88d69455fa3c0b1631179935e1c";

        ResponseEntity<City[]> response =
            restTemplate.getForEntity(
                uri,
                City[].class);
        City[] cities = response.getBody();

        System.out.println(cities);
        return cities[0];
    }

    /**
     * Allows to get weather forecast for the next 48 hours for the city specified by param
     *
     * @param city the object that contains the coordinates and info for a city
     * @return the Forecast for the next 48 hours
     */
    public Forecast getForecastByCity(City city) {

        final String uri = "http://api.openweathermap.org/data/2.5/forecast"
             + "?lat=" + city.getLat() + "&lon=" + city.getLon() + "&cnt=16"
            + "&units=metric&lang=IT&APPID=5ce9a88d69455fa3c0b1631179935e1c";

        Forecast result = restTemplate.getForObject(uri, Forecast.class);
        result.setCity(city);

        System.out.println(result);
        return result;
    }


}
