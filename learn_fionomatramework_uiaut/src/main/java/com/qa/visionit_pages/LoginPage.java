package com.qa.visionit_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.visionit_base.BaseClass;
import com.qa.visionit_utility.Helper;

//locate WebElements
public class LoginPage extends BaseClass
{
	@FindBy(name="username")
	@CacheLookup
	WebElement userName;

	@FindBy(name="password")
	@CacheLookup
	WebElement passWord;

	@FindBy(xpath="//input[@type='submit']")
	@CacheLookup
	WebElement loginBtn;

	@FindBy(xpath="(//div[@id='navbar-collapse']/ul/li/a)[2]")
	WebElement signUpLink;

	//constructor
	public LoginPage()
	{
		PageFactory.initElements(driver, this);

	}
	public String verifyloginPageTitle(){	
		return driver.getTitle();
	}

	public RegistrationPage verifyNavigateToRegistrationPage(){

		//signUpLink.click();
		WebDriverWait wait=new WebDriverWait(driver,3);
		boolean invisible=wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("preloader")));
		if(invisible){
			//driver.findElement(By.xpath("(//div[@id='navbar-collapse']/ul/li/a)[2]")).click();
			signUpLink.click();
		}

		Helper.capturesScreenShots(driver);
		return new RegistrationPage();
	}

	//method
	public HomePage loginToCrmPro(String uname,String upass)
	{
		userName.clear();
		userName.sendKeys(uname);
		passWord.clear();
		passWord.sendKeys(upass);

		WebDriverWait wait=new WebDriverWait(driver,3);
		boolean invisible=wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("preloader")));
		if(invisible){
			driver.findElement(By.xpath("//input[@type='submit' or @value='Login']")).click();
			//loginBtn.click();
		}
		Helper.capturesScreenShots(driver);
		return new HomePage();
	}
}


