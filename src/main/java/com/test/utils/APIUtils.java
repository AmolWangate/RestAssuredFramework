package com.test.utils;

import static com.test.constants.Route.API;
import static com.test.constants.Route.TOKEN;
import static io.restassured.RestAssured.given;

import java.util.Map;

import com.test.builder.SpecBuilder;
import com.test.extentreport.ExtentLogger;
import com.test.manager.TokenManager;
import com.test.pojo.PlayList;

import io.restassured.config.Config;
import io.restassured.config.LogConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;

public final class APIUtils {

	private APIUtils() {
		
	}
	
	public static Response get(String path) {
		Response response= given(SpecBuilder.requestSpecBuilder())
				.when()
				.auth()
				.oauth2(TokenManager.getToken())
				.get(path)
				.then()
				.spec(SpecBuilder.responseSpecBuilder())
				.extract()
				.response();
		
		ExtentLogger.info(response.prettyPrint());
		return response;
	}
	
	public static Response post(String path, Object requestedPlayList) {
		Response response= given(SpecBuilder.requestSpecBuilder())
				.body(requestedPlayList)
				.when()
				.auth()
				.oauth2(TokenManager.getToken())
				.post(path)
				.then()
				.spec(SpecBuilder.responseSpecBuilder())
				.extract()
				.response();
		ExtentLogger.info(response.prettyPrint());
		return response;
	}
	
	public static Response put(String path, PlayList requestedPlayList) {
		return given(SpecBuilder.requestSpecBuilder())
				.body(requestedPlayList)
				.when()
				.auth()
				.oauth2(TokenManager.getToken())
				.put(path)
				.then()
				.spec(SpecBuilder.responseSpecBuilder())
				.extract()
				.response();
	}
	
	public static Response postAccount(Map<String, String> formParams) {
		Response response= given(SpecBuilder.accountRequestSpecBuilder())
				.formParams(formParams)
				.when()
				.post(API + TOKEN)
				.then()
				.spec(SpecBuilder.responseSpecBuilder())
				.extract()
				.response();
		ExtentLogger.info(response.prettyPrint());
		return response;
	}
}
