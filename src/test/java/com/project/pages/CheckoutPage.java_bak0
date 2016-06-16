package com.project.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CheckoutPage {
	
    @FindBy(id = "subtotal")
    WebElement subtotal;
    @FindBy(id = "total")
    WebElement total;

	private WebDriver driver;
	private String url = "https://jungle-socks.herokuapp.com/checkout/create";

	
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
//		driver = new FirefoxDriver();
		PageFactory.initElements(driver, this);
	}
	
//	public void load() {
//	    this.driver.get(url);
//	}
	public void close() {
	    this.driver.close();
	}
	
	public String getSubtotal() {
		return subtotal.getText();
	}
	
	public String getTotal() {
		return total.getText();
	}
	
	public boolean pageContainsText(String text) {
		return driver.getPageSource().contains(text);
	}
	
	

	public String getTitle() {
		return driver.getTitle();
	}

	public void refreshPage() {
		driver.navigate().refresh();
	}
}
