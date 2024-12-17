import org.ies.airline.components.*;

import java.util.Scanner;

public class MainOriginal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PassengerReader passengerReader = new PassengerReader(scanner);
        FlightReader flightReader = new FlightReader(scanner, passengerReader);
        AirlineReader airlineReader = new AirlineReader(scanner, flightReader);

        AirlineAppMenu airlineAppMenu = new AirlineAppMenu(scanner , airlineReader);
        airlineAppMenu.menu();
    }
}