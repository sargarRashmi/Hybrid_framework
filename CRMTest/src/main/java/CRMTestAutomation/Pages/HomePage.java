package CRMTestAutomation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CRMTestAutomation.TestBase.Base_Class;
import CRMTestAutomation.Utility.Helper;

public class HomePage extends Base_Class
{
	@FindBy(xpath="//a[text()='Contacts']")
	@CacheLookup
	WebElement contact ;

	@FindBy(xpath="//a[text()='Deals']")
	@CacheLookup
	WebElement deals ;

	@FindBy(xpath="//a[text()='Tasks']")
	@CacheLookup
	WebElement task ;


	public HomePage() 
	{
		PageFactory.initElements(driver,this);

	}

	public ContactPage navigatetoContactPage()
	{
		driver.switchTo().frame("mainpanel");
		//Clicks contacts Link
		contact.click();
		//Return back to Home page
		driver.switchTo().defaultContent();
		Helper.CaptureScreenShot(driver);
		return new ContactPage();
	}

	public DealsPage navigatetoDealsPage()
	{
		driver.switchTo().frame("mainpanel");
		deals.click();
		driver.switchTo().defaultContent();
		Helper.CaptureScreenShot(driver);

		return new DealsPage();
	}

	public TaskPage navigatetoTaskPage()
	{
		driver.switchTo().frame("mainpanel");
		task.click();
		driver.switchTo().defaultContent();
		Helper.CaptureScreenShot(driver);

		return new TaskPage();
	}

}
