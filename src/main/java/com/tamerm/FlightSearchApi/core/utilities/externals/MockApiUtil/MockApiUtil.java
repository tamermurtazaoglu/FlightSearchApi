package com.tamerm.FlightSearchApi.core.utilities.externals.MockApiUtil;

import com.tamerm.FlightSearchApi.entities.concretes.Airport;
import com.tamerm.FlightSearchApi.entities.concretes.Flight;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MockApiUtil {

    public static List<Flight> fetchMockFlightData() {

        List<Flight> mockFlights = new ArrayList<>();

        mockFlights.add(createMockFlight("IST", "MIA", new Date(), null, 140.0));
        mockFlights.add(createMockFlight("TMR", "AMD", new Date(), new Date(), 200.0));

        return mockFlights;
    }

    private static Flight createMockFlight(String departureAirportCode, String arrivalAirportCode,
                                           Date departureDateTime, Date returnDateTime, double price) {
        Flight flight = new Flight();
        flight.setDepartureAirport(new Airport(departureAirportCode, "Departure city"));
        flight.setArrivalAirport(new Airport(arrivalAirportCode, "Arrival city"));
        flight.setDepartureDateTime(departureDateTime);
        flight.setReturnDateTime(returnDateTime);
        flight.setPrice(price);
        return flight;
    }
}
