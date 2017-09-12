package com.airplanescompany.flights.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airplanescompany.flights.domain.Airplane;
import com.airplanescompany.flights.repository.AirplanesRepository;

@Service
public class AirplaneServices {

	@Autowired
	AirplanesRepository airplanesRepository;
	
	public List<Airplane> listar() {
		return airplanesRepository.findAll();
	}
	
	public Airplane buscar(Long id) {
		return airplanesRepository.findOne(id);
	}
	
	//salvar
	
	//atualizar
	
	//deletar
}
