package com.test.automation.ClearlyRated.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends StartUpPage {

	@FindBy(linkText = "Contact Us")
	private WebElement lnkContactUs;

	public DashboardPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public DashboardPage waitForDashboardPageToLoad() throws Exception {
		ngHelper.waitTillElementIsVisible(lnkContactUs, maxWaitTime)
				.waitTillElementIsClickable(lnkContactUs, maxWaitTime)
				.waitTillPageTitleContains("Net Promoter", maxWaitTime);
		return PageFactory.initElements(driver, DashboardPage.class);
	}
	

	/**
	 * Method to check Contact Us Button visible or not
	 * @return
	 */
	public boolean isContactUsBtnVisible() {
		return ngHelper.checkVisibility(lnkContactUs);
	}
}
