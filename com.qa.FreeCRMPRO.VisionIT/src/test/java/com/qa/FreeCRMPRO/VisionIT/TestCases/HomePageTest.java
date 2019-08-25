package com.qa.FreeCRMPRO.VisionIT.TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.FreeCRMPRO.VisionIT.Base.BaseClass;
import com.qa.FreeCRMPRO.VisionIT.Pages.ContactPage;
import com.qa.FreeCRMPRO.VisionIT.Pages.HomePage;
import com.qa.FreeCRMPRO.VisionIT.Pages.LoginPage;
import com.qa.FreeCRMPRO.VisionIT.Utility.Helper;

import junit.framework.Assert;

public class HomePageTest extends BaseClass
{
	LoginPage loginpage;
	HomePage homepage;
	

	@BeforeMethod
	public void set()
	{
		startbrowser("Chrome", "https://www.crmpro.com/index.html");
		loginpage=new LoginPage();
		homepage=new HomePage();
		loginpage.VerifyloginPage("vasant","vasant123");
	}

	@Test(priority=1)
	public void navigateto_ContactPage_test()
	{
		homepage.navigatetoContactPage();

	}

	@Test(priority=2)

	public void navigateto_deals_test()
	{
		homepage.navigatetoDealsPage();
	}

	@Test(priority=3)
	public void navigateto_Task_test()
	{
		homepage.navigatetoTaskPage();
	}

	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}

