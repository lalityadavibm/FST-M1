package stepDefinitions;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Test {
	
	private WebDriver driver;
	private String title;
		
	@Given("user is on the training support home page")
	public void user_is_on_home_page() {
		
		driver =new FirefoxDriver();
		driver.get("https://training-support.net");
		
	}
	
	@When("the user checks the title of the page")
	public void user_checks_the_title() {
		title=driver.getTitle();
		
	}
	
	@Then("they should see Training Support")
	public void user_should_see_training_support() {
		Assertions.assertEquals("Training Support", title);
		
	}
	
	@And("close the browser")
	public void close_the_browser() {
		
		driver.quit();
		
	}




}
