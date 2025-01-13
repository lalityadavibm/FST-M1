package cRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class P6_MenuCheckingTest {

WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		driver =new FirefoxDriver();
		
	}
	
	@Test
	public void testMenuChecking() {
		
        driver.get("https://alchemy.hguy.co/crm/");
		
		WebElement username=driver.findElement(By.xpath("//input[@id=\"user_name\"]"));
		WebElement password=driver.findElement(By.xpath("//input[@id=\"username_password\"]"));
		WebElement loginButton=driver.findElement(By.xpath("//input[@id=\"bigbutton\"]"));
		
		username.sendKeys("admin");
		password.sendKeys("​pa$$w0rd");
		loginButton.click();
		
		WebElement activitiesMenu = driver.findElement(By.xpath("//a[@id='grouptab_3']"));
        Assert.assertTrue(activitiesMenu.isDisplayed(), "Homepage not loaded or Activities menu not found!");

        Assert.assertTrue(activitiesMenu.isEnabled(), "Activities menu is not clickable!");

        System.out.println("Activities menu exists and is clickable.");
        
		
	}
	

	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
}
