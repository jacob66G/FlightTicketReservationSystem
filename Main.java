import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Service service = new Service();

        List<Flight> flights = new ArrayList<>();
        List<Airport> airports = new ArrayList<>();
        List<Client> clients = new ArrayList<>();


        try{
            service = Serializer.readState();
            flights = service.getFlights();
            airports = service.getAirports();
            clients = service.getClients();
        } catch (IOException e) {
        // Obsługa wyjątku IOException (np. plik jest pusty)
        System.out.println("FILE STAN: " + e.getMessage());
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

                                while (manegeFlights) {

                                    System.out.println("1  SHOW AVAILABLE FLIGHTS");
                                    System.out.println("2  ADD NEW FLIGHT");
                                    System.out.println("3  REMOVE FLIGHT");
                                    System.out.println("4  GO BACK");

                                    int manageflightOption = scanner.nextInt();

                                    switch (manageflightOption) {
                                        case 1:
                                            if (flights.isEmpty()) {
                                                System.out.println("NO FLIGHTS HAVE BEEN ADDED YET\n");
                                            } else {
                                                for (Flight flight : flights) {
                                                    System.out.println("\n--------------------------------------------");
                                                    System.out.println(flight);
                                                    System.out.println("--------------------------------------------\n");
                                                }
                                            }
                                            break;
                                        case 2:
                                            //--------------------------------------------------------------------DEPARTURE AIRPORT INFORMATIONS
                                            Airport departureAirport = null;
                                            Runway departureRunnway = null;

                                            System.out.println("----------DEPARTURE AIRPORT INFORMATIONS----------\n");
                                            System.out.println("CHOOSE DEPARTURE AIRPORT\n");

                                            for (Airport airport : airports) {
                                                System.out.println(airport.displayBasicInf());
                                            }

                                            System.out.print("DEPARTURE AIRPORT CODE: ");
                                            String departureAirportCode = scanner.next();

                                            for (Airport airport : airports) {
                                                if (airport.getCode().equals(departureAirportCode)) {
                                                    departureAirport = airport;
                                                    break;
                                                }
                                            }

                                            if (departureAirport != null) {

                                                System.out.println("\n----------AVAILABLE RUNNWAYs----------\n");

                                                List<Runway> departureRunnways = departureAirport.getRunways();

                                                for (Runway runway : departureRunnways) {
                                                    System.out.println(runway);
                                                }
                                                System.out.print("\nCHOOSE RUNNWAY CODE: ");
                                                String departureRunnwayCode = scanner.next();

                                                //Zrobir funkcje
                                                for (Runway runway : departureRunnways) {
                                                    if (runway.getNumber().equals(departureRunnwayCode)) {
                                                        departureRunnway = runway;
                                                    }
                                                }
                                                if (departureRunnway == null) {
                                                    System.out.println("Wrong runnway code!");
                                                    break;
                                                }
                                                //
                                            } else {
                                                System.out.println("AIRPORT WITH THIS CODE DOES NOT EXIST!");
                                            }

                                            //----------------------------------------------------------------------ARRIVAL AIRPORT INFORMATIONS

                                            Airport arrivalAirport = null;
                                            Runway arrivalRunnway = null;

                                            System.out.println("\n----------ARRIVAL AIRPORT INFORMATIONS----------\n");
                                            System.out.println("CHOOSE ARRIVAL AIRPORT\n");

                                            for (Airport airport : airports) {
                                                if (!airport.getCode().equals(departureAirportCode))
                                                    System.out.println(airport.displayBasicInf());
                                            }

                                            System.out.print("ARRIVAL AIRPORT CODE: ");
                                            String arrivalAirportCode = scanner.next();

                                            for (Airport airport : airports) {
                                                if (airport.getCode().equals(arrivalAirportCode)) {
                                                    arrivalAirport = airport;
                                                    break;
                                                }
                                            }

                                            if (arrivalAirport != null) {

                                                System.out.println("\n----------AVAILABLE RUNNWAYs----------\n");

                                                List<Runway> arrivalRunnways = arrivalAirport.getRunways();

                                                for (Runway runway : arrivalRunnways) {
                                                    System.out.println(runway);
                                                }

                                                System.out.print("\nCHOOSE RUNNWAY CODE: ");
                                                String arrivalRunnwayCode = scanner.next();
                                                //zrobic funkcje
                                                for (Runway runway : arrivalRunnways) {
                                                    if (runway.getNumber().equals(arrivalRunnwayCode)) {
                                                        arrivalRunnway = runway;
                                                    }
                                                }
                                                if (arrivalRunnway == null) {
                                                    System.out.println("wrong runnway code!");
                                                    break;
                                                }


                                            } else {
                                                System.out.println("AIRPORT WITH THIS CODE DOES NOT EXIST!");
                                            }

                                            Route newRoute = new Route(departureAirport, arrivalAirport, departureRunnway, arrivalRunnway);

                                            System.out.println("dystans " + newRoute.calculateDistance(departureAirport, arrivalAirport));

                                            //--------------------------------------------------------------------------------PLANE
                                            System.out.println("----------PLANE INFORMATIONS----------\n");
                                            Plane plane =  null;
                                            System.out.println("CHOOSE PLANE TYPE: ");
                                            System.out.println("1  LIGHT JET\n2  JUMBO JET\n3  BUSINESS JET");

                                            int planeType;

                                            while (true) {
                                                planeType = scanner.nextInt();
                                                if (planeType >= 1 && planeType <= 3) {
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

                                            if(planeType == 1){
                                                plane = new LightJet(planeCode, numberOfSeats);
                                            }else if (planeType == 2){
                                                plane = new JumboJet(planeCode, numberOfSeats);
                                            }else {
                                                plane = new BusinessJet(planeCode, numberOfSeats);
                                            }

                                            //---------------------------------------------------------------------------------DATE
                                            System.out.println("\n----------DATE INFORMATIONS----------");

                                            System.out.println("SET DEPARTURE DATE (yyyy-MM-dd)");
                                            LocalDate departureDate = LocalDate.parse(scanner.next());

                                            System.out.println("SET DEPARTURE TIME OF TAKE-OFF (HH:mm)");
                                            LocalTime departureTime = LocalTime.parse(scanner.next());


                                            LocalDateTime departureDateTime = LocalDateTime.of(departureDate, departureTime);
                                            LocalDateTime arrivalDateTime = null;
                                            LocalDateTime predictedArrivalDate = departureDateTime.plusSeconds((long) newRoute.calculateDuration(plane, departureAirport, arrivalAirport));

                                            System.out.println("PREDICTED TIME: " + predictedArrivalDate);

                                            while (true){

                                                System.out.println("DO YOU ACCEPT PREDICTED TIME? (YES/NO)");
                                                String acceptTime = scanner.next();

                                                if(acceptTime.equalsIgnoreCase("YES")){

                                                    arrivalDateTime = predictedArrivalDate;
                                                    break;

                                                } else if (acceptTime.equalsIgnoreCase("NO")) {

                                                    System.out.println("\nSET ARRIVAL DATE (yyyy-MM-dd)");
                                                    LocalDate arrivalDate = LocalDate.parse(scanner.next());
                                                    System.out.println("SET ARRIVAL TIME OF LANDING (HH:mm)");
                                                    LocalTime arrivalTime = LocalTime.parse(scanner.next());

                                                    arrivalDateTime = LocalDateTime.of(arrivalDate, arrivalTime);
                                                    break;
                                                }
                                                else {
                                                    System.out.println("WRONG OPTION");
                                                }
                                            }


                                            System.out.println("------------------------------\n");

                                            //--------------------------------------------------------------------------GATE NUMBER
                                            System.out.println("\nENTER NUMBER OF GATES");
                                            System.out.print("GATE NUMBERS: ");
                                            String gateNumber = scanner.next();


                                            System.out.println("\nNEW FLIGHT IS ADDED\n");


                                            Flight newFlight = new Flight(newRoute, plane, departureDateTime, arrivalDateTime, gateNumber);
                                            flights.add(newFlight);

                                            Serializer.saveState(service);

                                            break;

                                        case 3:
                                            // usuwanie lotu po id
                                            break;
                                        case 4:
                                            manegeFlights = false;
                                            break;
                                        default:
                                            System.out.println("Wrong choice!");
                                            break;
                                    }
                                }
                                break;
                            case 2:
                                boolean manageAirports = true;

                                while (manageAirports) {
                                    System.out.println("----------SUPPORTED AIRPORTS----------\n");
                                    //service.showSupportedAirports();

                                    for (Airport airport : airports) {
                                        // System.out.println("AIRPORT CODE: " + airport.getCode() + "CITY: " + airport.getCityName());
                                        System.out.println(airport.displayBasicInf());
                                    }
                                    if (airports.isEmpty()) {
                                        System.out.println("ANY AIRPORT IS AVAILABLE");
                                    }

                                    System.out.println("\n1  ADD NEW AIRPORT");
                                    System.out.println("2  REMOVE AIRPORT");
                                    System.out.println("3  GO BACK");

                                    int airportOption = scanner.nextInt();

                                    switch (airportOption) {
                                        case 1:

                                            System.out.println("----------SET AIRPORT COUNTRY----------");
                                            AirportDataBase airportDataBase = new AirportDataBase();

                                            Map<String, List<AirportDataBase.City>> airportLocation = airportDataBase.getAirportLocation();

                                            for (String key : airportLocation.keySet()) {
                                                System.out.println("- " + key);
                                            }
                                            System.out.println();

                                            System.out.print("COUNTRY: ");
                                            String countryName = scanner.next();

                                            //sprawdzic czy jest

                                            System.out.println("\n----------SET AIRPORT CITY----------");
                                            List<AirportDataBase.City> cityList = airportLocation.get(countryName.toUpperCase());

                                            for (AirportDataBase.City city : cityList) {
                                                System.out.println(city.getCity());
                                            }

                                            AirportDataBase.City selectedCity = null;
                                            System.out.print("\nCITY: ");
                                            String cityName = scanner.next();

                                            for (AirportDataBase.City city : cityList) {
                                                if (city.getCity().equals(cityName.toUpperCase())) {
                                                    selectedCity = city;
                                                    break;
                                                }
                                            }

                                            //sprawdzic czy jest


                                            System.out.println("\n----------SET AIRPORT CODE-----------");
                                            System.out.print("AIRPORT CODE: ");
                                            String airportCode = scanner.next();

                                            Airport airport = new Airport(selectedCity, airportCode);
                                            //service.addAirport(airport);
                                            airports.add(airport);

                                            System.out.println("\n---SET NUMBER OF AVAILABLE RUNNWAYS---");

                                            System.out.print("NUMBER OF RUNNWAYS: \n");
                                            int numberOfrunnways = scanner.nextInt();

                                            for (int n = 1; n <= numberOfrunnways; n++) {
                                                System.out.print(n + " RUNNWAY CODE: ");
                                                String runnwayCode = scanner.next();
                                                Runway runway = new Runway(runnwayCode);
                                                airport.addRunway(runway);

                                            }
                                            System.out.println("\nA NEW AIRPORT HAS BEEN ADDED\n");
                                            Serializer.saveState(service);
                                            break;
                                        case 2:

                                            for(Airport airport1 : airports){
                                                System.out.println(airport1.displayBasicInf());
                                            }
                                            
                                            System.out.println("1  DELETE AIRPORT BY AIRPORT CODE");
                                            System.out.println("2  GO BACK");
                                            int option = scanner.nextInt();

                                            switch (option) {
                                                case 1:
                                                    System.out.print("AIRPOT CODE: ");
                                                    String airportCodeToDelete = scanner.next();

                                                    for (Airport airport1 : airports) {
                                                        if (airport1.getCode().equals(airportCodeToDelete)) {
                                                            service.removeAirport(airport1);
                                                            System.out.println("AIPORT DELETED SUCCESSFULY");
                                                            break;
                                                        }
                                                    }
                                                    System.out.println("AIRPORT WITH THIS AIRPORT CODE DOES NOT EXIST");
                                                    break;
                                                case 2:
                                                    break;
                                                default:
                                                    System.out.println("WRONG OPTION");
                                                    break;
                                            }
                                        case 3:
                                            manageAirports = false;
                                            break;
                                    }
                                }
                                break;
                            case 3:

                                while (true) {
                                    System.out.println("ARE YOU SURE YOU WANT TO DELETE THE DATA?\nDATA OF AIRPORTS, FLIGHTS AND CLIENTS WILL BE DELETED\n(YES/NO)");
                                    String deleteData = scanner.next();
                                    if (deleteData.equalsIgnoreCase("yes")) {
                                        Serializer.clearData();
                                        airports.clear();
                                        flights.clear();
                                        clients.clear();
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

                        System.out.println("1  CREATE AN ACCOUNT");
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
                                System.out.print("PHONE NUMBER: ");
                                int phoneNumber = scanner.nextInt();
                                System.out.print("ADRES EMAIL: ");
                                String adresEmail = scanner.next();
                                System.out.print("PESEL: ");
                                String PESEL = scanner.next();

                                boolean perissionToCreateAccount = true;

                                List<Client> clients1 = service.getClients();
                                for (Client client : clients1) {
                                    if (client instanceof Person person) {
                                        if (person.getPESEL().equals(PESEL) || person.getEmail().equals(adresEmail) || person.getPhoneNumber() == phoneNumber) {
                                            System.out.println("\nACCOUNT WITH THE GIVEN DATA ALREADY EXISTS!");
                                            perissionToCreateAccount = false;
                                        }
                                    }
                                }

                                System.out.println("\n------------------------------");
                                if (perissionToCreateAccount) {
                                    Person newPerson = new Person(phoneNumber, adresEmail, personName, surname, PESEL);
                                    service.addClient(newPerson);
                                }
                                break;

                            case 2:

                                Client client1 = null;
                                boolean logOn = false;
                                System.out.println("SIGN IN");
                                System.out.println("------------------------------\n");

                                System.out.print("NAME: ");
                                personName = scanner.next();
                                System.out.print("SURNAME: ");
                                surname = scanner.next();
                                System.out.print("PESEL: ");
                                PESEL = scanner.next();

                                List<Client> clients2 = service.getClients();


                                for (Client client : clients2) {
                                    if (client instanceof Person person) {
                                        if (personName.equals(person.getName()) && surname.equals(person.getSurname()) && PESEL.equals(person.getPESEL())) {
                                            client1 = client;
                                            System.out.println("\nLOGIN SUCCESSFUL!\n");
                                            logOn = true;
                                        }
                                    }
                                }
                                if (!logOn) {
                                    System.out.println("\nLOGIN FAILED!\nPLEASE INSERT CORRECT DATA\n");
                                }
                                while (logOn) {
                                    System.out.println("1  BUY TICKET");
                                    System.out.println("2  SHOW YOUR TICKETS");
                                    System.out.println("3  SIGN OUT");

                                    int signInClientOption = scanner.nextInt();

                                    switch (signInClientOption) {
                                        case 1:
                                            System.out.println("ROUND -TRIP TICKET? ");
                                            System.out.println("1) NO");
                                            System.out.println("2) YES");
                                            int returnTicket = scanner.nextInt();
                                            int i = 0;
                                            while (i < returnTicket) {
                                                i++;
                                                if (returnTicket == 2 && i == 2) {
                                                    System.out.println("RETURN TICKET\n");
                                                }
                                                System.out.print("DEPARTURE AIRPORT: ");
                                                String departureAirportName = scanner.next();
                                                System.out.print("ARRIVAL AIRPORT: ");
                                                String arrivalAirportName = scanner.next();
                                                System.out.print("DEPARTURE DATE yyyy-MM-dd: ");
                                                String departureDate = scanner.next();


                                                boolean foundFlight = false;
                                                boolean foundDate = false;


                                                for (Flight flight : flights) {
                                                    if (departureAirportName.equalsIgnoreCase(flight.getRoute().getDepartureAirport().getCityName()) && arrivalAirportName.equalsIgnoreCase(flight.getRoute().getArrivalAirport().getCityName())) {
                                                        foundFlight = true;

                                                        if (departureDate.equals(flight.getDepartureDate())) {
                                                            foundDate = true;
                                                            System.out.println("Found flights: ");
                                                            System.out.println("FLIGHT ID: " + flight.getFlightCode() + "      " + flight.getRoute().getDepartureAirport().getCityName() + "  -  " + flight.getRoute().getArrivalAirport().getCityName() + " on " + flight.getDepartureDate() + " : " + flight.getDepartureTime() + "  -  " + flight.getArrivalDate() + " : " + flight.getArrivalTime());
                                                        }
                                                    }
                                                }

                                                if (!foundFlight) {
                                                    System.out.println("\nWE ARE SORRY, BUT WE DID NOT FOUND THE FLIGHT YOU WERE LOOKING FOR\n");
                                                    foundFlight = false;
                                                }
                                                if (foundFlight && !foundDate) {
                                                    System.out.println("\nWE ARE SORRY, BUT WE DID NOT FOUND THE FLIGHT YOU WERE LOOKING FOR IN THESE DATA");
                                                    System.out.println("HERE ARE THE FLIGHT WE FOUND FOR OTHERS DAYS: \n");
                                                    for (Flight flight : flights) {
                                                        if (departureAirportName.equals(flight.getRoute().getDepartureAirport().getCityName()) && arrivalAirportName.equals(flight.getRoute().getArrivalAirport().getCityName())) {
                                                            System.out.println("FLIGHT ID: " + flight.getFlightCode() + "    " + flight.getRoute().getDepartureAirport().getCityName() + "  -  " + flight.getRoute().getArrivalAirport().getCityName() + "    " + flight.getDepartureDate() + " : " + flight.getDepartureTime() + "  -  " + flight.getArrivalDate() + " : " + flight.getArrivalTime());
                                                        }
                                                    }
                                                }

                                                if (foundFlight) {

                                                    System.out.println("1) BUY FLIGHT BY ID");
                                                    System.out.println("2) GO BACK");
                                                    int option = scanner.nextInt();

                                                    switch (option) {
                                                        case 1:
                                                            System.out.print("FLIGHT ID: ");
                                                            int flightId = scanner.nextInt();

                                                            for (Flight flight : flights) {
                                                                if (flight.getFlightCode() == flightId) {
                                                                    System.out.println("CHOOSE TICKET CLASS");
                                                                    System.out.println("1) ECONOMY");
                                                                    System.out.println("2) BUSINESS");
                                                                    System.out.println("3) FIRST");
                                                                    System.out.println("4) GO BACK");

                                                                    int ticketClass = scanner.nextInt();
                                                                    switch (ticketClass) {
                                                                        case 1:
                                                                            Ticket economyticket = new EconomyTicket(flight);
                                                                            System.out.println("FLGHT ID: " + flight.getFlightCode() + "    FROM: " + flight.getRoute().getDepartureAirport().getCityName() + " TO: " + flight.getRoute().getArrivalAirport().getCityName());
                                                                            System.out.println(" ON " + flight.getDepartureDate() + " : " + flight.getDepartureTime() + " SEAT NUMBER: " + economyticket.getSeatNumber());
                                                                            System.out.println("PRICE: " + economyticket.getPrice());

                                                                            System.out.println("1) ACCEPT");
                                                                            System.out.println("2) REJECT");

                                                                            int acceptTicket = scanner.nextInt();

                                                                            if (acceptTicket == 1) {
                                                                                client1.addTicket(economyticket);
                                                                                System.out.println("PURCHASED SUCCESSFULLY");
                                                                            } else {
                                                                                break;
                                                                            }

                                                                            break;
                                                                        case 2:
                                                                            Ticket businessticket = new BusinessTicket(flight);
                                                                            System.out.println("FLGHT ID: " + flight.getFlightCode() + "FROM: " + flight.getRoute().getDepartureAirport() + " TO: " + flight.getRoute().getArrivalAirport());
                                                                            System.out.println(" ON" + flight.getDepartureDate() + " : " + flight.getDepartureTime() + "SEAT NUMBER: " + businessticket.getSeatNumber());
                                                                            System.out.println("PRICE: " + businessticket.getPrice());

                                                                            System.out.println("1) ACCEPT");
                                                                            System.out.println("2) REJECT");

                                                                            acceptTicket = scanner.nextInt();

                                                                            if (acceptTicket == 1) {
                                                                                client1.addTicket(businessticket);
                                                                                System.out.println("PURCHASED SUCCESSFULLY");
                                                                            } else {
                                                                                break;
                                                                            }

                                                                            break;
                                                                        case 3:
                                                                            Ticket firstclassticket = new FirstClassTicket(flight);
                                                                            System.out.println("FLGHT ID: " + flight.getFlightCode() + "FROM: " + flight.getRoute().getDepartureAirport() + " TO: " + flight.getRoute().getArrivalAirport());
                                                                            System.out.println(" ON" + flight.getDepartureDate() + " : " + flight.getDepartureTime() + "SEAT NUMBER: " + firstclassticket.getSeatNumber());
                                                                            System.out.println("PRICE: " + firstclassticket.getPrice());

                                                                            System.out.println("1) ACCEPT");
                                                                            System.out.println("2) REJECT");

                                                                            acceptTicket = scanner.nextInt();

                                                                            if (acceptTicket == 1) {
                                                                                client1.addTicket(firstclassticket);
                                                                                System.out.println("PURCHASED SUCCESSFULLY");
                                                                            } else {
                                                                                break;
                                                                            }

                                                                            break;
                                                                        case 4:
                                                                            i = 10;
                                                                            break;
                                                                        default:
                                                                            System.out.println("Wrong choice!");
                                                                            break;
                                                                    }
                                                                }
                                                            }
                                                            break;
                                                        case 2:
                                                            break;
                                                        default:
                                                            System.out.println("Wrong choice!");
                                                            break;
                                                    }
                                                }
                                            }
                                            break;
                                        case 2:
                                            List<Ticket> tickets = client1.getTickets();
                                            for (Ticket ticket : tickets) {
                                                System.out.println("\n-----------------------------------------------------------------------------------------------------------------------");
                                                System.out.println("FLIGHT ID: " + ticket.getFlight().getFlightCode() + " " + ticket.getFlight().getRoute().getDepartureAirport().getCityName() + " - " + ticket.getFlight().getRoute().getArrivalAirport().getCityName());
                                                System.out.println("DEPARTURE: " + ticket.getFlight().getDepartureDate() + " ARRIVAL: " + ticket.getFlight().getArrivalDate());
                                                System.out.println("TICKET ID: " + ticket.getTicketid() + " SEAT NUMBER: " + ticket.getSeatNumber() + " GATE NUMBER: " + ticket.getFlight().getGateNumebr());
                                                System.out.println("PLANE: " + ticket.getFlight().getPlane().getPlaneCode());
                                                System.out.println("\n-----------------------------------------------------------------------------------------------------------------------");
                                            }
                                            if (tickets.isEmpty()) {
                                                System.out.println("YOU HAVE NOT BOUGHT ANY TICKET YET");
                                            }
                                            System.out.println("1) DELETE TICKET");
                                            System.out.println("2) GO BACK");
                                            int option = scanner.nextInt();

                                            switch (option) {
                                                case 1:
                                                    System.out.println("\nCHOOSE TICEKT TO DELETE BY ID");
                                                    System.out.print("TICKET ID: ");
                                                    int ticketIdtoDelete = scanner.nextInt();

                                                    List<Ticket> tickets1 = client1.getTickets();

                                                    for (Ticket ticket : tickets1) {
                                                        if (ticket.getTicketid().equals(ticketIdtoDelete)) {
                                                            client1.removeTicket(ticket);
                                                            System.out.println("TICKET IS REMOVED");
                                                            break;
                                                        }
                                                    }


                                                    break;
                                                case 2:
                                                    break;
                                                default:
                                                    System.out.println("Wrong choice!");
                                                    break;
                                            }

                                            break;
                                        case 3:
                                            logOn = false;
                                            break;
                                        default:
                                            System.out.println("Wrong choice!");
                                            break;
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