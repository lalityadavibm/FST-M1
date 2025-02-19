package stepDefinitions;

import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps_Activity2 {
	
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	
	 @Given("the user is on the login page")
	    public void openPage() {
		 
		    driver=new FirefoxDriver();
	        driver.get("https://training-support.net/webelements/login-form");
	        String title=driver.getTitle();

	        Assertions.assertEquals("Selenium: Login Form", title);
	    }
	 
	    @When("the user enters username and password")
	    public void enterCredentials() {
	    	
	        driver.findElement(By.id("username")).sendKeys("admin");
	        driver.findElement(By.id("password")).sendKeys("password");
	    }
	 
	    @And("clicks the submit button")
	    public void clickSubmit() {

	        driver.findElement(By.xpath("//button[text()='Submit']")).click();
	    }
	 
	    @Then("get the confirmation message and verify it")
	    public void confirmMessage() {

	        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("h2.mt-5"), "Welcome"));
	        String message = driver.findElement(By.cssSelector("h2.mt-5")).getText();

	        Assertions.assertEquals("Welcome Back, Admin!", message);
	    }
	

}
