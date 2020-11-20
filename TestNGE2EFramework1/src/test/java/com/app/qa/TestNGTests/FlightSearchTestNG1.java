package com.app.qa.TestNGTests;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Connection.Base;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.app.qa.base.TestBase;
import com.app.qa.pages.FlightResultPage;
import com.app.qa.pages.FlightSearchPage;
import com.app.qa.util.TestUtil;

public class FlightSearchTestNG1 extends TestBase {

	public static Logger Log = LogManager.getLogger(TestBase.class.getName());

	FlightSearchPage flightsearchpage;
	FlightResultPage flightresultpage;
	TestUtil testutil;

	String sheetName = "Places";

	public FlightSearchTestNG1() {
		super();
	}

	@BeforeMethod
	public void setup() {
		Log.info("TestCase Started");
		initialization();
		Log.info("Driver is initialized and navigated to url");
		flightsearchpage = new FlightSearchPage();
		testutil = new TestUtil();
	}

	@Test(priority = 1)
	public void verfiyFlightSearchTitleTest() {
		String title = testutil.doGetPageTitle();
		System.out.println(title);
		Log.info("The page title is: " + title);
		Assert.assertEquals(title, "Online flight booking, Hotels, Bus &amp; Holiday Packages at Goibib");
		Log.info("Successfully validated the title for FlightSearch page");
	}

	@Test(priority = 2, dataProvider = "getOriginDestDataTest")
	public void searchFlightsTest(String from, String to) throws InterruptedException {
		flightresultpage = flightsearchpage.searchFlight(from, to);

	}

	@DataProvider
	public Object[][] getOriginDestDataTest() {

		Object gdata[][] = testutil.getOriginDestData(sheetName);
		System.out.println(Arrays.deepToString(gdata));
		return gdata;
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		
		Thread.sleep(2000);
		driver.quit();
		Log.info("Driver exit");
		Log.info("TestCase Completed");
	}

}
