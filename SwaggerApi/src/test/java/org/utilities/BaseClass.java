/**
 * @author Arunkumar.K
 * @Date 15.05/2023
 * @see This is used to create reusable methods
 */
package org.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.bytebuddy.asm.Advice.This;

public class BaseClass {
	static Logger logger = Logger.getLogger(BaseClass.class);

	/**
	 * @author Arunkumar.K
	 * @Date 14/05/2023
	 * @see This method is used to read the value from the config file
	 * @param fileName
	 * @param key
	 * @return propertyValue
	 */

	public static String getPropertyValue(String fileName, String key) {

		try {
			Properties properties = new Properties();
			FileInputStream file = null;
			file = new FileInputStream(System.getProperty("user.dir") + "\\" + fileName);
			properties.load(file);
			return properties.getProperty(key);

		}

		catch (Exception exception) {
			logger.error("Property value is not performed " + exception);

		}
		return null;

	}

	/**
	 * @author Arunkumar.K
	 * @Date 14/05/2023
	 * @see This method is used to read the value from the config file
	 * @param key
	 * @return propertyValue
	 */
	public static String getPropertyValue(String key) {

		try {
			Properties properties = new Properties();
			FileInputStream file = null;
			file = new FileInputStream(System.getProperty("user.dir") + "\\config.properties");
			properties.load(file);
			return properties.getProperty(key);

		}

		catch (Exception exception) {
			logger.error("Property value is not performed " + exception);

		}
		return null;

	}

	/**
	 * @author Arunkumar.K
	 * @Date 14/05/2023
	 * @see This method is used to get a resouce from the server
	 * @param url
	 * @return response
	 */
	public static Response getMethod(String url) {
		try {
			Response response = RestAssured.given().log().all().header("Content-Type", "application/json").get(url);
			return response;

		} catch (Exception exception) {
			logger.error("Get method is not performed " + exception);

		}
		return null;

	}

	/**
	 * @author Arunkumar.K
	 * @date 15/05/2023
	 * @see This method is used to pass the path params with get method
	 * @param url
	 * @param key
	 * @param value
	 * @return response
	 */
	public static Response getMethod(String url, String key, Object value) {
		try {
			Response response = RestAssured.given().pathParam(key, value).log().all()
					.header("Content-Type", "application/json").get(url);
			return response;

		} catch (Exception exception) {
			logger.error("Get method is not performed " + exception);

		}
		return null;

	}

	/**
	 * @author Arunkumar.K
	 * @date 15/05/2023
	 * @see This method is used to pass the query params with get method
	 * @param url
	 * @param key
	 * @param value
	 * @return response
	 */
	public static Response getMethodQuery(String key, String value, String url) {
		try {
			Response response = RestAssured.given().log().all().header("Content-Type", "application/json")
					.queryParam(key, value).get(url);
			return response;

		} catch (Exception exception) {
			logger.error("Get method is not performed " + exception);

		}
		return null;

	}

	/**
	 *
	 * @author Arunkumar.K
	 * @Date 15.05/2023
	 * @see This method is used to get a resouce from the server
	 * @param url
	 * @param querryParameter
	 * @return response
	 */

	public Response getMethodPathPrams(String url, HashMap<String, String> pathParameter) {
		try {
			Response response = RestAssured.given().pathParams(pathParameter).log().all()
					.header("Content-Type", "application/json").get(url);
			return response;
		} catch (Exception exception) {
			logger.error("Get method is not performed " + exception);

		}
		return null;
	}

	/**
	 * @author Arunkumar.K
	 * @Date 15.05/2023
	 * @see This method is used to get a resouce from the server with parameter
	 * @param endpoint
	 * @param queryParam
	 * @return response
	 */
	public Response getMethodQueryParams(String url, HashMap<String, String> queryParam) {
		try {
			Response response = RestAssured.given().log().all().header("Content-Type", "application/json")
					.queryParams(queryParam).when().get(url);
			return response;
		} catch (Exception exception) {
			logger.error("Get method is not performed  " + exception);
		}
		return null;
	}

	/**
	 * @author Arunkumar.K
	 * @Date 15.05/2023
	 * @see This method is used to delete the resource from the server
	 * @param url
	 * @return response
	 */
	public static Response deleteMethod(String url) {
		try {
			Response response = RestAssured.given().log().all().header("Content-Type", "application/json").delete(url);
			return response;
		} catch (Exception exception) {
			logger.error("delete method is not performed " + exception);
		}
		return null;
	}

	/**
	 * @author Arunkumar.K
	 * @Date 15.05/2023
	 * @see This method is used to delete a resouce from the server with parameter
	 * @param endpoint
	 * @param key
	 * @param value
	 * @return response
	 */

	public Response deleteMethod(String endpoint, String key, Object value) {
		try {
			Response response = RestAssured.given().log().all().header("Content-Type", "application/json")
					.pathParam(key, value).when().delete(endpoint);
			return response;
		} catch (Exception exception) {
			logger.error("Delete method is not performed " + exception);
		}
		return null;
	}

	/**
	 * @author Arunkumar.K
	 * @Date 15.05/2023
	 * @see This method is used to update the existing resource in the server
	 * @param requestBody
	 * @param endpoint
	 * @return response
	 */
	public Response putMethod(Object requestBody, String endpoint) {
		try {
			RequestSpecification request = RestAssured.given().log().all().header("Content-Type", "application/json")
					.body(requestBody);
			Response response = request.put(endpoint);

			return response;
		} catch (Exception exception) {
			logger.error("Put method is not performed " + exception);

		}
		return null;

	}

	/**
	 * @author Arunkumar.K
	 * @Date 15.05/2023
	 * @see This method is used to update the existing resouce in the server with
	 *      parameter
	 * @param requestBody
	 * @param endpoint
	 * @param key
	 * @param value
	 * @return
	 */
	public Response putMethod(Object requestBody, String endpoint, String key, Object value) {
		try {
			Response response = RestAssured.given().log().all().header("Content-Type", "application/json")
					.pathParams(key, value).when().body(requestBody).put(endpoint);
			return response;

		} catch (Exception exception) {
			logger.error("Put method is not performed " + exception);

		}
		return null;

	}

	/**
	 * @author Arunkumar.K
	 * @Date 15.05/2023
	 * @see This method is used to create a new resource in the server
	 * @param requestBody
	 * @param endpoint
	 * @return response
	 */
	public Response postMethod(Object requestBody, String endpoint) {

		try {
			Response response = RestAssured.given().log().all().header("Content-Type", "application/json")
					.body(requestBody).when().post(endpoint);
			return response;

		} catch (Exception exception) {
			logger.error("Post method is not performed " + exception);
		}
		return null;
	}

	/**
	 * @author Arunkumar.K
	 * @Date 15.05/2023
	 * @see This method is used to create a new resouce in the server with parameter
	 * @param requestBody
	 * @param endpoint
	 * @param key
	 * @param value
	 * @return response
	 */
	public Response postMethod(String requestBody, String endpoint, String key, Object value) {
		try {
			Response response = RestAssured.given().log().all().header("Content-Type", "application/json")
					.param(key, value).when().body(requestBody).post(endpoint);
			return response;

		} catch (Exception exception) {
			logger.error("Post method is not performed " + exception);

		}
		return null;
	}

	/**
	 * @author Arunkumar.K
	 * @Date 15.05/2023
	 * @see This method is used to verify the basic authetication
	 * @param userName
	 * @param password
	 * @param url
	 * @return response
	 */
	public Response basicAuth(String userName, String password, String url) {
		try {
			RequestSpecification basic = RestAssured.given().auth().basic(userName, password);
			Response response = basic.get(url);
			return response;

		} catch (Exception exception) {
			logger.error("Basi Auth is not performed " + exception);
		}
		return null;

	}

	/**
	 * @author Arunkumar.K
	 * @Date 15.05/2023
	 * @see This method is used to verify the digest authetication
	 * @param userName
	 * @param password
	 * @param url
	 * @return
	 */
	public Response digestAuth(String userName, String password, String url) {
		try {
			RequestSpecification basic = RestAssured.given().auth().digest(userName, password);
			Response response = basic.get(url);
			return response;
		} catch (Exception exception) {
			logger.error("Digest Auth is not performed " + exception);
		}
		return null;

	}

	/**
	 * @author Arunkumar.K
	 * @Date 15.05/2023
	 * @see This method is used to verify the preemptive authetication
	 * @param userName
	 * @param password
	 * @param url
	 * @return
	 */
	public Response preemptiveAuth(String userName, String password, String url) {

		try {
			RequestSpecification basic = RestAssured.given().auth().preemptive().basic(userName, password);
			Response response = basic.get(url);
			return response;

		} catch (Exception exception) {
			logger.error("Digest Auth is not performed " + exception);

		}
		return null;
	}

	/**
	 * @author Arunkumar.K
	 * @Date 15.05/2023
	 * @see This method is used to verify the API-Key authetication
	 * @param location
	 * @param apikey
	 * @return
	 */
	public RequestSpecification apiKeyQuery(String location, String apikey) {
		try {
			RequestSpecification queryParam = RestAssured.given().queryParam("q", location).queryParam("appid", apikey);
			return queryParam;
		} catch (Exception exception) {
			logger.error("API-Key Auth is not performed " + exception);

		}
		return null;
	}

	/**
	 * @author Arunkumar.K
	 * @date 16/05/2023
	 * @see This method is used to create with OAuth authentication
	 * @param accessToken
	 * @param fileName
	 * @param url
	 * @return response
	 */

	public Response postMethodOAuth2(String accessToken, String fileName, String url) {
		try {
			FileInputStream inputData = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\" + fileName);
			Response response = RestAssured.given().auth().oauth2(accessToken).when().log().all()
					.contentType("application/json").body(inputData).post(url);
			return response;
		} catch (Exception exception) {
			logger.error("PostMethod with OAuth2.0 is not performed " + exception);
		}
		return null;

	}

	/**
	 * @author Arunkumar.K
	 * @date 16/05/2023
	 * @see This method is used to create with Multipart for pass the file
	 * @param fileName
	 * @param url
	 * @return response
	 */
	public Response postMethodMultiPart(String fileName, String url) {

		try {

			Response response = RestAssured.given().contentType(ContentType.MULTIPART).when().log().all()
					.multiPart(new File(System.getProperty("user.dir") + "\\src\\test\\resources\\" + fileName))
					.post(url);
			return response;
		} catch (Exception exception) {
			logger.error("PostMethod with MultiPart is not performed " + exception);

		}
		return null;
	}

	/**
	 * @author Arunkumar.K
	 * @date 16/05/2023
	 * @see This method is used to update with OAuth authentication
	 * @param accessToken
	 * @param fileName
	 * @param url
	 * @return response
	 */
	public Response putMethodOAuth2(String accessToken, String fileName, String url) {
		try {
			FileInputStream inputData = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\" + fileName);
			Response response = RestAssured.given().auth().oauth2(accessToken).when().log().all()
					.header("Content-Type", "application/json").body(inputData).put(url);
			return response;

		} catch (Exception exception) {
			logger.error("PutMethod with OAuth2.0 is not performed " + exception);
		}
		return null;
	}

	/**
	 * @author Arunkumar.K
	 * @date 19/05/2023
	 * @see This method is used for schema validation
	 * @param response
	 * @param fileName
	 */

	public void schemaValidation(Response response, String fileName) {
		try {
			File file = new File(System.getProperty("user.dir") + "\\Schema\\" + fileName);
			response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(file));
			logger.info("Schema validation successfull");
		} catch (Exception exception) {
			logger.error("Schema validation is not performed " + exception);

		}
	}

	/**
	 * @author Arunkumar.K
	 * @date 20/05/2023
	 * @see This method is used to Convert Json object to String
	 * @param object
	 * @return String
	 */

	public static String jsonStringConverter(Object object) {

		ObjectMapper objectMapper = new ObjectMapper();
		try {
			return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
		} catch (JsonProcessingException jsonProcessingException) {
			logger.error("jsonProcessingException occured in org.utilities.BaseClass" + jsonProcessingException);
		} catch (Exception exception) {
			logger.error("Unexpected Exception occured in org.utilities.BaseClass" + exception);

		}
		return null;

	}

	/**
	 * @author Arunkumar.K
	 * @date 20/05/2023
	 * @see This method is used to get a Json Obeject from json file
	 * @param fileName
	 * @param key
	 * @return
	 */

	public Object getJsonObject(String fileName, String key) {

		try {
			String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\" + fileName;
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);
			LinkedHashMap jsonObject = objectMapper.readValue(new File(filePath), LinkedHashMap.class);
			Object object = jsonObject.get(key);
			return object;
		} catch (Exception exception) {
			logger.error("getJsonObject not performed " + exception);
		}
		return null;

	}

	/**
	 * @author Arunkumar.K
	 * @date 24/05/2023
	 * @see This method is used to write logs as text file
	 * @param response
	 */
	public void writeLogsAsTextFile(Response response) {

		String logFilePath = getPropertyValue("textFilePath");
		try (FileWriter fileWriter = new FileWriter(logFilePath, true)) {
			fileWriter.write("" + "\n Response Body: " + response.getBody().asPrettyString() + "\n");
			fileWriter.write("Response StatusCode: " + response.statusCode() + "\n");
			fileWriter.write("\n------------------------------------");
			logger.info("File writing completed");
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	/**
	 * @author Arunkumar.K
	 * @date 24/05/2023
	 * @see This method is used to logger details
	 * @param response
	 */
	public void loggersDetails(Response response) {
		logger.info("Status Code " + response.statusCode() + "\nResponse Body " + response.body().asPrettyString());

	}

	/**
	 * @author Arunkumar.K
	 * @date 24/05/2023
	 * @see This method is used to handling the server error
	 * @param response
	 */
	public void handlingServerError(Response response) {
		if (response == null) {
			logger.error("Null response received");
		} else if (response.getStatusCode() >= StatusCode.INTERNAL_SERVER_ERROR.getCode()) {
			logger.error("Server error occurred");
			System.exit(0);
		}

	}

}
