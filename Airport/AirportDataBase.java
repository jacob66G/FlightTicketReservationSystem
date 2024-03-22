package Airport;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import Coordinates.Coordinates;

public final class AirportDataBase {
    //private Map<String, List<Location>> airportLocation;
    private List<Location> airportLocation;

    public AirportDataBase(){
        this.airportLocation = new ArrayList<Location>();

        airportLocation.add(new Location("POLAND", "WARSAW", new Coordinates(52.229,21.0117)));
        airportLocation.add(new Location("POLAND", "CRACOW", new Coordinates( 50.061,19.936)));
        airportLocation.add(new Location("POLAND", "GDANSK", new Coordinates(54.352,18.646)));
        airportLocation.add(new Location("POLAND", "POZNAN", new Coordinates(52.406, 16.929)));
        airportLocation.add(new Location("GERMANY", "BERLIN", new Coordinates(52.524, 13.410)));
        airportLocation.add(new Location("GERMANY", "HAMBURG", new Coordinates(53.575, 10.0153)));
        airportLocation.add(new Location("FRANCE", "PARIS", new Coordinates(48.853,  2.3488)));
        airportLocation.add(new Location("FRANCE", "MARSEILLE", new Coordinates(43.296, 5.3810)));
        airportLocation.add(new Location("SPAIN", "MADRID", new Coordinates( 40.416, -3.7038)));
        airportLocation.add(new Location("SPAIN", "BARCELONA", new Coordinates(41.388, 2.1589)));
        airportLocation.add(new Location("ENGLAND", "LONDON", new Coordinates(51.508,  -0.1257)));
        airportLocation.add(new Location("ENGLAND", "MANCHESTER", new Coordinates(53.480, -2.237)));
        airportLocation.add(new Location("GREECE", "ATHENS", new Coordinates(37.979, 23.716)));
        airportLocation.add(new Location("ITALY", "ROME", new Coordinates(41.891, 12.5113)));

    }

    public List<Location> getAirportLocation() {
        return airportLocation;
    }

    public void setAirportLocation(List<Location> airportLocation) {
        this.airportLocation = airportLocation;
    }

    public Location getLocByCountry(String country){
        for(Location location : airportLocation){
            if(location.getCountryName().equalsIgnoreCase(country)){
                return location;
            }
        }
        return null;
    }

    public Location getLocByCity(String city){
        for(Location location : airportLocation){
            if(location.getCityName().equalsIgnoreCase(city)){
                return location;
            }
        }
        return null;
    }
}
