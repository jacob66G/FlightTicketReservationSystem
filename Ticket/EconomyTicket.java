package Ticket;

import Flight.Flight;
public class EconomyTicket extends Ticket {
    private final double price = 150;
    public EconomyTicket(Flight flight) {
        super(flight);
    }

    public int setPrice(){
        double basicPrice = flight.getRoute().getDistance() * 0.15;
        return (int) (basicPrice + price);
    }
}
