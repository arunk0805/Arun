package org.build;

import java.util.LinkedHashMap;

import org.pojo.BooksPojo;
import org.utilities.ReadExcelData;

public class UpdateBookBuild {

	public Object createBooksData(String sheetName, String testCaseId) {
		BooksPojo booksPojo = new BooksPojo();

		LinkedHashMap<String, String> userData = ReadExcelData
				.getUserData(sheetName, testCaseId);

		booksPojo.setId(Integer.parseInt(userData.get("id")));
		booksPojo.setTitle(userData.get("title"));
		booksPojo.setDescription(userData.get("description"));
		booksPojo.setPageCount(Integer.parseInt(userData.get("pageCount")));
		booksPojo.setExcerpt(userData.get("excerpt"));
		booksPojo.setPublishDate(userData.get("publishDate"));
		return booksPojo;

	}

}
