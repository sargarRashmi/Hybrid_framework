package com.qa.FreeCRMPRO.VisionIT.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.FreeCRMPRO.VisionIT.Base.BaseClass;

public class HomePage extends BaseClass
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

		return new ContactPage();
	}

	public DealsPage navigatetoDealsPage()
	{
		driver.switchTo().frame("mainpanel");
		deals.click();
		driver.switchTo().defaultContent();

		return new DealsPage();
	}

	public TaskPage navigatetoTaskPage()
	{
		driver.switchTo().frame("mainpanel");
		task.click();
		driver.switchTo().defaultContent();

		return new TaskPage();
	}

}
