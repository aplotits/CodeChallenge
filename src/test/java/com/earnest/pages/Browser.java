package com.earnest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {
	private static WebDriver driver;;
	//private static WebDriver driver = new ChromeDriver();
    
    public static WebDriver driver() {
    	String BROWSER=System.getProperty("browser");
    	if (BROWSER == null || BROWSER.equalsIgnoreCase("Chrome")) {
    		driver = new ChromeDriver();
    	} 
    	else if (BROWSER.equalsIgnoreCase("Firefox")) {
    	    	driver = new FirefoxDriver();
    	}    	

      return driver;
    }

  public static void open(String url) {
    driver.get(url);
  }

  public static void close() {
    driver.quit();
  }
}
