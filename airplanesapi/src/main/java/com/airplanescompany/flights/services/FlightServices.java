package com.airplanescompany.flights.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airplanescompany.flights.domain.Flight;
import com.airplanescompany.flights.repository.FlightRepository;
import com.airplanescompany.flights.services.exception.FlightAlreadyExistsException;
import com.airplanescompany.flights.services.exception.FlightDoesNotExistsException;

@Service
public class FlightServices {

	@Autowired
	FlightRepository flightRepository;
	
	public List<Flight> listAll() {
		return flightRepository.findAll();
	}
	
	public Flight findById(Long id) {
		Flight flight = flightRepository.findOne(id);
		
		if (flight == null) {
			throw new FlightDoesNotExistsException("The flight could not be found");
		}
		
		return flight;
	}
	
	public Flight save(Flight flight) {
		Flight f = flightRepository.findOne(flight.getId());
		
		if (f != null) {
			throw new FlightAlreadyExistsException("The flight is already registered");
		}
		
		return flightRepository.save(flight);
	}
	
	public Flight update(Flight flight) {
		checkIfExists(flight);
		return flightRepository.save(flight);
	}
	
	public void delete(Long id) {
		checkIfExists(id);
		flightRepository.delete(id);
	}
	
	private void checkIfExists(Flight flight) {
		findById(flight.getId());
	}
	
	private void checkIfExists(Long id) {
		findById(id);
	}
}
