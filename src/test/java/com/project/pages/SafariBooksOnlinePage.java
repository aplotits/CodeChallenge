package com.project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SafariBooksOnlinePage {
	
	@FindBy(name = "q")
	@CacheLookup
	private WebElement searchTextBox;
	private WebDriver driver;
	private String url = "https://www.safaribooksonline.com";

	
	public SafariBooksOnlinePage() {
		driver = new FirefoxDriver();
		PageFactory.initElements(driver, this);
	}
	
	public void load() {
	    this.driver.get(url);
	}
	public void close() {
	    this.driver.close();
	}
	
	public boolean pageContainsText(String text) {
		return driver.getPageSource().contains(text);
	}
	
	public void searchForText(String text) {
		searchTextBox.clear();
		searchTextBox.sendKeys(text);
		searchTextBox.submit();
		// Google's search is rendered dynamically with JavaScript.
	    // Wait for the page to load, timeout after 10 seconds
//		new WebDriverWait(driver, 30).until(new ExpectedCondition<Boolean>() {
//			public Boolean apply(WebDriver d) {
//				return d.getTitle().toLowerCase()
//						.startsWith("Search");
//			}
//		});
	}

	public String getTitle() {
		return driver.getTitle();
	}
}
