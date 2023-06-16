package org.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData extends BaseClass {

	static Map<String, String> data = null;
	static Logger logger = Logger.getLogger(ReadExcelData.class);

	/**
	 * @author Arunkumar.K
	 * @Date 19/05/2023
	 * @see To fetch the data from the excel
	 * @param excelFilePath
	 * @param sheetName
	 * @param TestCaseID
	 * @return
	 * @return
	 */
	public static Map<String, String> getUserData(String sheetName, String TestCaseID) {
		try {
			File file = new File(getPropertyValue("excelFilePath"));
			FileInputStream inputStream = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet sheet = workbook.getSheet(sheetName);
			data = new LinkedHashMap<String, String>();
			String value = null;
			for (int row = 0; row <= sheet.getLastRowNum(); row++) {
				String testCase = sheet.getRow(row).getCell(0).getStringCellValue();
				if (testCase.contains(TestCaseID)) {
					for (int index = 1; index < sheet.getRow(0).getLastCellNum(); index++) {
						String key = sheet.getRow(0).getCell(index).getStringCellValue();
						Cell cellValue = sheet.getRow(row).getCell(index);
						if (cellValue != null) {
							value = new DataFormatter().formatCellValue(cellValue);
						}
						data.put(key, value);
					}
				}	
				
			}
			workbook.close();
			logger.info("Excel read is performed");
		} catch (Exception exception) {
			logger.error("Excel read is not performed : " + exception);
		}
		return data;
	}

}
