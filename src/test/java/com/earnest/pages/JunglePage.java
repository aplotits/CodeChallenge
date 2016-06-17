package com.earnest.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.earnest.pages.Browser;

/**
 * JunglePage Object
 * Contains elements and methods to interact with data input page of JungleSocks
 *
 */

public class JunglePage extends LoadableComponent<JunglePage> {
	
	private WebDriver driver;
	@FindBy(id = "line_item_quantity_giraffe")
//	@FindBy(xpath = "//tr[5]/td[4]/input")
	private WebElement giraffeTextBox;
	
	@FindBy(xpath = "//tr[3]/td[4]/input")
	private WebElement lionTextBox;
	
	@FindBy(name = "commit")
	WebElement checkoutButton;
	private String url = "https://jungle-socks.herokuapp.com/";
	private static String title = "JungleSocks";

	// Drop down menu of states
	Select selectState;
	
	public JunglePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	 @Override
	  public void load() {
	    Browser.open(url);
	  }

	  @Override
	  public void isLoaded() {
	    Assert.assertEquals(title, driver.getTitle());
	  }
	
	public boolean pageContainsText(String text) {
		return driver.getPageSource().contains(text);
	}
	
	public void enterGiraffeQuantity(String quantity) {
		giraffeTextBox.clear();
		giraffeTextBox.sendKeys(quantity);	
	}
	
	public void enterLionQuantity(String quantity) {
		lionTextBox.clear();
		lionTextBox.sendKeys(quantity);	
	}
	
	public void selectState(String state) {
		selectState = new Select(driver.findElement(By.name("state")));
		selectState.selectByVisibleText(state);
		
	}
	
	public List <String> getAllStates () {
		selectState = new Select(driver.findElement(By.name("state")));
        List <WebElement> allStates = selectState.getOptions();
        List <String> stateStrings = new ArrayList <String>() ;
        for(WebElement element: allStates) {
        	String oneState = element.getText().toString();
        	if (oneState.length() != 0) {
        		stateStrings.add(oneState);
        	}
        }
		return stateStrings;
	}
	
	public CheckoutPage checkout() {
		checkoutButton.click();
		return new CheckoutPage(driver);
	}

	public String getTitle() {
		return driver.getTitle();
	}
	
	public void backAndRefresh() {
		driver.navigate().back();
		driver.navigate().refresh();
	}
	public void back() {
		driver.navigate().back();
	}
}
