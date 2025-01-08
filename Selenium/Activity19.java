import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 WebDriver driver = new FirefoxDriver();

	        driver.get("https://training-support.net/webelements/alerts");
	        System.out.println("Page title: " + driver.getTitle());

	        driver.findElement(By.xpath("//button[text()='confirm']")).click();
	      
	        Alert confirmAlert = driver.switchTo().alert();

	        String alertText = confirmAlert.getText();
	        System.out.println("Text Message in alert: " + alertText);

	        confirmAlert.accept();

	        System.out.println(driver.findElement(By.xpath("//p[@id='result']")).getText());
	        
	        driver.quit();


	}

}
