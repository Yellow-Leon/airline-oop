package org.ies.airline.components;

import org.ies.airline.model.Flight;
import org.ies.airline.model.Passenger;

import java.util.Scanner;

public class FlightReader {
    private final Scanner scanner;
    private final PassengerReader passengerReader;

    public FlightReader(Scanner scanner, PassengerReader passengerReader) {
        this.scanner = scanner;
        this.passengerReader = passengerReader;
    }

    public Flight reader() {
        System.out.println("--- Datos del vuelo ---");
        System.out.println("Numero del vuelo");
        int flightNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Origen");
        String origin = scanner.nextLine();
        System.out.println("Destino");
        String destination = scanner.nextLine();
        System.out.println("Numero de puerta");
        int gateNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Numero de pasajeros");
        int size = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Pasajeros");
        Passenger[] passengers = new Passenger[size];
        for (int i = 0; i < size; i++) {
            Passenger passenger = passengerReader.reader();
            passengers[i] = passenger;
        }

        return new Flight(
                flightNumber,
                origin,
                destination,
                gateNumber,
                passengers
        );
    }
}
