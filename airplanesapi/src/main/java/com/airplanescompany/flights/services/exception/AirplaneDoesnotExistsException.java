package com.airplanescompany.flights.services.exception;

public class AirplaneDoesnotExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AirplaneDoesnotExistsException(String message) {
		super(message);
	}
	
	public AirplaneDoesnotExistsException(String message, Throwable cause) {
		super(message, cause);
	}
}
