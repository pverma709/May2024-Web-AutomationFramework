package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;


import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.RegisterPage;
import com.qa.opencart.pages.ResultsPage;

import io.qameta.allure.Step;

public class BaseTest {
	
	protected WebDriver driver;
	protected LoginPage loginPage;
	DriverFactory df;
	protected Properties prop;
	protected AccountsPage accPage;
	protected ResultsPage resultsPage;
	protected ProductInfoPage productInfopage;
	protected RegisterPage registerPage;
	protected SoftAssert softAssert;
	
	@Step("Set up with browser: {0} an dinit the properties")
	@Parameters({"browser"})
	@BeforeTest
	public void setUp (String browserName) {
	
		df = new DriverFactory();
		prop = df.initProp(); //here browser is chrome coming from properties file
		
		// if browsername coming from testNG.xml, we will update the value at runtime
		
		if(browserName != null) {
			prop.setProperty("browser", browserName);
		}
		
		driver = df.initDriver(prop);
		loginPage = new LoginPage(driver);
			

		
	}
	
	@Step("Close the browser")
	@AfterTest
	public void tearDown() {
		driver.close();
		
	}

}
