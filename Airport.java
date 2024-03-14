import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Airport implements Serializable {
    private String code, cityName;
    private List<Runway> runways;
    private Cordinates cordinates;
    private int numberOfgates;

    public Airport(String cityName, String code, Cordinates cordinates) {
        this.cityName =cityName;
        this.code = code;
        this.cordinates = cordinates;
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

    public Cordinates getCordinates() {
        return cordinates;
    }

    public void setCordinates(Cordinates cordinates) {
        this.cordinates = cordinates;
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
        sb.append("Coordinates: ").append(cordinates).append("\n");
        sb.append("Number of Gates: ").append(numberOfgates).append("\n");
        sb.append("Runways: \n");
        for (Runway runway : runways) {
            sb.append("  - ").append(runway).append("\n");
        }
        return sb.toString();
    }
}
