package org.ies.airline.components;

import org.ies.airline.model.Passenger;

import java.util.Scanner;

public class PassengerReader {
    private final Scanner scanner;

    public PassengerReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public Passenger reader() {
        System.out.println("--- Datos del pasajero---");
        System.out.println("NIF");
        String nif = scanner.nextLine();
        System.out.println("Name");
        String name = scanner.nextLine();
        System.out.println("Surname");
        String surname = scanner.nextLine();
        System.out.println("SeatNumber");
        Integer seatNumber = scanner.nextInt();
        scanner.nextLine();

        return new Passenger(
                nif,
                name,
                surname,
                seatNumber
        );
    }
}
