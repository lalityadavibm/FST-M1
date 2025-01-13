package cRM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class P7_ReadAdditionalInformationTest {
	
WebDriver driver;
	
         @BeforeClass
          public void setUp() {
    
  
    driver = new FirefoxDriver();
      }

          @Test
          public void testReadPhoneNumber() {
    
        driver.get("https://alchemy-crm-url.com"); 
        
        WebElement username=driver.findElement(By.xpath("//input[@id=\"user_name\"]"));
		WebElement password=driver.findElement(By.xpath("//input[@id=\"username_password\"]"));
		WebElement loginButton=driver.findElement(By.xpath("//input[@id=\"bigbutton\"]"));
		
		username.sendKeys("admin");
		password.sendKeys("​pa$$w0rd");
		loginButton.click();
        
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("salesMenu"))); 

        WebElement salesMenu = driver.findElement(By.id("salesMenu")); 
        salesMenu.click();
        WebElement leadsOption = driver.findElement(By.id("leadsOption")); 
        leadsOption.click();
        
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("leadsTable"))); 
        WebElement additionalInfoIcon = driver.findElement(By.xpath("//table[@id='leadsTable']//tr[last()]//td[last()]/span[@class='info-icon']")); // Adjust XPath accordingly
        additionalInfoIcon.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("popupPhoneNumber")));
        WebElement phoneNumber = driver.findElement(By.id("popupPhoneNumber"));
        System.out.println("Phone Number: " + phoneNumber.getText());
	}
	

	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}

}
