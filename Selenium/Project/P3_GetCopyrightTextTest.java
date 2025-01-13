package cRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class P3_GetCopyrightTextTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		
		driver=new FirefoxDriver();
		
	}
	
	@Test
	public void testGetCopyrightText () {
		
		driver.get("https://alchemy.hguy.co/crm/");

		String copyrightText=driver.findElement(By.xpath("//a[text()='© Supercharged by SuiteCRM']")).getText();
		
		System.out.println("First Copy Right Text is: " + copyrightText);
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
