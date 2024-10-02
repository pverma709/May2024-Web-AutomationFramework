package com.qa.opencart.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.opencart.errors.AppError;
import com.qa.opencart.exceptions.BrowserException;

import io.qameta.allure.Step;

public class DriverFactory {
	
	Properties prop;	
	protected WebDriver driver;
	
	public static String isHighlight;
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	
	/**
	 * method to initialize the browser
	 * @param browserName
	 * @return
	 */
	@Step("initiialize the browser with prop: {0}")
	public WebDriver initDriver(Properties prop){
		
		String browserName = prop.getProperty("browser");
		System.out.println("browser name is : " + browserName);
		
		isHighlight = prop.getProperty("highlight");
		
		OptionsManager optionsManager = new OptionsManager(prop);

		switch (browserName.toLowerCase().trim()) {
		case "chrome":
			//driver = new ChromeDriver(optionsManager.getChromeOptions());
			tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
			break;
		case "firefox":
			//driver = new FirefoxDriver(optionsManager.getFirefoxOptions());
			tlDriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
			break;
		case "edge":
			//driver = new EdgeDriver(optionsManager.getEdgeOptions());
			tlDriver.set(new EdgeDriver(optionsManager.getEdgeOptions()));
			break;
		case "safari":
			//driver = new SafariDriver();
			tlDriver.set(new SafariDriver());
			break;

		default:
			System.out.println(AppError.INVALID_BROWSER_MESG + browserName + " is invalid");
			throw new BrowserException(AppError.INVALID_BROWSER_MESG);
		}

		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().get(prop.getProperty("url"));

		return getDriver();
		
	}
	
	/**
	 * this method is returning the driver with threadlocal
	 * @return
	 */
	public static WebDriver getDriver() {
		return tlDriver.get();
	}
	
	
	public Properties initProp() {
		
		 prop = new Properties();

		try {
			FileInputStream iP = new FileInputStream(".\\src\\test\\resources\\config\\config.properties");
			
				prop.load(iP);
		} catch (FileNotFoundException e) {
		e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			
			
		} 
		
		
		
		
		return prop;
			
			
		
	}
	
	
	
	
	
	public static String getScreenShot(String methodName) {
		
		File srcFile = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE); //temp dir
		
		String path = System.getProperty("user.dir") + "/screenshot/" + methodName + "_" +  System.currentTimeMillis() + ".png";
		
		
		File destination = new File(path);
		
		try {
			FileHandler.copy(srcFile, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return path;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	}
	



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

