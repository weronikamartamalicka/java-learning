package com.kodilla.good.paterns.exception.test;


public class Flight {

    private String departureAirport;
    private String arrivalAirport;

    public Flight(String departureAirport, String arrivalAirport) {
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Flight)) return false;
        Flight flight = (Flight) o;
        return getDepartureAirport().equals(flight.getDepartureAirport()) && getArrivalAirport().equals(flight.getArrivalAirport());
    }

    @Override
    public int hashCode() {
        int result = departureAirport.hashCode();
        result = result * 31 + arrivalAirport.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "departureAirport='" + departureAirport + '\'' +
                ", arrivalAirport='" + arrivalAirport + '\'' +
                '}';
    }
}
