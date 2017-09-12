package com.airplanescompany.flights.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airplanescompany.flights.domain.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {

}
