package CRMTestAutomation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CRMTestAutomation.TestBase.Base_Class;

public class New_ContactPage extends Base_Class
{
	@FindBy(name="first_name")
	@CacheLookup
	WebElement first_name;

	
	@FindBy(name="surname")
	@CacheLookup
	WebElement Last_name;
	
	@FindBy(name="client_lookup")
	@CacheLookup
	WebElement company;
	
	@FindBy(name="addmore")
	@CacheLookup
	WebElement Savebtn;
	
	public New_ContactPage()
	{
		PageFactory.initElements(driver,this);
	}

	public void verify_New_contactPage()
	{
		
			first_name.sendKeys("Rashmi");
			Last_name.sendKeys("Sargar");
			company.sendKeys("Synechron");
			Savebtn.click();
			System.out.println("Added successfully");
		
	}
}
