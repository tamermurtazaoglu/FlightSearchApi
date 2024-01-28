package com.tamerm.FlightSearchApi.entities.concretes;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Airports")
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long airportID;

    @Column(name = "city", nullable = false)
    private String city;

    public Airport(String arrivalAirportCode, String arrivalCity) {
    }
}
