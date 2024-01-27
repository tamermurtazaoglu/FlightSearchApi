package com.tamerm.FlightSearchApi.business.abstracts;

import com.tamerm.FlightSearchApi.entities.concretes.Flight;

import java.util.List;

public interface FlightService {
    Flight getFlightById(Long flightID);

    List<Flight> getAllFlights();

    Flight createFlight(Flight flight);

    Flight updateFlight(Long flightID, Flight updatedFlight);

    void deleteFlight(Long flightID);
    List<Flight> findFlightsByCriteria(Long departureAirportId, Long arrivalAirportId,
                                       String departureDateTime, String returnDateTime);
}
