package com.test.automation.ClearlyRated.Login;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.automation.ClearlyRated.Pages.HomePage;
import com.test.automation.ClearlyRated.Pages.LoginPage;
import com.test.automation.ClearlyRated.Pages.StartUpPage;
import com.test.automation.ClearlyRated.TestBase.TestBase;

import test.automationframework.Exception.CustomException;
import test.automationframework.Utils.Efficacies;
import test.automationframework.Utils.WebDriverUtils;

public class LoginPageElementTest extends TestBase {

	public WebDriver driver;
	public Properties property;
	public StartUpPage startUpPage;
	public LoginPage loginPage;
	public HomePage homePage;
	public String instanceURL;
	SoftAssert softAssert;
	String homeUrl;
	public ObjectMapper mapper;

	@BeforeClass(alwaysRun = true)
	@Parameters({ "environment", "browser" })
	public void LoginToAdminApp(String environment, String browser) throws Exception {
		WebDriverUtils utils = new WebDriverUtils();
		utils.initializeDriver(browser);
		property = new Efficacies().loadPropertyFile(environment);
		driver = WebDriverUtils.getDriver();
		startUpPage = new StartUpPage(driver);
		loginPage = startUpPage.navigateToPage(property.getProperty("baseURL"));
		homeUrl = property.getProperty("baseURL");
	}

	@Test(description = "LoginPageElement_TC_1: Check Forgot Password Link", groups = {
			"Smoke Test" })
	public void testForgotPasswordLnk() throws Exception {
		
		try {
			softAssert = new SoftAssert();

			// Click on Forgot Password Page
			boolean resetBtnVisible = loginPage.navigateToLogin(homeUrl)
					 						   .waitForLoginPageToLoad()
					 						   .clickOnForgotPWDLnk()
					 						   .waitForForgotPasswordPageToLoad()
					 						   .isResetBtnVisible();
			
			softAssert.assertTrue(resetBtnVisible, "Reset Password Page Loaded Successfully.");
			
			softAssert.assertAll();
		} catch (Exception exception) {
			throw new CustomException(exception, driver);
		}
	}

	@Test(description = "LoginPageElement_TC_2: Verify Survey Dashboard Link", groups = {
			"Regression Test" })
	public void testSurveyDashboardLnk() throws Exception {
		
		try {
			softAssert = new SoftAssert();

			// Click on Forgot Password Page
			boolean contactUSBtnVisible = loginPage.navigateToLogin(homeUrl)
					 						   .waitForLoginPageToLoad()
					 						   .clickOnSurveyDashboardLnk()
					 						   .waitForDashboardPageToLoad()
					 						   .isContactUsBtnVisible();
			
			softAssert.assertTrue(contactUSBtnVisible, "Survey Dashboard Page Loaded Successfully.");
			
			softAssert.assertAll();
		} catch (Exception exception) {
			throw new CustomException(exception, driver);
		}
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		startUpPage.killDriver();
	}

}