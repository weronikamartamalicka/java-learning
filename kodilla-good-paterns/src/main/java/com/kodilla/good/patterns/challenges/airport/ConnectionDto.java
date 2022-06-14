package com.kodilla.good.patterns.challenges.airport;

public final class ConnectionDto {
    private final AirPlaneConnection airPlaneConnection;
    private final boolean isProceeded;

    public ConnectionDto(AirPlaneConnection airPlaneConnection, boolean isProceeded) {
        this.airPlaneConnection = airPlaneConnection;
        this.isProceeded = isProceeded;
    }

    public AirPlaneConnection getAirPlaneConnection() {
        return airPlaneConnection;
    }

    public boolean isProceeded() {
        return isProceeded;
    }
}
