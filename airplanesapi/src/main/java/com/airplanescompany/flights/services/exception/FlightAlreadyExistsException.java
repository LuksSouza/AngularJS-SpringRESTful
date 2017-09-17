package com.airplanescompany.flights.services.exception;

public class FlightAlreadyExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FlightAlreadyExistsException(String message) {
		super(message);
	}
	
	public FlightAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
	}
}
