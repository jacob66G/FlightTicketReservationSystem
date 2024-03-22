package Ticket;

import Flight.Flight;

public class FirstClassTicket extends Ticket {

    private final double price = 1000;
    public FirstClassTicket(Flight flight) {
        super(flight);
    }

    public int setPrice(){
        double basicPrice = flight.getRoute().getDistance() * 0.15;
        return (int) (basicPrice + price);
    }
}
