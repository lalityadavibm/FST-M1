import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver =new FirefoxDriver();
		driver.get("https://training-support.net/webelements/dynamic-controls");
		
		String title=driver.getTitle();
		System.out.println(title);
		
		WebElement textField=driver.findElement(By.id("textInput"));
		System.out.println("Is text field enable: " + textField.isEnabled());
		
		WebElement EnableInput=driver.findElement(By.xpath("//button[text()='Enable Input']"));
		System.out.println("Is text field enable: " + EnableInput.isEnabled());
		
		driver.quit();

	}

}
