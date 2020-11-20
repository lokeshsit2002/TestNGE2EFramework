package com.app.qa.util;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.app.qa.base.TestBase;

public class Listeners extends TestBase implements ITestListener {
	
	TestUtil tu = new TestUtil();

	public void onTestStart(ITestResult result) {
		System.out.println("Starting test is" + getMethodName(result));
		Reporter.log("Starting test is" + getMethodName(result)); // This will log in TestNG report

	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test passed is" + getMethodName(result));
		Reporter.log("Test passed is" + getMethodName(result)); // This will log in TestNG report

	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Test failed " + getMethodName(result));
		Reporter.log("Test failed " + getMethodName(result));
		
		try {
			
				tu.getScreenshot(result.getName());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test skipped " + getMethodName(result));
		Reporter.log("Test skipped " + getMethodName(result));

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("Test is passed based on percentage" + getMethodName(result));
		Reporter.log("Test is passed based on percentage" + getMethodName(result));

	}

	public void onStart(ITestContext context) {
		System.out.println("All test started");
		Reporter.log("All test started");

	}

	public void onFinish(ITestContext context) {
		System.out.println("All test finished");
		Reporter.log("All test finished");

	}

	private static String getMethodName(ITestResult result) {
		return result.getMethod().getConstructorOrMethod().getName();
	}

}
