package org.ies.airline.model;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Airline {
    private String name;
    private Flight[] flights;

    public Airline(String name, Flight[] flights) {
        this.name = name;
        this.flights = flights;
    }

    // Metodos propios aqui
    //Bucle para aerolinea
    public Flight forFlight() {
        for (Flight flight : flights) {
            return flight;
        }
        return null;
    }

    public Passenger forPassenger() {
        for (Passenger passenger : forFlight().getPassengers()) {
            return passenger;
        }
        return null;
    }

    //Pregunta NIF - Usado para simplificar en searchFlight y en showPassenger
    public String askNif() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduzca el nif del pasajero");
        return scanner.nextLine();
    }

    //Pregunta un numero
    public Integer askNum() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce un numero");
        Integer num = scanner.nextInt();
        scanner.nextLine();
        return num;
    }

    //Muestra un pasajero - Usado en showPassengerFlight
    public void showPassenger(Flight flight) {
        for (Passenger passenger : flight.getPassengers()) {
            if (passenger.getNif().equals(askNif()))
                System.out.println(passenger);
        }
    }
//---------


// Metodo para App1

    // Metodo para buscar un vuelo -- Usa otro metodo ubicado en la clase Passengar
    public void searchFlight(int flightNumber) {
        for (Flight flight : flights) {
            if (flightNumber == flight.getFlightNumber()) {
                flight.searchPassenger(askNif());
                break;
            }
        }
        System.out.println("No existe ese vuelo");
    }

//-------

// Metodos para app principal

    // Opcion 1: Metodo para ver todos los vuelos
    public void showFlights() {
        for (Flight flight : flights) {
            System.out.println(flight);
        }
    }

    // Opcion 2: Metodo para ver todos los vuelos por origen
    public void showFlightOrigin(String origin) {
        for (Flight flight : flights) {
            if (flight.getOrigin().equals(origin)) {
                System.out.println(flight);
            }
        }
    }

    // Opcion 3: Metodo para ver el vuelo de un pasajero --- Usa un metodo propio para evitar un cumulo de codigos
    public void showPassengerFlight(int fligthNumber) {
        for (Flight flight : flights) {
            if (flight.getFlightNumber() == fligthNumber) {
                showPassenger(flight);
            }
        }
    }

    // Opcion 4: Metodo para ver el asiento de un pasajero
    public void showPassengerSeat(Integer numberSeat) {
        if (forFlight().getFlightNumber() == askNum()) {
            if (numberSeat.equals(forPassenger().getSeatNumber())) {
                if (askNif().equals(forPassenger().getNif())) {
                    System.out.println("El pasajero se sienta en " + numberSeat);
                } else {
                    System.out.println("El pasajero no se encuentra");
                }
            }
        } else {
            System.out.println("No existe el vuelo");
        }
    }

    //Opcion 5: Metodo para cambiar el asiento
    public void changeSeatFlight (){
        if (forFlight().getFlightNumber() == askNum()){
            if (forPassenger().getNif().equals(askNif())){
                if (forPassenger().getSeatNumber().equals(askNum())){
                    forPassenger().changeSeatNumber();
                }
            }
        }
    }

// -----


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Flight[] getFlights() {
        return flights;
    }

    public void setFlights(Flight[] flights) {
        this.flights = flights;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airline airline = (Airline) o;
        return Objects.equals(name, airline.name) && Objects.deepEquals(flights, airline.flights);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, Arrays.hashCode(flights));
    }

    @Override
    public String toString() {
        return "Airline{" +
                "name='" + name + '\'' +
                ", flights=" + Arrays.toString(flights) +
                '}';
    }
}
