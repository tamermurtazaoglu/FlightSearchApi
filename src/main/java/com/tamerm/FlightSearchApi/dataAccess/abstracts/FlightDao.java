package com.tamerm.FlightSearchApi.dataAccess.abstracts;

import com.tamerm.FlightSearchApi.entities.concretes.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightDao extends JpaRepository<Flight, Long> {
    @Query(value = "SELECT * FROM flights f " +
            "WHERE f.departure_airport_id = :departureAirportId " +
            "AND f.arrival_airport_id = :arrivalAirportId " +
            "AND f.departure_date_time >= :departureDateTime " +
            "AND (f.return_date_time <= :returnDateTime OR :returnDateTime IS NULL)",
            nativeQuery = true)
    List<Flight> findFlightsByCriteria(@Param("departureAirportId") Long departureAirportId,
                                       @Param("arrivalAirportId") Long arrivalAirportId,
                                       @Param("departureDateTime") String departureDateTime,
                                       @Param("returnDateTime") String returnDateTime);

}
