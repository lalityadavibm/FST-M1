package activities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity2 {
	
	AppiumDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setUP() throws MalformedURLException {
		
		UiAutomator2Options options=new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.android.chrome");
		options.setAppActivity("com.google.android.apps.chrome.Main");
		options.noReset();

		URL serverURL=new URL("http://127.0.0.1:4723/");
		
		driver=new AndroidDriver(serverURL,options);
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
	}
	
	@Test
	public void chromeTest() {
	
		    driver.get("https://training-support.net");


		    WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.view.View[@text=\"Training Support\"]")));
		    String headerText = header.getText();
		    System.out.println("Header Text is: " + headerText);
		    

		    WebElement aboutousButton = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.view.View[@text=\"About Us\"]")));
		    aboutousButton.click();


		    WebElement aboutusHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.view.View[@text=\"About Us\"]")));
		    String aboutousText = aboutusHeader.getText();

		    System.out.println("About Us Page header Text is: " + aboutousText);
		}

		
	
	
	 @AfterClass
	    public void tearDown() {
	        // Close the app
	        driver.quit();
	
	

}
}
