package org.ies.airline.components;
import org.ies.airline.model.Airline;

import java.util.Scanner;

public class AirlineApp1 {
    private final Scanner scanner;
    private final AirlineReader airlineReader;
    private final FlightReader flightReader;
    private final PassengerReader passengerReader;

    public AirlineApp1(Scanner scanner, AirlineReader airlineReader, FlightReader flightReader, PassengerReader passengerReader) {
        this.scanner = scanner;
        this.airlineReader = airlineReader;
        this.flightReader = flightReader;
        this.passengerReader = passengerReader;
    }

    public void run (){
        Airline airline = airlineReader.reader();
        System.out.println("Introduce el numero de vuelo");
        int flightNumber = scanner.nextInt();
        scanner.nextLine();
        airline.searchFlight(flightNumber);
    }
}
