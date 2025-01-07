import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver=new FirefoxDriver();
		driver.get("https://training-support.net/webelements/dynamic-controls");
		
		String title=driver.getTitle();
		System.out.println("Title of the page: " + title);
		
		WebElement checkbox=driver.findElement(By.xpath("//input[@id='checkbox']"));
        System.out.println("Checkbox is displayed: " + checkbox.isDisplayed());

		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Toggle Checkbox']")).click();
		
        System.out.println("Checkbox is displayed: " + checkbox.isDisplayed());
        
        driver.quit();



		
		
		

	}

}
