package CRMTest.TestPages;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import CRMTestAutomation.Pages.HomePage;
import CRMTestAutomation.Pages.Login_Page;
import CRMTestAutomation.TestBase.Base_Class;

public class HomePage_Test extends Base_Class
{

	Login_Page loginpage;
	HomePage homepage;
	

	@BeforeMethod
	public void set()
	{
		startBrowser(prop.getProperty("browsername"),prop.getProperty("url"));
		loginpage=new Login_Page();
		homepage=new HomePage();
		loginpage.VerifyloginPage(prop.getProperty("username"),prop.getProperty("pass"));
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
