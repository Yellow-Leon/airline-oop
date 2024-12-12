package org.ies.airline.components;

import org.ies.airline.model.Airline;

import java.util.Scanner;

public class AirlineAppMenu {
    private final Scanner scanner;
    private final AirlineReader airlineReader;

    public AirlineAppMenu(Scanner scanner, AirlineReader airlineReader) {
        this.scanner = scanner;
        this.airlineReader = airlineReader;
    }

    public void menu() {
        System.out.println("Introduzca los datos de la aerolinea");
        Airline airline = airlineReader.reader();
    }
}
