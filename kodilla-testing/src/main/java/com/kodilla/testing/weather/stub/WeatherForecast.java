package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {

    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String,Double> calculateForecast() {
        Map<String,Double> resultMap = new HashMap<>();

        for (Map.Entry<String,Double> temperature : temperatures.getTemperatures().entrySet()) {
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0);
        }
        return resultMap;
    }

    public double getAverageOfTemperatures() {

        double averageTemperature = 0;
        double temporarySum = 0;

        for (Map.Entry<String,Double> measurement : temperatures.getTemperatures().entrySet()) {
            temporarySum = temporarySum + measurement.getValue();
            averageTemperature = temporarySum / temperatures.getTemperatures().size();
        }
        return averageTemperature;
    }

    public double getMedianOfTemperatures() {

        double medianOfTemperatures = 0;
        List<Double> temporaryTemperatures = new ArrayList<>();

        for (Map.Entry<String,Double> measurement : temperatures.getTemperatures().entrySet()) {
            temporaryTemperatures.add(measurement.getValue());
        }

        Collections.sort(temporaryTemperatures);

        int temporaryIndex = 0;

        if (temporaryTemperatures.size() % 2 == 0) {
            temporaryIndex = temporaryTemperatures.size() / 2;
            medianOfTemperatures = (temporaryTemperatures.get(temporaryIndex) + temporaryTemperatures.get(temporaryIndex - 1)) / 2;

        } else {
            temporaryIndex = (int) ((temporaryTemperatures.size() / 2));
            medianOfTemperatures = temporaryTemperatures.get(temporaryIndex);
        }
        return medianOfTemperatures;
    }
}
