import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver= new FirefoxDriver();
		
		driver.get("https://training-support.net");
		
		String title=driver.getTitle();
		System.out.println("Page title is: " + title);
		
		Thread.sleep(2000);
		
		driver.findElement(By.className("card mx-auto my-8 w-52 text-center svelte-4bhb3l")).click();
		
		String newTitle=driver.getTitle();
		System.out.println("New page title is: " + newTitle);
		
		driver.quit();
		
		

	}

}
