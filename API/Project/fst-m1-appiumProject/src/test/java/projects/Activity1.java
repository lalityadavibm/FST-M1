package projects;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
	WebDriverWait wait;
	
	@BeforeClass
	public void SetUp() throws MalformedURLException {
		
		UiAutomator2Options options=new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.google.android.apps.tasks");
		options.setAppActivity(".ui.TaskListsActivity");
		options.noReset();
		
       URL serverURL=new URL("http://127.0.0.1:4723/");
		
		driver=new AndroidDriver(serverURL,options);
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
	}
	
	 @Test
	    public void testAddTasks() throws InterruptedException {
	        // Add Task 1: "Google Tasks"
	        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/tasks_fab")).click();
	        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title"))).sendKeys("Google Tasks");
	        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();

	        // Add Task 2: "Google Keep"
	        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/tasks_fab")).click();
	        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title"))).sendKeys("Google Keep");
	        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();

	        // Add Task 3: "2nd Google Keep"
	        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/tasks_fab")).click();
	        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title"))).sendKeys("2nd Google Keep");
	        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();

	        // Wait a moment to ensure tasks are added
	        Thread.sleep(2000);

	        // Verify that the tasks were added successfully
	        WebElement task1 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Google Tasks']"));
	        WebElement task2 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Google Keep']"));
	        WebElement task3 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='2nd Google Keep']"));

	        Assert.assertNotNull(task1, "Google Tasks was not added.");
	        Assert.assertNotNull(task2, "Google Keep was not added.");
	        Assert.assertNotNull(task3, "2nd Google Keep was not added.");
	    }

	    @AfterClass
	    public void tearDown() {

	        if (driver != null) {
	            driver.quit();
	        }
	    }
}
