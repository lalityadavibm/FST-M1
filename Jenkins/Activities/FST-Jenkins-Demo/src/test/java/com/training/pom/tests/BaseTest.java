package com.training.pom.tests;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;

public class BaseTest {
	public WebDriver driver;
	public FirefoxBinary firefoxBinary;
	public FirefoxOptions firefoxOptions;
	  
	@BeforeClass
	public void setup() {
		// Create a new FirefoxDriver. All our test classes will use this.
		firefoxBinary = new FirefoxBinary();
		firefoxBinary.addCommandLineOptions("--headless");
		firefoxOptions = new FirefoxOptions();
		firefoxOptions.setBinary(firefoxBinary);
		driver = new FirefoxDriver(firefoxOptions);
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}

}
