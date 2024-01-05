package com.maven.MavenWebDriver;

import org.junit.gen5.api.AfterEach;
import org.junit.gen5.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class mavenwithtestng {
	private  ChromeDriver driver;
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver","C:\\AUTOMATION TOOLS\\chromedriver.exe");
	     driver =new ChromeDriver();
	}
	@Test
	public void tcs()
	{
		driver.get("https://careercenter.tops-int.com/");
		 driver.manage().window().maximize();
	}
	
	@AfterMethod
	 public void driverclose() {
		if (driver!=null) {
		 driver.close();
		}
	 } 
}
