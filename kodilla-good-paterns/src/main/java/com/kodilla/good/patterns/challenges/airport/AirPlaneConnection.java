package com.kodilla.good.patterns.challenges.airport;

import java.util.HashMap;
import java.util.Map;

public final class AirPlaneConnection {

    private final Map<DepartureAirport, ArrivalAirport> flightConnections;

    public AirPlaneConnection(Map<DepartureAirport, ArrivalAirport> flightConnections) {
        this.flightConnections = flightConnections;
    }

    public Map<DepartureAirport, ArrivalAirport> getFlightConnections() {
        return new HashMap<>(flightConnections);
    }
}
