package com.test.assertions;

import static org.assertj.core.api.Assertions.assertThat;

import com.test.enums.StatusCode;

import io.restassured.response.Response;

public final class AssertionsUtil {

	private AssertionsUtil() {
		
	}
	
	public static void isEqualsTo(Response response, StatusCode expectedStatusCode) {
		assertThat(response.getStatusCode()).isEqualTo(expectedStatusCode.getCode());
	}
}
