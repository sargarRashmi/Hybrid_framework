package CRMTestAutomation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import CRMTestAutomation.TestBase.Base_Class;
import CRMTestAutomation.Utility.Helper;

public class Login_Page extends Base_Class
{
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
		@FindBy(xpath="//input[@type='submit' or @value='Login']")
		@CacheLookup
		WebElement signupbtn;
		//Constructor



		public Login_Page()
		{
			PageFactory.initElements(driver,this);
		}


		public String Loginpage_title()
		{
			return driver.getTitle();

		}

		public HomePage VerifyloginPage(String us,String Pwd)
		{

			username.clear();
			username.sendKeys(us);

			password.clear();
			password.sendKeys(Pwd);

			/*JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("arguments[0].click();",loginbtn);*/

			WebDriverWait wait=new  WebDriverWait(driver, 3);
			boolean invisible=wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("preloader")));

			if(invisible) 
			{
				signupbtn.click();	
			}
			
			Helper.CaptureScreenShot(driver);
			return new HomePage();

		}


}
