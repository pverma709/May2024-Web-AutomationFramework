package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class RegisterPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	private By firstName = By.id("input-firstname");
//	By.xpath("//label[text()='First Name' and @class ='col-sm-2 control-label']");
	private By lastName = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By pwd = By.id("input-password");
	private By pwdConfirm = By.id("input-confirm");
	private By checkBox = By.name("agree");
	private By continueButton = By.xpath("//*[@id=\"content\"]/form/div/div/input[2]");
	private By subscribeYes = By.xpath("(//input[@name ='newsletter'])[1]");
	private By subscribeNo = By.xpath("(//input[@name ='newsletter'])[2]");
	private By header = By.tagName("h1");
	private By successHeaderAfterRegistration = By.tagName("h1");
	private By warning = By.className("alert-dismissible");
	private By placeHolderText = By.className("form-control");
	private By textFieldLabel = By.className("control-label");
	private By registerLink = By.linkText("Register");
	private By logoutLink = By.linkText("Logout");

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);

	}

	public boolean userRegistration(String firstName, String lastName, String email, String telephone, String pwd,
			String pwdConfirm, String subscribe) {

		eleUtil.waitForElementVisible(this.firstName, AppConstants.DEFAULT_SHORT_TIME_OUT).sendKeys(firstName);

		eleUtil.doSendKeys(this.lastName, lastName);
		eleUtil.doSendKeys(this.email, email);
		eleUtil.doSendKeys(this.telephone, telephone);
		eleUtil.doSendKeys(this.pwd, pwd);
		eleUtil.doSendKeys(this.pwdConfirm, pwdConfirm);

		if (subscribe.equalsIgnoreCase("yes")) {
			eleUtil.doClick(subscribeYes);
		} else {
			eleUtil.doClick(subscribeNo);
		}

		eleUtil.doClick(checkBox);
		
		eleUtil.doClick(continueButton);

		String successMsg = eleUtil
				.waitForElementVisible(successHeaderAfterRegistration, AppConstants.DEFAULT_SHORT_TIME_OUT).getText();

		if (successMsg.contains(AppConstants.USER_REGISTER_SUCCESS_MESSG)) {
			eleUtil.doClick(logoutLink);
			eleUtil.doClick(registerLink);
			
			return true;

		} else {
			return false;
		}

	}

}
