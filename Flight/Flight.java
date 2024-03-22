package Flight;

import Plane.Plane;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;
import Route.Route;

public abstract class Flight implements Serializable {
    private Route route;
    private Plane plane;
    private String gateNumebr;
    private LocalDateTime departureDateTime, arrivalDateTime;
    private String flightCode;

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

    public String generateFlightCode(){
        Random random = new Random();
        int code = random.nextInt(9999 - 1000 + 1) + 1000;

        String flightCode = Integer.toString(code);

        return flightCode;
    }

    public Route getRoute() {
        return route;
    }
    public Plane getPlane() {
        return plane;
    }
    public String getGateNumebr() {
        return gateNumebr;
    }
    public String getFlightCode() {return flightCode;}

    @Override
    public String toString() {
        return "FLIGHT CODE: " + flightCode + "\n" +
                route.getDepartureAirport().getLocation().getCountryName() + " " + route.getDepartureAirport().getLocation().getCityName() + "  ->  " +
                route.getArrivalAirport().getLocation().getCountryName() + " " + route.getArrivalAirport().getLocation().getCityName() + "\n" +
                "DEPARTURE DATE: " + departureDateTime.toLocalDate() + " " + departureDateTime.toLocalTime() + "\n" +
                "ARRIVAL DATE: " + arrivalDateTime.toLocalDate() + " " + arrivalDateTime.toLocalTime() + "\n" +
                "PLANE CODE: " + plane.getPlaneCode() + "\n" +
                "GATE NUMBER: " + gateNumebr + "\n";
    }

    public String displayBasicInf() {
        return  "FLIGHT CODE: " + flightCode + "\n" +
                route.getDepartureAirport().getLocation().getCountryName() + " " + route.getDepartureAirport().getLocation().getCityName() + "  ->  " +
                route.getArrivalAirport().getLocation().getCountryName() + " " + route.getArrivalAirport().getLocation().getCityName() + "\n" +
                "DEPARTURE DATE: " + departureDateTime.toLocalDate() + " " + departureDateTime.toLocalTime()+ "\n" +
                "ARRIVAL DATE: " + arrivalDateTime.toLocalDate() + " " + arrivalDateTime.toLocalTime() + "\n";
    }

}
