package com.airplanescompany.flights.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.airplanescompany.flights.domain.Pilot;
import com.airplanescompany.flights.services.PilotServices;

@RestController
@RequestMapping("/pilots")
public class PilotResources {
	
	@Autowired
	PilotServices pilotServices;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Pilot>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(pilotServices.listar());
	}

}
