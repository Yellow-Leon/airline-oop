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

    public String askNif(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduzca el nif del pasajero");
        return scanner.nextLine();
    }

    public void searchFlight (int flightNumber){
        for (Flight flight: flights){
            if (flightNumber == flight.getFlightNumber()){
                flight.searchPassenger(askNif());
                break;
            }
        }
        System.out.println("No existe ese vuelo");
    }

    public void showFlights (){
        for (Flight flight: flights){
            System.out.println(flight);
        }
    }

    public void showFlightOrigin (String origin){
        for (Flight flight: flights){
            if (flight.getOrigin().equals(origin)){
                System.out.println(flight);
            }
        }
    }

    public void showPassengerSeat (int fligthNumber, String nif){
        for (Flight flight: flights){
            if (flight.getFlightNumber() == fligthNumber){
                for (Passenger passenger: flight.getPassengers()){
                    if (passenger.getNif().equals(nif)){
                        System.out.println(passenger);
                    }
                }
            }
        }
    }


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
