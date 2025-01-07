import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		
		WebDriver driver=new FirefoxDriver();
		
		Actions builder=new Actions(driver);
		driver.get("https://training-support.net/webelements/mouse-events");
		
		String title=driver.getTitle();
		System.out.println(title);
		
		WebElement cargoLock_button = driver.findElement(By.xpath("//h1[text()='Cargo.lock']"));
        WebElement cargoToml_button = driver.findElement(By.xpath("//h1[text()='Cargo.toml']"));
        WebElement src = driver.findElement(By.xpath("//h1[text()='src']"));
        WebElement targetButton = driver.findElement(By.xpath("//h1[text()='target']"));
		
		builder.click(cargoLock_button).pause(500).moveToElement(cargoToml_button)
		.pause(2000).click(cargoToml_button).build().perform();
		
		String finalText=driver.findElement(By.id("result")).getText();
		System.out.println(finalText);
		
		builder.doubleClick(src).pause(5000).contextClick(targetButton).pause(3000).build().perform();
		
		builder.click(driver.findElement(By.xpath("//div[@id='menu']/div/ul/li[1]"))).pause(5000).build().perform();
		finalText = driver.findElement(By.id("result")).getText();
        System.out.println(finalText);
        driver.quit();
	}

}
