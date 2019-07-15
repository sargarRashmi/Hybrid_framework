package com.qa.visionit_TestCase;

import org.testng.Assert;
import org.testng.Reporter;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.visionit_base.BaseClass;
//import com.qa.visionit_pages.HomePage;
import com.qa.visionit_pages.LoginPage;
//import com.qa.visionit_pages.RegistrationPage;
import com.qa.visionit_utility.ExcelDataReader;
//import com.qa.visionit_utility.Helper;

public class LoginPageTest extends BaseClass
{
	LoginPage loginpage;
	ExcelDataReader excelReader;

	@BeforeMethod
	public void setup(){
		
		Reporter.log("Browser started and navigating to testing server", true);
		
		startBrowser(prop.getProperty("browserName"), prop.getProperty("testUrl"));
		
		Reporter.log("Succesfuly navigated  to the login page ", true);
		
		loginpage=new LoginPage();
	}
	
	@Test(priority=1)
	public void verifyLoginPageTitleTest(){
		
		Reporter.log("Test started and verifying Title of the Login Page", true);
		
		logger=reports.createTest("Verify_Login_Page_Title_Test");

		logger.info("Verifying title of the Login Page ");
		
		String actualTitle=loginpage.verifyloginPageTitle();
		
		String expectedTitle="CRMPRO - CRM software for customer relationship management, sales, and support.";
		
		Assert.assertEquals(actualTitle, expectedTitle,"Title of the Login page doesn't match with Expected title");
		
		logger.pass("Veried Login Page title succesfully........");
		
		Reporter.log("veried Title of the Login Page", true);
	}
	
	@Test(priority=2, dataProvider="getExcelData")
	public void verifyLogintoFreeCrmProTest(String uname, String upass){
		
		Reporter.log("Eneter username and password to the Text field  ", true);
		logger=reports.createTest("verify_Login_To_FreeCrmPro_Test");
		
		
		//Helper.cparturesScreenShots(driver);
		loginpage.loginToCrmPro(uname, upass);
		
		Assert.assertTrue(driver.getTitle().contains("CRMPRO"),"Titlte of the Home Page doesn't contain CRMPRO");
		
		//Helper.cparturesScreenShots(driver);
		
		logger.pass("Logged in successfully and verified the HomePage title");
		
		Reporter.log("Navigating to home page of the application ", true);
	}

	@DataProvider
	public Object [][] getExcelData(){
		
		return excelData.getData("login");
	}
	
	
	
	
}
