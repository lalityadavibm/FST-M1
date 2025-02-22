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

public class Activity3 {
	

    AppiumDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Setup Appium driver
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.keep");
        options.setAppActivity(".activities.BrowseActivity");
        options.noReset();
        
        URL serverURL = new URL("http://127.0.0.1:4723/");
        driver = new AndroidDriver(serverURL, options);
        
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void testAddNoteWithReminder() throws InterruptedException {
        // Step 1: Click "Create New Note" button (Floating action button)
        WebElement createNewNoteButton = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.google.android.keep:id/speed_dial_create_close_button")));
        createNewNoteButton.click();

        // Step 2: Add title to the note
        WebElement titleField = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.keep:id/editable_title")));
        titleField.sendKeys("Test Note with Reminder");

        // Step 3: Add description to the note
        WebElement descriptionField = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.keep:id/edit_note_text")));
        descriptionField.sendKeys("This is a test note with a reminder.");

        // Step 4: Click on the reminder icon to set the reminder
        WebElement reminderButton = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.google.android.keep:id/menu_reminder")));
        reminderButton.click();

        // Step 5: Choose the "Afternoon" reminder
        WebElement afternoonReminderOption = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@text='Afternoon']")));
        afternoonReminderOption.click();

        // Step 6: Save the note by pressing the back button
        driver.navigate().back();
        Thread.sleep(2000); // Wait for the note to be saved

        // Step 7: Switch to the Reminders page
        WebElement remindersTab = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.google.android.keep:id/nav_reminder")));
        remindersTab.click();

        // Step 8: Assert that the note with reminder is displayed in the Reminders list
        WebElement noteWithReminder = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='Test Note with Reminder']")));
        Assert.assertNotNull(noteWithReminder, "The note with the reminder was not added.");
    }

    @AfterClass
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
	
	

}
