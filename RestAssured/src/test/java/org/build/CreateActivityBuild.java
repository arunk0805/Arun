package org.build;

import java.util.LinkedHashMap;

import org.pojo.ActivitiesPojo;
import org.utilities.ReadExcelData;

public class CreateActivityBuild {

	public static ActivitiesPojo newActivityData(String sheetName, String testCaseId) {
		ActivitiesPojo activitiesPojo = new ActivitiesPojo();

		LinkedHashMap<String, String> userData = ReadExcelData
				.getUserData(sheetName, testCaseId);
		activitiesPojo.setId(userData.get("id"));
		activitiesPojo.setTitle(userData.get("title"));
		activitiesPojo.setDueDate(userData.get("dueDate"));
		activitiesPojo.setCompleted(Boolean.parseBoolean(userData.get("completed")));

		return activitiesPojo;

	}

}
