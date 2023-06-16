package org.swaggers;

import org.apache.log4j.Logger;
import org.build.CreateActivityBuild;
import org.build.UpdateActivityBuild;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.utilities.BaseClass;
import org.utilities.EndPoint;
import org.utilities.StatusCode;

import io.restassured.response.Response;

public class Activities extends BaseClass {

	static Logger logger = Logger.getLogger(Activities.class);
	String id;

	@Test
	public void createActivity() {
		try {
			Object postRequestBody = CreateActivityBuild.newActivityData( getPropertyValue("activitySheetName"), getPropertyValue("postTestCaseId"));
			Response response = postMethod(postRequestBody, EndPoint.createActivities);
			Assert.assertEquals(response.getStatusCode(), StatusCode.OK.getCode());
			Assert.assertTrue(response.getBody().asString().contains("Cricket"));
			logger.info(response.statusCode() + "\nNew Activities Created");
			id = response.jsonPath().getString("id");
			logger.info(id);
		
			try {
				schemaValidation(response, "activitySchema.json");
				logger.info("Schema validate Successfully");

			} catch (Exception exception) {
				logger.error("Schema is Not Validated  Schema is missing " + exception);

			}


		} catch (Exception exception) {
			logger.error("postMethod is not performed" + exception);

		}
	

		// get by id

		try {
			
			Response getActivity = getMethod(EndPoint.getActivities, "id", "7");
			Assert.assertEquals(getActivity.getStatusCode(), StatusCode.OK.getCode());
			Assert.assertTrue(getActivity.getBody().asString().contains("7"));
			logger.info(getActivity.statusCode() + "\n New Activities Displayed");
			try {
				schemaValidation(getActivity, "activitySchema.json");
				logger.info("Schema validate Successfully");

			} catch (Exception exception) {
				logger.error("Schema is Not Validated  Schema is missing " + exception);

			}

		} catch (Exception exception) {
			logger.error("getMethod is not performed" + exception);

		}
		// Put by id
		try {
			Object putRequestBody = UpdateActivityBuild.updateActivityData("Activity", "TC02");
			Response putMethod = putMethod(putRequestBody, EndPoint.updateActivities, "id", "7");
			Assert.assertEquals(putMethod.getStatusCode(), StatusCode.OK.getCode());
			Assert.assertTrue(putMethod.getBody().asString().contains("Football"));
			logger.info(putMethod.statusCode() + "\n New Activities Updated");
			try {
				schemaValidation(putMethod, "activitySchema.json");
				logger.info("Schema validate Successfully");

			} catch (Exception exception) {
				logger.error("Schema is Not Validated  Schema is missing " + exception);

			}

		} catch (Exception exception) {
			logger.error("putMethod is not performed" + exception);

		}

		// delete by id

		try {
			Response deleteMethod = deleteMethod(EndPoint.deleteActivities, "id", "7");
			Assert.assertEquals(deleteMethod.getStatusCode(), StatusCode.OK.getCode());
			logger.info(deleteMethod.statusCode() + "\n New Activities Deleted");

		} catch (Exception exception) {
			logger.error("deleteMethod is not performed" + exception);
		}

	}

}
