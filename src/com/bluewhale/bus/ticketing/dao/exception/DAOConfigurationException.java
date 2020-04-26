package com.bus.ticketing.dao.exception;

public class DAOConfigurationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DAOConfigurationException(String message) {
		super(message);
	}

	public DAOConfigurationException(Throwable cause) {
		super(cause);
	}

	public DAOConfigurationException(String message, Throwable cause) {
		super(message, cause);
	}

}
