package activities;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import static activities.ActionBase.doSwipe;

public class Activity6 {
	
	AppiumDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void beforeClass() throws MalformedURLException {
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.android.chrome");
		options.setAppActivity("com.google.android.apps.chrome.Main");
		options.noReset();
		
		URL serverURL = new URL("http://127.0.0.1:4723/");
		driver = new AndroidDriver(serverURL, options);
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://training-support.net/webelements/sliders");
	}
	
	@Test
	public void volume75Test() {
		// Wait for SeekBar to be clickable
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.SeekBar")));
		
		// Get the size of the screen
		Dimension dims = driver.manage().window().getSize();
		System.out.println(dims);
		
		// Set the start and end points for the swipe
		Point start = new Point((int) (dims.getWidth() * .50), (int) (dims.getHeight() * .65));
		Point end = new Point((int) (dims.getWidth() * .67), (int) (dims.getHeight() * .65));
		
		// Perform the swipe to set the volume to 75%
		doSwipe(driver, start, end, 2000);
 
		// Get the volume level text
//		String volumeText = driver
//			.findElement(AppiumBy.xpath("//android.view.View/android.widget.TextView[contains(@text, '%')]"))
//			.getText();
//		
//		// Assertions to check if the volume is set to 75%
//		assertTrue(volumeText.contains("75%"));
	}
	
	@Test
	public void volume25Test() {
		// Wait for SeekBar to be clickable
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.SeekBar")));
		
		// Get the size of the screen
		Dimension dims = driver.manage().window().getSize();
		
		// Set the start and end points for the swipe (Volume 25%)
		Point start = new Point((int) (dims.getWidth() * .50), (int) (dims.getHeight() * .65));
		Point end = new Point((int) (dims.getWidth() * .33), (int) (dims.getHeight() * .65));
		
		// Perform the swipe to set the volume to 25%
		doSwipe(driver, start, end, 2000);
	
		// Get the volume level text
//		String volumeText = driver
//			.findElement(AppiumBy.xpath("//android.view.View/android.widget.TextView[contains(@text, '%')]"))
//			.getText();
// 
//		// Assertions to check if the volume is set to 25%
//		assertTrue(volumeText.contains("25%"));
	}
 
	@AfterClass
	public void tearDown() {
		// Close the browser
		driver.quit();
	}
}
