import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver= new FirefoxDriver();
		
		driver.get("https://training-support.net/webelements/login-form/");
		
		String title=driver.getTitle();
		System.out.println("Tilte of the page: " + title);
		
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.linkText("Submit")).click();
		
		String message = driver.findElement(By.tagName("h1")).getText();
        System.out.println(message);
		driver.quit();
		

	}

}
