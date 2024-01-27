package com.tamerm.FlightSearchApi.entities.concretes;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Airports")
@Getter
@Setter
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long airportID;

    @Column(name = "city", nullable = false)
    private String city;

}
