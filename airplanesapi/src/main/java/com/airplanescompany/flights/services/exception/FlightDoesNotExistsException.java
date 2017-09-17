package com.airplanescompany.flights.services.exception;

public class FlightDoesNotExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FlightDoesNotExistsException(String message) {
		super(message);
	}
	
	public FlightDoesNotExistsException(String message, Throwable cause) {
		super(message, cause);
	}
}
