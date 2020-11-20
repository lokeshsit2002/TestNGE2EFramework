package com.app.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.testng.Assert;

import com.app.qa.base.TestBase;

public class TestUtil extends TestBase implements Library {

	public static JavascriptExecutor JSdriver;
	static String projectPath = System.getProperty("user.dir");
	public static String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
	
	public static String CUCUMBER_TEST_DATA_SHEET_PATH = projectPath+"\\src\\main\\java\\com\\app\\qa\\testdata\\ExcelSearchFlight.xlsx";
	public static String TESTNG_TEST_DATA_SHEET_PATH = projectPath+"\\src\\main\\java\\com\\app\\qa\\testdata\\SearchFlight.xlsx";
	private static String SHEET_NAME;
	private static Map<String, String> map = new HashMap<String, String>();
	static XSSFWorkbook hbook;
	static XSSFSheet hsheet;
	
	static Workbook book;
	static Sheet sheet;

	/******************************************************************************
	 * Common utility wrappers
	 *****************************************************************************/

	// Click on the element
	/*
	 * public void doClick(By locator) { WebElement element =
	 * driver.findElement(locator);
	 * 
	 * try { boolean elementIsClickable = element.isEnabled(); while
	 * (elementIsClickable) { element.click(); }
	 * 
	 * } catch (Exception e) { System.out.println("Element is not enabled");
	 * e.printStackTrace(); } }
	 */

	public void doClick(By locator) {
		driver.findElement(locator).click();
	}

	// Enter text action
	public void doEnterText(By locator, String text) {
		driver.findElement(locator).sendKeys(text);
	}

	// Clear the text field
	public void clearTextField(By locator) {
		WebElement element = doGetElement(locator);
		element.clear();
	}

	// Get page title
	public String doGetPageTitle() {
		return driver.getTitle();

	}

	// Get the webElement
	public WebElement doGetElement(By locator) {
		WebElement element = null;
		try {
			element = driver.findElement(locator);
			return element;
		} catch (Exception e) {
			System.out.println("Error occured while creating element " + locator.toString());
		}

		return element;
	}

	// Get the text
	public String doGetText(By locator) {
		return doGetElement(locator).getText();
	}

	// Wait for element present
	public void doWaitForElementPresent(By locator) {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		} catch (Exception e) {
			System.out.println("Some error occurred while waiting for the element to be present " + locator.toString());
		}

	}

	// Wait for element to be clickable
	public void doWaitForElementTobeClickable(By locator) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(locator));
		} catch (Exception e) {
			System.out
					.println("Some error occurred while waiting for the element to be clickable " + locator.toString());
		}

	}

	// Wait for element to be visible
	public void waitForElementTobeVisible(By locator) {
		WebElement element = doGetElement(locator);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	// Wait for the page title
	public void doWaitforPageTitle(String title) {
		try {
			wait.until(ExpectedConditions.titleContains(title));
		} catch (Exception e) {
			System.out.println("Some error occurred while waiting for the page title " + title.toString());
		}

	}

	// Get the screen shot
	public void getScreenshot(String result) throws IOException {
		try {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// now copy the screenshot to desired location using copyFile //method
		FileUtils.copyFile(src, new File(projectPath+"\\Screenshots\\" + result + timeStamp + ".png"));
	
	}
		catch(NoSuchSessionException e)
		{
			e.printStackTrace();
		}
		
	}

	// Get Web Element screen shot
	public void doTakeScreenshotOfWebelement(By locator, String screenshotName) throws Exception {
		WebElement element = doGetElement(locator);
		File srcFile = element.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File(".target/screenshots/" + screenshotName + timeStamp + ".png"));

	}

	// This method will help us to Switch to a new window. Consider one parent
	// window and one child window
	public void doSwitchToNewWindow() {
		Set<String> s = driver.getWindowHandles();
		Iterator<String> itr = s.iterator();
		String parent = (String) itr.next();
		String child = (String) itr.next();
		driver.switchTo().window(child);
	}

	// This method will switch to default content (ie:. main url)
	public void doSwitchToDefaultContent() {
		driver.switchTo().defaultContent();
	}

	// This method will helps us to switch to a Frame. Here you need to pass name of
	// the frame
	public void doSwitchToFrameByName(String frameName) {
		driver.switchTo().frame(frameName);
	}

	// This method will helps us to switch to a Frame. Here you need to pass number
	// of the frame
	public void doSwitchToFrameByIndex(int frameValue) {
		driver.switchTo().frame(frameValue);
	}

	// Set the window size
	public void setWindowSize(int Dimension1, int dimension2) {
		driver.manage().window().setSize(new Dimension(Dimension1, dimension2));

	}

	// Key Actions
	public void pressKeyDown(By locator) {
		WebElement element = doGetElement(locator);
		element.sendKeys(Keys.DOWN);
	}

	public void pressKeyEnter(By locator) {
		WebElement element = doGetElement(locator);
		element.sendKeys(Keys.ENTER);
	}

	public void pressKeyUp(By locator) {
		WebElement element = doGetElement(locator);
		element.sendKeys(Keys.UP);
	}

	public void moveToTab(By locator) {
		WebElement element = doGetElement(locator);
		element.sendKeys(Keys.chord(Keys.ALT, Keys.TAB));
	}

	// Drag and Drop the element
	public void doDragAndDrop(By fromLocator, By toLocator) {
		WebElement fromElement = doGetElement(fromLocator);
		WebElement toElement = doGetElement(toLocator);
		Actions builder = new Actions(driver);
		builder.dragAndDrop(fromElement, toElement);
	}

	// Mouse hover on the element
	public void hoverWebelement(By locator) throws InterruptedException {
		WebElement element = doGetElement(locator);
		Actions builder = new Actions(driver);
		builder.moveToElement(element).perform();
		Thread.sleep(2000);

	}

	// Double click on the element
	public void doubleClickWebelement(By locator) throws InterruptedException {
		WebElement element = doGetElement(locator);
		Actions builder = new Actions(driver);
		builder.doubleClick(element).perform();
		Thread.sleep(2000);

	}

	/********************************************************************************
	 * Below are the Methods related to Drop down
	 ********************************************************************************/

	// Verify the expected and actual options in drop down
	public void verifyExpectedAndActualOptionsInDropdown(By locator, List<String> listOfOptions) {

		WebElement element = doGetElement(locator);
		Select ele = new Select(element);
		// need to give list of options like below. You can add values from
		// excel or csv
		/*
		 * List<String> ds = new ArrayList<String>(); ds.add("Asia"); ds.add("Europe");
		 * ds.add("Africa");
		 */
		List<String> expectedOptions = listOfOptions;
		List<String> actualOptions = new ArrayList<String>();
		for (WebElement option : ele.getOptions()) {
			System.out.println("Dropdown options are: " + option.getText());
			actualOptions.add(option.getText());
		}
		System.out.println("Numbers of options present in the dropdown: " + actualOptions.size());

		Assert.assertEquals(expectedOptions.toArray(), actualOptions.toArray());
		System.out.println("test");

	}

	// Select item from drop down by visible text
	public void selectItemByVisibleText(By locator, String Name) {
		WebElement element = doGetElement(locator);
		Select selectitem = new Select(element);
		selectitem.selectByVisibleText(Name);
	}

	// DeSelect item from drop down by visible text
	public void deselectElementByNameMethod(By locator, String Name) {
		WebElement element = doGetElement(locator);
		Select selectitem = new Select(element);
		selectitem.deselectByVisibleText(Name);
	}

	// Verify that drop down does not have multiple selection
	public void verifyDropdownHaveNoMultipleSelection(By locator, String Name) {
		WebElement element = doGetElement(locator);
		Select ss = new Select(element);
		Assert.assertFalse(ss.isMultiple());
	}

	// Verify that drop down have multiple selection
	public void verifyDropdownHaveMultipleSelection(By locator, String Name) {
		WebElement element = doGetElement(locator);
		Select ss = new Select(element);
		Assert.assertTrue(ss.isMultiple());
	}

	// Verify drop down options are in alphabetical order
	public void verifyOptionsInDropdownInAphabeticalOrder(By locator) {

		WebElement element = doGetElement(locator);
		Select ele = new Select(element);
		List<String> expectedOptions = new ArrayList<String>();
		List<String> actualOptions = new ArrayList<String>();

		for (WebElement option : ele.getOptions()) {
			System.out.println("Dropdown options are: " + option.getText());
			actualOptions.add(option.getText());
			expectedOptions.add(option.getText());
		}

		Collections.sort(actualOptions);
		System.out.println("Numbers of options present in the dropdown: " + actualOptions.size());
		Assert.assertEquals(expectedOptions.toArray(), actualOptions.toArray());

	}

	// Verify the size of the drop down option
	public void verifyOptionsSizeOfDropdown(By locator, int numberOfOptions) {
		WebElement element = doGetElement(locator);
		Select ssd = new Select(element);
		Assert.assertEquals(numberOfOptions, ssd.getOptions().size());
	}

	// Select drop down item by value
	public void selectItemByValue(By locator, String value) {
		WebElement element = doGetElement(locator);
		Select selectitem = new Select(element);
		selectitem.selectByValue(value);
	}

	// DeSelect drop down item by value
	public void deselectItemByValue(By locator, String value) {
		WebElement element = doGetElement(locator);
		Select selectitem = new Select(element);
		selectitem.deselectByValue(value);
	}

	// Select drop down item by Index
	public void selectElementByIndexMethod(By locator, int index) {
		WebElement element = doGetElement(locator);
		Select selectitem = new Select(element);
		selectitem.selectByIndex(index);
	}

	// DeSelect drop down item by Index
	public void deselectElementByIndexMethod(By locator, int index) {
		WebElement element = doGetElement(locator);
		Select selectitem = new Select(element);
		selectitem.deselectByIndex(index);
	}

	/****************************************
	 * End of drop down methods
	 ****************************************/

	// Click the checkbox from the list
	public void clickCheckboxFromList(String xpathOfElement, String valueToSelect) {
		List<WebElement> lst = driver.findElements(By.xpath(xpathOfElement));
		for (int i = 0; i < lst.size(); i++) {
			List<WebElement> dr = lst.get(i).findElements(By.tagName("label"));
			for (WebElement f : dr) {
				System.out.println("value in the list : " + f.getText());
				if (valueToSelect.equals(f.getText())) {
					f.click();
					break;
				}
			}
		}
	}

	// Navigate back
	public void navigateBack() {
		driver.navigate().back();
	}

	// Page refresh
	public void refresh() {
		driver.navigate().refresh();
	}

	// Navigate forward
	public void navigateForward() {
		driver.navigate().forward();
	}

	// Get tool tip
	public String getToolTip(By locator) throws InterruptedException {
		WebElement element = doGetElement(locator);
		String tooltip = element.getAttribute("title");
		System.out.println("Tool text : " + tooltip);
		return tooltip;
	}

	// This method click on all the links on the page and takes screenshot
	public void clickAllLinksInPage(String NameOfScreenshot) throws Exception {

		List<WebElement> Links = driver.findElements(By.tagName("a"));
		System.out.println("Total number of links  :" + Links.size());

		for (int p = 0; p < Links.size(); p++) {
			System.out.println("Elements present the body :" + Links.get(p).getText());
			Links.get(p).click();
			Thread.sleep(3000);
			System.out.println("Url of the page  " + p + ")" + driver.getCurrentUrl());
			getScreenshot(NameOfScreenshot + "_" + p);
			navigateBack();
			Thread.sleep(2000);
		}
	}

	// Highlight the element
	public void highlightelement(By locator) {
		WebElement element = doGetElement(locator);
		for (int i = 0; i < 3; i++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
					"color: solid red; border: 5px solid blue;");
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
		}
	}

	// Check for alert
	public boolean checkAlert() {
		try {
			Alert a = driver.switchTo().alert();
			String str = a.getText();
			System.out.println(str);

			return true;

		} catch (Exception e) {

			System.out.println("no alert ");
			return false;

		}
	}

	// Accept the alert
	public boolean acceptAlert() {
		try {
			Alert a = driver.switchTo().alert();
			String str = a.getText();
			System.out.println(str);

			a.accept();
			return true;

		} catch (Exception e) {

			System.out.println("no alert ");
			return false;

		}
	}

	// Dismiss the alert
	public boolean dismissAlert() {
		try {
			Alert a = driver.switchTo().alert();
			String str = a.getText();
			System.out.println(str);

			a.dismiss();
			return true;

		} catch (Exception e) {

			System.out.println("no alert ");
			return false;

		}
	}

	// Scroll to element
	public void scrolltoElement(By locator) {
		WebElement ScrolltoThisElement = doGetElement(locator);
		Coordinates coordinate = ((Locatable) ScrolltoThisElement).getCoordinates();
		coordinate.onPage();
		coordinate.inViewPort();
	}

	// Checkbox checking
	public void checkboxChecking(By locator) {
		WebElement checkbox = doGetElement(locator);
		boolean checkstatus;
		checkstatus = checkbox.isSelected();
		if (checkstatus == true) {
			System.out.println("Checkbox is already checked");
		} else {
			checkbox.click();
			System.out.println("Checked the checkbox");
		}
	}

	// Checkbox Unchecking
	public void checkboxUnchecking(By locator) {
		WebElement checkbox = doGetElement(locator);
		boolean checkstatus;
		checkstatus = checkbox.isSelected();
		if (checkstatus == true) {
			checkbox.click();
			System.out.println("Checkbox is unchecked");
		} else {
			System.out.println("Checkbox is already unchecked");
		}
	}

	// Radio button select
	public void radiobuttonSelect(By locator) {
		WebElement Radio = doGetElement(locator);
		boolean checkstatus;
		checkstatus = Radio.isSelected();
		if (checkstatus == true) {
			System.out.println("RadioButton is already checked");
		} else {
			Radio.click();
			System.out.println("Selected the Radiobutton");
		}
	}
	
	//Radio button DeSelect
	public void radioButtonDeselect(WebElement Radio) {
		boolean checkstatus;
		checkstatus = Radio.isSelected();
		if (checkstatus == true) {
			Radio.click();
			System.out.println("Radio Button is deselected");
		} else {
			System.out.println("Radio Button is already Deselected");
		}
	}

	
	
	/**********************************************************
	 * Get the test data from excel: For origin and destination places
	 **********************************************************/

	public Object[][] getOriginDestData(String sheetName) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(TESTNG_TEST_DATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			book = WorkbookFactory.create(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];


		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {

				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();

			}
		}
		return data;
	}

	/**********************************************************
	 * End of the test data from excel: For origin and destination places
	 **********************************************************/
	
	/*****************************************************************
	 * Get the test data from excel for scenario or scenario outline:
	 *****************************************************************/
	public String getdatafromExcel(String sheetName,String testcasename,String columnname) throws IOException
	{
		FileInputStream efis = null;
		int k =0;
		SHEET_NAME=sheetName;
		try {
			efis = new FileInputStream(CUCUMBER_TEST_DATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			hbook = new XSSFWorkbook(efis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		hsheet = hbook.getSheet(SHEET_NAME);
		int rows = hsheet.getPhysicalNumberOfRows();
		 for(int i=0;i<rows;i++){
			 int cols = hsheet.getRow(0).getPhysicalNumberOfCells();
			 
			 for (int j = 0; j < cols; j++) { 

			 if(hsheet.getRow(i).getCell(j,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).toString().replace(".0", "").equalsIgnoreCase(columnname)){ 
			 k=j;
			 }
			 map.put(hsheet.getRow(i).getCell(0,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).toString().replace(".0",""),
			 hsheet.getRow(i).getCell(k,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).toString().replace(".0", "")); 
			 }
			 } 
			System.out.println(map.get(testcasename));
	//		System.out.println(map.get(columnname));
			
			 return map.get(testcasename);
			 
	}
	/*****************************************************************
	 * End of the test data from excel for scenario or scenario outline:
	 *****************************************************************/
}
