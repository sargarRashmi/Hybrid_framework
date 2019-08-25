package com.qa.FreeCRMPRO.VisionIT.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.FreeCRMPRO.VisionIT.Base.BaseClass;


public class LoginPage extends BaseClass
{
	//@CacheLookup- Buffer data into temporary Memory

	// UserName
	@FindBy(name="username")
	@CacheLookup
	WebElement username;

	// Password
	@FindBy(name="password")
	@CacheLookup
	WebElement password;

	// LOgin Button
	@FindBy(xpath="//input[@type='submit'  or @value='Login']")
	@CacheLookup
	WebElement loginbtn;

	//Signup Button
	@FindBy(xpath="//a[text()='Sign Up']")
	@CacheLookup
	WebElement signupbtn;
	//Constructor



	public LoginPage()
	{
		PageFactory.initElements(driver,this);
	}

	public String VerifyLoginPageTitle()
	{
		return driver.getTitle();
	}

	public HomePage VerifyloginPage(String us,String Pwd)
	{
		
		username.clear();
		username.sendKeys(us);

		password.clear();
		password.sendKeys(Pwd);
		
		/*Actions action=new Actions(driver);
		action.moveToElement(loginbtn).click().perform();*/
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",loginbtn);
		//loginbtn.click();

		return new HomePage();

	}

	public void SignUpPage()
	{
		signupbtn.click();
	}
}
