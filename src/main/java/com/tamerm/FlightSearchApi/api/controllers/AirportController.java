package com.tamerm.FlightSearchApi.api.controllers;

import com.tamerm.FlightSearchApi.business.abstracts.AirportService;
import com.tamerm.FlightSearchApi.entities.concretes.Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/airports")
public class AirportController {
    private final AirportService airportService;

    @Autowired
    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @GetMapping("/{airportID}")
    public Airport getAirportById(@PathVariable Long airportID) {
        return airportService.getAirportById(airportID);
    }

    @GetMapping("/all")
    public List<Airport> getAllAirports() {
        return airportService.getAllAirports();
    }

    @PostMapping("/create")
    public Airport createAirport(@RequestBody Airport airport) {
        return airportService.createAirport(airport);
    }

    @PutMapping("/update/{airportID}")
    public Airport updateAirport(@PathVariable Long airportID, @RequestBody Airport updatedAirport) {
        return airportService.updateAirport(airportID, updatedAirport);
    }

    @DeleteMapping("/delete/{airportID}")
    public void deleteAirport(@PathVariable Long airportID) {
        airportService.deleteAirport(airportID);
    }


}
