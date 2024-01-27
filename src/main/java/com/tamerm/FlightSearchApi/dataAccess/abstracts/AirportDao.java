package com.tamerm.FlightSearchApi.dataAccess.abstracts;

import com.tamerm.FlightSearchApi.entities.concretes.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AirportDao extends JpaRepository<Airport, Long> {

}
