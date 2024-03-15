package com.example.FlightTicketReservationSystem;

import java.io.Serializable;

public class Plane implements Serializable {
    private String planeCode;
    private int numbersOfSeats;

    public Plane(String planeCode, int numbersOfSeats) {
        this.planeCode = planeCode;
        this.numbersOfSeats = numbersOfSeats;
    }

    public String getPlaneCode() {
        return planeCode;
    }

    public void setPlaneCode(String planeNumber) {
        this.planeCode = planeNumber;
    }

    public int getNumbersOfSeats() {
        return numbersOfSeats;
    }

    public void setNumbersOfSeats(int numbersOfSeats) {
        this.numbersOfSeats = numbersOfSeats;
    }
    @Override
    public String toString() {
        return "com.example.FlightTicketReservationSystem.Plane.com.example.FlightTicketReservationSystem.Plane Information:\n" +
                "com.example.FlightTicketReservationSystem.Plane.com.example.FlightTicketReservationSystem.Plane Code: " + planeCode + "\n" +
                "Number of Seats: " + numbersOfSeats + "\n";
    }

}
