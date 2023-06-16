package org.build;

import java.util.LinkedHashMap;
import java.util.Map;

import org.pojo.AuthorsPojo;
import org.utilities.ReadExcelData;

public class UpdateAuthorsBuild {
	/**
	 * @author Arunkumar.K
	 * @date 23/05/2023
	 * @see This method is used to create the request body for update the existing
	 *      author
	 * @param sheetName
	 * @param testCaseId
	 * @return
	 */

	public static Object updateAuthorsData(String sheetName, String testCaseId) {
		AuthorsPojo authorsPojo = new AuthorsPojo();

		Map<String, String> userData = ReadExcelData.getUserData(sheetName, testCaseId);
		authorsPojo.setId(Integer.parseInt(userData.get("id")));
		authorsPojo.setIdBook(Integer.parseInt(userData.get("bookId")));
		authorsPojo.setFirstName(userData.get("firstName"));
		authorsPojo.setLastName(userData.get("lastName"));

		return authorsPojo;

	}

}
