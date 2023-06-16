package org.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.utilities.BaseClass;
import org.utilities.EndPoint;
import org.utilities.StatusCode;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CSRFToken extends BaseClass {
	static Logger logger = Logger.getLogger(Authentication.class);
	Response response;

	/**
	 * @author Arunkumar.K
	 * @date 16/05/2023
	 * @see This method is used for post request with CSRF token authentication
	 */
	@Test
	public void postWithCsrfToken() {

		try {
			FileInputStream inputData = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\" + getPropertyValue("inputFileName"));

			Response response = RestAssured.given().header("cookie", getPropertyValue("Config.properties", "csrfToken"))
					.queryParam("user_id", getPropertyValue("zomatoUserId")).when().log().all().body(inputData)
					.post(EndPoint.csrfToken);
			logger.info(response.getStatusCode());
			Assert.assertEquals(response.getStatusCode(), StatusCode.OK.getCode());
			Assert.assertTrue(response.getBody().asString().contains("ok"));
		} catch (FileNotFoundException exception) {
			logger.error("postWith CSRF token is not performed" + exception);
		}

	}
}
