import Airport.*;
import Client.*;
import Flight.*;
import Plane.*;
import Route.Route;
import Runway.Runway;
import Serializer.Serializer;
import Service.Service;
import Ticket.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {

        Service service;

        try{
            service = Serializer.readState();
        }catch (IOException e){
            System.out.println("FILE IS EMPTY");
            service = new Service();
        }

        boolean exit = true;
        Scanner scanner = new Scanner(System.in);

        while (exit) {
            System.out.println("-----CHOOSE ACCOUNT TYPE-----");
            System.out.println("1  ADMIN");
            System.out.println("2  CLIENT");
            System.out.println("3  EXIT");

            int accountType = scanner.nextInt();

            switch (accountType) {
                case 1 -> {
                    //-------------------------------------------------ADMIN ACCOUNT PANEAL
                    boolean accountAdmin = true;
                    while (accountAdmin) {
                        System.out.println("1  MANAGE FLIGHTS");
                        System.out.println("2  MANAGE AIRPORTS");
                        System.out.println("3  CLEAR DATA");
                        System.out.println("4  SIGN OUT");

                        int adminOptions = scanner.nextInt();

                        switch (adminOptions) {
                            case 1:
                                boolean manegeFlights = true;
                                List<Flight> flights = service.getFlights();

                                while (manegeFlights) {

                                    System.out.println("1  SHOW AVAILABLE FLIGHTS");
                                    System.out.println("2  ADD NEW FLIGHT");
                                    System.out.println("3  REMOVE FLIGHT");
                                    System.out.println("4  GO BACK");

                                    int manageflightOption = scanner.nextInt();

                                    switch (manageflightOption) {
                                        case 1 -> {
                                            if (flights.isEmpty())
                                                System.out.println("NO FLIGHTS HAVE BEEN ADDED YET\n");
                                            else {
                                                for (Flight flight : flights) {
                                                    System.out.println("\n--------------------------------------------");
                                                    System.out.println(flight);
                                                    System.out.println("--------------------------------------------\n");
                                                }
                                            }
                                        }
                                        case 2 -> {
                                            //--------------------------------------------------------------------DEPARTURE AIRPORT INFORMATIONS
                                            Airport departureAirport;
                                            Runway departureRunnway;

                                            System.out.println("----------DEPARTURE AIRPORT INFORMATIONS----------\n");
                                            System.out.println("CHOOSE DEPARTURE AIRPORT\n");

                                            service.showAirports();

                                            while (true) {
                                                System.out.print("DEPARTURE AIRPORT CODE: ");
                                                String departureAirportCode = scanner.next();

                                                departureAirport = service.getAirportByCode(departureAirportCode);

                                                if (departureAirport != null) break;
                                                else System.out.println("WRONG AIRPORT CODE");
                                            }
                                            System.out.println("\n----------AVAILABLE RUNWAYS----------\n");
                                            List<Runway> departureRunnways = departureAirport.getRunways();

                                            for (Runway runway : departureRunnways) System.out.println(runway);

                                            while (true) {
                                                System.out.print("\nCHOOSE RUNNWAY CODE: ");
                                                String departureRunnwayCode = scanner.next();

                                                departureRunnway = departureAirport.getRunnwayByCode(departureRunnwayCode);

                                                if (departureRunnway != null) break;
                                                else System.out.println("WRONG RUNNWAY CODE");

                                            }


                                            //----------------------------------------------------------------------ARRIVAL AIRPORT INFORMATIONS
                                            Airport arrivalAirport;
                                            Runway arrivalRunnway;

                                            System.out.println("\n----------ARRIVAL AIRPORT INFORMATIONS----------\n");
                                            System.out.println("CHOOSE ARRIVAL AIRPORT\n");

                                            for (Airport airport : service.getAirports()) {
                                                if (!airport.getCode().equals(departureAirport.getCode()))
                                                    System.out.println(airport.displayBasicInf());
                                            }

                                            while (true) {
                                                System.out.print("ARRIVAL AIRPORT CODE: ");
                                                String arrivalAirportCode = scanner.next();

                                                arrivalAirport = service.getAirportByCode(arrivalAirportCode);

                                                if (arrivalAirport != null) break;
                                                else System.out.println("\nWRONG AIRPORT CODE\n");

                                            }
                                            System.out.println("\n----------AVAILABLE RUNWAYS----------\n");
                                            List<Runway> arrivalRunnways = arrivalAirport.getRunways();

                                            for (Runway runway : arrivalRunnways) System.out.println(runway);

                                            while (true) {
                                                System.out.print("\nCHOOSE RUNNWAY CODE: ");
                                                String arrivalRunnwayCode = scanner.next();

                                                arrivalRunnway = arrivalAirport.getRunnwayByCode(arrivalRunnwayCode);

                                                if (arrivalRunnway != null) break;
                                                else System.out.println("WRONG RUNNWAY CODE");
                                            }
                                            Route newRoute = new Route(departureAirport, arrivalAirport, departureRunnway, arrivalRunnway);

                                            boolean domesticFlight = arrivalAirport.getLocation().getCountryName().equals(departureAirport.getLocation().getCountryName());
                                            String[] domesticPlaneTypes = {"LIGHT JET", "BUSINESS JET"};
                                            String[] internationalPlaneTypes = {"MID JET", "JUMBO JET", "BUSINESS JET"};
                                            String[] planeTypes = domesticFlight ? domesticPlaneTypes : internationalPlaneTypes;

                                            //--------------------------------------------------------------------------------PLANE
                                            System.out.println("----------PLANE INFORMATIONS----------\n");
                                            Plane plane = null;
                                            System.out.println("CHOOSE PLANE TYPE: ");

                                            for (int i = 0; i < planeTypes.length; i++) {
                                                System.out.println((i + 1) + "  " + planeTypes[i]);
                                            }

                                            String[] planeTypeLabels = domesticFlight ? new String[]{"LIGHTJET", "BUSINESS JET"} : new String[]{"MIDJET", "JUMBOJET", "BUSINESS JET"};
                                            String planeType;
                                            while (true) {
                                                planeType = scanner.next();
                                                if (planeType.matches("\\d+") && Integer.parseInt(planeType) >= 1 && Integer.parseInt(planeType) <= planeTypes.length) {
                                                    planeType = planeTypeLabels[Integer.parseInt(planeType) - 1];
                                                    break;
                                                } else {
                                                    System.out.println("WRONG OPTION!");
                                                }
                                            }
                                            System.out.println("SET PLANE CODE");
                                            System.out.print("PLANE CODE: ");
                                            String planeCode = scanner.next();
                                            System.out.println("\nENTER NUMBER OF AVAILABLE SEATS");
                                            System.out.print("NUMBER OD SEATS: ");
                                            int numberOfSeats = scanner.nextInt();

                                            switch (planeType) {
                                                case "LIGHTJET" -> plane = new LightJet(planeCode, numberOfSeats);
                                                case "MIDJET" -> plane = new MidJet(planeCode, numberOfSeats);
                                                case "JUMBOJET" -> plane = new JumboJet(planeCode, numberOfSeats);
                                                case "BUSINESS JET" -> plane = new BusinessJet(planeCode, numberOfSeats);
                                            }


                                            //---------------------------------------------------------------------------------DATE
                                            System.out.println("\n----------DATE INFORMATIONS----------");
                                            LocalDate departureDate;
                                            while (true) {
                                                try {
                                                    LocalDate currentDate = LocalDate.now();
                                                    System.out.println("SET DEPARTURE DATE (yyyy-MM-dd)");
                                                    departureDate = LocalDate.parse(scanner.next());

                                                    if (departureDate.isAfter(currentDate)) break;
                                                    else
                                                        System.out.println("DEPARTURE DATE CANNOT BE EARLIER THAN " + currentDate.plusDays(1));
                                                } catch (DateTimeParseException e) {
                                                    System.out.println("INVALID DATE FORMAT. PLEASE ENTER DATE IN yyyy-MM-dd FORMAT");
                                                    scanner.nextLine();
                                                }
                                            }
                                            System.out.println("SET DEPARTURE TIME OF TAKE-OFF (HH:mm)");
                                            LocalTime departureTime = null;
                                            while (departureTime == null) {
                                                try {
                                                    departureTime = LocalTime.parse(scanner.next());
                                                } catch (DateTimeParseException e) {
                                                    System.out.println("INVALID TIME FORMAT. PLEASE ENTER TIME IN HH:mm FORMAT");
                                                    scanner.nextLine();
                                                }
                                            }
                                            LocalDateTime departureDateTime = LocalDateTime.of(departureDate, departureTime);
                                            LocalDateTime arrivalDateTime;
                                            LocalDateTime predictedArrivalDate = departureDateTime.plusSeconds((long) newRoute.calculateDuration(plane, departureAirport, arrivalAirport));

                                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                                            System.out.println("PREDICTED TIME: " + predictedArrivalDate.format(formatter));

                                            while (true) {

                                                System.out.println("DO YOU ACCEPT PREDICTED TIME? (YES/NO)");
                                                String acceptTime = scanner.next();

                                                if (acceptTime.equalsIgnoreCase("YES")) {
                                                    arrivalDateTime = predictedArrivalDate;
                                                    arrivalDateTime.format(formatter);
                                                    break;

                                                } else if (acceptTime.equalsIgnoreCase("NO")) {

                                                    LocalDate arrivalDate;

                                                    while (true) {
                                                        try {
                                                            System.out.println("\nSET ARRIVAL DATE (yyyy-MM-dd)");
                                                            arrivalDate = LocalDate.parse(scanner.next());

                                                            if (arrivalDate.isBefore(departureDate))
                                                                System.out.println("ARRIVAL DATE CANNOT BE EARLIER THAN DEPARTURE DATE: " + departureDateTime);
                                                            else break;
                                                        } catch (DateTimeParseException e) {
                                                            System.out.println("INVALID TIME FORMAT. PLEASE ENTER TIME IN HH:mm FORMAT");
                                                            scanner.nextLine();
                                                        }
                                                    }

                                                    LocalTime arrivalTime;

                                                    while (true) {
                                                        try {
                                                            System.out.println("SET ARRIVAL TIME OF LANDING (HH:mm)");
                                                            arrivalTime = LocalTime.parse(scanner.next());

                                                            if (arrivalDate.equals(departureDate)) {
                                                                if (arrivalTime.isAfter(departureTime)) break;
                                                                else
                                                                    System.out.println("ARRIVAL TIME CANNOT BE EARLIER THAN DEPARTURE TIME ON THE SAME DAY");
                                                            } else break;
                                                        } catch (DateTimeParseException e) {
                                                            System.out.println("INVALID TIME FORMAT. PLEASE ENTER TIME IN HH:mm FORMAT");
                                                            scanner.nextLine();
                                                        }
                                                    }

                                                    arrivalDateTime = LocalDateTime.of(arrivalDate, arrivalTime);
                                                    break;
                                                } else {
                                                    System.out.println("WRONG OPTION");
                                                }
                                            }

                                            //--------------------------------------------------------------------------GATE NUMBER
                                            System.out.println("\nENTER NUMBER OF GATES");
                                            System.out.print("GATE NUMBERS: ");
                                            String gateNumber = scanner.next();
                                            Flight flight;
                                            if (domesticFlight) {
                                                flight = new DomesticFlight(newRoute, plane, departureDateTime, arrivalDateTime, gateNumber);
                                            } else {
                                                flight = new InternationalFlight(newRoute, plane, departureDateTime, arrivalDateTime, gateNumber);
                                            }

                                            service.addFlight(flight);
                                            System.out.println("\nNEW FLIGHT IS ADDED\n");
                                        }
                                        case 3 -> {

                                            for (Flight flight : flights) System.out.println(flight);
                                            System.out.println("DELETE FLIGHT BY FLIGHT CODE");
                                            while (true) {
                                                System.out.println("TYPE 'ESC' TO GET BACK");
                                                System.out.print("FLIGHT CODE: ");
                                                String flightCodeToDelete = scanner.next();

                                                if (flightCodeToDelete.equalsIgnoreCase("esc")) {
                                                    break;
                                                }

                                                boolean found = false;
                                                for (Flight flight : flights) {
                                                    if (flight.getFlightCode().equals(flightCodeToDelete)) {
                                                        service.removeFlight(flight);

                                                        System.out.println("FLIGHT DELETED SUCCESSFULY");
                                                        found = true;
                                                        break;
                                                    }
                                                }
                                                if (!found) {
                                                    System.out.println("WRONG FLIGHT CODE GIVEN");
                                                }
                                            }
                                        }
                                        case 4 -> manegeFlights = false;
                                        default -> System.out.println("WRONG CHOICE");
                                    }
                                }
                                break;
                            case 2:
                                boolean manageAirports = true;

                                while (manageAirports) {
                                    System.out.println("----------SUPPORTED AIRPORTS----------\n");

                                    service.showAirports();

                                    System.out.println("\n1  ADD NEW AIRPORT");
                                    System.out.println("2  REMOVE AIRPORT");
                                    System.out.println("3  GO BACK");

                                    String airportOption = scanner.next();

                                    switch (airportOption) {
                                        case "1" -> {
                                            System.out.println("----------SET AIRPORT COUNTRY----------");
                                            AirportDataBase airportDataBase = new AirportDataBase();
                                            List<Location> airportLocation = airportDataBase.getAirportLocation();

                                            Set<String> uniqueCountryNames = new HashSet<>();
                                            for (Location location : airportLocation) {
                                                String countryName = location.getCountryName();
                                                if (!uniqueCountryNames.contains(countryName)) {
                                                    uniqueCountryNames.add(countryName);
                                                    System.out.println(countryName);
                                                }
                                            }

                                            String countryName;
                                            while (true) {
                                                System.out.print("\nCOUNTRY: ");
                                                countryName = scanner.next();

                                                if (airportDataBase.getLocByCountry(countryName) != null) break;
                                                else System.out.println("UNAVAILABLE COUNTRY NAME GIVEN");
                                            }

                                            System.out.println("\n----------SET AIRPORT CITY----------");
                                            for (Location location : airportLocation) {
                                                if (location.getCountryName().equalsIgnoreCase(countryName))
                                                    System.out.println(location.getCityName());
                                            }
                                            Location location;
                                            String cityName;
                                            while (true) {
                                                System.out.print("\nCITY: ");
                                                cityName = scanner.next();

                                                location = airportDataBase.getLocByCity(cityName);

                                                if (location != null && location.getCountryName().equalsIgnoreCase(countryName))
                                                    break;
                                                else System.out.println("UNAVAILABLE CITY NAME GIVEN");
                                            }
                                            System.out.println("\n----------SET AIRPORT CODE-----------");
                                            Airport airport;
                                            String airportCode;
                                            while (true) {
                                                System.out.print("AIRPORT CODE: ");
                                                airportCode = scanner.next();

                                                if (service.getAirportByCode(airportCode) != null)
                                                    System.out.println("AIRPORT WITH CODE: " + airportCode + " ALREADY EXIST!\n");
                                                else {
                                                    airport = new Airport(location, airportCode);
                                                    break;
                                                }
                                            }
                                            System.out.println("\n---SET NUMBER OF AVAILABLE RUNWAYS---");
                                            System.out.print("NUMBER OF RUNWAYS: ");
                                            int numberOfrunnways = scanner.nextInt();

                                            for (int n = 1; n <= numberOfrunnways; n++) {
                                                System.out.print(n + " RUNWAY CODE: ");
                                                String runnwayCode = scanner.next();
                                                if (airport.getRunnwayByCode(runnwayCode) != null) {
                                                    System.out.println("RUNWAY WITH THIS CODE ALREADY EXIST\n");
                                                    n--;
                                                } else {
                                                    Runway runway = new Runway(runnwayCode);
                                                    airport.addRunway(runway);
                                                }
                                            }

                                            service.addAirport(airport);
                                            System.out.println("\nA NEW AIRPORT HAS BEEN ADDED\n");
                                        }
                                        case "2" -> {

                                            service.showAirports();

                                            System.out.println("DELETE AIRPORT BY AIRPORT CODE");
                                            while (true) {
                                                System.out.println("TYPE 'ESC' TO GET BACK\n");
                                                System.out.print("AIRPOT CODE: ");
                                                String airportCodeToDelete = scanner.next();

                                                if (airportCodeToDelete.equalsIgnoreCase("esc")) {
                                                    break;
                                                }

                                                boolean found = false;
                                                for (Airport airport : service.getAirports()) {
                                                    if (airport.getCode().equals(airportCodeToDelete)) {
                                                        service.removeAirport(airport);

                                                        System.out.println("AIPORT DELETED SUCCESSFULY");
                                                        found = true;
                                                        break;
                                                    }
                                                }
                                                if (!found) {
                                                    System.out.println("\nWRONG AIRPORT CODE GIVEN\n");
                                                }
                                            }
                                        }
                                        case "3" -> manageAirports = false;

                                        default -> System.out.println("WRONG OPTION");
                                    }
                                }
                                break;
                            case 3:

                                while (true) {
                                    System.out.println("ARE YOU SURE YOU WANT TO DELETE THE DATA?\nDATA OF AIRPORTS, FLIGHTS AND CLIENTS WILL BE DELETED\n(YES/NO)");
                                    String deleteData = scanner.next();
                                    if (deleteData.equalsIgnoreCase("yes")) {
                                        Serializer.clearData();
                                        Serializer.saveState(service);
                                        break;
                                    } else if (deleteData.equalsIgnoreCase("no")) {
                                        break;
                                    } else {
                                        System.out.println("WRONG OPTION");
                                    }
                                }
                            case 4:
                                accountAdmin = false;
                                break;
                            default:
                                System.out.println("WRONG OPTION");
                                break;
                        }
                    }
                }

                case 2 -> {
                    //---------------------------------------------------------CLIENT ACCOUNT PANEL
                    boolean accountClient = true;
                    while (accountClient) {

                        System.out.println("\n1  CREATE AN ACCOUNT");
                        System.out.println("2  LOG ON");
                        System.out.println("3  EXIT");

                        int clientOption = scanner.nextInt();

                        switch (clientOption) {
                            case 1:

                                System.out.println("SET INFORMATIONS ABOUT YOU");
                                System.out.println("------------------------------\n");
                                System.out.print("NAME: ");
                                String personName = scanner.next();
                                System.out.print("SURNAME: ");
                                String surname = scanner.next();

                                String phoneNumber;
                                while (true){
                                    System.out.print("PHONE NUMBER: ");
                                     phoneNumber = scanner.next();

                                    if (phoneNumber.matches("\\d{9}")){
                                        break;
                                    } else {
                                        System.out.println("PHONE NUMBER SHOULD CONTAIN EXACTLY 9 DIGITS. PLEASE TRY AGAIN.");
                                    }
                                }

                                System.out.print("EMAIL: ");
                                String email = scanner.next();

                                String PESEL;
                                while (true) {
                                    System.out.print("PESEL: ");
                                     PESEL = scanner.next();

                                    if (PESEL.matches("\\d{11}")) {
                                        break;
                                    } else {
                                        System.out.println("PESEL SHOULD CONTAIN EXACTLY 11 DIGITS. PLEASE TRY AGAIN.");
                                    }
                                }



                                if (service.getClinetByPhoneNumber(phoneNumber) != null) {
                                    System.out.println("ACCOUNT WITH THE GIVEN PHONE NUMBER ALREADY EXIST\n");
                                } else if (service.getClinetByEmail(email) != null) {
                                    System.out.println("ACCOUNT WITH THE GIVEN ADRESS EMAIL NUMBER ALREADY EXIST\n");
                                } else if (service.getClinetByPesel(PESEL) != null) {
                                    System.out.println("ACCOUNT WITH THE GIVEN PESEL NUMBER ALREADY EXIST\n");
                                } else {
                                    Person newPerson = new Person(phoneNumber, email, personName, surname, PESEL);

                                    service.addClient(newPerson);
                                    System.out.println("ACCOUNT SUCCESSFULLY CREATED");
                                }

                                break;

                            case 2:

                                Client client1;

                                System.out.println("\n---------SIGN IN----------");

                                System.out.print("EMAIL: ");
                                email = scanner.next();
                                System.out.print("PESEL: ");
                                PESEL = scanner.next();

                                boolean logOn = false;
                                client1 = service.loggingClinet(email, PESEL);

                                if(client1 != null){
                                    logOn = true;
                                    System.out.println("SUCCESSFULLY LOGGED IN");
                                }
                                else{
                                    System.out.println("\nLOGIN FAILED!\nPLEASE INSERT CORRECT DATA\n");
                                }

                                while (logOn) {
                                    System.out.println("\n1  BUY TICKET");
                                    System.out.println("2  SHOW YOUR TICKETS");
                                    System.out.println("3  SIGN OUT");

                                    int signInClientOption = scanner.nextInt();

                                    switch (signInClientOption) {
                                        case 1 -> {
                                            boolean roundTripTicket = false;
                                            System.out.println("ROUND-TRIP TICKET?");
                                            System.out.println("1  NO");
                                            System.out.println("2  YES");

                                            while (true) {
                                                String ticketType = scanner.next();

                                                if (ticketType.equals("1")) break;
                                                else if (ticketType.equals("2")) {
                                                    roundTripTicket = true;
                                                    break;
                                                } else System.out.println("WRONG OPTION");
                                            }

                                            service.showAirports();

                                            Airport departureAirport;
                                            Airport arrivalAirport;
                                            System.out.println("CHOOSE BY AIRPORT CODE");
                                            String departureAirportCode;
                                            while (true) {
                                                System.out.print("DEPARTURE AIRPORT: ");
                                                departureAirportCode = scanner.next();

                                                departureAirport = service.getAirportByCode(departureAirportCode);

                                                if (departureAirport != null) break;
                                                else System.out.println("WRONG AIRPORT CODE");
                                            }
                                            String arrivalAirportCode;
                                            while (true) {

                                                System.out.print("ARRIVAL AIRPORT: ");
                                                arrivalAirportCode = scanner.next();

                                                arrivalAirport = service.getAirportByCode(arrivalAirportCode);
                                                if (arrivalAirport != null) break;
                                                else System.out.println("WRONG AIRPORT CODE");
                                            }
                                            LocalDate departureDate = null;
                                            boolean acceptDataForamt = false;
                                            while (!acceptDataForamt) {
                                                try {
                                                    System.out.println("DEPARTURE DATE (yyyy-MM-dd)");
                                                    departureDate = LocalDate.parse(scanner.next());
                                                    acceptDataForamt = true;
                                                } catch (DateTimeParseException e) {
                                                    System.out.println("INVALID DATE FORMAT. PLEASE ENTER DATE IN yyyy-MM-dd FORMAT");
                                                    scanner.nextLine();
                                                }
                                            }
                                            boolean foundFlight = false;

                                            List<Flight> flightAnotherDate = new ArrayList<>();

                                            System.out.println("FOUND FLIGHTS:\n");
                                            for (Flight flight : service.getFlights()) {
                                                if (flight.getRoute().getDepartureAirport() == departureAirport &&
                                                        flight.getRoute().getArrivalAirport() == arrivalAirport) {

                                                    if (flight.getDepartureDateTime().toLocalDate().equals(departureDate)) {
                                                        foundFlight = true;
                                                        System.out.println(flight.displayBasicInf() + "\n");
                                                    } else {
                                                        flightAnotherDate.add(flight);
                                                    }
                                                }
                                            }
                                            if (!flightAnotherDate.isEmpty()) {
                                                foundFlight = true;
                                                System.out.println("WE ARE SORRY BUT WE COULD NOT FIND A FLIGHT ON THIS DAY\nHERE ARE THE FLIGHTS ON OTHER DAYS:\n");
                                                for(Flight flight : flightAnotherDate){
                                                    System.out.println(flight.displayBasicInf() + "\n");
                                                }
                                            }
                                            if (foundFlight) {
                                                System.out.println("1  BUY TICKET");
                                                System.out.println("2  GO BACK");

                                                String option = scanner.next();

                                                switch (option) {
                                                    case "1":
                                                        System.out.println("CHOOSE FLIGHT BY ID");

                                                        Flight flight;
                                                        while (true) {
                                                            System.out.print("FLIGHT ID: ");
                                                            String flightCode = scanner.next();
                                                            flight = service.getFlightByCode(flightCode);

                                                            if (flight != null) break;
                                                            else System.out.println("WRONG FLIGHT CODE");
                                                        }

                                                        Ticket ticket = null;

                                                        boolean wrongOption = true;
                                                        while (wrongOption) {
                                                            System.out.println("\nCHOOSE TICKET TYPE");
                                                            System.out.println("1  ECONOMY\n2  BUSINESS\n3  FIRST CLASS");

                                                            String ticketType = scanner.next();
                                                            switch (ticketType) {
                                                                case "1":
                                                                    ticket = new EconomyTicket(flight);
                                                                    wrongOption = false;
                                                                    break;
                                                                case "2":
                                                                    ticket = new BusinessTicket(flight);
                                                                    wrongOption = false;
                                                                    break;
                                                                case "3":
                                                                    ticket = new FirstClassTicket(flight);
                                                                    wrongOption = false;
                                                                    break;
                                                                default:
                                                                    System.out.println("WRONG OPTION");
                                                                    break;
                                                            }

                                                            if (!wrongOption) {
                                                                System.out.println("PRICE: " + ticket.getPrice());
                                                                System.out.println("1  ACCEPT\n2  REJECT");
                                                                String confirmPrice = scanner.next();

                                                                if (confirmPrice.equals("1")) {
                                                                    client1.addTicket(ticket);
                                                                    System.out.println("PURCHASED SUCCESSFULLY");

                                                                    System.out.println(ticket);

                                                                } else if (confirmPrice.equals("2")) {
                                                                    System.out.println("1  SELECT ANOTHER TYPE OF TICKET\n2  EXIT");
                                                                    String select = scanner.next();

                                                                    if (select.equals("1")) wrongOption = true;
                                                                    else if (select.equals("2")) wrongOption = false;
                                                                    else System.out.println("WRONG OPTION");

                                                                } else System.out.println("WRONG OPTION");
                                                            }
                                                        }

                                                        break;
                                                    case "2":
                                                        foundFlight = false;
                                                        break;
                                                    default:
                                                        System.out.println("WRONG OPTION");

                                                }

                                            }
                                        }
                                        case 2 -> {
                                            for (Ticket ticket : client1.getTickets()){
                                                System.out.println(ticket);
                                            }

                                            System.out.println("\n1  RETURN TICKET");
                                            System.out.println("2  GO BACK");

                                            String option = scanner.next();

                                            switch (option){
                                                case "1" -> {
                                                    while (true) {
                                                        System.out.println("TYPE 'ESC' TO GET BACK");
                                                        System.out.print("TICKED ID TO RETURN: ");
                                                        String ticketIdToDelete = scanner.next();

                                                        if (ticketIdToDelete.equalsIgnoreCase("esc")) break;
                                                        else {
                                                            Ticket ticket = client1.getTicetById(ticketIdToDelete);

                                                            if (ticket != null) {
                                                                client1.removeTicket(ticket);
                                                                System.out.println("THE TICKET WAS RETURNED");
                                                                break;
                                                            } else System.out.println("WRONG TICKET ID WAS GIVEN");
                                                        }
                                                    }
                                                }
                                                case "2" -> {}
                                                default ->
                                                        throw new IllegalStateException("Unexpected value: " + option);
                                            }
                                        }
                                        case 3 -> logOn = false;
                                        default -> System.out.println("Wrong choice!");
                                    }
                                }
                                break;
                            case 3:
                                accountClient = false;
                                break;
                            default:
                                System.out.println("Wrong choice!");
                                break;
                        }
                    }
                }
                case 3 -> exit = false;
                default -> System.out.println("Wrong choice!");
            }
        }
        Serializer.saveState(service);
    }
}


