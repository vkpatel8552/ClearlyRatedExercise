package com.test.automation.ClearlyRated.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends StartUpPage {

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
}
