package com.app.qa.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.app.qa.base.TestBase;

public class WebEventListener extends TestBase implements WebDriverEventListener {
	public static Logger Log = LogManager.getLogger(WebEventListener.class.getName());
	public void beforeAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		Log.info("Before accepting alert");
		
	}

	public void afterAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		Log.info("Alert accepted");
	}

	public void afterAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		Log.info("Alert dismissed");
	}

	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		Log.info("Before dismissing alert");
	}

	public void beforeNavigateTo(String url, WebDriver driver) {
		// TODO Auto-generated method stub
		Log.info("Current url : " + driver.getCurrentUrl());
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		// TODO Auto-generated method stub
		Log.info("Navigated to url : " + url);
	}

	public void beforeNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
		Log.info("Url before navigating back : " + driver.getCurrentUrl());
	}

	public void afterNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
		Log.info("Navigated back to url : " + driver.getCurrentUrl());
	}

	public void beforeNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		Log.info("Url before navigating forward : "+ driver.getCurrentUrl());
	}

	public void afterNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		Log.info("Navigated forward to url : " + driver.getCurrentUrl());
	}

	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		Log.info("Url before refreshing page : "+ driver.getCurrentUrl());
	}

	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		Log.info("Url after refreshing : "+ driver.getCurrentUrl());
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		Log.info("Trying to find the element by "+ by.toString());
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		Log.info("Element found");
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		Log.info("Trying to click on the element" + element.toString());
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		Log.info("Element clicked");
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		Log.info("Before changing value in the element : " + element.toString());
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		Log.info("The value is changed in the element : " + element.toString());
		
	}

	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		Log.info("Executing javascript : " + script);
	}

	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		Log.info("Executed javascript : "+ script);
	}

	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub
		Log.info("Before window switching- "+ windowName);
	}

	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub
		Log.info("Switched to window- "+ windowName);
	}

	public void onException(Throwable throwable, WebDriver driver) {
		// TODO Auto-generated method stub
		Log.fatal("Exception throwed : "+ throwable.getMessage());
	}

	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		// TODO Auto-generated method stub
		
		Log.info("Before Screenshot- "+ target);
	}

	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		// TODO Auto-generated method stub
		
		
			Log.info("After Screenshot- "+ target);
	}

	public void beforeGetText(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		Log.info("Just before performing getText method");
	}

	public void afterGetText(WebElement element, WebDriver driver, String text) {
		// TODO Auto-generated method stub
		Log.info("After performing getText method,Text is- " + text);
	}

}
