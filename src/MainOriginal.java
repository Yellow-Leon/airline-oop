import org.ies.airline.components.*;
import org.ies.airline.model.Airline;
import org.ies.airline.model.Flight;
import org.ies.airline.model.Passenger;

import java.util.Scanner;

public class MainOriginal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PassengerReader passengerReader = new PassengerReader(scanner);
        FlightReader flightReader = new FlightReader(scanner, passengerReader);
        AirlineReader airlineReader = new AirlineReader(scanner, flightReader);
        Passenger[] passengers = new Passenger[4];
        passengers[0]= new Passenger("1A", "Leonardo", "Amarilla", 1);
        passengers[1]= new Passenger("1B", "Julian", "Amarilla", 2);
        passengers[2]= new Passenger("1C", "Julio", "Almada", 3);
        passengers[3]= new Passenger("1D", "Julian", "Almada", 4);
        Passenger[] passengers2 = new Passenger[4];
        passengers2[0]= new Passenger("2A", "Bel", "Grano", 1);
        passengers2[1]= new Passenger("2B", "Javier", "Miller", 2);
        passengers2[2]= new Passenger("2C", "Nis", "Man", 3);
        passengers2[3]= new Passenger("2D", "Julian", "Almada", 4);
        Flight[] flights = new Flight[4];
        flights[0]=new Flight(1, "Paraguay", "Brasil", 1,passengers2);
        flights[1]=new Flight(2, "Paraguay", "Argentina", 2,passengers2);
        flights[2]=new Flight(3, "Paraguay", "España", 3,passengers);
        flights[3]=new Flight(4, "España", "Alemania", 2,passengers);
        Airline hornero = new Airline("Hornero", flights);

        AirlineAppMenu airlineAppMenu = new AirlineAppMenu(scanner , airlineReader);
        airlineAppMenu.menu(hornero);
    }
}