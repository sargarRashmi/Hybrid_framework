package learn_reading_excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadMultiple 
{
	static XSSFWorkbook wb;
	static XSSFSheet sheet;
	public static void main(String[] args) throws IOException 
	{
		try {
			FileInputStream fis=new FileInputStream(new File("C:\\Users\\Dell\\Desktop\\Read1.xlsx"));
			wb=new XSSFWorkbook(fis);
			sheet=wb.getSheetAt(0);

		} catch (Exception e) 
		{

			System.out.println(e.getMessage());
		}
		Iterator itr=sheet.iterator();
		
		while(itr.hasNext())
		{
			Row rowitr=(Row)itr.next();
			
			Iterator<Cell> cellitr = rowitr.cellIterator();
			
			while(cellitr.hasNext())
			{
				Cell cel = cellitr.next();
				
				switch(cel.getCellType())
				{

				case Cell.CELL_TYPE_STRING:
					System.out.println(cel.getStringCellValue());
					break;
					
				case Cell.CELL_TYPE_BOOLEAN:
					System.out.println(cel.getBooleanCellValue());
					break;
					
				case Cell.CELL_TYPE_NUMERIC:
					System.out.println(cel.getNumericCellValue());
					break;


				}
			}
		}
	}

}
