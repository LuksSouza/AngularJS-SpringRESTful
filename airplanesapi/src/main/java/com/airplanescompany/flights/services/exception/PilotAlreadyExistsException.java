package com.airplanescompany.flights.services.exception;

public class PilotAlreadyExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PilotAlreadyExistsException(String message) {
		super(message);
	}
	
	public PilotAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
	}
}
