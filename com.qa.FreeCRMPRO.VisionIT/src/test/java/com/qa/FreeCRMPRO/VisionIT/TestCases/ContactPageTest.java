package com.qa.FreeCRMPRO.VisionIT.TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.FreeCRMPRO.VisionIT.Base.BaseClass;
import com.qa.FreeCRMPRO.VisionIT.Pages.ContactPage;
import com.qa.FreeCRMPRO.VisionIT.Pages.HomePage;
import com.qa.FreeCRMPRO.VisionIT.Pages.LoginPage;
import com.qa.FreeCRMPRO.VisionIT.Pages.New_ContactPage;

public class ContactPageTest extends BaseClass
{

	LoginPage loginpage;
	HomePage homepage;
	ContactPage contactpage;
	New_ContactPage New_contact;

	@BeforeMethod
	public void setup()
	{
		startbrowser("Chrome", "https://www.crmpro.com/index.html");
		loginpage=new LoginPage();
		homepage=new HomePage();
		contactpage=new ContactPage();
		New_contact=new New_ContactPage();
		loginpage.VerifyloginPage("vasant","vasant123");

	}
	
	@Test(priority=1)
	public void verify_New_ContactPage()
	{
		contactpage.navigate_NewContact_Form();
		New_contact.verify_New_contactPage();
	}

	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
