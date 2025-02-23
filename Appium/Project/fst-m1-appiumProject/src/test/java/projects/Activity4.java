package projects;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.touch.offset.PointOption;

public class Activity4 {
	
	 AppiumDriver driver;
	    WebDriverWait wait;

	    @BeforeClass
	    public void setUp() throws MalformedURLException {
	        // Setup Appium to work with Chrome on Android
	    	UiAutomator2Options options = new UiAutomator2Options();
			options.setPlatformName("android");
			options.setAutomationName("UiAutomator2");
			options.setAppPackage("com.android.chrome");
			options.setAppActivity("com.google.android.apps.chrome.Main");
			options.noReset();
			
			URL serverURL = new URL("http://127.0.0.1:4723/");
			driver = new AndroidDriver(serverURL, options);
			
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        
	    }

	    @Test
	    public void testToDoList() throws InterruptedException {
	        // Step 1: Open the URL
	        driver.get("https://v1.training-support.net/selenium");

	        
	        TouchAction action = new TouchAction((PerformsTouchActions) driver);

	        // Perform swipe gesture from bottom to top (Scroll down)
	        action.press(PointOption.point(500, 1500))   // Starting point (bottom of the screen)
	              .moveTo(PointOption.point(500, 500))    // Ending point (top of the screen)
	              .release()
	              .perform();
	        
	        // Step 2: Scroll to find the To-Do List card and click it
	        WebElement todoCard = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.view.View[contains(@text, 'To-Do List')]")));
	        todoCard.click();

	        // Step 3: Add tasks to the list
	        WebElement taskInputField = waitForElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='taskInput']"), 20);
	        
	        // Adding the first task
	        taskInputField.sendKeys("Add tasks to list");
	        WebElement addButton = driver.findElement(AppiumBy.xpath("//button[text()='Add']"));
	        addButton.click();
	        
	        // Adding the second task
	        taskInputField.sendKeys("Get number of tasks");
	        addButton.click();
	        
	        // Adding the third task
	        taskInputField.sendKeys("Clear the list");
	        addButton.click();

	        // Step 4: Strike out each task by clicking on it
	        WebElement firstTask = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//li[contains(text(),'Add tasks to list')]")));
	        firstTask.click();

	        WebElement secondTask = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//li[contains(text(),'Get number of tasks')]")));
	        secondTask.click();

	        WebElement thirdTask = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//li[contains(text(),'Clear the list')]")));
	        thirdTask.click();

	        // Step 5: Clear the list (remove all tasks)
	        WebElement clearButton = driver.findElement(AppiumBy.xpath("//button[@text='Clear List']"));
	        clearButton.click();
	        
	        // Step 6: Verify that all tasks are removed
	        WebElement taskCount = driver.findElement(AppiumBy.xpath("//span[@class='todo-count']"));
	        String taskCountText = taskCount.getText();
	        Assert.assertEquals(taskCountText, "0", "The number of tasks is not zero after clearing the list.");
	    }

	    private WebElement waitForElement(By xpath, int i) {
			// TODO Auto-generated method stub
			return null;
		}

		@AfterClass
	    public void tearDown() {
	        // Close the driver after the test completes
	        if (driver != null) {
	            driver.quit();
	        }
	    }

}
