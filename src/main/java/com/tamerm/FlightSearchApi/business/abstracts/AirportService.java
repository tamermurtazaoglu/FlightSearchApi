package com.tamerm.FlightSearchApi.business.abstracts;

import com.tamerm.FlightSearchApi.entities.concretes.Airport;

import java.util.List;

public interface AirportService {
    Airport getAirportById(Long airportID);

    List<Airport> getAllAirports();

    Airport createAirport(Airport airport);

    Airport updateAirport(Long airportID, Airport updatedAirport);

    void deleteAirport(Long airportID);
}
