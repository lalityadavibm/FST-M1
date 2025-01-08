import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new FirefoxDriver();
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://training-support.net/webelements/tabs");
		String title=driver.getTitle();
        System.out.println(title);
        
       WebElement newTab=driver.findElement(By.xpath("//button[text()='Open A New Tab']"));
       System.out.println("Current window: "+ driver.getWindowHandle());
    
       newTab.click();
       wait.until(ExpectedConditions.numberOfWindowsToBe(2));
       
       System.out.println("Total open windows: " + driver.getWindowHandles());
       
       for(String handle: driver.getWindowHandles()) {
    	   driver.switchTo().window(handle);
    	   
    	   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Another One')]")));
           System.out.println("Current tab: " + driver.getWindowHandle());
           System.out.println("New Page title: " + driver.getTitle());
           System.out.println("New Page message: " + driver.findElement(By.cssSelector("h2.mt-5")).getText());
           driver.findElement(By.xpath("//button[contains(text(), 'Another One')]")).click();

           wait.until(ExpectedConditions.numberOfWindowsToBe(3));
           for (String handle1 : driver.getWindowHandles()) {
               driver.switchTo().window(handle1);
           }

           driver.quit();
       }
   }
       
	}


