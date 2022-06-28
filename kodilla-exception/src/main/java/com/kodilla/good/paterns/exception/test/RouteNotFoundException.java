package com.kodilla.good.paterns.exception.test;

public class RouteNotFoundException extends Exception{

    public RouteNotFoundException(final String message) {
        super(message);
    }
}
