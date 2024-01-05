package com.maven.MavenWebDriver;


import org.junit.gen5.api.AfterEach;
import org.junit.gen5.api.BeforeEach;
import org.junit.gen5.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class mavenwithjunit {
	private  ChromeDriver driver;
	@BeforeEach
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
	
	@AfterEach
	 public void driverclose() {
		if (driver!=null) {
		 driver.close();
		}
	 } 
	
	
}
