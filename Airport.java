import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Airport implements Serializable {
    private String code, cityName;
    private List<Runway> runways;
    private Coordinates coordinates;
    private int numberOfgates;

    public Airport(String cityName, String code, Coordinates coordinates) {
        this.cityName =cityName;
        this.code = code;
        this.coordinates = coordinates;
        this.runways = new ArrayList<>();
    }
    private AirportDataBase.City city;
    public Airport(AirportDataBase.City city, String code) {
        this.cityName = city.getCity();
        this.code = code;
        this.coordinates = city.getCoordinates();
        this.runways = new ArrayList<>();
    }

    public List<Runway> getRunways() {
        return runways;
    }
    public void addRunway(Runway runway){runways.add(runway);}
    public void removeRunway(Runway runway){runways.remove(runway);}
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Coordinates getCordinates() {
        return coordinates;
    }

    public void setCordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public int getNumberOfgates() {
        return numberOfgates;
    }

    public void setNumberOfgates(int numberOfgates) {
        this.numberOfgates = numberOfgates;
    }

    public String getCityName() {
        return cityName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Airport Code: ").append(code).append("\n");
        sb.append("City Name: ").append(cityName).append("\n");
        sb.append("Coordinates: ").append(coordinates).append("\n");
        sb.append("Number of Gates: ").append(numberOfgates).append("\n");
        sb.append("Runways: \n");
        for (Runway runway : runways) {
            sb.append("  - ").append(runway).append("\n");
        }
        return sb.toString();
    }

    public String displayBasicInf(){
        StringBuilder sb = new StringBuilder();
        sb.append("Airport Code: ").append(code).append("\n");
        sb.append("City Name: ").append(cityName).append("\n");
        return sb.toString();
    }
}
