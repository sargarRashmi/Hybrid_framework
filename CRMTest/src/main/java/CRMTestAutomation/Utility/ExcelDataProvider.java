package CRMTestAutomation.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider 
{
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	//Constructor

	public ExcelDataProvider()
	{
		// user.dir means current directory ie current project
		//File fs = new File(System.getProperty("user.dir") + "//TestData//TestingData.xlsx");
		File fs=new File("D:\\Rashmi\\eclipse\\CRMTest\\TestData\\CRMPRO_TestDAta.xlsx");

		try
		{
			FileInputStream fins=new FileInputStream(fs);
			try {
				wb=new XSSFWorkbook(fins);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println(e.getMessage());
		}
	}

	public String getExcelStringData(String sheetName,int row,int column)
	{
		return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
	}

	public String getExcelStringData(int sheetindex,int row,int col)
	{
		return wb.getSheetAt(sheetindex).getRow(row).getCell(col).getStringCellValue();
	}

	public int getExcelNumericData(String sheetName,int row,int column)
	{
		return (int) wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
	}

	public int getExcelNumericData(int sheetIndex,int row,int column)
	{
		return (int) wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getNumericCellValue();
	}

	public Object[][] getExcelTestData(String sheetName)
	{
		sheet=wb.getSheet(sheetName);
		int total_rows=sheet.getLastRowNum();
		int total_column=wb.getSheet(sheetName).getRow(0).getLastCellNum();

		Object[][] data=new Object[total_rows][total_column];

		for (int i = 0; i <total_rows; i++) 
		{
			for (int j = 0; j <total_column; j++)
			{
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			}	
		}
		return data;

	}
}
