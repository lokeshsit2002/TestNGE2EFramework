package com.app.qa.resources;

import org.openqa.selenium.By;

public class DynamicXpath {
	
	//creates dynamic xpath by replacing %replaceable% with required data
	public static By get(String xpath,String data)
	{
		String rawXpath=xpath.replaceAll("%replacable%", data);
		return By.xpath(rawXpath);
	}

}
