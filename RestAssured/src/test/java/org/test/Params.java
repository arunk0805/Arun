package org.test;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.utilities.BaseClass;
import org.utilities.EndPoint;
import org.utilities.StatusCode;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.bytebuddy.asm.Advice.This;

public class Params extends BaseClass {
	static Logger logger = Logger.getLogger(OauthAthentication.class);
	Response response = null;

	/**
	 * @author Arunkumar.K
	 * @date 17/05/2023
	 * @see This method is used for post request with multi value option
	 */
	@Test
	public void multiValue() {
		try {
			response = RestAssured.given()
					.queryParam("q", getPropertyValue("location"), getPropertyValue("stateCode"),
							getPropertyValue("countryCode"))
					.queryParam("appid", getPropertyValue("apiKey")).when().log().all().post(EndPoint.multiValue);
			logger.info(response.body().asPrettyString());
			logger.info(response.getStatusCode());
			Assert.assertEquals(response.getStatusCode(), StatusCode.OK.getCode());
			Assert.assertTrue(response.body().asPrettyString().contains(getPropertyValue("location")));

		} catch (Exception exception) {
			logger.error("API-Key Authenication Not Successfull" + exception);

		} finally {
			if (response.statusCode() > 500) {
				logger.error("Internal Server Error");
			}
		}

	}

	/**
	 * @author Arunkumar.K
	 * @date 16/05/2023
	 * @see This method is used for post request with path params and query params
	 */

	@Test
	public void pathParams() {
		try {

			response = RestAssured.given().pathParam("petId", 7).queryParam("name", "Lion")
					.queryParam("status", "available").when().log().all().post(EndPoint.pathParam);
			logger.info(response.body().asPrettyString());
			logger.info(response.getStatusCode());
			Assert.assertEquals(response.getStatusCode(), StatusCode.OK.getCode());
			Assert.assertTrue(response.body().asPrettyString().contains(getPropertyValue("petName")));

		} catch (Exception exception) {
			logger.error("pathParams not performed" + exception);
		} finally {
			if (response.statusCode() > 500) {
				logger.error("Internal Server Error");
			}

		}

	}

}
