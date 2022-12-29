package com.example.LittleWeatherForecast.rest;

import com.example.LittleWeatherForecast.LittleWeatherForecastApplication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 2022/12/29
 *
 * @author Sirius
 */
@ContextConfiguration(classes = LittleWeatherForecastApplication.class)
@SpringBootTest
public class ForecastResourceTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    String jsonData = "{\n" +
        "  \"city\": {\n" +
        "    \"name\": \"London\",\n" +
        "    \"lat\": 51.5073219,\n" +
        "    \"lon\": -0.1276474\n" +
        "  },\n" +
        "  \"list\": [\n" +
        "    {\n" +
        "      \"dt\": \"2022-12-29T18:00:00Z\",\n" +
        "      \"main\": {\n" +
        "        \"temp_max\": 8.4,\n" +
        "        \"temp_min\": 7.35,\n" +
        "        \"humidity\": 71,\n" +
        "        \"feels_like\": 5.18\n" +
        "      }\n" +
        "    },\n" +
        "    {\n" +
        "      \"dt\": \"2022-12-29T21:00:00Z\",\n" +
        "      \"main\": {\n" +
        "        \"temp_max\": 7.33,\n" +
        "        \"temp_min\": 6.54,\n" +
        "        \"humidity\": 75,\n" +
        "        \"feels_like\": 4.32\n" +
        "      }\n" +
        "    },\n" +
        "    {\n" +
        "      \"dt\": \"2022-12-30T00:00:00Z\",\n" +
        "      \"main\": {\n" +
        "        \"temp_max\": 6.51,\n" +
        "        \"temp_min\": 6.51,\n" +
        "        \"humidity\": 79,\n" +
        "        \"feels_like\": 3.65\n" +
        "      }\n" +
        "    },\n" +
        "    {\n" +
        "      \"dt\": \"2022-12-30T03:00:00Z\",\n" +
        "      \"main\": {\n" +
        "        \"temp_max\": 7.62,\n" +
        "        \"temp_min\": 7.62,\n" +
        "        \"humidity\": 85,\n" +
        "        \"feels_like\": 4.16\n" +
        "      }\n" +
        "    },\n" +
        "    {\n" +
        "      \"dt\": \"2022-12-30T06:00:00Z\",\n" +
        "      \"main\": {\n" +
        "        \"temp_max\": 7.87,\n" +
        "        \"temp_min\": 7.87,\n" +
        "        \"humidity\": 81,\n" +
        "        \"feels_like\": 4.16\n" +
        "      }\n" +
        "    },\n" +
        "    {\n" +
        "      \"dt\": \"2022-12-30T09:00:00Z\",\n" +
        "      \"main\": {\n" +
        "        \"temp_max\": 8.51,\n" +
        "        \"temp_min\": 8.51,\n" +
        "        \"humidity\": 85,\n" +
        "        \"feels_like\": 4.71\n" +
        "      }\n" +
        "    },\n" +
        "    {\n" +
        "      \"dt\": \"2022-12-30T12:00:00Z\",\n" +
        "      \"main\": {\n" +
        "        \"temp_max\": 10.45,\n" +
        "        \"temp_min\": 10.45,\n" +
        "        \"humidity\": 93,\n" +
        "        \"feels_like\": 9.98\n" +
        "      }\n" +
        "    },\n" +
        "    {\n" +
        "      \"dt\": \"2022-12-30T15:00:00Z\",\n" +
        "      \"main\": {\n" +
        "        \"temp_max\": 12.59,\n" +
        "        \"temp_min\": 12.59,\n" +
        "        \"humidity\": 76,\n" +
        "        \"feels_like\": 11.89\n" +
        "      }\n" +
        "    },\n" +
        "    {\n" +
        "      \"dt\": \"2022-12-30T18:00:00Z\",\n" +
        "      \"main\": {\n" +
        "        \"temp_max\": 11.79,\n" +
        "        \"temp_min\": 11.79,\n" +
        "        \"humidity\": 74,\n" +
        "        \"feels_like\": 10.96\n" +
        "      }\n" +
        "    },\n" +
        "    {\n" +
        "      \"dt\": \"2022-12-30T21:00:00Z\",\n" +
        "      \"main\": {\n" +
        "        \"temp_max\": 10.43,\n" +
        "        \"temp_min\": 10.43,\n" +
        "        \"humidity\": 82,\n" +
        "        \"feels_like\": 9.67\n" +
        "      }\n" +
        "    },\n" +
        "    {\n" +
        "      \"dt\": \"2022-12-31T00:00:00Z\",\n" +
        "      \"main\": {\n" +
        "        \"temp_max\": 10.31,\n" +
        "        \"temp_min\": 10.31,\n" +
        "        \"humidity\": 86,\n" +
        "        \"feels_like\": 9.64\n" +
        "      }\n" +
        "    },\n" +
        "    {\n" +
        "      \"dt\": \"2022-12-31T03:00:00Z\",\n" +
        "      \"main\": {\n" +
        "        \"temp_max\": 11.68,\n" +
        "        \"temp_min\": 11.68,\n" +
        "        \"humidity\": 93,\n" +
        "        \"feels_like\": 11.33\n" +
        "      }\n" +
        "    },\n" +
        "    {\n" +
        "      \"dt\": \"2022-12-31T06:00:00Z\",\n" +
        "      \"main\": {\n" +
        "        \"temp_max\": 12.98,\n" +
        "        \"temp_min\": 12.98,\n" +
        "        \"humidity\": 90,\n" +
        "        \"feels_like\": 12.68\n" +
        "      }\n" +
        "    },\n" +
        "    {\n" +
        "      \"dt\": \"2022-12-31T09:00:00Z\",\n" +
        "      \"main\": {\n" +
        "        \"temp_max\": 13.33,\n" +
        "        \"temp_min\": 13.33,\n" +
        "        \"humidity\": 83,\n" +
        "        \"feels_like\": 12.89\n" +
        "      }\n" +
        "    },\n" +
        "    {\n" +
        "      \"dt\": \"2022-12-31T12:00:00Z\",\n" +
        "      \"main\": {\n" +
        "        \"temp_max\": 12.78,\n" +
        "        \"temp_min\": 12.78,\n" +
        "        \"humidity\": 91,\n" +
        "        \"feels_like\": 12.49\n" +
        "      }\n" +
        "    },\n" +
        "    {\n" +
        "      \"dt\": \"2022-12-31T15:00:00Z\",\n" +
        "      \"main\": {\n" +
        "        \"temp_max\": 12.53,\n" +
        "        \"temp_min\": 12.53,\n" +
        "        \"humidity\": 87,\n" +
        "        \"feels_like\": 12.11\n" +
        "      }\n" +
        "    }\n" +
        "  ]\n" +
        "}";

    @Test
    public void shouldReturnWeatherForecastForAcity() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/forecast?cityName=London")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
            //.andExpect(content().json(jsonData));

    }
}
