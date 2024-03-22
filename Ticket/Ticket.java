package Ticket;

import java.io.Serializable;
import java.util.Random;
import Flight.Flight;

public abstract class Ticket implements Serializable {
    protected String ticketid;
    protected int seatNumber;
    protected double price;
    protected Flight flight;
    public Ticket(Flight flight) {
        this.flight = flight;
        this.seatNumber = SetSeatNuber(flight);
        this.price = setPrice();
        this.ticketid = setTicketId(flight);
    }
    public double getPrice(){
        return price;
    }

    protected int setPrice(){
        double basicPrice = flight.getRoute().getDistance() * 0.15;
        return (int) basicPrice;
    }
    public String getTicketid() {
        return ticketid;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public Flight getFlight() {
        return flight;
    }

    public int SetSeatNuber(Flight flight){
        int seatNumber = flight.getPlane().getNumbersOfSeats();
        flight.getPlane().setNumbersOfSeats(seatNumber-1);
        return seatNumber;
    }
    public String setTicketId(Flight flight){
        Random random = new Random();
        int randInt = random.nextInt(99 - 10 + 1) + 10;
        String ticketCode = Integer.toString(randInt);

        return ticketCode;
    }

    @Override
    public String toString() {
        return "TICKET ID: " + ticketid + "\n" +
                flight.getRoute().getDepartureAirport().getLocation().getCountryName() + " " + flight.getRoute().getDepartureAirport().getLocation().getCityName() + " -> " +
                flight.getRoute().getArrivalAirport().getLocation().getCountryName() + " " + flight.getRoute().getArrivalAirport().getLocation().getCityName() + "\n" +
                flight.getDepartureDateTime().toLocalDate() + "  " + flight.getDepartureDateTime().toLocalTime() +  "  -  " +
                flight.getArrivalDateTime().toLocalDate() + "  " + flight.getArrivalDateTime().toLocalTime() + "\n" +
                "SEAT NUMBER: " + seatNumber + "\n" +
                "FLIGHT CODE : " + flight.getFlightCode() + "\n" +
                "PRICE: " + price + "\n" +
                "GATE: " + flight.getGateNumebr();
    }

}
