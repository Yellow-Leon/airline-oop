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
        int option;
        do {
            System.out.println("1. Muestra todos los vuelos");
            System.out.println("2. Mostrar vuelos origen");
            System.out.println("3. Muestra el vuelo de este pasajero");
            System.out.println("4. Muestra asiento de pasajero");
            System.out.println("5. Cambiar asiento de pasajero");
            System.out.println("6. Salir");

            option = scanner.nextInt();
            scanner.nextLine();
            if (option == 1){

            } else if (option == 2) {

            }else if (option == 3){

            }else if (option == 4){

            }else if (option == 5){

            }else if (option == 6){

            } else {
                System.out.println("Error");
            }
        }while (option != 6);
    }
}
