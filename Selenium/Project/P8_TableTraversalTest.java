package cRM;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class P8_TableTraversalTest {
	
	 WebDriver driver;
	    
	    @BeforeMethod
	    public void setUp() {
	        driver = new FirefoxDriver();
	    }
	    
	    @Test
	    public void testPrintOddRowsOfTable() {
	        driver.get("https://alchemy.hguy.co/crm/");
	        
	        // Wait for the login elements to be visible and log in
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_name")));
	        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username_password")));
	        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("bigbutton")));
	        
	        username.sendKeys("admin");
	        password.sendKeys("pa$$w0rd");
	        loginButton.click();
	        
	        // Wait for the Sales -> Accounts menu item to be clickable and navigate to Accounts
	        WebElement salesMenu = wait.until(ExpectedConditions.elementToBeClickable(By.id("grouptab_0")));
	        salesMenu.click();
	        
	        WebElement accountsMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='moduleTab_9_Accounts']")));
	        accountsMenu.click();
	        
	        // Wait for the table to load and find the table rows
	        WebElement accountsTable = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='list view']")));
	        List<WebElement> rows = accountsTable.findElements(By.tagName("tr"));
	        
	        // Loop through the rows and print names of odd-numbered rows (1st, 3rd, 5th, etc.)
	        int count = 0;
	        for (int i = 1; i < rows.size(); i += 2) {  // Skip even-indexed rows (0-based index)
	            WebElement row = rows.get(i);
	            List<WebElement> columns = row.findElements(By.tagName("td"));
	            if (!columns.isEmpty()) {
	                String accountName = columns.get(2).getText();  // Assuming the name is in the 3rd column
	                System.out.println("Account Name (Row " + (i+1) + "): " + accountName);
	                count++;
	            }
	            if (count == 5) {
	                break;
	            }
	        }
	    }

	    @AfterMethod
	    public void tearDown() {
	        driver.quit();
	    }

}
