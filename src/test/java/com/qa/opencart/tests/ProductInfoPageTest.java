package com.qa.opencart.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.base.BaseTest;

public class ProductInfoPageTest extends BaseTest {
	
	
	@BeforeClass
	public void productInfoSetUp() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	
	@Test
	public void productHeaderTest() {
		
		resultsPage = accPage.doSearch("macBook");
		
		productInfopage = resultsPage.selectProduct("MacBook Pro");
		
		Assert.assertEquals(productInfopage.getProductHeader(), "MacBook Pro");
				
	}
	

	
//	meta data
//	Brand: Apple
//	Product Code: Product 18
//	Reward Points: 800
//	Availability: In Stock
	
	//price data
//	$2,000.00
//	Ex Tax: $2,000.00
	
	
	@DataProvider
	public Object[][] getCompleteProductData(){
		return new Object[][] {
			{"macBook" , "MacBook Pro", "Apple",  "Product 18", "800", "In Stock", "$2,000.00", "$2,000.00"}
			
			
			
		};
	}
	
	
	
	@Test(dataProvider = "getCompleteProductData")
	public void productInfoTest(String searchKey, String searchResult, String brand, String productCode, String rewardsPoint, String availability, String productPrice, String taxParice) {
		
		softAssert = new SoftAssert();
		
		resultsPage = accPage.doSearch(searchKey);
		
		productInfopage = resultsPage.selectProduct(searchResult);
		
		
		Map<String, String> completeProdData = productInfopage.getCompleteProdData();
		
		softAssert.assertEquals(completeProdData.get("Brand"), brand);
		softAssert.assertEquals(completeProdData.get("Product Code"), productCode);
		softAssert.assertEquals(completeProdData.get("Reward Points"), rewardsPoint);
		softAssert.assertEquals(completeProdData.get("Availability"), availability);
		softAssert.assertEquals(completeProdData.get("productPrice"), productPrice);
		softAssert.assertEquals(completeProdData.get("exTaxPrice"), taxParice);
		softAssert.assertAll();
		
		
	}
	
	@DataProvider
	public Object[][] getProductImagesCountData(){
		
		return new Object[][] {
			
			{"macbook" , "MacBook Pro", 4 },
			{"imac" , "iMac", 3 },
			
			
		};
		
	}
	
	@Test(dataProvider = "getProductImagesCountData")
	public void productImagesCountTest(String searchKey, String searchResult, int count) {
		
		resultsPage = accPage.doSearch(searchKey);
		
		productInfopage = resultsPage.selectProduct(searchResult);
		Assert.assertEquals(productInfopage.getProductImagesCount(),  count ); 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
