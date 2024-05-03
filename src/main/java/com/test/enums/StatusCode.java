package com.test.enums;

public enum StatusCode {

	CODE_200(200, ""), 
	CODE_201(201, "");

	private int code;
	private String message;

	private StatusCode(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}
