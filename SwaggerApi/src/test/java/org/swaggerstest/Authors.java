package org.swaggerstest;

import org.apache.log4j.Logger;
import org.build.CreateAuthorsBuild;
import org.build.UpdateAuthorsBuild;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.utilities.BaseClass;
import org.utilities.EndPoint;
import org.utilities.StatusCode;

import io.restassured.response.Response;

public class Authors extends BaseClass {

	static Logger logger = Logger.getLogger(Authors.class);

	int id = Integer.parseInt(getPropertyValue("id"));
	int bookId = Integer.parseInt(getPropertyValue("bookId"));

	@Test(priority = 1, groups = { "e2e", "post" })
	public void createAuthor() {
		Response postMethodResponse = null;
		try {

			Object requestBody = CreateAuthorsBuild.createAuthorsData(getPropertyValue("authorsSheetName"),
					getPropertyValue("postTestCaseId"));
			postMethodResponse = postMethod(requestBody, EndPoint.createAuthors);
			Assert.assertEquals(postMethodResponse.statusCode(), StatusCode.OK.getCode());
			Assert.assertTrue(postMethodResponse.body().asPrettyString().contains(getPropertyValue("firstName")));
			schemaValidation(postMethodResponse, getPropertyValue("schemaFile"));
			loggersDetails(postMethodResponse);
			writeLogsAsTextFile(postMethodResponse);
			logger.info("Authors details created successfully");
			id = postMethodResponse.jsonPath().get("id");
			bookId = postMethodResponse.jsonPath().get("idBook");

		} catch (Exception exception) {
			logger.error("Post method is not performed" + exception);

		} finally {
			if (postMethodResponse == null) {
				logger.error("Null response received");
			} else if (postMethodResponse.getStatusCode() >= 500) {
				logger.error("Server error occurred");
			}
		}

	}

	@Test(priority = 2, groups = { "e2e", "get" })
	public void getAuthor() {
		Response getMethodResponse = null;
		try {
			logger.info(id);
			getMethodResponse = getMethod(EndPoint.getAuthors, "id", id);
			Assert.assertEquals(getMethodResponse.statusCode(), StatusCode.OK.getCode());
			Assert.assertTrue(getMethodResponse.body().asPrettyString().contains(getPropertyValue("id")));
			schemaValidation(getMethodResponse, getPropertyValue("schemaFile"));
			loggersDetails(getMethodResponse);
			writeLogsAsTextFile(getMethodResponse);
			logger.info("Authors details displayed");
		} catch (Exception exception) {
			logger.error("Get method is not performed" + exception);

		} finally {
			if (getMethodResponse == null) {
				logger.error("Null response received");
			} else if (getMethodResponse.getStatusCode() >= 500) {
				logger.error("Server error occurred");
			}
		}

	}

	@Test(priority = 3, groups = { "e2e", "get" })
	public void getAuthorByBookId() {
		Response getMethodResponse = null;
		try {

			getMethodResponse = getMethod(EndPoint.getAuthorsBooksById, "bookId", bookId);
			Assert.assertEquals(getMethodResponse.statusCode(), StatusCode.OK.getCode());
			schemaValidation(getMethodResponse, getPropertyValue("bookIdSchema"));
			loggersDetails(getMethodResponse);
			writeLogsAsTextFile(getMethodResponse);
			logger.info("Authors details displayed");

		} catch (Exception exception) {
			logger.error("Get method is not performed" + exception);
		} finally {
			if (getMethodResponse == null) {
				logger.error("Null response received");
			} else if (getMethodResponse.getStatusCode() >= 500) {
				logger.error("Server error occurred");
			}
		}

	}

	@Test(priority = 4, groups = { "e2e", "put" })
	public void updateAuthor() {
		Response putMethodResponse = null;
		try {
			if (id == 0) {
				id = Integer.parseInt(getPropertyValue("id"));
			}
			Object responseBody = UpdateAuthorsBuild.updateAuthorsData(getPropertyValue("authorsSheetName"),
					getPropertyValue("putTestCaseId"));
			putMethodResponse = putMethod(responseBody, EndPoint.updateAuthors, getPropertyValue("key"), id);
			Assert.assertEquals(putMethodResponse.statusCode(), StatusCode.OK.getCode());
			Assert.assertTrue(putMethodResponse.body().asPrettyString().contains(getPropertyValue("lastName")));
			schemaValidation(putMethodResponse, getPropertyValue("schemaFile"));
			loggersDetails(putMethodResponse);
			writeLogsAsTextFile(putMethodResponse);
			logger.info("Authors details created successfully");

		} catch (Exception exception) {
			logger.error("Put method is not performed" + exception);
		} finally {
			if (putMethodResponse == null) {
				logger.error("Null response received");
			} else if (putMethodResponse.getStatusCode() >= 500) {
				logger.error("Server error occurred");
			}
		}

	}

	@Test(priority = 5, groups = { "e2e", "delete" })
	public void deleteAuthor() {
		Response deleteMethodResponse = null;
		try {
			if (id == 0) {
				id = Integer.parseInt(getPropertyValue("id"));
			}

			deleteMethodResponse = deleteMethod(EndPoint.deleteAuthors, getPropertyValue("key"), id);
			Assert.assertEquals(deleteMethodResponse.statusCode(), StatusCode.OK.getCode());
			loggersDetails(deleteMethodResponse);
			writeLogsAsTextFile(deleteMethodResponse);
			logger.info("Authors details deleted successfully");

		} catch (Exception exception) {
			logger.error("Delete method is not performed" + exception);

		} finally {
			if (deleteMethodResponse == null) {
				logger.error("Null response received");
			} else if (deleteMethodResponse.getStatusCode() >= StatusCode.INTERNAL_SERVER_ERROR.getCode()) {
				logger.error("Server error occurred");
				System.exit(0);
			}

		}

	}
}
