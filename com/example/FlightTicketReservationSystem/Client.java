package com.example.FlightTicketReservationSystem;

import java.io.Serializable;
import java.util.List;

abstract class Client implements Serializable {
    protected int phoneNumber;
    protected String email;
    protected List<Ticket> tickets;

    public Client(Integer phoneNumber, String email) {
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
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("com.example.FlightTicketReservationSystem.Client Information:\n");
        sb.append("Phone Number: ").append(phoneNumber).append("\n");
        sb.append("Email: ").append(email).append("\n");
        sb.append("Tickets:\n");
        for (Ticket ticket : tickets) {
            sb.append("  - ").append(ticket).append("\n");
        }
        return sb.toString();
    }

}
