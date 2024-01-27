package com.tamerm.FlightSearchApi.entities.concretes;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "Flights")
@Getter
@Setter
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long flightID;

    @ManyToOne
    @JoinColumn(name = "departureAirportID", nullable = false)
    private Airport departureAirport;

    @ManyToOne
    @JoinColumn(name = "arrivalAirportID", nullable = false)
    private Airport arrivalAirport;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "departureDateTime", nullable = false)
    private Date departureDateTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "returnDateTime", nullable = false)
    private Date returnDateTime;

    @Column(name = "price", nullable = false)
    private Double price;
}
