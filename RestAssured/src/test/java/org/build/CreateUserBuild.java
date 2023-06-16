package org.build;

import java.util.LinkedHashMap;

import org.pojo.UserPojo;
import org.utilities.BaseClass;
import org.utilities.ReadExcelData;

public class CreateUserBuild extends BaseClass {

	public static String createUserData(String sheetName, String testCaseId) {

		LinkedHashMap<String, String> userData = ReadExcelData.getUserData(sheetName, testCaseId);
		UserPojo reqBody = UserPojo.builder().id(Integer.parseInt(userData.get("id")))
				.userName(userData.get("userName")).password(userData.get("password")).build();

		String postReqBody = jsonStringConverter(reqBody);
		return postReqBody;

	}
}
