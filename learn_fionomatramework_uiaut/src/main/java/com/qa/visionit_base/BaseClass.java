package com.qa.visionit_base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
//import java.io.File;
//import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.qa.visionit_utility.ExcelDataReader;
import com.qa.visionit_utility.Helper;

public class BaseClass 
{
	public static WebDriver driver;
	public static Properties prop;
	public ExcelDataReader excelData;
	public ExtentReports reports;
	public ExtentTest logger;

	@BeforeSuite
	public void beforeSuite(){

		Reporter.log("Initializing the Excel Config and extents Reporters  ", true);
		excelData=new ExcelDataReader();

		ExtentHtmlReporter htmlRepoter = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"//ExtentsReports//FreeCrm_"+Helper.getCurrentDateAndTime()+".html"));

		reports= new ExtentReports();

		reports.attachReporter(htmlRepoter);

		Reporter.log("Succesfully done initialization  ", true);

	}

	@AfterMethod
	public void tearDown(ITestResult results) throws IOException{

		Reporter.log("generating and attaching screen shots ", true);

		if(results.getStatus()==ITestResult.FAILURE){

			//Helper.capturesScreenShots(driver);

			logger.fail("TestCase Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.capturesScreenShots(driver)).build());
		}

		else if(results.getStatus()==ITestResult.SUCCESS){
			//Helper.capturesScreenShots(driver);

			logger.pass("TestCase Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.capturesScreenShots(driver)).build());
		}
		/*else if(results.getStatus()==ITestResult.SKIP){
		//	Helper.capturesScreenShots(driver);
		}*/
		else{
			System.out.println("we can't captured screenshots here......");
		}

		driver.quit();

		reports.flush();

		Reporter.log("generated  and attached the  screen shots and test will be completed.. ", true);
	}



	public BaseClass(){

		try{
			File fs=new File("D:\\Hybrid_framework\\com.learnMavenProject\\src\\main\\java\\com\\qa\\visionit_configfile\\config.properties");
			FileInputStream fis = new FileInputStream(fs);

			prop=new Properties();

			prop.load(fis);
		}
		catch (Exception e) {
			System.out.println("File not found"+e.getMessage());
		}
	}

	public static void startBrowser(String browserName,String testUrl )
	{
		if (browserName.equals("Firefox"))
		{

			System.setProperty("webdriver.gecko.driver", "D://Rashmi//Selenium//Selenium3//gecko.exe");

			driver = new FirefoxDriver();

		}
		if (browserName.equals("Chrome")) 
		{

			System.setProperty("webdriver.chrome.driver","D:\\Rashmi\\Selenium\\Selenium3\\Chrome\\chromedriver.exe");

			driver = new ChromeDriver();
		} 
		else if (browserName.equals("IE")) 
		{
			System.setProperty("webdriver.ie.driver", "D://Rashmi//Selenium//Selenium3//IEDriverServer.exe");

			driver = new InternetExplorerDriver();

		} else 
		{

			System.out.println("Browser not able to fetch and hence we are not navigating to respected browser");
		}

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get(testUrl);

	}
}
