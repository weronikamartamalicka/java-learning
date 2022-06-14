package com.kodilla.good.patterns.challenges.airport;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class FlightRequestRetriever {
    public FlightRequest retrieve() {
        ArrivalAirport arrivalAirport1 = new ArrivalAirport("Modlin", "Warszawa", 43738, true, 2022, 06, 16, 10, 00);
        ArrivalAirport arrivalAirport2 = new ArrivalAirport("Lech Wałęsa", "Gdańsk", 13738, true, 2022, 06, 16, 18, 00);
        ArrivalAirport arrivalAirport3 = new ArrivalAirport("Strachowice", "Wrocław", 43638, true, 2022, 06, 16, 16, 00);
        ArrivalAirport arrivalAirport4 = new ArrivalAirport("Ławica", "Poznań", 33738, true, 2022, 06, 16, 18, 00);
        ArrivalAirport arrivalAirport5 = new ArrivalAirport("Władysława Reymonta", "Łódź", 437328, true, 2022, 06, 16, 19, 00);

        DepartureAirport departureAirport1 = new DepartureAirport("Modlin", "Warszawa", 43738, true, 2022, 06, 16, 12, 30);
        DepartureAirport departureAirport2 = new DepartureAirport("Lech Wałęsa", "Gdańsk", 13738, true, 2022, 06, 16, 8, 00);
        DepartureAirport departureAirport3 = new DepartureAirport("Strachowice", "Wrocław", 43638, true, 2022, 06, 16, 11, 00);
        DepartureAirport departureAirport4 = new DepartureAirport("Ławica", "Poznań", 33738, true, 2022, 06, 16, 15, 00);
        DepartureAirport departureAirport5 = new DepartureAirport("Władysława Reymonta", "Łódź", 437328, true, 2022, 06, 16, 17, 00);

        Map<DepartureAirport, ArrivalAirport> flightConnections = new HashMap<>();
        flightConnections.put(departureAirport2, arrivalAirport1);
        flightConnections.put(departureAirport1, arrivalAirport3);
        flightConnections.put(departureAirport3, arrivalAirport4);
        flightConnections.put(departureAirport4, arrivalAirport5);
        flightConnections.put(departureAirport5, arrivalAirport1);

        AirPlaneConnection airPlaneConnection = new AirPlaneConnection(flightConnections);

        LocalDate time = LocalDate.of(2022, 06, 14);

        return new FlightRequest(airPlaneConnection, time);
    }
}
