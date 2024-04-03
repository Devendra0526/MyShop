package com.myStore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.myStore.actionDriver.Action;
import com.myStore.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static Properties prop;
	public static WebDriver driver;
	public static FileInputStream ip;

	@BeforeSuite(groups = { "Smoke", "Sanity", "Regression" })
	public void loadConfig() {
		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");

		prop = new Properties();
		System.out.println("super constructor invoked");
		try {
			ip = new FileInputStream(System.getProperty("user.dir") + "\\Configuration\\config.properties");

			prop.load(ip);
			System.out.println("driver: " + driver);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void lunchApp(String browserName) {
		WebDriverManager.chromedriver().setup();
//		String browserName = prop.getProperty("browser"); //Here, I'm using @Parameters, instead of using getProperty

		if (browserName.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		}
		if (browserName.contains("FireFox")) {
			driver = new FirefoxDriver();
		}
		if (browserName.contains("IE")) {
			driver = new InternetExplorerDriver();
		}

		driver.get(prop.getProperty("url"));
		Action.implicitWait(driver, 10);
		Action.pageLoadTimeOut(driver, 30);

	}

	@AfterSuite
	public void afterSuite() {
		ExtentManager.endReport();
	}
}
