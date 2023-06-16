package org.api;

import org.testng.annotations.Test;
import org.utilities.APIBaseClass;

import io.restassured.RestAssured;

public class OauthAthentication extends APIBaseClass {

	@Test
	public void getAccessToken() {

//		Response response = RestAssured.given().when().auth().preemptive()
//				.basic(getPropertyValue("userName"), getPropertyValue("passWord"))
//				.param("Grant Type", "Authorization Code")
//				.param("callbackUrl", getPropertyValue("callBackUrl"))
//				.params("AuthURL", getPropertyValue("authUrl"))
//				.params("AccessTokenUrl", getPropertyValue("accessTokenUrl"))
//				.param("Scope", getPropertyValue("scope"))
//				.log().all().post(getPropertyValue("postUrl"));
//
//		response.prettyPrint();
//		System.out.println("Status Code " + response.statusCode());
		
RestAssured.given().auth().oauth2(getPropertyValue("accessToken"))
	 .when().get(getPropertyValue("postUrl")).prettyPrint();
	
	 
	}

}
