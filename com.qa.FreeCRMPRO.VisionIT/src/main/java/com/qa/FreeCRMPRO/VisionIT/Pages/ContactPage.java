package com.qa.FreeCRMPRO.VisionIT.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.FreeCRMPRO.VisionIT.Base.BaseClass;

public class ContactPage extends BaseClass
{
	@FindBy(xpath="//a[text()='Contacts']")
	@CacheLookup
	WebElement contact ;

	@FindBy(xpath="//a[text()='New Contact']")
	@CacheLookup
	WebElement New_Contact;



	public ContactPage()
	{
		PageFactory.initElements(driver,this);
	}


	public New_ContactPage navigate_NewContact_Form()
	{
		driver.switchTo().frame("mainpanel");
		
		Actions action=new Actions(driver);
		action.moveToElement(contact);
	
		action.moveToElement(New_Contact).click().perform();

	//	New_Contact.click();
	
		return new New_ContactPage();
	}
}
