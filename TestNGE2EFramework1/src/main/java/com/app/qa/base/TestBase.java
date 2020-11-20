package com.app.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.app.qa.util.WebEventListener;

import io.github.bonigarcia.wdm.WebDriverManager;

//import com.crm.qa.util.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;
	public static Actions action;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListner;


	String projectPath = System.getProperty("user.dir");

	//Constructor to initiate the config.properties file
	public TestBase() {

		prop = new Properties();
		FileInputStream ip;
		try {
			ip = new FileInputStream(projectPath + "\\src\\main\\java\\com\\app\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//Method to initialize the browser and launch the browser
	public void initialization() {
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("Chrome Browser detected");
			
		}

		else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("Firefox Browser detected");
		}

		
		 e_driver = new EventFiringWebDriver(driver); 
		 //Now create object of EventListnerHandler to register with EventFiringWebDriver 
		 eventListner = new WebEventListener(); 
		 e_driver.register(eventListner); 
		 driver = e_driver;
		 

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Long.parseLong(prop.getProperty("pageLoadTimeout")),
				TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Long.parseLong(prop.getProperty("implicitlyWait")),
				TimeUnit.SECONDS);
		action = new Actions(driver);
		wait = new WebDriverWait(driver, 50);

		driver.get(prop.getProperty("url"));
	}

}
