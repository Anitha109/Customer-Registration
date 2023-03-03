//CREATE DRIVER USING THIS CLASS. DO NOT CHANGE THE CLASS AND METHOD NAME

package com.selenium.setup;

import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSetup {
	public static WebDriver driver;
	public static String baseUrl = "http://webapps.tekstac.com/CustomerRegistration/";
	
	public  WebDriver getDriver() {
	// For Windows OS
		    System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		//
		
		/** For Linux OS **/
////	    System.setProperty("webdriver.gecko.driver", "/usr/bin/geckodriver");
//		
//		FirefoxBinary firefoxBinary = new FirefoxBinary();
//      firefoxBinary.addCommandLineOptions("--headless");
//        FirefoxProfile profile=new FirefoxProfile();
//        FirefoxOptions firefoxOptions = new FirefoxOptions();
//        firefoxOptions.setBinary(firefoxBinary);
//        firefoxOptions.setProfile(profile);
        driver = new FirefoxDriver();
	    driver.navigate().to(DriverSetup.baseUrl);
	    return driver;
		    
//		    {
//		        System.setProperty(
//		            "webdriver.chrome.driver",
//		            "chromedriver.exe");
//		        // Instantiate a ChromeDriver class.
//		         driver = new ChromeDriver();
//		  
//		        // Maximize the browser
//		        driver.manage().window().maximize();
//		        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		  
//		        // Launch Website
//		        driver.get(DriverSetup.baseUrl);
//		        return driver;
		    }
	}
	



