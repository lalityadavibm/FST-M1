package activities;

import java.net.MalformedURLException;
import java.net.URL;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity1 {
	
	AppiumDriver driver;
	
	//setup function
	
	@BeforeClass
	public void setUp() throws MalformedURLException {
		
		//Desired Capabilities
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.android.calculator2");
		options.setAppActivity(".Calculator");
		options.noReset();
		
		//Server URL
		
		URL serverURL=new URL("http://127.0.0.1:4723/");
		
		driver=new AndroidDriver(serverURL, options);
		
		
	}
	@Test
	public void addTest() {
		
		driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_5")).click();
		driver.findElement(AppiumBy.id("com.android.calculator2:id/op_mul")).click();
		driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_5")).click();
		driver.findElement(AppiumBy.id("com.android.calculator2:id/eq")).click();
		
		String result=driver.findElement(AppiumBy.id("com.android.calculator2:id/result")).getText();
		System.out.println(result);

		Assert.assertEquals(result, "25");
	}
		
		@AfterClass
	    public void tearDown() {
	        // Close the app
	        driver.quit();

		
	}
	

}
