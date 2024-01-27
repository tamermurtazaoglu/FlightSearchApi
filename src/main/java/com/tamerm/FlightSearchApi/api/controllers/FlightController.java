package com.tamerm.FlightSearchApi.api.controllers;

import com.tamerm.FlightSearchApi.business.abstracts.FlightService;
import com.tamerm.FlightSearchApi.entities.concretes.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/flights")
public class FlightController {
    private final FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/{flightID}")
    public Flight getFlightById(@PathVariable Long flightID) {
        return flightService.getFlightById(flightID);
    }

    @GetMapping("/all")
    public List<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }

    @PostMapping("/create")
    public Flight createFlight(@RequestBody Flight flight) {
        return flightService.createFlight(flight);
    }

    @PutMapping("/update/{flightID}")
    public Flight updateFlight(@PathVariable Long flightID, @RequestBody Flight updatedFlight) {
        return flightService.updateFlight(flightID, updatedFlight);
    }

    @DeleteMapping("/delete/{flightID}")
    public void deleteFlight(@PathVariable Long flightID) {
        flightService.deleteFlight(flightID);
    }

    @GetMapping("/search")
    public List<Flight> searchFlights(@RequestParam Long departureAirportId,
                                      @RequestParam Long arrivalAirportId,
                                      @RequestParam String departureDateTime,
                                      @RequestParam(required = false) String returnDateTime) {
        return flightService.findFlightsByCriteria(departureAirportId, arrivalAirportId, departureDateTime, returnDateTime);
    }
}
