package Ticket;

import Flight.Flight;
public class BusinessTicket extends Ticket {

    private final double price = 500;
    public BusinessTicket(Flight flight) {
        super(flight);
    }
    public int setPrice(){
        double basicPrice = flight.getRoute().getDistance() * 0.15;
        return (int) (basicPrice + price);
    }
}
