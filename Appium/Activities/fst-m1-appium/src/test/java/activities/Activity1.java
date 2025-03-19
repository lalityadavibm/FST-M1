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

    // Setup function
    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.calculator2");
        options.setAppActivity(".Calculator");
        options.noReset();

        // Server URL
        URL serverURL = new URL("http://127.0.0.1:4723/");

        driver = new AndroidDriver(serverURL, options);
    }

    @Test
    public void addTest() {
        // Locating elements using 3 different locators:

        // 1. ID locator
        driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_5")).click(); // Clicking 5
        driver.findElement(AppiumBy.id("com.android.calculator2:id/op_mul")).click();  // Clicking multiplication operator (*)
        driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_5")).click(); // Clicking 5 again
        driver.findElement(AppiumBy.id("com.android.calculator2:id/eq")).click();      // Clicking equals (=)

        // 2. XPath locator: Accessing the result element using XPath
        String result = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.android.calculator2:id/result']")).getText();
        System.out.println("Result using XPath: " + result);

        // 3. Accessibility ID locator: Assuming there's an element with accessibility ID, e.g., for checking a clear button
        driver.findElement(AppiumBy.accessibilityId("Clear")).click(); // Clicking the Clear button if available
        String clearResult = driver.findElement(AppiumBy.id("com.android.calculator2:id/result")).getText(); // Clear result
        System.out.println("Result after clear using Accessibility ID: " + clearResult);

        // Validate the multiplication result
        Assert.assertEquals(result, "25", "Multiplication result is incorrect");
    }

    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }
}
