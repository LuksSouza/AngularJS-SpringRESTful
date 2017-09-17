package com.airplanescompany.flights.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airplanescompany.flights.domain.Airplane;
import com.airplanescompany.flights.repository.AirplanesRepository;
import com.airplanescompany.flights.services.exception.AirplaneAlreadyExistsException;
import com.airplanescompany.flights.services.exception.AirplaneDoesNotExistsException;

@Service
public class AirplaneServices {

	@Autowired
	AirplanesRepository airplanesRepository;
	
	public List<Airplane> listAll() {
		return airplanesRepository.findAll();
	}
	
	public Airplane findById(Long id) {
		Airplane airplane = airplanesRepository.findOne(id);
		
		if (airplane == null) {
			throw new AirplaneDoesNotExistsException("The airplane could not be found");
		}
		
		return airplanesRepository.findOne(id);
	}
	
	public Airplane save(Airplane airplane) {
		Airplane a = airplanesRepository.findOne(airplane.getId());
		
		if (a != null) {
			throw new AirplaneAlreadyExistsException("The airplane is already registered");
		}
		
		return airplanesRepository.save(airplane);
	}
	
	public void update(Airplane airplane) {
		checkIfExists(airplane);
		airplanesRepository.save(airplane);
	}
	
	public void delete(Long id) {
		checkIfExists(id);
		airplanesRepository.delete(id);
	}

	private void checkIfExists(Airplane airplane) {
		findById(airplane.getId());
	}
	
	private void checkIfExists(Long id) {
		findById(id);
	}
}
