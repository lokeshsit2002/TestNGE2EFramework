package com.app.qa.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import com.app.qa.base.TestBase;
import com.app.qa.resources.DatePicker;
import com.app.qa.resources.DynamicXpath;
import com.app.qa.util.TestUtil;

public class FlightSearchPage extends TestUtil {
	
	TestUtil testutil = new TestUtil();
	public static Logger Log = LogManager.getLogger(TestBase.class.getName());
	
	//Page locators (below design is non page factory)
	By fromLocation = By.cssSelector("input[placeholder='From']");
	By toLocation = By.cssSelector("input[placeholder='Destination']");
	By autosuggestVisible = By.id("react-autosuggest-1");
	By returnDate = By.cssSelector("input[placeholder='Return']");
	By search = By.cssSelector("button[value='Search']");
	
	//This is the date picker dynamic xpath
	String datePickerXpath="//div[@aria-label='%replacable%' and @aria-disabled='false']";
	
	/**********************************************************
	 * PAGE ACTIONS
	 **********************************************************/
	
	//Action: Get the title of the page
	public String getFlightSearchPageTitle() {
		return driver.getTitle();
	}
	
	//Action: This method is to search the flight. We can do method overload here for negative testing
	public FlightResultPage searchFlight(String from, String to) throws InterruptedException {
		testutil.doEnterText(fromLocation, from);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("react-autosuggest-1")));
		testutil.waitForElementTobeVisible(autosuggestVisible);
		testutil.pressKeyDown(fromLocation);
		testutil.pressKeyEnter(fromLocation);
		Log.info("Entered the 'From' location");
		
		testutil.doEnterText(toLocation, to);
		testutil.waitForElementTobeVisible(autosuggestVisible);
		testutil.pressKeyDown(toLocation);
		testutil.pressKeyEnter(toLocation);
		Log.info("Entered the 'To' location");
		
		DatePicker date=DatePicker.getDates();
		driver.findElement(DynamicXpath.get(datePickerXpath, date.getDepartureDate())).click();
		Log.info("Entered the Departure date");
		testutil.doClick(returnDate);		
		driver.findElement(DynamicXpath.get(datePickerXpath, date.getReturnDate())).click();
		Log.info("Entered the Return date");
		
		testutil.doClick(search);
		Log.info("Clicked on Search button");
		return new FlightResultPage();

	}

}
