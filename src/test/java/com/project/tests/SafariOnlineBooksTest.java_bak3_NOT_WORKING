package com.project.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import com.project.pages.SafariBooksOnlinePage;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.AfterClass;


public class SafariOnlineBooksTest {
	
	final static String SHARED_TEST_DATA_FILE = "src/test/resources/testdata.json";
	@BeforeClass
	
	@AfterClass
	
	
	@DataProvider
	public Object[][] searchData() {
//		return new Object[][] {
//			new Object[] {"Selenium", "842"},
//			new Object[] {"Ruby", "4405"}
//		};	
		return getData(SHARED_TEST_DATA_FILE);
	}

	@Test(dataProvider = "searchData")
	public void testSafariOnlineBooks(String searchString, String numberOfResults) {
		SafariBooksOnlinePage safariSearch = new SafariBooksOnlinePage();
		try {
			safariSearch.load();
			safariSearch.searchForText(searchString);

			Assert.assertEquals("Search for : Safari", safariSearch.getTitle());
			Assert.assertTrue(safariSearch.pageContainsText(numberOfResults));
			
		}
		finally {
			safariSearch.close();
		}
	}
	
	public Object[][] getData(String filePath) {
		JSONArray jsonArray = parseJson(filePath);
		Object[] array = jsonArray.toArray();
        Object[][] data = {
       		 ((ArrayList) array[0]).toArray(),
       		 ((ArrayList) array[1]).toArray()
        };
        System.out.println(Arrays.toString(data[0]));
        System.out.println(Arrays.toString(data[1]));
		return data;
		
	}
	
	
	public JSONArray parseJson(String pathName) {
        JSONParser parser = new JSONParser();
        JSONArray jsonArray = new JSONArray();
        try {
 
            Object obj = parser.parse(new FileReader(pathName));
            jsonArray =  (JSONArray) parser.parse(new FileReader(pathName));
//            Object[] array = jsonArray.toArray();
//            System.out.println(Arrays.toString(array));
//            Object[][] data = {
//            		 ((ArrayList) array[0]).toArray(),
//            		 ((ArrayList) array[1]).toArray()
//            };
//            System.out.println(Arrays.toString(data[0]));
//            System.out.println(Arrays.toString(data[1]));
//            for(int i = 0; i < array.length; i++) {
//            	dataProvider[0][i] = array[i];
//            }
//            Object[][] data;
//            
//            
//            
//            for (int i = 0; i < jsonArray.size() ; i++) {
//            	JSONArray entry = array(i);
//            }

//            System.out.println(jsonArray.toJSONString());
 
//            String name = (String) jsonObject.get("Name");
//            String author = (String) jsonObject.get("Author");
//            JSONArray companyList = (JSONArray) jsonObject.get("Company List");
// 
//            System.out.println("Name: " + name);
//            System.out.println("Author: " + author);
//            System.out.println("\nCompany List:");
//            Iterator<String> iterator = companyList.iterator();
//            while (iterator.hasNext()) {
//                System.out.println(iterator.next());
//            }
 
        } catch (Exception e) {
            e.printStackTrace();
        }
		return jsonArray;
    }

}

