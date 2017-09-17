package com.airplanescompany.flights.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airplanescompany.flights.domain.Pilot;
import com.airplanescompany.flights.repository.PilotRepository;
import com.airplanescompany.flights.services.exception.PilotAlreadyExistsException;
import com.airplanescompany.flights.services.exception.PilotDoesNotExistsException;

@Service
public class PilotServices {

	@Autowired
	PilotRepository pilotRepository;
	
	public List<Pilot> listAll() {
		return pilotRepository.findAll();
	}
	
	public Pilot findById(Long id) {
		Pilot pilot = pilotRepository.findOne(id);
		
		if (pilot == null) {
			throw new PilotDoesNotExistsException("The pilot could not be found");
		}
		
		return pilot;
	}
	
	public Pilot save(Pilot pilot) {
		Pilot p = pilotRepository.findOne(pilot.getId());
		
		if (p != null) {
			throw new PilotAlreadyExistsException("The pilot is already registered");
		}
		
		return pilotRepository.save(pilot);
	}
	
	public Pilot update(Pilot pilot) {
		checkIfExists(pilot);
		return pilotRepository.save(pilot);
	}
	
	public void delete(Long id) {
		checkIfExists(id);
		pilotRepository.delete(id);
	}
	
	private void checkIfExists(Pilot pilot) {
		findById(pilot.getId());
	}
	
	private void checkIfExists(Long id) {
		findById(id);
	}
}
