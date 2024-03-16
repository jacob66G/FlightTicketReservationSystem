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
        return "Business Class Ticket Information:\n" +
                "Ticket ID: " + getTicketid() + "\n" +
                "Seat Number: " + getSeatNumber() + "\n" +
                "Price: " + getPrice() + "\n" +
                "Flight: " + getFlight().getFlightCode() + "\n";
    }
}
