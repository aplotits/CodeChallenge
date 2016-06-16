package com.project.pages;

import java.util.ArrayList;
import java.util.List;

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

import com.project.pages.Browser;


public class JunglePage {
	
	private WebDriver driver;
	
//	@FindBy(id = "line_item_name_giraffe")
	@FindBy(xpath = "//tr[5]/td[4]/input")
	private WebElement giraffeTextBox;
	

//	@FindBy(xpath = "//select[@name='state']")
//	@FindBy(name = "state")
//	WebElement selectMenue;
//	private Select selectState = new Select(selectMenue);
	
	
	@FindBy(name = "commit")
	WebElement checkoutButton;
	private String url = "https://jungle-socks.herokuapp.com/";

	Select selectState;
	
	public JunglePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// Initialize variable
	}
	
	public void load() {
	    Browser.open(url);
	}
	public void close() {
	    this.driver.close();
	}
	
	public boolean pageContainsText(String text) {
		return driver.getPageSource().contains(text);
	}
	
	public void enterGiraffeQuantity(String quantity) {
		giraffeTextBox.clear();
		giraffeTextBox.sendKeys(quantity);	
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
        
        for(String oneState: stateStrings){
        	System.out.println(oneState);
        }
		return stateStrings;
		
//		this.selectMenue.click();
//		this.selectMenue.sendKeys(state);
//		this.selectMenue.click();
//		selectState.selectByVisibleText(state);
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
}
