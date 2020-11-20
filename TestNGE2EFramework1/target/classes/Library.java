package com.app.qa.util;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface Library {

	// This is the interface to hold all the common libraries

	// Click on the element
	public void doClick(By locator);

	// Enter the text
	public void doEnterText(By locator, String text);
	
	//Clear the text field
	public void clearTextField(By locator);

	// Get Page title
	public String doGetPageTitle();

	// Wait for the page title
	public void doWaitforPageTitle(String title);

	// Get the webElement
	public WebElement doGetElement(By locator);

	// Get the text
	public String doGetText(By locator);

	// Wait for element present
	public void doWaitForElementPresent(By locator);

	// Wait for element to be clickable
	public void doWaitForElementTobeClickable(By locator);

	// Wait for element to be visible
	public void waitForElementTobeVisible(By locator);

	// Get the screenshot
	public void getScreenshot(String result) throws IOException;

	// Get Web Element screen shot
	public void doTakeScreenshotOfWebelement(By locator, String screenshotName) throws Exception;

	// This method will help us to Switch to a new window. Consider one parent
	// window and one child window
	public void doSwitchToNewWindow();

	// This method will switch to default content (ie:. main url)
	public void doSwitchToDefaultContent();

	// This method will helps us to switch to a Frame. Here you need to pass name of
	// the frame
	public void doSwitchToFrameByName(String frameName);

	// This method will helps us to switch to a Frame. Here you need to pass number
	// of the frame
	public void doSwitchToFrameByIndex(int frameValue);

	// Set the window size
	public void setWindowSize(int Dimension1, int dimension2);

	// Key Actions
	public void pressKeyDown(By locator);

	public void pressKeyEnter(By locator);

	public void pressKeyUp(By locator);

	public void moveToTab(By locator);

	// Drag and Drop the element
	public void doDragAndDrop(By fromLocator, By toLocator);

	// Mouse hover on the element
	public void hoverWebelement(By locator) throws InterruptedException;

	// Double click on the element
	public void doubleClickWebelement(By locator) throws InterruptedException;

	/********************************************************
	 * Start of Drop down methods
	 ********************************************************/
	
	// Verify the expected and actual options in drop down
	public void verifyExpectedAndActualOptionsInDropdown(By locator, List<String> listOfOptions);
	
	//Select item from drop down by visible text
	public void selectItemByVisibleText(By locator, String Name);
	
	//DeSelect item from drop down by visible text
	public void deselectElementByNameMethod(By locator, String Name);
	
	//Verify that drop down does not have multiple selection
	public void verifyDropdownHaveNoMultipleSelection(By locator, String Name);
	
	//Verify that drop down have multiple selection
	public void verifyDropdownHaveMultipleSelection(By locator, String Name);
		
	//Verify drop down options are in alphabetical order
	public void verifyOptionsInDropdownInAphabeticalOrder(By locator);	
	
	//Verify the size of the drop down option
	public void verifyOptionsSizeOfDropdown(By locator, int numberOfOptions);
	
	//Select drop down item by value
	public void selectItemByValue(By locator, String value);
		
	//DeSelect drop down item by value
	public void deselectItemByValue(By locator, String value);
	
	//Select drop down item by Index
	public void selectElementByIndexMethod(By locator, int index);
	
	//DeSelect drop down item by Index
	public void deselectElementByIndexMethod(By locator, int index);
	
	/****************************************
	 * End of drop down methods
	 ****************************************/
	
	//Click the checkbox from the list
	public void clickCheckboxFromList(String xpathOfElement, String valueToSelect);
	
	//Navigate back
	public void navigateBack();
	
	//Page refresh
	public void refresh();
	
	//Navigate forward
	public void navigateForward();
	
	//Get tool tip
	public String getToolTip(By locator) throws InterruptedException;
	
	//This method click on all the links on the page and takes screenshot
	public void clickAllLinksInPage(String NameOfScreenshot) throws Exception;
	
	//Highlight the element
	public void highlightelement(By locator);
	
	// Check for alert
	public boolean checkAlert();
	
	// Accept the alert
	public boolean acceptAlert();
	
	//Dismiss the alert
	public boolean dismissAlert();;
	
	//Scroll to element
	public void scrolltoElement(By locator);
	
	//Checkbox checking
	public void checkboxChecking(By locator);
	
	//Radio button select
	public void radiobuttonSelect(By locator);
	
	// Checkbox Unchecking
	public void checkboxUnchecking(By locator);

}
