package org.ies.airline.components;

import org.ies.airline.model.Airline;
import org.ies.airline.model.Flight;

import java.util.Scanner;

public class AirlineReader {
    private final Scanner scanner;
    private final FlightReader flightReader;

    public AirlineReader(Scanner scanner, FlightReader flightReader) {
        this.scanner = scanner;
        this.flightReader = flightReader;
    }

    public Airline reader (){
        System.out.println("--- Datos de la Aerolinea --- ");
        System.out.println("Nombre");
        String name = scanner.nextLine();
        System.out.println("Cantidad de vuelos");
        int size = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Vuelos");
        Flight[] flights = new Flight[size];
        for (int i = 0; i < size; i++) {
            Flight flight = flightReader.reader();
            flights[i] = flight;
        }

        return new Airline(
                name,
                flights
        );
    }
}
