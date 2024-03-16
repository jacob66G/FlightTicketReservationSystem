import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class AirportDataBase {
    private Map<String, List<City>> airportLocation;

    public AirportDataBase(){
        this.airportLocation = new HashMap<>();
        addLocation("POLAND", List.of(new City("WARSAW", new Coordinates(52.229,21.0117)),
                new City("CRACOW", new Coordinates( 50.061,19.936)),
                new City("GDANSK", new Coordinates(54.352,18.646)),
                new City("POZNAN", new Coordinates(52.406, 16.929))));
        addLocation("GERMANY", List.of(new City("BERLIN", new Coordinates(52.524, 13.410)),
                new City("HAMBURG", new Coordinates(53.575, 10.0153))));

        addLocation("FRANCE", List.of(new City("PARIS", new Coordinates(48.853,  2.3488)),
                new City("MARSEILLE", new Coordinates(43.296, 5.3810))));

        addLocation("SPAIN", List.of(new City("MADRID", new Coordinates( 40.416, -3.7038)),
                new City("BARCELONA", new Coordinates(41.388, 2.1589))));

        addLocation("ENGLAND", List.of(new City("LONDON", new Coordinates(51.508,  -0.1257)),
                new City("MANCHESTER", new Coordinates(53.480, -2.237))));

        addLocation("GREECE", List.of(new City("ATHENS", new Coordinates(37.979, 23.716))));

        addLocation("ITALY", List.of(new City("ROME", new Coordinates(41.891, 12.5113))));
    }

    private void addLocation(String countryName, List<City> cities){
        airportLocation.put(countryName, cities);
    }

    public Map<String, List<City>> getAirportLocation(){
        return this.airportLocation;
    }
    public class City{
        private String city;
        private Coordinates coordinates;

        public City(String city, Coordinates coordinates){
            this.city = city;
            this.coordinates = coordinates;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public Coordinates getCoordinates() {
            return coordinates;
        }

        public void setCoordinates(Coordinates coordinates) {
            this.coordinates = coordinates;
        }
    }
}
