package com.example.FlightTicketReservationSystem;

public class BusinessTicket extends Ticket {
    public BusinessTicket(Flight flight) {
        super(flight);
    }

    @Override
    public double setPrice() {
        return 300 + flight.getRoute().getDistance() * 0.1;
    }

    @Override
    public String toString() {
        return "Business Class com.example.FlightTicketReservationSystem.Ticket Information:\n" +
                "com.example.FlightTicketReservationSystem.Ticket ID: " + getTicketid() + "\n" +
                "Seat Number: " + getSeatNumber() + "\n" +
                "Price: " + getPrice() + "\n" +
                "com.example.FlightTicketReservationSystem.Flight: " + getFlight().getFlightCode() + "\n";
    }
}
