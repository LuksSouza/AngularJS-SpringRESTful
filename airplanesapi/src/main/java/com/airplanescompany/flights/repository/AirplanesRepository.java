package com.airplanescompany.flights.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airplanescompany.flights.domain.Airplane;

public interface AirplanesRepository extends JpaRepository<Airplane, Long> {

}
