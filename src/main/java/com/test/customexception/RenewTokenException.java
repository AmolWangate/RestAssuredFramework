package com.test.customexception;

public class RenewTokenException extends RuntimeException {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2957103584417690957L;

	public RenewTokenException(String message) {
		super(message);
	}

	public RenewTokenException(String message, Throwable cause) {
		super(message, cause);
	}
}
