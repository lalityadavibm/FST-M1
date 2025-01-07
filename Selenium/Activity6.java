import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity6 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver=new FirefoxDriver();
		
		driver.get("https://training-support.net/webelements/dynamic-controls");
		
		String title=driver.getTitle();
		System.out.println(title);
		
		WebElement checkbox=driver.findElement(By.xpath("//input[@id='checkbox']"));
        System.out.println("Checkbox is selected: " + checkbox.isSelected());
        
        Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='checkbox']")).click();
		
        System.out.println("Checkbox is selected: " + checkbox.isSelected());
        
        driver.quit();
        
		

	}

}
