package com.tamerm.FlightSearchApi.business.concretes;

import com.tamerm.FlightSearchApi.business.abstracts.FlightService;
import com.tamerm.FlightSearchApi.dataAccess.abstracts.FlightDao;
import com.tamerm.FlightSearchApi.entities.concretes.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightManager implements FlightService {

    private final FlightDao flightDao;

    @Autowired
    public FlightManager(FlightDao flightDao) {
        this.flightDao = flightDao;
    }

    @Override
    public Flight getFlightById(Long flightID) {
        return flightDao.findById(flightID).orElse(null);
    }

    @Override
    public List<Flight> getAllFlights() {
        return flightDao.findAll();
    }

    @Override
    public Flight createFlight(Flight flight) {
        return flightDao.save(flight);
    }

    @Override
    public Flight updateFlight(Long flightID, Flight updatedFlight) {
        Flight existingFlight = flightDao.findById(flightID).orElse(null);

        if (existingFlight != null) {
            existingFlight.setDepartureAirport(updatedFlight.getDepartureAirport());
            existingFlight.setArrivalAirport(updatedFlight.getArrivalAirport());
            existingFlight.setDepartureDateTime(updatedFlight.getDepartureDateTime());
            existingFlight.setReturnDateTime(updatedFlight.getReturnDateTime());
            existingFlight.setPrice(updatedFlight.getPrice());

            return flightDao.save(existingFlight);
        }

        return null; // or a suitable error condition is handled
    }

    @Override
    public void deleteFlight(Long flightID) {
        flightDao.deleteById(flightID);
    }


    public List<Flight> findFlightsByCriteria(Long departureAirportId, Long arrivalAirportId,
                                              String departureDateTime, String returnDateTime) {
        return flightDao.findFlightsByCriteria(departureAirportId, arrivalAirportId, departureDateTime, returnDateTime);
    }
}
