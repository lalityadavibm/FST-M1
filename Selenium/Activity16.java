import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new FirefoxDriver();
		
		driver.get(" https://training-support.net/webelements/selects");
		
		String title=driver.getTitle();
		System.out.println(title);
		
        WebElement dropdown = driver.findElement(By.cssSelector("select.h-10"));
        Select check=new Select(dropdown);
        check.selectByVisibleText("Two");
        check.selectByIndex(3);
        check.selectByValue("Four");
        
        List<WebElement> allOptions=check.getOptions();
        for(WebElement option:allOptions) {
        	System.out.println(option.getText());
        }

		

	}

}
