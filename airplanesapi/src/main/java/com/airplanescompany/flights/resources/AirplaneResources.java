package com.airplanescompany.flights.resources;

import java.net.URI;
import java.util.List;

import org.apache.catalina.valves.rewrite.Substitution.ServerVariableEnvElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.airplanescompany.flights.domain.Airplane;
import com.airplanescompany.flights.services.AirplaneServices;

@RestController
@RequestMapping("/airplanes")
public class AirplaneResources {

	@Autowired
	AirplaneServices airplaneServices;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Airplane>> listAll() {
		List<Airplane> airplanes = airplaneServices.listAll();
		return ResponseEntity.status(HttpStatus.OK).body(airplanes);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Airplane> findById(@PathVariable("id") Long id) {
		Airplane airplane = airplaneServices.findById(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(airplane);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody Airplane airplane) {
		Airplane airplaneSaved = airplaneServices.save(airplane);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(airplaneSaved.getId()).toUri();
		
		return ResponseEntity.created(uri).build();		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Airplane airplane, @PathVariable("id") Long id) {
		airplane.setId(id);
		airplaneServices.update(airplane);
				
		return ResponseEntity.noContent().build();	
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		airplaneServices.delete(id);
		
		return ResponseEntity.noContent().build();
	}
}
