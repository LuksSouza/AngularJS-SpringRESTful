package com.airplanescompany.flights.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airplanescompany.flights.domain.Pilot;

public interface PilotRepository extends JpaRepository<Pilot, Long> {

}
