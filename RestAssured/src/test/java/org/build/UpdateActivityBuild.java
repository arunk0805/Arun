package org.build;

import java.util.LinkedHashMap;

import org.pojo.ActivitiesPojo;
import org.utilities.ReadExcelData;

public class UpdateActivityBuild {

	public static Object updateActivityData(String sheetName, String testCaseId) {
		ActivitiesPojo updateActivitiesPojo = new ActivitiesPojo();

		LinkedHashMap<String, String> userData = ReadExcelData.getUserData(sheetName, testCaseId);
		updateActivitiesPojo.setId(userData.get("id"));
		updateActivitiesPojo.setTitle(userData.get("title"));
		updateActivitiesPojo.setDueDate(userData.get("dueDate"));
		updateActivitiesPojo.setCompleted(Boolean.parseBoolean(userData.get("completed")));

		return updateActivitiesPojo;

	}

}
