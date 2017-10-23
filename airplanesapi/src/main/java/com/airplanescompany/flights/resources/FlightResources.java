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

import com.airplanescompany.flights.domain.Flight;
import com.airplanescompany.flights.services.FlightServices;

@RestController
@RequestMapping("/flights")
public class FlightResources {

	@Autowired
	FlightServices flightServices;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Flight>> listAll() {
		return ResponseEntity.status(HttpStatus.OK).body(flightServices.listAll());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Flight> findById(@PathVariable("id") Long id) {
		Flight flight = flightServices.findById(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(flight);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody Flight flight) {
		Flight flightSaved = flightServices.save(flight);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(flightSaved.getId()).toUri();
		
		return ResponseEntity.created(uri).build();		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Flight flight, @PathVariable("id") Long id) {
		flight.setId(id);
		flightServices.update(flight);
				
		return ResponseEntity.noContent().build();	
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		flightServices.delete(id);
		
		return ResponseEntity.noContent().build();
	}
}
