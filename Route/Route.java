package Route;

import Airport.Airport;
import Plane.Plane;
import Runway.Runway;
import Coordinates.Coordinates;

import java.io.Serializable;

public class Route  implements Serializable {
    private static final double R = 6371; // Średni promień Ziemi w kilometrach
    private Airport departureAirport;
    private Airport arrivalAirport;
    private double distance;
    private Runway departureRunway;
    private Runway arrivalRunway;

    public Route(Airport departureAirport, Airport arrivalAirport, Runway departureRunway, Runway arrivalRunway) {
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.distance = calculateDistance(departureAirport, arrivalAirport);
    }

    public double calculateDistance(Airport departureAirport, Airport arrivalAirport){

        double xDeparture = departureAirport.getLocation().getCoordinates().getX();
        double yDeparture = departureAirport.getLocation().getCoordinates().getY();
        double xArrival = arrivalAirport.getLocation().getCoordinates().getX();
        double yArrival = arrivalAirport.getLocation().getCoordinates().getY();

        double xDepartureRad = Math.toRadians(xDeparture);
        double yDepartureRad = Math.toRadians(yDeparture);
        double xArrivalRad = Math.toRadians(xArrival);
        double yArrivalRad = Math.toRadians(yArrival);

        double deltaX = xArrivalRad - xDepartureRad;
        double deltaY = yArrivalRad - yDepartureRad;

        // Wzór haversine
        double a = Math.pow(Math.sin(deltaX / 2), 2) + Math.cos(xDepartureRad) * Math.cos(xArrivalRad) * Math.pow(Math.sin(deltaY / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        distance = R * c;
        return distance;
    }

    public double calculateDuration(Plane plane, Airport departureAirport, Airport arrivalAirport){

        double distance = calculateDistance(departureAirport, arrivalAirport) * 1000; // meters
        double averageSpeed = plane.getAverageSpeed() * 1000 / 3600; // m/s

        double averageTime = distance / averageSpeed; // sec

        return averageTime + 15 * 60;
    }

    public double getDistance() {
        return distance;
    }

    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public Airport getArrivalAirport() {
        return arrivalAirport;
    }

    public Runway getDepartureRunway() {
        return departureRunway;
    }

    public Runway getArrivalRunway() {
        return arrivalRunway;
    }

    @Override
    public String toString() {
        return "Route.Route Information:\n" +
                "Departure Airport.Airport: " + departureAirport.getCode() + "\n" +
                "Arrival Airport.Airport: " + arrivalAirport.getCode() + "\n" +
                "Distance: " + distance + " km\n" +
                "Departure Runway.Runway: " + (departureRunway != null ? departureRunway.getNumber() : "Not specified") + "\n" +
                "Arrival Runway.Runway: " + (arrivalRunway != null ? arrivalRunway.getNumber() : "Not specified") + "\n";
    }

}
