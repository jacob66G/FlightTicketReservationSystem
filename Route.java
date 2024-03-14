import java.io.Serializable;

public class Route  implements Serializable {
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
        int x1 = departureAirport.getCordinates().getX();
        int y1 = departureAirport.getCordinates().getY();
        int x2 = arrivalAirport.getCordinates().getX();
        int y2 = arrivalAirport.getCordinates().getY();
        return Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
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
