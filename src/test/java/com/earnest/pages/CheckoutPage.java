package com.earnest.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

/**
 * CheckokutPage Object
 * Contains elements and methods to interact with checkout page of JungleSocks
 *
 */
public class CheckoutPage extends LoadableComponent<CheckoutPage> {
    
    @FindBy(id = "subtotal")
    WebElement subtotal;
    @FindBy(id = "total")
    WebElement total;

	private WebDriver driver;
	private String url = "https://jungle-socks.herokuapp.com/checkout/create";
	private static String title = "JungleSocks";

	
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
//		driver = new FirefoxDriver();
		PageFactory.initElements(driver, this);
	}
	
    @Override
	protected void load() {
	    // TODO Auto-generated method stub
	}
	
    @Override
	public void isLoaded() {
	  Assert.assertEquals(title, driver.getTitle());
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
}
