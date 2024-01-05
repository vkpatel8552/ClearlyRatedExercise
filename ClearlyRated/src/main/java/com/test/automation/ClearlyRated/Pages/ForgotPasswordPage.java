package com.test.automation.ClearlyRated.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage extends StartUpPage {

	@FindBy(xpath = "//div[contains(text(),'Reset Your Password')]")
	private WebElement restPasswordTab;
	
	@FindBy(css = "input[type=submit]")
	private WebElement btnResetPassword;

	public ForgotPasswordPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public ForgotPasswordPage waitForForgotPasswordPageToLoad() throws Exception {
		ngHelper.waitTillElementIsVisible(restPasswordTab, maxWaitTime)
			 	.waitTillPageTitleContains("Forgot Password", maxWaitTime);
		return PageFactory.initElements(driver, ForgotPasswordPage.class);
	}
	
	/**
	 * Method to check Reset Password Button visible or not
	 * @return
	 */
	public boolean isResetBtnVisible() {
		return ngHelper.checkVisibility(btnResetPassword);
	}
}
