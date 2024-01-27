package com.tamerm.FlightSearchApi.business.concretes;

import com.tamerm.FlightSearchApi.business.abstracts.AirportService;
import com.tamerm.FlightSearchApi.dataAccess.abstracts.AirportDao;
import com.tamerm.FlightSearchApi.entities.concretes.Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportManager implements AirportService {

    private final AirportDao airportDao;

    @Autowired
    public AirportManager(AirportDao airportDao) {
        this.airportDao = airportDao;
    }

    @Override
    public Airport getAirportById(Long airportID) {
        return airportDao.findById(airportID).orElse(null);
    }

    @Override
    public List<Airport> getAllAirports() {
        return airportDao.findAll();
    }

    @Override
    public Airport createAirport(Airport airport) {
        return airportDao.save(airport);
    }

    @Override
    public Airport updateAirport(Long airportID, Airport updatedAirport) {
        Airport existingAirport = airportDao.findById(airportID).orElse(null);

        if (existingAirport != null) {
            existingAirport.setCity(updatedAirport.getCity());

            return airportDao.save(existingAirport);
        }

        return null; // or a suitable error condition is handled
    }

    @Override
    public void deleteAirport(Long airportID) {
        airportDao.deleteById(airportID);
    }



}
