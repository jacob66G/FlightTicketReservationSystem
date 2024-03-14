import java.io.Serializable;

public class FirstClassTicket extends Ticket implements Serializable {
    public FirstClassTicket(Flight flight) {
        super(flight);
    }

    @Override
    public double setPrice() {
        return 600 + flight.getRoute().getDistance() * 0.1;
    }

    @Override
    public String toString() {
        return "First Class Ticket Information:\n" +
                "Ticket ID: " + getTicketid() + "\n" +
                "Seat Number: " + getSeatNumber() + "\n" +
                "Price: " + getPrice() + "\n" +
                "Flight: " + getFlight().getFlightCode() + "\n";
    }
}
