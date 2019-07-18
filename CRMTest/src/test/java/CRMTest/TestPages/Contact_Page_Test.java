package CRMTest.TestPages;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import CRMTestAutomation.Pages.ContactPage;
import CRMTestAutomation.Pages.HomePage;
import CRMTestAutomation.Pages.Login_Page;
import CRMTestAutomation.Pages.New_ContactPage;
import CRMTestAutomation.TestBase.Base_Class;

public class Contact_Page_Test extends Base_Class 
{

	Login_Page loginpage;
	HomePage homepage;
	ContactPage contactpage;
	New_ContactPage New_contact;

	@BeforeMethod
	public void setup()
	{
		startBrowser(prop.getProperty("browsername"),prop.getProperty("url"));
		loginpage=new Login_Page();
		homepage=new HomePage();
		contactpage=new ContactPage();
		New_contact=new New_ContactPage();
		loginpage.VerifyloginPage(prop.getProperty("username"),prop.getProperty("pass"));

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
