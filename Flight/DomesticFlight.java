package Flight;

import Plane.*;
import Route.Route;

import java.time.LocalDateTime;

public class DomesticFlight extends Flight{
    public DomesticFlight(Route route, Plane plane, LocalDateTime departureDate, LocalDateTime arrivalDate, String gateNumebr) {
        super(route, plane, departureDate, arrivalDate, gateNumebr);
    }

}
