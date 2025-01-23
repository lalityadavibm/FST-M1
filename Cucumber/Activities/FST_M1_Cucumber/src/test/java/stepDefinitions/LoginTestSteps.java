package stepDefinitions;


import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginTestSteps {
	
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	
	@Given("the user is on the login page")
    public void openPage1() {
		
		driver=new FirefoxDriver();

        driver.get("https://training-support.net/webelements/login-form");

        Assertions.assertEquals("Selenium: Login Form", driver.getTitle());
    }
 
    @When("the user enters username and password")
    public void enterCredentials1() {

        driver.findElement(By.id("username")).sendKeys("admin");

        driver.findElement(By.id("password")).sendKeys("password");
    }
 
    @When("the user enters {string} and {string}")
    public void enterCredentialsFromInputs1(String username, String password) {

        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));

        usernameField.clear();
        passwordField.clear();

        usernameField.sendKeys(username);

        passwordField.sendKeys(password);
    }
 
    @And("clicks the submit button")
    public void clickSubmit1() {

        driver.findElement(By.xpath("//button[text()='Submit']")).click();
    }
 
    @Then("get the confirmation message and verify it")
    public void confirmMessage1() {

        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("h2.mt-5"), "Welcome"));
        String message = driver.findElement(By.cssSelector("h2.mt-5")).getText();

        Assertions.assertEquals("Welcome Back, Admin!", message);
    }
 
    @Then("get the confirmation text and verify message as {string}")
    public void confirmMessageAsInput1(String expectedMessage) {

        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("h2.mt-5"), "Welcome"));
        String message = driver.findElement(By.cssSelector("h2.mt-5")).getText();

        Assertions.assertEquals(expectedMessage, message);
    }

}
