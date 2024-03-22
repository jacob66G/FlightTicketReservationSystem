package Service;

import Airport.Airport;
import Client.*;
import Flight.Flight;
import Serializer.Serializer;
import Ticket.Ticket;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Service implements Serializable {
    private List<Client> clients;
    private List<Flight> flights;
    private List<Airport> airports;

    public Service(){
        flights = new ArrayList<>();
        clients = new ArrayList<>();
        airports = new ArrayList<>();
    }

    //----------------------------------------------------------------------------------------------------AIRPORT METHODS
    public void addAirport(Airport airport){airports.add(airport);}
    public void removeAirport(Airport airport){airports.remove(airport);}
    public List<Airport> getAirports(){ return airports; }

    public void showAirports(){
        if (airports.isEmpty()) {
            System.out.println("ANY AIRPORT IS AVAILABLE");
        }else {
            for (Airport airport : airports)
                System.out.println(airport.displayBasicInf());
        }
    }
    public Airport getAirportByCode(String code){
        for (Airport airport : airports){
            if(airport.getCode().equals(code)) return airport;
        }
        return null;
    }



    //----------------------------------------------------------------------------------------------------CLIENT METHODS
    public void addClient(Client client){
        clients.add(client);
    }
    public void removeClient(Client client){clients.remove(client);}
    public List<Client> getClients() {
        return clients;
    }
    public Client getClinetByPhoneNumber(String phoneNumber) {

        for (Client client : clients) {
            if (client.getPhoneNumber().equals(phoneNumber)) {
                return client;
            }
        }
        return null;
    }
    public Client getClinetByEmail(String email){

        for (Client client : clients){
            if(client.getEmail().equals(email)) return client;
        }
        return null;
    }
    public Client getClinetByPesel(String pesel){

        for (Client client : clients){
            if(client instanceof Person person){
                if(person.getPESEL().equals(pesel)) return client;
            }
        }
        return null;
    }

    public void showTickets(Client client){
        if(client.getTickets().isEmpty()){
            System.out.println("YOU HAVEN'T BOUGHT ANY TICKETS YET");
        }
        else {
            for(Ticket ticket : client.getTickets()) System.out.println(ticket);
        }

    }
    public Client loggingClinet(String emial, String pesel){
        for (Client client : clients){
            if(client instanceof Person person){
                if(person.getPESEL().equals(pesel) && person.getEmail().equals(emial)){
                    return person;
                }
            }
        }
        return null;
    }


    //----------------------------------------------------------------------------------------------------FLIGHT METHODS
    public void addFlight(Flight flight){
        flights.add(flight);
    }
    public void removeFlight(Flight flight){
        flights.remove(flight);
    }
    public List<Flight> getFlights() {
        return flights;
    }

    public Flight getFlightByDate(LocalDate date){

        for(Flight flight : flights){
            if (flight.getDepartureDateTime().toLocalDate().equals(date)) return flight;
        }
        return null;
    }

    public Flight getFlightByCode(String flightCode){

        for(Flight flight : flights){
            if (flight.getFlightCode().equals(flightCode)) return flight;
        }
        return null;
    }

    public Flight getFlightByAirportsCode(String departureAirportCode, String arrivalAirportCode){

        for(Flight flight : flights){
            if (flight.getRoute().getDepartureAirport().getCode().equals(departureAirportCode) &&
                flight.getRoute().getArrivalAirport().getCode().equals(arrivalAirportCode)) return flight;
        }
        return null;
    }

    public void showFlights(){
        for (Flight flight : flights){
            System.out.println(flight.displayBasicInf());
        }
    }



}
