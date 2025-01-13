package cRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class P2_GetHeaderImageUrlTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		
		driver=new FirefoxDriver();
		
	}
	
	@Test
	public void testHeaderImageUrl() {
		
		driver.get("https://alchemy.hguy.co/crm/");

		WebElement HeaderImg=driver.findElement(By.xpath("//img[@alt='SuiteCRM']"));
		String headerUrl=HeaderImg.getAttribute("src");
		
		System.out.println("Header image Url: " + headerUrl);
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}
	
	

}
