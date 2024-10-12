package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.listeners.AnnotationTransformer;
import com.qa.opencart.listeners.ExtentReportListener;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

//to activate listeners if we run from test class and not from testNG.xml
@Listeners({ExtentReportListener.class , AnnotationTransformer.class})
	@Epic(" Epic 100: desihn page java")
	@Story("Stroy gdfs=1236")
	@Owner("pv")
	public class LoginPageTest extends BaseTest {
	
			
	@Severity(SeverityLevel.MINOR)
	@Feature("Feature 400: login page title feature")
	@Description("Login page title test")
	@Test
	public void loginPageTitleTest() {
		
		String actualTitle = loginPage.loginPageTitle();
		Assert.assertEquals(actualTitle, AppConstants.LOGIN_PAGE_TITLE);
	}
	
	@Severity(SeverityLevel.NORMAL)
	@Feature("Feature 400: login page url feature")
	@Description("Login page ur; test")
	@Test
	public void loginPageUrlTest() {
		
		String actualUrl = loginPage.loginPageUrl();
		Assert.assertTrue(actualUrl.contains(AppConstants.LOGIN_PAGE_FRACTION_URL));
	}
	
	
	@Severity(SeverityLevel.NORMAL)
	@Feature("Feature 400: login page url feature")
	@Issue("Bug-123")
	@Test
	public void forgotPwdLinkExistTest() {
		
		Assert.assertTrue(loginPage.forgotPwdLinkExist());
	}
	
	@Severity(SeverityLevel.TRIVIAL)
	@Feature("Feature 400: login page Logo feature")
	@Test
	public void logoDisplayedTest() {
		
		Assert.assertTrue(loginPage.logoDisplayed());
	}
	
	@Severity(SeverityLevel.CRITICAL)
	@Feature("Feature 400: login page login feature")
	@Test(priority= Integer.MAX_VALUE)
	public void doLoginTest() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(accPage.getAccountPageTitle(), AppConstants.ACCOUNT_PAGE_TITLE);
		
	}
	
	
	
	
	
	
	
//	route=account/success
//	May2024Naveen@gmail.com
//	zxcvbnmkj
// video at 38.20	
	
	
	
}

