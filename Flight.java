import java.io.Serializable;
import java.util.Random;

public class Flight implements Serializable {
    private Route route;
    private Plane plane;
    private String departureDate, arrivalDate, departureTime, arrivalTime, gateNumebr; // date format: yyyy-MM-dd/HH:mm:ss
    private int flightCode;

    public Flight(Route route, Plane plane, String departureDate, String arrivalDate, String departureTime, String arrivalTime, String gateNumebr) {
        this.route = route;
        this.plane = plane;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.gateNumebr = gateNumebr;
        this.flightCode = generateFlightCode();
    }

    public int generateFlightCode(){
        Random random = new Random();
        int flightCode = random.nextInt(9999 - 1000 + 1) + 1000;
        return flightCode;
    }

    public Route getRoute() {
        return route;
    }

    public Plane getPlane() {
        return plane;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public String getGateNumebr() {
        return gateNumebr;
    }

    public int getFlightCode() {return flightCode;}

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    @Override
    public String toString() {
        return "Flight Information:\n" +
                "Flight Code: " + flightCode + "\n" +
                "Departure Airport: " + route.getDepartureAirport().getCityName() + " - " + route.getDepartureAirport().getCode() + "\n" +
                "Arrival Airport: " + route.getArrivalAirport().getCityName() + " - " + route.getArrivalAirport().getCode() + "\n" +
                "Plane Code: " + plane.getPlaneCode() + "\n" +
                "Departure Date and Time: " + departureDate + " " + departureTime + "\n" +
                "Arrival Date and Time: " + arrivalDate + " " + arrivalTime + "\n" +
                "Gate Number: " + gateNumebr + "\n";
    }


}
