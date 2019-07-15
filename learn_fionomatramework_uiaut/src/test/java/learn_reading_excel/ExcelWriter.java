package learn_reading_excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriter 
{
	public static void main(String[] args) 
	{
		try {
			File fs=new File("D:\\WriteInTo.xlsx");
			FileInputStream fins=new FileInputStream(fs);
			XSSFWorkbook wb=new XSSFWorkbook(fins);
			XSSFSheet sheet=wb.getSheet("Sheet1");
			System.out.println(sheet.getRow(0).getCell(0).getStringCellValue());
			
			sheet.getRow(0).createCell(1).setCellValue("Department");
			sheet.getRow(1).createCell(1).setCellValue("Computer");
			sheet.getRow(2).createCell(1).setCellValue("Information Tech");
			sheet.getRow(3).createCell(1).setCellValue("Mechanical");
			
			/*sheet.getRow(1).createCell(1).setCellValue("InformationTech");
			sheet.getRow(2).createCell(1).setCellValue("ENTC");
			sheet.getRow(3).createCell(1).setCellValue("Computer");
			sheet.getRow(4).createCell(1).setCellValue("Mechanical");*/

			FileOutputStream fout=new FileOutputStream(fs);
			wb.write(fout);
			fout.close();

		}

		catch (Exception e) 
		{

			System.out.println(e.getMessage());
		}

	}
}
