package com.test.automation.ClearlyRated.Login;

import java.util.Map;
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

public class LoginTest extends TestBase {

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

	@Test(description = "Login_TC_1: Verify Login Functionality with blank username and password", groups = {
			"Regression Test" })
	public void loginWithBlankCredential() throws Exception {
		String jsonFilePath = "/Login/Login_TC1.json";

		try {
			softAssert = new SoftAssert();

			// Read data from Json File
			Map<String, String> testData = new Efficacies().readJsonElementInOrder(jsonFilePath, "Data");

			// Navigate to Login Page
			loginPage.navigateToLogin(homeUrl)
					 .waitForLoginPageToLoad();

			// Enter blank credentials to check login functionality
			loginPage.enterUserCredentials(testData.get("loggedInUserEmail"), testData.get("loggedInUserPassword"))
					.clickOnLoginBtn();

			// Verfiy Error Message
			String actualErrMsg = loginPage.getLoginErrMsg();
			softAssert.assertEquals(actualErrMsg, testData.get("errMsg"));

			softAssert.assertAll();
		} catch (Exception exception) {
			throw new CustomException(exception, driver);
		}
	}

	@Test(description = "Login_TC_2: Verify Login Functionality with blank username", groups = {
			"Regression Test" })
	public void loginWithBlankEmail() throws Exception {
		String jsonFilePath = "/Login/Login_TC1.json";

		try {
			softAssert = new SoftAssert();

			// Read data from Json File
			Map<String, String> testData = new Efficacies().readJsonElementInOrder(jsonFilePath, "Data");

			// Navigate to Login Page
			loginPage.navigateToLogin(homeUrl)
					 .waitForLoginPageToLoad();

			// Enter blank credentials to check login functionality
			loginPage.enterUserCredentials(testData.get("loggedInUserEmail"), testData.get("loggedInUserPassword"))
					.clickOnLoginBtn();

			// Verfiy Error Message
			String actualErrMsg = loginPage.getLoginErrMsg();
			softAssert.assertEquals(actualErrMsg, testData.get("errMsg"));

			softAssert.assertAll();
		} catch (Exception exception) {
			throw new CustomException(exception, driver);
		}
	}

	@Test(description = "Login_TC_3: Verify Login Functionality with Invalid Credentials", groups = {
			"Regression Test" })
	public void loginWithInValidCredential() throws Exception {
		String jsonFilePath = "/Login/Login_TC1.json";

		try {
			softAssert = new SoftAssert();

			// Read data from Json File
			Map<String, String> testData = new Efficacies().readJsonElementInOrder(jsonFilePath, "Data");

			// Navigate to Login Page
			loginPage.navigateToLogin(homeUrl)
					 .waitForLoginPageToLoad();

			// Enter blank credentials to check login functionality
			loginPage.enterUserCredentials(testData.get("loggedInUserEmail"), testData.get("loggedInUserPassword"))
					.clickOnLoginBtn();

			// Verfiy Error Message
			String actualErrMsg = loginPage.getLoginErrMsg();
			softAssert.assertEquals(actualErrMsg, testData.get("errMsg"));

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