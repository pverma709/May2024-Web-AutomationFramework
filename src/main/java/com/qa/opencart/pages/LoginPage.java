package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

import io.qameta.allure.Step;

public class LoginPage {
	
	//1. private by locators also called page objects
	
	//2. public page constructor
	
	//3. public page actions/methods
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	By logo = By.cssSelector("img.img-responsive");
	By username = By.id("input-email");
	By password = By.id("input-password");
	By loginbutton = By.cssSelector("input.btn ");
	By forgotPwdLink = By.linkText("Forgotten Password");
	By registerPageLink = By.linkText("Register");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	@Step("Getting login page title value")
	public String loginPageTitle() {
		String title = eleUtil.waitForTitleContainsAndReturn(AppConstants.LOGIN_PAGE_TITLE, AppConstants.DEFAULT_SHORT_TIME_OUT);
		 System.out.println("login page title: " + title);
		return title;	
	}
	
	
	@Step("Getting login page url value")
	public String loginPageUrl() {
		String url =eleUtil.waitForURLContainsAndReturn(AppConstants.LOGIN_PAGE_FRACTION_URL, AppConstants.DEFAULT_SHORT_TIME_OUT);
		System.out.println("login page url: " + url);
		return url;
	}
	
	
	@Step("checking forgotPwdLinkExist on login page")
	public Boolean forgotPwdLinkExist() {
		return eleUtil.isElementDisplayed(forgotPwdLink);
		
	}
	
	@Step("checking login displayed on login page")
	public Boolean logoDisplayed() {
		return eleUtil.isElementDisplayed(logo);
		
	}
	
	@Step("login with username: {0} and password {1}")
	public AccountsPage doLogin(String userName, String pwd) {
		
		eleUtil.waitForElementVisible(username, AppConstants.DEFAULT_MEDIUM_TIME_OUT).sendKeys(userName);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(loginbutton);
//		String accountPageTitle = eleUtil.waitForTitleContainsAndReturn(AppConstants.ACCOUNT_PAGE_TITLE, AppConstants.DEFAULT_SHORT_TIME_OUT);
//		System.out.println("Account page Title: " + accountPageTitle);
		return new AccountsPage(driver);
		
		
	}
	
	@Step("Navigating to register page")
	public RegisterPage navigateToRegisterPage() {
		
		eleUtil.doClick(registerPageLink);
		
		return new RegisterPage(driver);
		
	}


	
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

