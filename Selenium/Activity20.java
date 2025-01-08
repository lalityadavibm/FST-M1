import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new FirefoxDriver();
		driver.get("https://training-support.net/webelements/alerts");
		
		String title=driver.getTitle();
		System.out.println(title);
		
		driver.findElement(By.xpath("//button[text()='prompt']")).click();
		Alert promtAlert=driver.switchTo().alert();
        String alertText = promtAlert.getText();
        
        System.out.println("Text Message in alert: " + alertText);
        promtAlert.sendKeys("Awesome!");
        promtAlert.accept();
        
        System.out.println(driver.findElement(By.xpath("//p[@id='result']")).getText());

        driver.quit();



	}

}
