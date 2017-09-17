package com.airplanescompany.flights.services.exception;

public class PilotDoesNotExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PilotDoesNotExistsException(String message) {
		super(message);
	}
	
	public PilotDoesNotExistsException(String message, Throwable cause) {
		super(message, cause);
	}
}
