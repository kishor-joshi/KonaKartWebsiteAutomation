package com.konakart.util;





import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;




public class BaseClass {
	public  WebDriver driver;
/**
 * select driver class type
 * 
 * @param browserType
 * @throws IOException
 */
	
	public Properties property=new Properties();
	public void openBrowser(String browserType) throws IOException {
		Properties property=new Properties();
		
			
	
			switch (browserType) {
		case "chrome":
			ChromeOptions optionschrome = new ChromeOptions();
			optionschrome.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver", Constants.chromeDriverPath);
			 driver = new ChromeDriver(optionschrome);
			break;
			
		case "firefox":
			System.setProperty("webdriver.gecko.driver", Constants.fireFoxDriverPath);
			
			driver = new FirefoxDriver();
			break;
			
		case "ie":
			
			System.setProperty("webdriver.ie.driver", Constants.IEDriverPath);
			driver = new InternetExplorerDriver();
			break;
	
		}
		
		driver.manage().window().maximize();
		PageManager.manageTimeOuts(driver);
		PageManager.loadpropertyFile(Constants.driverPropertiesFilePath, property);
		driver.get(property.getProperty("url"));
		
		
	}
	

}
