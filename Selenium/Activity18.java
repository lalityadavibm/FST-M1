import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new FirefoxDriver();
		driver.get("https://training-support.net/webelements/alerts");
		
		String title=driver.getTitle();
		System.out.println(title);
		
		driver.findElement(By.xpath("//button[text()='Simple']")).click();
		Alert simpleAlert=driver.switchTo().alert();
		String alertText=simpleAlert.getText();
		System.out.println("Text in alert: " + alertText);
		
		simpleAlert.accept();
		
		String successMessage=driver.findElement(By.xpath("//p[@id='result']")).getText();
		System.out.println("Success message is : " + successMessage);
		
		driver.quit();

	}

}
