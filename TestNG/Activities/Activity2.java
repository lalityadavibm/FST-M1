package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		
		driver=new FirefoxDriver();
		driver.get("https://training-support.net/webelements/target-practice/");
	}
	@Test
	public void firstTest() {
		
		String title=driver.getTitle();
		System.out.println("Page Title is: " + title);
		Assert.assertEquals(title, "Selenium: Target Practice");
	}
	
		
	@Test
	public void secondTest() {
		
		WebElement blackButton=driver.findElement(By.cssSelector("button.black"));
		Assert.assertTrue(blackButton.isDisplayed());
		Assert.assertEquals(blackButton.getText(), "black");
	}

	@Test(enabled = false)
	public void thirdTest() {
		String subHeading=driver.findElement(By.className("sub")).getText();
        Assert.assertTrue(subHeading.contains("Practice"));

		
	}
	@Test
	public void fourthTest() {
        throw new SkipException("Skipping test case");

		
	}
	
	
	
	@AfterClass
    public void tearDown() {
        driver.quit();

}
}

