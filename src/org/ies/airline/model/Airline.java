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
    // Opcion 2 : Devuelve un vuelo segun el origen
    public Flight returnFlightOrigin(String origin) {
        for (var flight : flights) {
            if (flight.getOrigin().equals(origin)) {
                return flight;
            }
        }
        return null;
    }

    //Opcion 3 : Devuelve un pasajero segun su nif
    public Passenger returnThisPassengerFlight(String nif) {
        for (var flight : flights) {
            for (var passenger : flight.getPassengers())
                if (passenger.getNif().equals(nif)) {
                    return passenger;
                }
        }
        return null;
    }

    //Opcion 4 : Devuelve un pasajero segun el numero de su asiento
    public Flight returnFlightByNumber(int flightNumber) {
        for (var flight : flights) {
            if (flight.getFlightNumber() == flightNumber) {
                return flight;
            }
        }
        return null;
    }

    public Integer returnPassengerSeat(int flightNumber) {
        Flight flight = returnFlightByNumber(flightNumber);
        if (flight != null) {
            Passenger passenger = returnThisPassengerFlight(askNif());
            return passenger.getSeatNumber();
        }
        return null;
    }


    //Pregunta NIF
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

//---------


// Metodo para App1

    // Metodo para buscar un vuelo -- Usa otro metodo ubicado en la clase Passengar

//-------

// Metodos para app principal

    // Opcion 1: Metodo para ver todos los vuelos

    public void showAllFlights() {
        for (var flight : flights) {
            System.out.println(flight);
        }
    }

    // Opcion 2: Metodo para ver todos los vuelos por origen

    public void showFlightForOrigin(String origin) {
        System.out.println(returnFlightOrigin(origin));
    }

    // Opcion 3: Metodo para ver el vuelo de un pasajero

    public void showThisPassengerFlight(String nif) {
        System.out.println(returnThisPassengerFlight(nif));
    }

    // Opcion 4: Metodo para ver el asiento de un pasajero

    public void seePassengerSeat(Integer seatNumber) {
        System.out.println(returnPassengerSeat(seatNumber));
    }

    //Opcion 5: Metodo para cambiar el asiento
    public void changePassengerSeat(){
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
