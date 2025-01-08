import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new FirefoxDriver();
		driver.get("https://training-support.net/webelements/selects");
		
		String titler=driver.getTitle();
		
        WebElement values = driver.findElement(By.cssSelector("select.h-80"));
        Select val=new Select(values);
        
        val.selectByVisibleText("HTML");
        for (int i = 3; i <= 5; i++) {
            val.selectByIndex(i);
        }
        
        val.selectByValue("Node");
        
        List<WebElement> selectedOptions=val.getAllSelectedOptions();
        System.out.println("Selcted optiones are: ");
        for(WebElement option : selectedOptions) {
        	System.out.println(option.getText());
        	
        }
        
        val.deselectByIndex(5);
        
        System.out.println("Final Selcted optiones are: ");
        for(WebElement option : selectedOptions) {
        	System.out.println(option.getText());
        	
        }
        driver.quit();
        


	}

}
