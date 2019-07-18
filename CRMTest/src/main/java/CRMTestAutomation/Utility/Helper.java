package CRMTestAutomation.Utility;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

import com.sun.jna.platform.FileUtils;
import com.sun.jna.platform.win32.OaIdl.DATE;

public class Helper 
{

	//Switch to frame by Function

	public static void SwitchtoFrameByName(WebDriver driver,String Frame_name)
	{
		driver.switchTo().frame(Frame_name);
	}

	public static void SwitchToFrameById(WebDriver driver,int frame_id)
	{
		driver.switchTo().frame(frame_id);
	}

	public static void SwitchToFrameByIndex(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}

	public void SwitchByWebElement(WebDriver driver,WebElement ele)
	{
		driver.switchTo().frame(ele);
	}

	public static void CaptureScreenShot(WebDriver driver)
	{
		TakesScreenshot ts=(TakesScreenshot) driver;

		File srcfile=ts.getScreenshotAs(OutputType.FILE);
		try
		{
			FileHandler.copy(srcfile,new File(".//Screenshots//CRM_"+GetCurrentDateTime()+".png"));
		} 
		catch (IOException e) 
		{
			System.out.println("Unable to capture Screenshot"+e.getMessage());
		}


	}

	public static String GetCurrentDateTime()
	{
		DateFormat customformat=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");

		Date currentdate=new Date();
		return customformat.format(currentdate);
	}
}
