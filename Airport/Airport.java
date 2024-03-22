package Airport;

import java.io.Serializable;
import java.util.ArrayList;
import Runway.Runway;
import Coordinates.Coordinates;
import java.util.List;

public class Airport implements Serializable {
    private String code;
    private List<Runway> runways;
    private int numberOfgates;
    private Location location;

    public Airport(Location location, String code) {
        this.location = location;
        this.code = code;
        this.runways = new ArrayList<>();
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
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

    public int getNumberOfgates() {
        return numberOfgates;
    }

    public void setNumberOfgates(int numberOfgates) {
        this.numberOfgates = numberOfgates;
    }


    public Runway getRunnwayByCode(String code){
        for(Runway runway : runways){
            if (runway.getNumber().equals(code)) return runway;
        }
        return null;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AIRPORT CODE: ").append(code).append("\n");
        sb.append("LOCATION: ").append(location.getCountryName() + " " +location.getCityName()).append("\n");
        sb.append("COORDINATES: ").append(location.getCoordinates()).append("\n");
        sb.append("NUMBER OF GATES: ").append(numberOfgates).append("\n");
        sb.append("RUNNWAYS: \n");
        for (Runway runway : runways) {
            sb.append("  - ").append(runway).append("\n");
        }
        return sb.toString();
    }

    public String displayBasicInf(){
        StringBuilder sb = new StringBuilder();
        sb.append("LOCATION: ").append(location.getCountryName() + " " +location.getCityName()).append("\n");
        sb.append("AIRPORT CODE: ").append(code).append("\n");

        return sb.toString();
    }
}
