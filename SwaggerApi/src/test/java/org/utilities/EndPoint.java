package org.utilities;

public class EndPoint extends BaseClass {

	private static String swaggerBaseUrl = getPropertyValue("swaggerBaseUrl");

	public static final String createAuthors = swaggerBaseUrl + "api/v1/Authors";
	public static final String getAuthors = swaggerBaseUrl + "api/v1/Authors/{id}";
	public static final String getAuthorsBooksById = swaggerBaseUrl + "api/v1/Authors/authors/books/{bookId}";
	public static final String updateAuthors = swaggerBaseUrl + "api/v1/Authors/{id}";
	public static final String deleteAuthors = swaggerBaseUrl + "api/v1/Authors/{id}";

}
