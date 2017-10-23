package com.airplanescompany.flights.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.airplanescompany.flights.domain.Pilot;
import com.airplanescompany.flights.services.PilotServices;

@RestController
@RequestMapping("/pilots")
public class PilotResources {
	
	@Autowired
	PilotServices pilotServices;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Pilot>> listAll() {
		return ResponseEntity.status(HttpStatus.OK).body(pilotServices.listAll());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Pilot> findById(@PathVariable("id") Long id) {
		Pilot pilot = pilotServices.findById(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(pilot);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody Pilot pilot) {
		Pilot pilotSaved = pilotServices.save(pilot);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(pilotSaved.getId()).toUri();
		
		return ResponseEntity.created(uri).build();		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Pilot pilot, @PathVariable("id") Long id) {
		pilot.setId(id);
		pilotServices.update(pilot);
				
		return ResponseEntity.noContent().build();	
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		pilotServices.delete(id);
		
		return ResponseEntity.noContent().build();
	}
}
