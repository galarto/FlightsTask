package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();
        flights.stream()
                .filter(flight -> !flight.getSegment(0).getDepartureDate().isBefore(LocalDateTime.now()))
                .forEach(System.out::println);
        flights.stream()
                .filter(Flight::isValidSegments).forEach(System.out::println);
        flights.stream().filter(flight -> flight.getGroundTime() < 2).forEach(System.out::println);

    }
}