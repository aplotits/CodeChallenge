package com.project.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.project.pages.GooglePage;


public class GoogleSearchTest {

	@Test
	public void testGoogleSearch() {
		GooglePage googleSearch = new GooglePage();
		googleSearch.load();
		googleSearch.searchForText("Selenium testing tools cookbook");

		Assert.assertEquals("Selenium testing tools cookbook - Google Search",
				googleSearch.getTitle());
		
		googleSearch.close();
	}

}
