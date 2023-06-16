package org.api;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class SchemaValidation {
	@Test
	public void validation(){
		File reqBody = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\inputData.json");
		 Response response = RestAssured.given().baseUri("https://petstore3.swagger.io/").log().all()
		.header("Content-Type","application/json").body(reqBody).when().post("api/v3/store/order");
		 response.then()
	        .assertThat()
	        .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema.json"));

		
		
	}
 
	
}
//JsonSchemaValidator.matchesJsonSchemaInClasspath("schema.json")