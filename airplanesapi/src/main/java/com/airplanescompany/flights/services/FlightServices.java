package com.airplanescompany.flights.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airplanescompany.flights.domain.Flight;
import com.airplanescompany.flights.repository.FlightRepository;

@Service
public class FlightServices {

	@Autowired
	FlightRepository flightRepository;
	
	public List<Flight> listar() {
		return flightRepository.findAll();
	}
	
	public Flight buscar(Long id) {
		return flightRepository.findOne(id);
	}
}
