package com.tamerm.FlightSearchApi.core.utilities.adapters;

import com.tamerm.FlightSearchApi.business.abstracts.FlightService;
import com.tamerm.FlightSearchApi.core.utilities.externals.MockApiUtil.MockApiUtil;
import com.tamerm.FlightSearchApi.entities.concretes.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FlightDataFetcher {
    private final FlightService flightService;

    @Autowired
    public FlightDataFetcher(FlightService flightService) {
        this.flightService = flightService;
    }


    @Scheduled(cron = "0 0 0 * * ?") // Set to run every day at 00:00.
    public void fetchAndSaveFlightData() {
        List<Flight> mockFlightData = MockApiUtil.fetchMockFlightData();

        for (Flight flight : mockFlightData) {
            flightService.createFlight(flight);
        }
    }
}
