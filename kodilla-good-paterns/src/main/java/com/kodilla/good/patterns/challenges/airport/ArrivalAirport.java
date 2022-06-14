package com.kodilla.good.patterns.challenges.airport;

import java.time.LocalDateTime;
import java.util.Objects;

public final class ArrivalAirport implements Airport {
    private final String airportName;
    private final String cityName;
    private final int airportId;
    private final boolean proceedingFlights;
    private final LocalDateTime timeOfDeparture;

    public ArrivalAirport(final String airportName, final String cityName, final int airportId, final boolean proceedingFlights, final int year, final int month, final int day, final int hour, final int minute) {
        this.airportName = airportName;
        this.cityName = cityName;
        this.airportId = airportId;
        this.proceedingFlights = proceedingFlights;
        this.timeOfDeparture = LocalDateTime.of(year, month, day, hour, minute);
    }

    public String getAirportName() {
        return airportName;
    }

    public String getCityName() {
        return cityName;
    }

    public int getAirportId() {
        return airportId;
    }

    public boolean isProceedingFlights() {
        return proceedingFlights;
    }

    public LocalDateTime getTimeOfDeparture() {
        return timeOfDeparture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null ||!(o instanceof ArrivalAirport)) return false;
        ArrivalAirport that = (ArrivalAirport) o;
        return getAirportId() == that.getAirportId() && isProceedingFlights() == that.isProceedingFlights() && getAirportName().equals(that.getAirportName()) && getCityName().equals(that.getCityName()) && getTimeOfDeparture().equals(that.getTimeOfDeparture());
    }

    @Override
    public int hashCode() {
        return airportId;
    }
}
