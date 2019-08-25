package com.qa.FreeCRMPRO.VisionIT.Base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class BaseClass 
{
	public static WebDriver driver;

	public void startbrowser(String brrname,String url)
	{
		System.setProperty("webdriver.chrome.driver","D:\\Rashmi\\Selenium\\Selenium3\\Chrome\\chromedriver.exe");

		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
	}
}
