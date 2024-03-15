package com.example.FlightTicketReservationSystem;

public class LightJet extends Plane {
    private final double averageSpeed = 800; //km/h
    public LightJet(String planeCode, int numbersOfSeats) {
        super(planeCode, numbersOfSeats);
    }

    public double getAverageSpeed(){
        return averageSpeed;
    }
}
