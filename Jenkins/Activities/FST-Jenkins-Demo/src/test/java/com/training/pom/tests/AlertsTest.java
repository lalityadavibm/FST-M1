package com.training.pom.tests;

import org.testng.annotations.Test;

import com.training.pom.pages.AlertsPage;

public class AlertsTest extends BaseTest {
	
  @Test
  public void triggerSimpleAlert() {
	  AlertsPage page = new AlertsPage(driver);
	  page.goToPage().getButton(page.SimpleAlertButton).click();
	  page.getAlertTextAndAccept();
  }

}
