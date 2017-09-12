package com.airplanescompany.flights.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airplanescompany.flights.domain.Pilot;
import com.airplanescompany.flights.repository.PilotRepository;

@Service
public class PilotServices {

	@Autowired
	PilotRepository pilotRepository;
	
	public List<Pilot> listar() {
		return pilotRepository.findAll();
	}
	
	public Pilot buscar(Long id) {
		return pilotRepository.findOne(id);
	}
}
