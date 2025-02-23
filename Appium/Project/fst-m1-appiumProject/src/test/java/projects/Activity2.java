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

public class Activity2 {

    AppiumDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void SetUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.keep");
        options.setAppActivity(".activities.BrowseActivity");  
        options.noReset();  

        URL serverURL = new URL("http://127.0.0.1:4723/");
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void testAddNote() throws InterruptedException {
        WebElement createNewNoteButton = wait.until(
            ExpectedConditions.elementToBeClickable(AppiumBy.id("com.google.android.keep:id/speed_dial_create_close_button"))
        );
        createNewNoteButton.click();

        WebElement createNewNoteTextButton = wait.until(
            ExpectedConditions.elementToBeClickable(AppiumBy.id("new UiSelector().resourceId(\"com.google.android.keep:id/snackbar_text"))
        );
        createNewNoteTextButton.click();

        WebElement titleField = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.keep:id/editable_title")));
        titleField.sendKeys("Test Note");

        WebElement descriptionField = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.keep:id/edit_note_text")));
        descriptionField.sendKeys("Hey, I am mobile tester");

        driver.navigate().back();

        Thread.sleep(2000);

        WebElement noteTitle = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Test Note']"));
        Assert.assertNotNull(noteTitle, "The note with title 'Test Note' was not added.");
    }

    @AfterClass
    public void tearDown() {
        // Close the driver after the test completes
        if (driver != null) {
            driver.quit();
        }
    }
}
