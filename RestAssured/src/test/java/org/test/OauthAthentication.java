package org.test;

import java.util.Base64;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.utilities.AuthCode;
import org.utilities.BaseClass;
import org.utilities.EndPoint;
import org.utilities.JsonObjectRead;
import org.utilities.StatusCode;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.bytebuddy.asm.Advice.This;

public class OauthAthentication extends BaseClass {
	static Logger logger = Logger.getLogger(OauthAthentication.class);
	static String access_token;
	Response response = null;

	/**
	 * @author Arunkumar.K
	 * @date 16/05/2023
	 * @see This method is used for get Access token
	 */
	@Test(priority = 1)
	public void getAccessToken() {
		try {

			String authorizationCode = AuthCode.getAuthCode();
			String authHeader = "Basic " + Base64.getEncoder().encodeToString(
					(getPropertyValue("clientId") + ":" + getPropertyValue("clientSecretId")).getBytes());
			response = RestAssured.given().contentType(ContentType.URLENC).header("Authorization", authHeader)
					.formParam("grant_type", "authorization_code").formParam("code", authorizationCode)
					.formParam("redirect_uri", EndPoint.callBackUrl).post(EndPoint.accesstokeUrl);
			logger.info(response.body().asPrettyString());
			access_token = response.jsonPath().getString("access_token");
			logger.info("check " + access_token);

		} catch (Exception exception) {
			logger.error("Access token is not generated" + exception);

		} finally {
			if (response.statusCode() > 500) {
				logger.error("Internal Server Error");
			}
		}

	}

	/**
	 * @author Arunkumar.K
	 * @date 16/05/2023
	 * @see This method is used for get playlist with access token
	 */

	@Test(priority = 3, groups = {"get"},dependsOnMethods =  "getAccessToken")
	public void getplaylist() {
		try {
			logger.info("check " + access_token);
			response = RestAssured.given().auth().oauth2(access_token).when().log().all().get(EndPoint.getPlaylist);
			logger.info("StatuCode " + response.statusCode() + "\n" + response.body().asPrettyString());
			Assert.assertEquals(response.getStatusCode(), StatusCode.OK.getCode());
		} catch (Exception exception) {
			logger.error("Playlist is not displayed" + exception);

		} finally {
			if (response.statusCode() > 500) {
				logger.error("Internal Server Error");
			}
		}

	}

	/**
	 * @author Arunkumar.K
	 * @date 16/05/2023
	 * @see This method is used for create new playlist with Access token
	 */

	@Test(priority = 2, dependsOnMethods = "getAccessToken")
	public void createNewPlayList() {
		try {
			response = postMethodOAuth2(access_token, getPropertyValue("inputFileName"), EndPoint.createPlayList);
			logger.info("StatuCode " + response.statusCode() + "\n" + response.body().asPrettyString());
			logger.info("New Playlist Created Successfully");
		} catch (Exception exception) {
			logger.error("Playlist is not created" + exception);
		} finally {
			if (response.statusCode() > 500) {
				logger.error("Internal Server Error");
			}
		}
	}

	/**
	 * @author Arunkumar.K
	 * @date 16/05/2023
	 * @see This method is used for update playlist with access token
	 */
	@Test(priority = 4, dependsOnMethods = "getAccessToken")
	public void updatePlaylist() {

		try {
			JSONObject jsonObject = JsonObjectRead.getJsonObject("requestBodies.json", "createPlaylist");

			logger.info("check " + access_token);
			response = putMethodOAuth2(access_token, getPropertyValue("updateFileName"), EndPoint.updatePlaylist);
			logger.info(response.statusCode());
			Assert.assertEquals(response.getStatusCode(), StatusCode.OK.getCode());
		} catch (Exception exception) {
			logger.error("Playlist is not created" + exception);

		} finally {
			if (response.statusCode() > 500) {
				logger.error("Internal Server Error");
			}
		}

	}

}
