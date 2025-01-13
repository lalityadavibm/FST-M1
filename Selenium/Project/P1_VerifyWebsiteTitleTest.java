package cRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class P1_VerifyWebsiteTitleTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		driver= new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/crm/");
	}
	
	@Test
	public void testWebsiteTitle() {
		
		
		String title=driver.getTitle();
		System.out.println("page title is: " + title);
		Assert.assertEquals(title, "SuiteCRM", "Website title does not match!");
		
		System.out.println("Title matches: " + title);
		
	}
	@AfterMethod
    public void tearDown() {
		driver.quit();
	}
	

}
