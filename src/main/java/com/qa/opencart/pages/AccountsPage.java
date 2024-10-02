package com.qa.opencart.pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class AccountsPage {
	
//	modifying for git push practice
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By logoutLink = By.linkText("Logout");
	private By headers = By.cssSelector("div#content h2");
	private By search = By.name("search");
	private By searchIcon = By.cssSelector("div#search button");
	
	
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		
	}
	
	public String getAccountPageTitle() {
		
		String title = eleUtil.waitForTitleContainsAndReturn(AppConstants.ACCOUNT_PAGE_TITLE, AppConstants.DEFAULT_SHORT_TIME_OUT);
		System.out.println("Account page Title: " + title);
		return title;
		
	}
	
	
	public Boolean isLogoutLinkExist() {
		return eleUtil.isElementDisplayed(logoutLink);
	}
	
	
	
	public int getTotalAccountsPageHeader() {
		return eleUtil.waitForElementsVisible(headers, AppConstants.DEFAULT_SHORT_TIME_OUT).size();
		
	}
	
	
	public List<String> getAccPageHeaders() {
		
		List <WebElement> headersList = eleUtil.waitForElementsVisible(headers, AppConstants.DEFAULT_SHORT_TIME_OUT);
		List<String> headersValueList = headersList.stream().map(ele -> ele.getText()).collect(Collectors.toList());
		return headersValueList;
	
	}
	
	public ResultsPage doSearch(String searchKey) {
		System.out.println("Search Key ===> " + searchKey);
		WebElement searchele = eleUtil.waitForElementVisible(search, AppConstants.DEFAULT_SHORT_TIME_OUT);
		eleUtil.doSendKeys(searchele, searchKey);
		eleUtil.doClick(searchIcon);
		return new ResultsPage(driver);
		
	}
	
	
	
	

}
