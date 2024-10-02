package com.qa.opencart.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class ProductInfoPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	private Map<String, String> productMap;
	
	private By productHeader = By.tagName("h1");
	private By productMetaData = By.xpath("(//div[@class='col-sm-4']//ul)[1]/li");
	private By productPrice = By.xpath("(//div[@class='col-sm-4']//ul)[2]/li");
	private By productImage = By.cssSelector("ul.thumbnails li");
	
	
	public ProductInfoPage(WebDriver driver) {
		
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		
	}
	
	public String getProductHeader() {
		String productHeaderValue = eleUtil.waitForElementVisible(productHeader, AppConstants.DEFAULT_SHORT_TIME_OUT).getText();
		System.out.println("product Header value ===> " + productHeaderValue);
//		productMap.put("product Header valu", productHeaderValue);
		System.out.println("first test done-----");
		return productHeaderValue;
	}
	
// header
//	MacBook Pro
	
//	meta data
//	Brand: Apple
//	Product Code: Product 18
//	Reward Points: 800
//	Availability: In Stock
	
	
	
	
	private void getProductMetaData() {
		
			
		List<WebElement> productMetaList = eleUtil.getElements(productMetaData);
		for(WebElement e : productMetaList) {
		String productMetaDataArray[] = e.getText().split(":");
		productMap.put(productMetaDataArray[0].trim(),productMetaDataArray[1].trim() );
						
		}
	
	
	}
	
	//price data
//	$2,000.00
//	Ex Tax: $2,000.00
	
	private void getProductPriceData() {
		
		List<WebElement> productPriceData = eleUtil.getElements(productPrice);
		productMap.put("productPrice", productPriceData.get(0).getText().trim());
		
		String productTaxPrice[] = productPriceData.get(1).getText().split(":");
		productMap.put("exTaxPrice",productTaxPrice[1].trim() );
		
	
	}
	
	
	public Map<String, String> getCompleteProdData() {
		
		
		productMap = new HashMap<String, String>();
		getProductHeader();
		getProductMetaData();
		getProductPriceData();
		System.out.println("product full data " + productMap);
		
		return productMap;
	}
	
	
	
	
	
	public int getProductImagesCount(){
		
		int imagesCount = eleUtil.waitForElementsPresence(productImage, AppConstants.DEFAULT_MEDIUM_TIME_OUT).size();
				
		System.out.println("Images count ===> " + imagesCount);
		
		return imagesCount;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


}
	
	

