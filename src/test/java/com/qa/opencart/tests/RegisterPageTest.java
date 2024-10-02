package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class RegisterPageTest extends BaseTest{
	
	@BeforeClass
	public void regSetUp() {
		
		registerPage = loginPage.navigateToRegisterPage();
	}
	
	public String getRandomEmail() {
		
		return "LearnAutomation" + System.currentTimeMillis() + "@open.com";
	}
	
	
	@DataProvider
	public Object[][] getUserDetails(){
		
		return new Object[][]{
			{"Tom", "Key",  "9999999999" , "vsxhavxga" , "vsxhavxga", "yes" },
			{"Bom", "Tey" , "9999999999" , "vsxhavxga" , "vsxhavxga", "no" },
			{"Dom", "Hey", "9999999999" , "vsxhavxga" , "vsxhavxga", "yes" },
			{"Kom", "Sey", "9999999999" , "vsxhavxga" , "vsxhavxga", "no" },
			{"Mom", "pey", "9999999999" , "vsxhavxga" , "vsxhavxga", "yes" },
		
			
		};
		
		
	}
	
	
	
	@Test(dataProvider = "getUserDetails")	
	public void userRegisterTest(String firstName, String lastName, String telephone, String pwd, String pwdConfirm, String subscribe) {
		
		Assert.assertTrue(registerPage.userRegistration(firstName, lastName, getRandomEmail(), telephone, pwd, pwdConfirm, subscribe ));
		
		
	}
	
	
	
	
	
}
