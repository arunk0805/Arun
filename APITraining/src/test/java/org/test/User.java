package org.test;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.utilities.APIBaseClass;
import org.utilities.EndPoint;
import org.utilities.StatusCode;

import io.restassured.response.Response;

public class User extends APIBaseClass {
	Logger logger = Logger.getLogger(Pet.class);

	@Test
	public void getUserByUserName() {
		try {
			Response response = getMethod(EndPoint.getUserByUserName, getPropertyValue("userName"));
			Assert.assertEquals(response.getStatusCode(), StatusCode.OK.getCode());
			Assert.assertTrue(response.getBody().asString().contains("James"));
			logger.info(response.getBody().asPrettyString());
			logger.info("Request body contains  name as James");
			logger.info("Successfully find the user by username");

		} catch (Exception exception) {
			exception.printStackTrace();
		}

	}

}
