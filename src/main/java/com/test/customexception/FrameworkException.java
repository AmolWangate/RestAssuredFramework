package com.test.customexception;

public class FrameworkException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7494611676888145409L;

	public FrameworkException(String message) {
		super(message);
	}

	public FrameworkException(String message, Throwable cause) {
		super(message, cause);
	}

}
