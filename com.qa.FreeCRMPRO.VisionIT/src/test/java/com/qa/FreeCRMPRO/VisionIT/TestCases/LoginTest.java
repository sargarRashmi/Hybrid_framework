package com.qa.FreeCRMPRO.VisionIT.TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.FreeCRMPRO.VisionIT.Base.BaseClass;
import com.qa.FreeCRMPRO.VisionIT.Pages.LoginPage;

import junit.framework.Assert;

public class LoginTest extends BaseClass 
{
	LoginPage login;

	@BeforeMethod
	public void setup()
	{
		startbrowser("Chrome", "https://www.crmpro.com/index.html");
		login=new LoginPage();
	}

	@Test(priority=2)
	public void verifyLoginpage()
	{
		login.VerifyloginPage("vasant","vasant123");

	}

	@SuppressWarnings("deprecation")
	@Test(priority=1)
	public void verifyLOginPageTitle()
	{
		String actualTitle=login.VerifyLoginPageTitle();
		System.out.println("Actual title of Page is :"+actualTitle);
		String expectedTitle="CRMPRO - CRM software for customer relationship management, sales, and support.";
		//Assert.assertEquals(expectedTitle, actualTitle,"Title Of Page doesn't match with Expected Title");
		Assert.assertEquals(expectedTitle, actualTitle);
	}

	@AfterMethod
	public void teardown()
	{
		//driver.quit();
	}
}
