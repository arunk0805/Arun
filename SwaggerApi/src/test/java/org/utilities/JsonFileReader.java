package org.utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

public class JsonFileReader {
	@Test
	public void readValue() throws IOException, ParseException {
		//String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\" + fileName;
		String filePath = "D:\\Eclipse\\SwaggerApi\\TestData\\requestBodies.json";
		try {
			FileReader fileReader= new FileReader(filePath);
			JSONParser jsonParser = new JSONParser();
			Object parse = jsonParser.parse(fileReader);
			System.out.println(parse);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
