package com.kodilla.good.patterns.challenges.airport;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public final class AirPlaneConnectionProcessor {
    private final AirPlaneConnection airPlaneConnection;

    public AirPlaneConnectionProcessor(AirPlaneConnection airPlaneConnection) {
        this.airPlaneConnection = airPlaneConnection;
    }

    public ConnectionDto getFlightConnection(String nameOfDepartureAirport, String nameOfArrivalAirport) {
        Map<DepartureAirport, ArrivalAirport> filteredConnections = airPlaneConnection.getFlightConnections().entrySet().stream()
                .filter(e -> e.getKey().getAirportName().equals(nameOfDepartureAirport))
                .filter(e -> e.getValue().getAirportName().equals(nameOfArrivalAirport))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        Map<DepartureAirport, ArrivalAirport> filteredDepartureConnections = airPlaneConnection.getFlightConnections().entrySet().stream()
                .filter(e -> e.getKey().getAirportName().equals(nameOfDepartureAirport))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        Map<DepartureAirport, ArrivalAirport> filteredArrivalConnections = airPlaneConnection.getFlightConnections().entrySet().stream()
                .filter(e -> e.getValue().getAirportName().equals(nameOfArrivalAirport))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        Set<String> arrivalAirportNames = filteredArrivalConnections.keySet().stream().map(c -> c.getAirportName()).collect(Collectors.toSet());

        Map<DepartureAirport, ArrivalAirport> filteredConnectingFlights = filteredDepartureConnections.entrySet().stream()
                .filter(e -> arrivalAirportNames.contains(e.getValue().getAirportName()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        if(filteredConnections.size() > 0) {
            return new ConnectionDto(airPlaneConnection, true);
        } else if(filteredConnectingFlights.size() > 0) {
            return new ConnectionDto(airPlaneConnection, true);
        } else {
            return new ConnectionDto(airPlaneConnection, false);
        }
    }
}
