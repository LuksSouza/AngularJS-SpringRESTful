package com.airplanescompany.flights.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.airplanescompany.flights.domain.ErrorDetails;
import com.airplanescompany.flights.services.exception.AirplaneAlreadyExistsException;
import com.airplanescompany.flights.services.exception.AirplaneDoesNotExistsException;
import com.airplanescompany.flights.services.exception.FlightAlreadyExistsException;
import com.airplanescompany.flights.services.exception.FlightDoesNotExistsException;
import com.airplanescompany.flights.services.exception.PilotAlreadyExistsException;
import com.airplanescompany.flights.services.exception.PilotDoesNotExistsException;

@ControllerAdvice
public class ResourceHandlerException {

	@ExceptionHandler(AirplaneDoesNotExistsException.class)
	public ResponseEntity<ErrorDetails> handlerLivroNaoEncontradoExceptio
				(AirplaneDoesNotExistsException e, HttpServletRequest request) {
		
		ErrorDetails error = new ErrorDetails();
		error.setStatus(404l);
		error.setTitle("The airplane could not be found");
		error.setDeveloperMessage("page under construction");
		error.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@ExceptionHandler(AirplaneAlreadyExistsException.class)
	public ResponseEntity<ErrorDetails> handlerAutorExistenteException
				(AirplaneAlreadyExistsException e, HttpServletRequest request) {
		
		ErrorDetails error = new ErrorDetails();
		error.setStatus(409l);
		error.setTitle("The airplane is already registered");
		error.setDeveloperMessage("page under construction");
		error.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
	}
	
	@ExceptionHandler(PilotDoesNotExistsException.class)
	public ResponseEntity<ErrorDetails> handlerPilotDoesNotExistsException
				(PilotDoesNotExistsException e, HttpServletRequest request) {
		
		ErrorDetails error = new ErrorDetails();
		error.setStatus(404l);
		error.setTitle("The pilot could not be found");
		error.setDeveloperMessage("page under construction");
		error.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@ExceptionHandler(PilotAlreadyExistsException.class)
	public ResponseEntity<ErrorDetails> handlerPilotAlreadyExistsException
				(PilotAlreadyExistsException e, HttpServletRequest request) {
		
		ErrorDetails error = new ErrorDetails();
		error.setStatus(409l);
		error.setTitle("The pilot is already registered");
		error.setDeveloperMessage("page under construction");
		error.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
	}
	
	@ExceptionHandler(FlightDoesNotExistsException.class)
	public ResponseEntity<ErrorDetails> handlerFlightDoesNotExistsException
				(FlightDoesNotExistsException e, HttpServletRequest request) {
		
		ErrorDetails error = new ErrorDetails();
		error.setStatus(404l);
		error.setTitle("The flight could not be found");
		error.setDeveloperMessage("page under construction");
		error.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@ExceptionHandler(FlightAlreadyExistsException.class)
	public ResponseEntity<ErrorDetails> handlerFlightAlreadyExistsException
				(FlightAlreadyExistsException e, HttpServletRequest request) {
		
		ErrorDetails error = new ErrorDetails();
		error.setStatus(409l);
		error.setTitle("The flight is already registered");
		error.setDeveloperMessage("page under construction");
		error.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
	}
}
