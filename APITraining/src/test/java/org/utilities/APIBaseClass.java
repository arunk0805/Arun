/**
 * @author Arunkumar.K
 * @Date 18/04/2023
 * @see This is used to create reusable methods
 */
package org.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.constantpath.ConstantPath;

import bsh.This;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIBaseClass {
	/**
	 * @author Arunkumar.K
	 * @Date 18/04/2023
	 * @see This method is used to read the value from the config file
	 * @param key
	 * @return propertyValue
	 */

	public static String getPropertyValue(String key) {
		Properties properties = new Properties();
		FileInputStream file = null;
		try {
			file = new FileInputStream(ConstantPath.configPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			properties.load(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties.getProperty(key);

	}

	/**
	 * @author Arunkumar.K
	 * @Date 18/04/2023
	 * @see This method is used to get a resouce from the server
	 * @param url
	 * @return response
	 */
	public static Response getMethod(String url) {
		Response response = RestAssured.given().log().all().get(url);
		return response;
	}

	/**
	 *
	 * @author Arunkumar.K
	 * @Date 18/04/2023
	 * @see This method is used to get a resouce from the server
	 * @param url
	 * @param querryParameter
	 * @return response
	 */

	public Response getMethod(String url, String querryParameter) {
		Response response = RestAssured.given().log().all().get(url + querryParameter);
		return response;
	}

	/**
	 * @author Arunkumar.K
	 * @Date 18/04/2023
	 * @see This method is used to get a resouce from the server with parameter
	 * @param endpoint
	 * @param key
	 * @param value
	 * @return response
	 */
	public Response getMethod(String endpoint, String key, String value) {
		Response response = RestAssured.given().log().all().param(key, value).when().get(endpoint);
		return response;
	}

	/**
	 * @author Arunkumar.K
	 * @Date 18/04/2023
	 * @see This method is used to delete the resource from the server
	 * @param url
	 * @return response
	 */
	public static Response deleteMethod(String url) {
		Response response = RestAssured.given().log().all().delete(url);
		return response;
	}

	/**
	 * @author Arunkumar.K
	 * @Date 18/04/2023
	 * @see This method is used to delete a resouce from the server with parameter
	 * @param endpoint
	 * @param key
	 * @param value
	 * @return response
	 */

	public Response deleteMethod(String endpoint, String key, String value) {
		Response response = RestAssured.given().log().all().param(key, value).when().delete(endpoint);
		return response;
	}

	/**
	 * @author Arunkumar.K
	 * @Date 18/04/2023
	 * @see This method is used to update the existing resource in the server
	 * @param requestBody
	 * @param endpoint
	 * @return response
	 */
	public Response putMethod(Object requestBody, String endpoint) {
		RequestSpecification request = RestAssured.given().log().all().header("Content-Type", "application/json")
				.body(requestBody);
		Response response = request.put(endpoint);

		return response;
	}

	/**
	 * @author Arunkumar.K
	 * @Date 18/04/2023
	 * @see This method is used to update the existing resouce in the server with
	 *      parameter
	 * @param requestBody
	 * @param endpoint
	 * @param key
	 * @param value
	 * @return
	 */
	public Response putMethod(String requestBody, String endpoint, String key, String value) {
		Response response = RestAssured.given().log().all().header("Content-Type", "application/json").param(key, value)
				.when().body(requestBody).put(endpoint);
		return response;
	}

	/**
	 * @author Arunkumar.K
	 * @Date 18/04/2023
	 * @see This method is used to create a new resource in the server
	 * @param requestBody
	 * @param endpoint
	 * @return response
	 */
	public static Response postMethod(Object requestBody, String endpoint) {
		Response response = RestAssured.given().log().all().header("Content-Type", "application/json").body(requestBody)
				.when().post(endpoint);
		return response;

	}

	/**
	 * @author Arunkumar.K
	 * @Date 18/04/2023
	 * @see This method is used to create a new resouce in the server with parameter
	 * @param requestBody
	 * @param endpoint
	 * @param key
	 * @param value
	 * @return response
	 */
	public Response postMethod(String requestBody, String endpoint, String key, String value) {
		Response response = RestAssured.given().log().all().header("Content-Type", "application/json").param(key, value)
				.when().body(requestBody).post(endpoint);
		return response;
	}
	
	

	

}