package org.swaggers;

import org.apache.log4j.Logger;
import org.build.CreateBookBuild;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.utilities.BaseClass;
import org.utilities.EndPoint;
import org.utilities.StatusCode;

import io.restassured.response.Response;

public class Books extends BaseClass {
	static Logger logger = Logger.getLogger(Activities.class);
	String id;

	@Test
	public void booksDetails() {
		try {
			Object createBooksData = CreateBookBuild.createBooksData(getPropertyValue("booksSheetName"), getPropertyValue("postTestCaseId"));
			Response postMethod = postMethod(createBooksData, EndPoint.createBooks);
			Assert.assertEquals(postMethod.getStatusCode(), StatusCode.OK.getCode());
			Assert.assertTrue(postMethod.getBody().asString().contains("Arunkumar"));
			logger.info(postMethod.statusCode() + "\nNew Books details is Created");
			id = postMethod.jsonPath().getString("id");
			logger.info(id);
			try {
				schemaValidation(postMethod, "booksSchema.json");
				logger.info("Schema validate Successfully");

			} catch (Exception exception) {
				logger.error("Schema is Not Validated  Schema is missing " + exception);

			}

		} catch (Exception exception) {
			logger.error("postMethod is not performed" + exception);

		}

		// get by id
		try {
			Response getBooks = getMethod(EndPoint.getBooks, "id", "100");
			Assert.assertEquals(getBooks.getStatusCode(), StatusCode.OK.getCode());
			Assert.assertTrue(getBooks.getBody().asString().contains("100"));
			logger.info(getBooks.statusCode() + "\n Books details is Displayed");
			try {
				schemaValidation(getBooks, "booksSchema.json");
				logger.info("Schema validate Successfully");

			} catch (Exception exception) {
				logger.error("Schema is Not Validated  Schema is missing " + exception);

			}
		} catch (Exception exception) {
			logger.error("getMethod is not performed" + exception);

		}
		// Put by id
		try {

			Object putRequestBody = CreateBookBuild.createBooksData(getPropertyValue("booksSheetName"), getPropertyValue("putTestCaseId"));
			Response putMethod = putMethod(putRequestBody, EndPoint.updateBooks, "id", "100");
			Assert.assertEquals(putMethod.getStatusCode(), StatusCode.OK.getCode());
			Assert.assertTrue(putMethod.getBody().asString().contains("Logesh"));
			logger.info(putMethod.statusCode() + "\n Books details Updated");
			try {
				schemaValidation(putMethod, "booksSchema.json");
				logger.info("Schema validate Successfully");

			} catch (Exception exception) {
				logger.error("Schema is Not Validated  Schema is missing " + exception);

			}

		} catch (Exception exception) {
			logger.error("putMethod is not performed" + exception);

		}

		// delete by id

		try {
			Response deleteMethod = deleteMethod(EndPoint.deleteBooks, "id", "100");
			Assert.assertEquals(deleteMethod.getStatusCode(), StatusCode.OK.getCode());
			logger.info(deleteMethod.statusCode() + "\n New books details Deleted");

		} catch (Exception exception) {
			logger.error("deleteMethod is not performed" + exception);
		}

	}
	
	@Test
	public void logTextFile() {
		Response postMethod = null;
		try {
			Object createBooksData = CreateBookBuild.createBooksData(getPropertyValue("booksSheetName"), getPropertyValue("postTestCaseId"));
			 postMethod = postMethod(createBooksData, EndPoint.createBooks);
			Assert.assertEquals(postMethod.getStatusCode(), StatusCode.OK.getCode());
			Assert.assertTrue(postMethod.getBody().asString().contains("Arunkumar"));
			logger.info(postMethod.statusCode() + "\nNew Books details is Created");
			id = postMethod.jsonPath().getString("id");
			logger.info(id);
			try {
				schemaValidation(postMethod, "booksSchema.json");
				logger.info("Schema validate Successfully");

			} catch (Exception exception) {
				logger.error("Schema is Not Validated  Schema is missing " + exception);

			}

		} catch (Exception exception) {
			logger.error("postMethod is not performed" + exception);

		}
		
	
	}
	
	
	

}
