package com.qa.visionit_utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataReader 
{
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;

	public ExcelDataReader() {
		try {
			File fs = new File("C:\\Users\\Abhijit Sargar\\git\\Hybrid_framework\\learn_fionomatramework_uiaut\\TestData\\Data1.xlsx");
			FileInputStream fis = new FileInputStream(fs);
			wb = new XSSFWorkbook(fis);
			

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public String getExcelData(String sheetName, int row, int column) {
		sheet = wb.getSheet(sheetName);

		return sheet.getRow(row).getCell(column).getStringCellValue();
	}

	public int getExcelData(int sheetIndex, int row, int column) {
		return 10;
	}

	public int getExcelData(int row, String sheetName, int column) {
		return 10;
	}

	public Object[][] getData(String sheetName) {
		
		sheet = wb.getSheet(sheetName);
		
		int row = sheet.getLastRowNum();
		
		int column = sheet.getRow(0).getLastCellNum();
		
		
		Object[][] data = new Object[row][column];

		for (int i = 0; i < row; i++) {
			
			for (int j = 0; j < column; j++) {
				
				data[i][j] = sheet.getRow(i+1).getCell(j).toString();
			}

		}
		return data;
	}
}

