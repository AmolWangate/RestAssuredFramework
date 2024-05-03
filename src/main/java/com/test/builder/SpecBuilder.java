package com.test.builder;

import org.aeonbits.owner.ConfigFactory;

import com.test.constants.Route;
import com.test.iowner.IConfig;
import com.test.manager.TokenManager;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static com.test.constants.Route.*;

public final class SpecBuilder {

	private SpecBuilder() {
		
	}
	
	private static IConfig iconfig=ConfigFactory.create(IConfig.class);
	
	public static RequestSpecification requestSpecBuilder() {
		return new RequestSpecBuilder()
				.setBaseUri(iconfig.baseuri())
				.setBasePath(BASE_PATH)
				.setContentType(ContentType.JSON)
				.log(LogDetail.ALL)
				.build();
		
	}
	
	public static ResponseSpecification responseSpecBuilder() {
		return new ResponseSpecBuilder()
				.expectContentType(ContentType.JSON)
				.log(LogDetail.ALL)
				.build();
	}
	
	public static RequestSpecification accountRequestSpecBuilder() {
		return new RequestSpecBuilder()
				.setBaseUri(iconfig.accounturi())
				.setContentType(ContentType.URLENC)
				.log(LogDetail.ALL)
				.build();
		
	}
}
