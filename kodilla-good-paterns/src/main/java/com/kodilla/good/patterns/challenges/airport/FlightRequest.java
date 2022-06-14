package com.kodilla.good.patterns.challenges.airport;

import java.time.LocalDate;
import java.time.LocalDateTime;

public final class FlightRequest {
    private final AirPlaneConnection airPlaneConnection;
    private final LocalDate time;

    public FlightRequest(final AirPlaneConnection airPlaneConnection, final LocalDate time) {
        this.airPlaneConnection = airPlaneConnection;
        this.time = time;
    }

    public AirPlaneConnection getAirPlaneConnection() {
        return airPlaneConnection;
    }

    public LocalDate getTime() {
        return time;
    }
}
