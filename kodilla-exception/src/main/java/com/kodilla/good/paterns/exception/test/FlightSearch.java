package com.kodilla.good.paterns.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightSearch {

    public void findFlight(Flight flight) throws RouteNotFoundException {
        Map<String,Boolean> flightMap = new HashMap<>();
        flightMap.put("Alghero",true);
        flightMap.put("Barcelona El Prat", false);
        if(flightMap.containsKey(flight.getArrivalAirport()) && flightMap.get(flight.getArrivalAirport()).equals(true)) {
            System.out.println("Flight:<< " + flight + " >> Could be realized");
        } else {
            throw new RouteNotFoundException("Provided route is not in database or The destination airport is not currently processing arrivals");
        }
    }
}
