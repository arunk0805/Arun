package org.build;

import java.util.LinkedHashMap;

import org.pojo.UserPojo;
import org.utilities.BaseClass;
import org.utilities.ReadExcelData;

public class UpdateUserBuild extends BaseClass {
	public static String updateUserData(String sheetName, String testCaseId) {
		try {
			LinkedHashMap<String, String> userData = ReadExcelData.getUserData(sheetName, testCaseId);
			UserPojo requestBody = UserPojo.builder().id(Integer.parseInt(userData.get("id")))
					.userName(userData.get("userName")).password(userData.get("password")).build();
			String putRequestBody = jsonStringConverter(requestBody);
			return putRequestBody;

		} catch (Exception exception) {
		}
		return null;

	}

}
