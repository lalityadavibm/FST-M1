import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.get("https://training-support.net/webelements/dynamic-attributes");
		
		String title=driver.getTitle();
		System.out.println(title);
		
		WebElement fullName=driver.findElement(By.id("full-name-fd57"));
		WebElement email=driver.findElement(By.id("fd57-email"));
		WebElement date=driver.findElement(By.xpath("//input[@data-testid='event-date']"));
		WebElement additionDetails=driver.findElement(By.id("5938-additional-details-fd57"));
		WebElement button=driver.findElement(By.xpath("//button[text()='Submit']"));
		
		fullName.sendKeys("Lalit");
		email.sendKeys("testemail@gmail.com");
		date.sendKeys("10-11-2025");
		additionDetails.sendKeys("testing");
		button.click();
		
		String message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("action-confirmation")))
                .getText();
        System.out.println("Success message: " + message);

        driver.quit();
			
		

	}

}
