package CRMTest.TestPages;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import CRMTestAutomation.Pages.Login_Page;
import CRMTestAutomation.TestBase.Base_Class;

public class Login_Page_Test extends Base_Class
{
	static Login_Page loginpage;

	@BeforeMethod
	public void setup()
	{
		startBrowser(prop.getProperty("browsername"),prop.getProperty("url"));

		loginpage=new Login_Page();
	}

	@SuppressWarnings("deprecation")
	@Test(priority=1)
	public void verify_LoginPAge_Title()
	{
		String actualPageTitle=loginpage.Loginpage_title();
		System.out.println(actualPageTitle);
		String expectedPagetitle="CRMPRO - CRM software for customer relationship management, sales, and support.";
		Assert.assertEquals(actualPageTitle, expectedPagetitle,"Title of the Page doesn't match");
	}

	//For accesing data from config file use this
	/*@Test(priority=2)
	public void Verify_Login_Page()
	{
		loginpage.VerifyloginPage(prop.getProperty("username"),prop.getProperty("pass"));
	}*/

	// For accessing data from excel use this

	@Test(priority=2,dataProvider="getExcelData")
	public void verifyLoginToFreeCRmProTest(String uname, String upass)
	{
		loginpage.VerifyloginPage(uname,upass);

		Assert.assertTrue(driver.getTitle().contains("CRMPRO"),"Titlte of the Home Page doesn't contain CRMPRO");
		
	}
	
	@DataProvider
	public Object [][] getExcelData() 
	{
		return exceldata.getExcelTestData("Login");

	}
	/*@AfterMethod

	public void teardown()
	{
		driver.quit();
	}*/
}
