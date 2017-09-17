package com.airplanescompany.flights.services.exception;

public class AirplaneDoesNotExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AirplaneDoesNotExistsException(String message) {
		super(message);
	}
	
	public AirplaneDoesNotExistsException(String message, Throwable cause) {
		super(message, cause);
	}
}
