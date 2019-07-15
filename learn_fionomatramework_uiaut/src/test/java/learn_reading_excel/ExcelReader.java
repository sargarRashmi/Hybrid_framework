package learn_reading_excel;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader 
{
	public static void main(String[] args) 
	{
		try 
		{

			FileInputStream fis=new FileInputStream(new File("C:\\Users\\Dell\\Desktop\\Read.xlsx"));
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			XSSFSheet sheet=wb.getSheet("Sheet1");
			System.out.println(sheet.getRow(1).getCell(0).getStringCellValue());

		} 



		catch (Exception e) 
		{

			System.out.println(e.getMessage());
		}
	}
}
