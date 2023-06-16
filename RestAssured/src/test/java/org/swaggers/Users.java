package org.swaggers;

import org.apache.log4j.Logger;
import org.build.CreateUserBuild;
import org.build.UpdateUserBuild;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.utilities.BaseClass;
import org.utilities.EndPoint;
import org.utilities.StatusCode;

import io.restassured.response.Response;

public class Users extends BaseClass {
	static Logger logger = Logger.getLogger(Activities.class);
	String id;

	@Test
	public void userDetails() {
		try {
			String postReqBody = CreateUserBuild.createUserData(getPropertyValue("userSheetName"), getPropertyValue("postTestCaseId"));
			Response postMethod = postMethod(postReqBody, EndPoint.createUser);
			Assert.assertEquals(postMethod.getStatusCode(), StatusCode.OK.getCode());
			Assert.assertTrue(postMethod.getBody().asString().contains("arun1997"));
			logger.info(postMethod.statusCode() + "\nNew Activities Created");
			id = postMethod.jsonPath().getString("id");
			logger.info(id);

		} catch (Exception exception) {
			logger.error("postMethod is not performed" + exception);

		}
		// get Method
		try {
			Response getBooks = getMethod(EndPoint.getBooks, "id", "7");
			Assert.assertEquals(getBooks.getStatusCode(), StatusCode.OK.getCode());
			Assert.assertTrue(getBooks.getBody().asString().contains("7"));
			logger.info(getBooks.statusCode() + "\n New user details Displayed");

		} catch (Exception exception) {
			logger.error("getMethod is not performed" + exception);

		}
		try {
			String putReqBody = UpdateUserBuild.updateUserData(getPropertyValue("userSheetName"),getPropertyValue("putTestCaseId"));
			Response putMethod = putMethod(putReqBody, EndPoint.updateUser, "id", "7");
			System.out.println(putMethod.getStatusCode());
			Assert.assertEquals(putMethod.getStatusCode(), StatusCode.OK.getCode());
			Assert.assertTrue(putMethod.getBody().asString().contains("arun1234"));
			logger.info(putMethod.statusCode() + "\n New Activities Updated");
			
		} catch (Exception exception) {
			logger.error("putMethod is not performed" + exception);

		}
		try {
			Response deleteMethod = deleteMethod(EndPoint.deleteUser, "id", "8");
			Assert.assertEquals(deleteMethod.getStatusCode(), StatusCode.OK.getCode());
			logger.info(deleteMethod.statusCode() + "\n New Activities Deleted");

		} catch (Exception exception) {
			logger.error("deleteMethod is not performed" + exception);
		}


	}

}
