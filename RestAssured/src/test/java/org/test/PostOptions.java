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

public class PostOptions extends BaseClass {
	static Logger logger = Logger.getLogger(Authentication.class);

	/**
	 * @author Arunkumar.K
	 * @date 17/05/2023
	 * @see This method is used for post request with multi part
	 */

	@Test
	public void postWithMulipart() {
		try {
			Response response = postMethodMultiPart(getPropertyValue("multiPart"), EndPoint.multiPart);
			logger.info("StatuCode " + response.statusCode() + "\n" + response.body().asPrettyString());
			Assert.assertTrue(response.body().asPrettyString().contains(getPropertyValue("multiPart")));
			Assert.assertEquals(response.getStatusCode(), StatusCode.OK.getCode());

		} catch (Exception exception) {
			logger.error("postWithMultiPart is not performed" + exception);
		}
	}

	/**
	 * @author Arunkumar.K
	 * @date 16/05/2023
	 * @see This method is used for post request with cookiee session
	 */
	@Test
	public void cookieSession() {

		Response response = null;
		try {
			response = RestAssured.given().header("apiKey", getPropertyValue("cookieApiKey"))
					.queryParam("base", "USD").queryParam("symbols", "EUR", "GBP").cookie("user", "arun").when()
					.get(EndPoint.cookies);
			response.prettyPeek();
		} catch (Exception e) {
			logger.error("Exception occurred while getting access token: " + e.getMessage());
		} finally {
			if (response.getStatusCode() >= 500) {
				logger.error("Server error occurred");
			}
		}
	}

}
