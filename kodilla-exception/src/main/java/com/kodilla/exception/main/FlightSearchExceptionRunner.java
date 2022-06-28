package com.kodilla.exception.main;

import com.kodilla.exception.test.Flight;
import com.kodilla.exception.test.FlightSearch;
import com.kodilla.exception.test.RouteNotFoundException;

public class FlightSearchExceptionRunner {

    public static void main(String[] args) {

        Flight flight = new Flight("Warsaw Modlin","Alghero");
        Flight flightOne = new Flight("Warsaw Chopin","Alghero");
        Flight flightTwo = new Flight("Warsaw Modlin","Barcelona El Prat");
        Flight flightThree = new Flight("Alghero","Madrid Barajas");
        Flight flightFour = new Flight("Warsaw Modlin","Mediolan Bergamo");

        FlightSearch flightSearch = new FlightSearch();

        try {
            flightSearch.findFlight(flight);
            flightSearch.findFlight(flightFour);
            flightSearch.findFlight(flightThree);
            flightSearch.findFlight(flightTwo);
        }
        catch(RouteNotFoundException e) {
            System.out.println("This flight couldn't be executed, because of: " + e);
        }
    }
}
