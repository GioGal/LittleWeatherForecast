package com.example.LittleWeatherForecast.service;

import com.example.LittleWeatherForecast.model.Forecast;
import com.example.LittleWeatherForecast.model.Main;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 2022/12/28
 *
 * @author Sirius
 */
@RunWith(MockitoJUnitRunner.class)
public class ForecastServiceTest {

    private ForecastService target;

    @Before
    public void setUp() {
        target = new ForecastService();
    }

    @Test
    public void shouldReturnCityWeatherForecastInfo() {

    }
}
