import java.io.Serializable;
import java.util.Random;

public abstract class Ticket implements Serializable {
    protected int ticketid;
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

    public void setPrice(double price){
        this.price = price;
    }
    public Integer getTicketid() {
        return ticketid;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public Flight getFlight() {
        return flight;
    }

    public int SetSeatNuber(Flight flight){
        seatNumber = flight.getPlane().getNumbersOfSeats();
        flight.getPlane().setNumbersOfSeats(seatNumber-1);
        return seatNumber;
    }
    public int setTicketId(Flight flight){
        Random random = new Random();
        int randInt = random.nextInt(99 - 10 + 1) + 10;
        int ticketCode = flight.getFlightCode() - randInt;
        return ticketCode;
    }
    public abstract double setPrice();

    @Override
    public String toString() {
        return "Ticket.Ticket Information:\n" +
                "Ticket.Ticket ID: " + ticketid + "\n" +
                "Seat Number: " + seatNumber + "\n" +
                "Price: " + price + "\n" +
                "Flight: " + flight.getFlightCode() + "\n";
    }

}
