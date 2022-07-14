package com.kodilla.good.paterns.challenges.airport;

import com.kodilla.good.paterns.challenges.airport.AirPlaneConnectionProcessor;
import com.kodilla.good.paterns.challenges.airport.ConnectionDto;
import com.kodilla.good.paterns.challenges.airport.FlightRequest;
import com.kodilla.good.paterns.challenges.airport.FlightRequestRetriever;

public class AirportApplication {

    public static void main(String[] args) {
        FlightRequestRetriever flightRequestRetriever = new FlightRequestRetriever();
        FlightRequest flightRequest = flightRequestRetriever.retrieve();

        AirPlaneConnectionProcessor airPlaneConnectionProcessor = new AirPlaneConnectionProcessor(flightRequest.getAirPlaneConnection());
        ConnectionDto isConnectedOne = airPlaneConnectionProcessor.getFlightConnection("Modlin", "Strachowice");

        if(isConnectedOne.isProceeded()){
            System.out.println("There is a connection!!");
        } else {
            System.out.println("There is no connection");
        }

        ConnectionDto isConnectedTwo = airPlaneConnectionProcessor.getFlightConnection("Modlin", "Ławica");
        if(isConnectedTwo.isProceeded()){
            System.out.println("There is a connection!!");
        } else {
            System.out.println("There is no connection");
        }
    }
}
