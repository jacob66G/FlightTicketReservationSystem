import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

public class Flight implements Serializable {
    private Route route;
    private Plane plane;
    private String gateNumebr;
    private LocalDateTime departureDateTime, arrivalDateTime;
    private int flightCode;
    private String departureDate, departureTime, arrivalTime, arrivalDate; //do usuniecia

    public Flight(Route route, Plane plane, LocalDateTime departureDate, LocalDateTime arrivalDate, String gateNumebr) {
        this.route = route;
        this.plane = plane;

        this.gateNumebr = gateNumebr;
        this.flightCode = generateFlightCode();
        this.arrivalDateTime = arrivalDate;
        this.departureDateTime = departureDate;
    }

    public LocalDateTime getDepartureDateTime() {
        return departureDateTime;
    }

    public LocalDateTime getArrivalDateTime() {
        return arrivalDateTime;
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

//    @Override
//    public String toString() {
//        return "Flight Information:\n" +
//                "Flight Code: " + flightCode + "\n" +
//                "Departure Airport: " + route.getDepartureAirport().getCityName() + " - " + route.getDepartureAirport().getCode() + "\n" +
//                "Arrival Airport: " + route.getArrivalAirport().getCityName() + " - " + route.getArrivalAirport().getCode() + "\n" +
//                "Plane.Plane Code: " + plane.getPlaneCode() + "\n" +
//                "Departure Date and Time: " + departureDate + " " + departureTime + "\n" +
//                "Arrival Date and Time: " + arrivalDate + " " + arrivalTime + "\n" +
//                "Gate Number: " + gateNumebr + "\n";
//    }
    transient DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    @Override
    public String toString() {
        return "Flight Information:\n" +
                "Flight Code: " + flightCode + "\n" +
                "Departure Airport: " + route.getDepartureAirport().getCityName() + " - " + route.getDepartureAirport().getCode() + "\n" +
                "Arrival Airport: " + route.getArrivalAirport().getCityName() + " - " + route.getArrivalAirport().getCode() + "\n" +
                "Plane Code: " + plane.getPlaneCode() + "\n" +
                "Departure Date and Time: " + departureDateTime.format(formatter) + "\n" +
                "Arrival Date and Time: " + arrivalDateTime.format(formatter) + "\n" +
                "Gate Number: " + gateNumebr + "\n";
    }


}
