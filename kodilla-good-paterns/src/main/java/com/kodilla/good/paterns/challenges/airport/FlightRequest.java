package com.kodilla.good.paterns.challenges.airport;

import java.time.LocalDate;

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
