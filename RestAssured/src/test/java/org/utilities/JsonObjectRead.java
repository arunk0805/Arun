package org.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

public class JsonObjectRead {
	static Logger logger = Logger.getLogger(JsonObjectRead.class);

	/**
	 * @author Arunkumar.K
	 * @date 19/05/2023
	 * @see This method is used to get a jsonObject from Json file
	 * @param fileName
	 * @param key
	 * @return
	 */
	@Test
	public static JSONObject getJsonObject(String fileName, String key) {

		try {
			InputStream input = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\" + fileName);
			JSONTokener tokener = new JSONTokener(input);
			JSONObject jsonObject = new JSONObject(tokener);
			JSONObject object = jsonObject.getJSONObject(key);
			return object;
		} catch (FileNotFoundException exception) {
			logger.error("Json Object Read is Not Performed" + exception);
		}
		return null;

	}

}
