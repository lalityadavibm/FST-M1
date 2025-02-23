package projects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity5 {
	
	
	 WebDriver driver;

	    @BeforeMethod
	    public void setUp() {
	        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
	        driver = new FirefoxDriver();
	    }

	    @Test(priority = 1)
	    public void testLoginWithCorrectCredentials() {
	        driver.get("https://v1.training-support.net/selenium");

	        WebElement loginCard = driver.findElement(By.xpath("//div[@class='card'][.//h3[contains(text(),'Login Form')]]"));
	        loginCard.click();

	        WebElement usernameField = driver.findElement(By.id("username"));
	        WebElement passwordField = driver.findElement(By.id("password"));
	        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));

	        usernameField.sendKeys("admin");
	        passwordField.sendKeys("password");
	        loginButton.click();

	        WebElement confirmationMessage = driver.findElement(By.id("action-confirmation"));
	        String message = confirmationMessage.getText();
	        Assert.assertEquals(message, "Welcome admin", "Login with correct credentials failed.");
	    }

	    @Test(priority = 2)
	    public void testLoginWithIncorrectCredentials() {
	        driver.get("https://v1.training-support.net/selenium");

	        WebElement loginCard = driver.findElement(By.xpath("//div[@class='card'][.//h3[contains(text(),'Login Form')]]"));
	        loginCard.click();

	        WebElement usernameField = driver.findElement(By.id("username"));
	        WebElement passwordField = driver.findElement(By.id("password"));
	        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));

	        // Input invalid credentials
	        usernameField.sendKeys("wrongUser");
	        passwordField.sendKeys("wrongPassword");
	        loginButton.click();

	        // Verify that the login failed
	        WebElement confirmationMessage = driver.findElement(By.id("action-confirmation"));
	        String message = confirmationMessage.getText();
	        Assert.assertEquals(message, "Invalid credentials", "Login with incorrect credentials failed.");
	    }

	    @AfterMethod
	    public void tearDown() {
	        // Close the browser
	        driver.quit();
	    }

}
