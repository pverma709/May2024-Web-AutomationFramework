package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class AccountsPageTest extends BaseTest {
	
	@BeforeClass
	public void accSetUp() {
		
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test
	public void AccountsPageTitleTest() {
		
		String actualTitle = accPage.getAccountPageTitle();
		Assert.assertEquals(actualTitle, AppConstants.ACCOUNT_PAGE_TITLE);
	}
	
	
	@Test
	public void isLogoutLinkExistTest() {
		Assert.assertTrue(accPage.isLogoutLinkExist());
	}

	@Test
	public void accPageHeadersCountTest() {
		Assert.assertEquals(accPage.getTotalAccountsPageHeader(), AppConstants.ACCOUNTS_PAGE_HEADERS_COUNT);

	}

	@Test
	public void accPageHeadersTest() {
		List<String> actualHeadersList = accPage.getAccPageHeaders();
		Assert.assertEquals(actualHeadersList, AppConstants.EXPECTED_ACC_PAGE_HEADERS_LIST);
	}
	
	
	@DataProvider
	public Object[][] getSearchKey(){
		return new Object[][] {
			{"macbook", 3},
			{"imac", 1},
			{"samsung", 2}
		
		
		};
		
		
	}
	
	@Description("search functionality")
	@Severity(SeverityLevel.CRITICAL)
	@Test(dataProvider = "getSearchKey")
	public void searchCountTest(String searchKey, int searchCount) {
		resultsPage =   accPage.doSearch(searchKey);
		Assert.assertEquals(resultsPage.getSearchResultsCount(), searchCount); 
		
	}
	
	
	@DataProvider
	public Object[][] getSearchData(){
		return new Object[][] {
			{"macbook", "MacBook Pro"},
			{"macbook", "MacBook Air"},
			{"imac", "iMac"},
			{"samsung", "Samsung Galaxy Tab 10.1"}
		
		
		};
		
		
	}
	
	
	
	@Test(dataProvider = "getSearchData")
	public void searchTest(String searchKey, String productname ) {
		resultsPage =   accPage.doSearch(searchKey);
		productInfopage = resultsPage.selectProduct(productname);
		Assert.assertEquals(productInfopage.getProductHeader(), productname);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//video recap - pom03 sep 11 49.30 min
	

}
