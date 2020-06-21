package com.bluewhale.bus.exception;

public class InvalidPasswordException extends RuntimeException {
	private String message;

	public InvalidPasswordException(final String message) {
		if (message == null) {
			throw new RuntimeException("Message cannot be null");
		}
		this.message = message;
	}
}
