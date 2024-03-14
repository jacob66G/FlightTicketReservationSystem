import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Service implements Serializable {
    private List<Client> clients;
    private List<Flight> flights;
    private List<Airport> airports;

    public Service(List<Client> clients, List<Flight> flights, List<Airport> airports) {
        this.clients = clients;
        this.flights = flights;
        this.airports = airports;
    }

    public Service(){
        flights = new ArrayList<>();
        clients = new ArrayList<>();
        airports = new ArrayList<>();
    }

    public void addClient(Client client){
        clients.add(client);
    }
    public void removeClient(Client client){clients.remove(client);}
    public List<Client> getClients() {
        return clients;
    }
    public void addFlight(Flight flight){
        flights.add(flight);
    }
    public void removeFlight(Flight flight){
        flights.remove(flight);
    }
    public List<Flight> getFlights() {
        return flights;
    }
    public void addAirport(Airport airport){airports.add(airport);}
    public void removeAirport(Airport airport){airports.remove(airport);}
    public List<Airport> getAirports(){ return airports; }

    public void showSupportedAirports(){
        for(Airport airport : airports){
            System.out.println("AIRPORT CODE: "+ airport.getCode() +  "  CITY: " + airport.getCityName());
        }
    }
}
