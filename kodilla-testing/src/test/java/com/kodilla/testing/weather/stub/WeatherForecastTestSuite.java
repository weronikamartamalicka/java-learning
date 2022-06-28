package com.kodilla.testing.weather.stub;

import com.kodilla.testing.stub.Temperatures;
import com.kodilla.testing.stub.TemperaturesStub;
import com.kodilla.testing.stub.WeatherForecast;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;//

public class WeatherForecastTestSuite {

    @Test
    public void testCalculateWeatherForecastWithStub() {
        Temperatures temperatures = new TemperaturesStub();
        WeatherForecast weatherForecast = new WeatherForecast(temperatures);

        int quantityOfSensors = weatherForecast.calculateForecast().size();

        Assertions.assertEquals(5,quantityOfSensors);
    }
}
