package com.earnest.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.earnest.pages.Browser;
import com.earnest.pages.CheckoutPage;
import com.earnest.pages.JunglePage;

import java.util.ArrayList;
import java.util.List;


public class JungleTest {
 
	// Testing Notes:
	// North Dakota miscalculates tax
	// Quantity 50000 causes "java.lang.NumberFormatException: For input string: "1,000,034.00" "
	
	final static String ORDER_QUANTITY_ONE = "1";
	final static String ORDER_QUANTITY_TWO = "2";
	final static String ORDER_QUANTITY_LIMIT = "50000";
	
	JunglePage jungle = new JunglePage(Browser.driver());
	
	@BeforeClass
	public void setJungle() {
		jungle.get();
	}
	
	@AfterClass
	public void closeJungle() {
		Browser.close();
	}
	SoftAssert softAssert = new SoftAssert();
	List <String> allStates = new ArrayList <String>();
	
	// Using data provider for zero and negative input values
	@DataProvider
	  public Object[][] testData() {
	    return new Object[][] {
	        new Object[] { "0"},
	        new Object[] { "-2"}};
	  }
	
	@Test(dataProvider = "testData")
	public void zeroAndNegative(String quantity) {
		List <String> someStates = new ArrayList <String>();
		someStates.add("California");
		someStates.add("North Dakota");
		someStates.add("Alabama");
		testSteps(jungle, someStates, quantity);
		
	}
	
	@Test()
	public void testAllStates() {
		try {
			String giraffeQuantity = ORDER_QUANTITY_TWO;
			List <String> allStates = jungle.getAllStates();
			for (String oneState: allStates) {
				jungle.enterGiraffeQuantity(giraffeQuantity);
				jungle.selectState(oneState);
				CheckoutPage checkoutPage = jungle.checkout();
				checkoutPage.get();
				float subTotal = Float.parseFloat(checkoutPage.getSubtotal().replace("$", ""));
				float total = Float.parseFloat(checkoutPage.getTotal().replace("$", ""));
				softAssert.assertEquals(calculateExpectedTotal(oneState, subTotal),  
						total ,oneState + ": Actual and Expected Totals did not match");
				jungle.backAndRefresh();
			}
			
			softAssert.assertAll();
		} 
		catch (Exception e) {
			System.out.println(e);
		}
	}

	
	@Test()
	public void testTwoTypes() {
		System.out.println("TESTING TWO TYPES");
		try {
			jungle.get();
			Thread.sleep(2000);
			String giraffeQuantity = ORDER_QUANTITY_ONE;
			String lionQuantity = ORDER_QUANTITY_LIMIT;
			List <String> someStates = new ArrayList <String>();
			someStates.add("California");
			someStates.add("North Dakota");
			someStates.add("Alabama");
			for (String oneState: someStates) {
				jungle.enterGiraffeQuantity(giraffeQuantity);
				jungle.enterLionQuantity(lionQuantity);
				jungle.selectState(oneState);
				CheckoutPage checkoutPage = jungle.checkout();
				checkoutPage.get();
				float subTotal = Float.parseFloat(checkoutPage.getSubtotal().replace("$", ""));
				float total = Float.parseFloat(checkoutPage.getTotal().replace("$", ""));
				softAssert.assertEquals(calculateExpectedTotal(oneState, subTotal),  
						total ,oneState + ": Actual and Expected Totals did not match");
				jungle.backAndRefresh();
			}
			softAssert.assertAll();
		} 
		catch (Exception e) {
			System.out.println(e);
		}
		finally {
			try {
				Thread.sleep(1000);
				jungle.backAndRefresh();
			}
			catch(Exception e) {
				System.out.println(e);
			}
			
		}
	}
	
	
	
	public void testSteps(JunglePage jungle, List <String> states, String quantity) {
		try {
			for (String oneState: states) {
				jungle.get();
				jungle.enterGiraffeQuantity(quantity);
				jungle.selectState(oneState);
				CheckoutPage checkoutPage = jungle.checkout();
				checkoutPage.get();
				float subTotal = Float.parseFloat(checkoutPage.getSubtotal().replace("$", ""));
				float total = Float.parseFloat(checkoutPage.getTotal().replace("$", ""));
				softAssert.assertEquals(calculateExpectedTotal(oneState, subTotal),  
						total ,oneState + ": Actual and Expected Totals did not match");
				jungle.backAndRefresh();
			}
			softAssert.assertAll();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}

	private Float calculateExpectedTotal(String oneState, float subTotal) {
		float tax = (float) -1000.00;
		if (oneState.equals("California")) {
			tax = (float) (subTotal * 0.08);
		}
		else if (oneState.equals("Minnesota")){
			tax = (float) (subTotal * 0.00);
		}
		
		else if (oneState.equals("New York")) {
			tax = (float) (subTotal * 0.06);
		}
		
		else {
			tax = (float) (subTotal * 0.05);
		}	
		float expectedTotal = (float) subTotal + tax;
		return expectedTotal;
	}

}

