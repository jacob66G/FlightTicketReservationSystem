package com.example.FlightTicketReservationSystem;

public class EconomyTicket extends Ticket {
    private double price;
    public EconomyTicket(Flight flight) {
        super(flight);
    }

    @Override
    public double setPrice() {
        price = 100 + flight.getRoute().getDistance() * 0.1;
        return price;
    }
    @Override
    public String toString() {
        return "Economy com.example.FlightTicketReservationSystem.Ticket Information:\n" +
                "com.example.FlightTicketReservationSystem.Ticket ID: " + getTicketid() + "\n" +
                "Seat Number: " + getSeatNumber() + "\n" +
                "Price: " + getPrice() + "\n" +
                "com.example.FlightTicketReservationSystem.Flight: " + getFlight().getFlightCode() + "\n";
    }

}
