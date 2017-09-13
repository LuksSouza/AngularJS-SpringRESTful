package com.airplanescompany.flights.services.exception;

public class AirplaneAlreadyExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AirplaneAlreadyExistsException(String message) {
		super(message);
	}
	
	public AirplaneAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
	}
}
