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

        double xDeparture = departureAirport.getCordinates().getX();
        double yDeparture = departureAirport.getCordinates().getY();
        double xArrival = arrivalAirport.getCordinates().getX();
        double yArrival = arrivalAirport.getCordinates().getY();

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
        return "Route Information:\n" +
                "Departure Airport: " + departureAirport.getCode() + "\n" +
                "Arrival Airport: " + arrivalAirport.getCode() + "\n" +
                "Distance: " + distance + " km\n" +
                "Departure Runway: " + (departureRunway != null ? departureRunway.getNumber() : "Not specified") + "\n" +
                "Arrival Runway: " + (arrivalRunway != null ? arrivalRunway.getNumber() : "Not specified") + "\n";
    }

}
