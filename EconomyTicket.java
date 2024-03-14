import java.io.Serializable;

public class EconomyTicket extends Ticket implements Serializable {
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
        return "Economy Ticket Information:\n" +
                "Ticket ID: " + getTicketid() + "\n" +
                "Seat Number: " + getSeatNumber() + "\n" +
                "Price: " + getPrice() + "\n" +
                "Flight: " + getFlight().getFlightCode() + "\n";
    }

}
