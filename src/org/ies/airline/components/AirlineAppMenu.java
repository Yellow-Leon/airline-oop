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

    public void menu(Airline airline) {
//        System.out.println("Introduzca los datos de la aerolinea");
//        Airline airline = airlineReader.reader();
        int option;
        do {
            System.out.println("---- " + airline.getName() + " ----");
            System.out.println("1. Muestra todos los vuelos");
            System.out.println("2. Mostrar vuelos origen");
            System.out.println("3. Muestra el vuelo de este pasajero");
            System.out.println("4. Muestra asiento de pasajero");
            System.out.println("5. Cambiar asiento de pasajero");
            System.out.println("6. Salir");

            option = scanner.nextInt();
            scanner.nextLine();
            if (option == 1){
                airline.showAllFlights();
            } else if (option == 2) {
                System.out.println("Introduzca el origen del vuelo");
                String origin = scanner.nextLine();

            }else if (option == 3){
                airline.showThisPassengerFlight(airline.askNif());
            }else if (option == 4){
            }else if (option == 5){
            }else if (option == 6){
                System.out.println("Saliendo....");
            } else {
                System.out.println("Error");
            }
        }while (option != 6);
    }
}
