package com.selenium.setup;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils { // Do not change the class name
	// Implement code here
	public static Object[][] readExcelData(String sheetName) throws IOException, InvalidFormatException {

		// Step 1: Go to the workbook
		XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(new File("src//customer_registration.xlsx")));

		// Step 2: Go to the worksheet
		XSSFSheet sheet = workbook.getSheet(sheetName);

		// Column Count
		short columnCount = sheet.getRow(0).getLastCellNum();

		String[][] data = new String[1][columnCount];

		for (int i = 0; i < columnCount; i++) {

			// Step 3: Go to the row
			XSSFRow dataRow = sheet.getRow(1); // first data row
			// Step 4: Go to the column (cell)

			XSSFCell companyName = dataRow.getCell(i);
			// Step 5: Get the content
			String dataValue = companyName.getStringCellValue();
			data[0][i] = dataValue;
		}
		workbook.close();
		return data;
	}

}
