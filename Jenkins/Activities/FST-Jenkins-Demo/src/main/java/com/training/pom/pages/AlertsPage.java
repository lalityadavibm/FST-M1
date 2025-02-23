package com.training.pom.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AlertsPage extends BasePage {
	
	// Constructor
	public AlertsPage(WebDriver driver) {
		super(driver);
	}
	
	// Page Variables
	String URL = new String("https://v1.training-support.net/selenium/javascript-alerts");
	
	// Web Elements
	public By SimpleAlertButton = By.cssSelector("button#simple");
	public By ConfirmationButton = By.cssSelector("button#confirm");
	public By PromptButton = By.cssSelector("button#prompt");
	
	// Page Methods
	public AlertsPage goToPage() {
		driver.get(this.URL);
		return this;
	}
	
	public WebElement getButton(By element) {
		WebElement button = driver.findElement(element);
		return button;
	}
	
	public void clickButton(WebElement button) {
		button.click();
	}
	
	public void AcceptAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	public void DismissAlert() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}
	
	public void getAlertTextAndAccept() {
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
	}

}
