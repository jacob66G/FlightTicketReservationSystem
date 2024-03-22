package Client;

import Ticket.Ticket;

import java.io.Serializable;
import java.util.List;

public abstract class Client implements Serializable {
    protected String phoneNumber;
    protected String email;
    protected List<Ticket> tickets;

    public Client(String phoneNumber, String email) {
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.tickets = tickets;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void addTicket(Ticket ticket){
        tickets.add(ticket);
    }

    public void removeTicket(Ticket ticket){
        tickets.remove(ticket);
        int numberOfseats = ticket.getFlight().getPlane().getNumbersOfSeats();
        ticket.getFlight().getPlane().setNumbersOfSeats(numberOfseats + 1);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Ticket getTicetById(String id){

        for (Ticket ticket : tickets){
            if (ticket.getTicketid().equals(id)) return ticket; break;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Phone Number: ").append(phoneNumber).append("\n");
        sb.append("Email: ").append(email).append("\n");
        sb.append("Tickets:\n");
        for (Ticket ticket : tickets) {
            sb.append("  - ").append(ticket).append("\n");
        }
        return sb.toString();
    }

}
