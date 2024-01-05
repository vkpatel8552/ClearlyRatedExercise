package com.test.automation.ClearlyRated.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends StartUpPage {

	@FindBy(css = "div#dashboard-login")
	private WebElement loginDashboardTab;

	@FindBy(id = "email")
	private WebElement inputEmail;

	@FindBy(name = "password")
	private WebElement inputPassword;

	@FindBy(xpath = "//input[@value='Submit']")
	private WebElement btnSubmit;

	@FindBy(partialLinkText = "forgot my password")
	private WebElement lnkForgotPassword;
	
	@FindBy(partialLinkText = "ClearlyRated survey reporting dashboard")
	private WebElement lnkSurveyDashboard;
	
	@FindBy(css = "div.alert")
	private WebElement alertMsg;

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	/**
	 * Method to wait for Login Page to Load
	 * @return
	 * @throws Exception
	 */
	public LoginPage waitForLoginPageToLoad() throws Exception {
		ngHelper.waitTillElementIsVisible(loginDashboardTab, maxWaitTime)
				.waitTillPageTitleContains("Please Login", maxWaitTime);
		return PageFactory.initElements(driver, LoginPage.class);
	}
	
	/**
	 * Method to Navigate to Login Page
	 * @param url
	 * @return
	 */
	public LoginPage navigateToLogin(String url) {
		ngHelper.navigateTo(url);
		return PageFactory.initElements(driver, LoginPage.class);
	}
	
	/**
	 * Method to enter User Credentials
	 * @param email
	 * @param password
	 * @return 
	 * @throws Exception
	 */
	public LoginPage enterUserCredentials(String email, String password) throws Exception {
		ngHelper.waitTillElementIsVisible(inputEmail, maxWaitTime)
				.sendKeysTo(inputEmail, email);
		
		ngHelper.waitTillElementIsVisible(inputPassword, maxWaitTime)
				.sendKeysTo(inputPassword, password);
		return PageFactory.initElements(driver, LoginPage.class);	
	}

	/**
	 * Method to Click on Login Button
	 * @return
	 * @throws Exception
	 */
	public HomePage clickOnLoginBtn() throws Exception {
		ngHelper.waitTillElementIsVisible(btnSubmit, maxWaitTime)
				.waitTillElementIsClickable(btnSubmit, maxWaitTime)
				.click(btnSubmit);
		return PageFactory.initElements(driver, HomePage.class);
	}
	
	/**
	 * Method to get Login Error Message
	 * @return
	 * @throws Exception
	 */
	public String getLoginErrMsg() throws Exception {
		String errMsg = ngHelper.waitTillElementIsVisible(alertMsg, maxWaitTime)
								.getInnerText(alertMsg);
		return errMsg;	
	}
	
	/**
	 * Method to Click on Survey Dashboard Link
	 * @return
	 * @throws Exception
	 */
	public DashboardPage clickOnSurveyDashboardLnk() throws Exception {
		ngHelper.waitTillElementIsVisible(lnkSurveyDashboard, maxWaitTime)
				.waitTillElementIsClickable(lnkSurveyDashboard, maxWaitTime)
				.click(lnkSurveyDashboard);
		return PageFactory.initElements(driver, DashboardPage.class);
	}
	
	/**
	 * Method to click on Forgot Password Link
	 * @return
	 * @throws Exception
	 */
	public ForgotPasswordPage clickOnForgotPWDLnk() throws Exception {
		ngHelper.waitTillElementIsVisible(lnkForgotPassword, maxWaitTime)
				.waitTillElementIsClickable(lnkForgotPassword, maxWaitTime)
				.click(lnkForgotPassword);
		return PageFactory.initElements(driver, ForgotPasswordPage.class);
	}
}
