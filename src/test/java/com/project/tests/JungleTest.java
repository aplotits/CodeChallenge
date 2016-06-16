package com.project.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeClass;

import com.project.pages.Browser;
import com.project.pages.CheckoutPage;
import com.project.pages.JunglePage;
import com.project.pages.SafariBooksOnlinePage;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.AfterClass;


public class JungleTest {

	@BeforeClass
	
	@AfterClass
	
	
	@DataProvider
	public Object[][] inputData() {
		return new Object[][] {
			new Object[] {"1", "California", "842"},
//			new Object[] {"2", "4405", "2"}
		};	
	}

	@Test(dataProvider = "inputData")
	public void testGiraffe(String quantity, String state, String result) {
		
		
		JunglePage jungle = new JunglePage(Browser.driver());
		jungle.load();
		List <String> allStates = new ArrayList <String>();
//		List <String> allStates = jungle.getAllStates();
		allStates.add("California");
		allStates.add("Minnesota");
		allStates.add("North Dakota");
		for (String oneState: allStates) {
			System.out.println("One state is: " + oneState);
		}
//		jungle.close();
		
		try {
//			jungle.load();
//			jungle.enterGiraffeQuantity(quantity);
//			jungle.selectState("California");
//			CheckoutPage checkoutPage = jungle.checkout();
//			Assert.assertEquals(checkoutPage.getTotal(), "$18.36");
//			jungle.backAndRefresh();
//			jungle.enterGiraffeQuantity(quantity);
//			jungle.selectState("California");
//			checkoutPage = jungle.checkout();
//			Assert.assertEquals(checkoutPage.getTotal(), "$18.36");
//			
//			checkoutPage.refreshPage();
			
//			jungle.load();
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertTrue(false);
			for (String oneState: allStates) {
				jungle.enterGiraffeQuantity(quantity);
				System.out.println("The state is: " + oneState);
				jungle.selectState(oneState);
				CheckoutPage checkoutPage = jungle.checkout();
				float subTotal = Float.parseFloat(checkoutPage.getSubtotal().replace("$", ""));
				float total = Float.parseFloat(checkoutPage.getTotal().replace("$", ""));
//				softAssert.assertTrue(false);
				Assert.assertTrue(isTaxCorrect(oneState, subTotal, total),  "Actual and Expected Totals did not match");
				
//				if (oneState.equals("California")) {
//					Assert.assertEquals(checkoutPage.getTotal(), "$18.36");
//				}
//				else if (oneState.equals("Minnesota")){
//					Assert.assertEquals(checkoutPage.getTotal(), "$17.00");
//				}
//				
//				else {
//					Assert.assertEquals(checkoutPage.getTotal(), "17.85");
//				}
				jungle.backAndRefresh();
//				Assert.assertEquals(checkoutPage.getTotal(), "$18.36");
			}
			

//			Assert.assertEquals();
//			Assert.assertTrue();
			
		} 
//		catch (AssertionError e) {
//			System.out.println(e);
//		}
		finally {
			jungle.close();
		}
	}

	private boolean isTaxCorrect(String oneState, float subTotal, float total) {
		Boolean result = false;
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
		System.out.println("Exptected Total is: " + expectedTotal);
		
		result = (expectedTotal == total) ?  true :  false;
		
//		if (expectedTotal == total) {
//			result = true;
//		}
//		else {
//			result = false;
//		}
		
		return result;
	}

}

