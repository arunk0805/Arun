package org.test;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.utilities.BaseClass;
import org.utilities.EndPoint;
import org.utilities.StatusCode;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Authentication extends BaseClass {
	static Logger logger = Logger.getLogger(Authentication.class);
	Response response = null;

	/**
	 * @author Arunkumar.K
	 * @date 16/05/2023
	 * @see This method is used for Basic Authetication
	 */
	@Test(priority = 1)
	public void basicAuthentication() {
		try {
			response = basicAuth(getPropertyValue("userName"),
					getPropertyValue( "password"), EndPoint.basicAuthUrl);
			Assert.assertEquals(response.getStatusCode(), StatusCode.OK.getCode());
			Assert.assertTrue(response.getBody().asString().contains("true"));
			logger.info("StatuCode " + response.statusCode() + "\n" + response.body().asPrettyString());
			logger.info("Basic Authenication Successfully");

		} catch (Exception exception) {
			logger.error("Basic Authenication Not Successfull" + exception);

		}

		finally {
			if (response.statusCode() > 500) {
				logger.error("Internal Server Error");
			}
		}
	}

	/**
	 * @author Arunkumar.K
	 * @date 16/05/2023
	 * @see This method is used for digest authentication
	 */

	@Test(priority = 2)
	public void digestAuthentication() {
		try {
			response = digestAuth(getPropertyValue( "userName"),
					getPropertyValue( "password"), EndPoint.digestAuthUrl);
			Assert.assertEquals(response.getStatusCode(), StatusCode.OK.getCode());
			Assert.assertTrue(response.getBody().asString().contains("true"));
			logger.info("StatuCode " + response.statusCode() + "\n" + response.body().asPrettyString());
			logger.info("Digest Authenication Successfully");

		} catch (Exception exception) {
			logger.error("Digest Authenication Not Successfull" + exception);

		} finally {
			if (response.statusCode() > 500) {
				logger.error("Internal Server Error");
			}
		}

	}

	/**
	 * @author Arunkumar.K
	 * @date 16/05/2023
	 * @see This method is used for preemptive authentication
	 */
	@Test(priority = 3)
	public void preemptiveAuthentication() {
		try {
			RequestSpecification basic = RestAssured.given().auth().preemptive().basic(
					getPropertyValue( "basicUserName"),
					getPropertyValue( "basicPassword"));
			response = basic.get(EndPoint.preemptiveUrl);
			Assert.assertEquals(response.getStatusCode(), StatusCode.OK.getCode());
			Assert.assertTrue(response.getBody().asString().contains("true"));
			logger.info("StatuCode " + response.statusCode() + "\n" + response.body().asPrettyString());
			logger.info("Preemptive Authenication Successfully");

		} catch (Exception exception) {
			logger.error("Digest Authenication Not Successfull" + exception);

		} finally {
			if (response.statusCode() > 500) {
				logger.error("Internal Server Error");
			}
		}

	}

	/**
	 * @author Arunkumar.K
	 * @date 16/05/2023
	 * @see This method is used for API-Key authentication
	 */
	@Test(priority = 4)
	public void apiKeyAuthentication() {
		try {
			response = apiKeyQuery(getPropertyValue( "location"),
					getPropertyValue( "apiKey")).when().log().all().get(EndPoint.weatherApiKey);
			logger.info("StatuCode " + response.statusCode() + "\n" + response.body().asPrettyString());
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
	 * @see This method is used for Bearer authentication
	 */

	@Test(priority = 5)
	public void bearerToken() {
		try {
			response = RestAssured.given()
					.header("Authorization", "Bearer" + getPropertyValue( "bearerToken")).when()
					.log().all().get(EndPoint.gitHubBearerToken);
			Assert.assertEquals(response.getStatusCode(), StatusCode.OK.getCode());
			logger.info("StatuCode " + response.statusCode() + "\n" + response.body().asPrettyString());
		} catch (Exception exception) {
			logger.error("BearerToken Authenication Not Successfull" + exception);

		} finally {
			if (response.statusCode() > 500) {
				logger.error("Internal Server Error");
			}
		}

	}

}
