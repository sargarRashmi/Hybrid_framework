package CRMTestAutomation.TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import CRMTestAutomation.Utility.ExcelDataProvider;
import CRMTestAutomation.Utility.Helper;

public class Base_Class
{
	public static WebDriver driver;
	public static Properties prop;
	public static FileInputStream fis;
	public static ExcelDataProvider exceldata;

	@BeforeSuite
	public void BeforeSuite()
	{
		exceldata=new ExcelDataProvider();
	}

	@AfterSuite
	public void teardown(ITestResult results)
	{


		if(results.getStatus()==results.SUCCESS)
		{
			Helper.CaptureScreenShot(driver);
		}

		else if(results.getStatus()==results.SKIP)
		{
			Helper.CaptureScreenShot(driver);
		}
		else if(results.getStatus()==results.FAILURE)
		{
			Helper.CaptureScreenShot(driver);
			System.out.println("Screenshot not captured");
		}
		driver.quit();
	}
	
	public Base_Class()
	{
		File f=new File("D:\\Rashmi\\eclipse\\CRMTest\\src\\main\\java\\CRMTestAutomation\\Config\\config_file.properties");

		try {
			fis = new FileInputStream(f);
		}
		catch (FileNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
		prop=new Properties();
		try 
		{
			prop.load(fis);
		} 
		catch (IOException e1) 
		{
			System.out.println(e1.getMessage());
		}

	}

	public static void startBrowser(String brrName, String url_name)
	{

		if (brrName.equals("Firefox"))
		{

			System.setProperty("webdriver.gecko.driver", "D://Rashmi//Selenium//Selenium3//gecko.exe");

			driver = new FirefoxDriver();

		}
		if (brrName.equals("Chrome")) 
		{

			System.setProperty("webdriver.chrome.driver","D:\\Rashmi\\Selenium\\Selenium3\\Chrome\\chromedriver.exe");

			driver = new ChromeDriver();
		} 
		else if (brrName.equals("IE")) 
		{
			System.setProperty("webdriver.ie.driver", "D://Rashmi//Selenium//Selenium3//IEDriverServer.exe");

			driver = new InternetExplorerDriver();

		} else 
		{

			System.out.println("Browser not able to fetch and hence we are not navigating to respected browser");
		}

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get(url_name);

	}
}
 