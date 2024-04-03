package com.myStore.testScripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.myStore.base.BaseClass;
import com.myStore.dataprovider.DataProviders;
import com.myStore.pageObjects.HomePage;
import com.myStore.pageObjects.IndexPage;
import com.myStore.pageObjects.LoginPage;
import com.myStore.utility.Log;

public class LoginPageTest extends BaseClass {

	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		lunchApp(browser);
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		if (driver !=null) {
			driver.quit();
		}
	}
	
	@Test(dataProvider = "credentials", dataProviderClass = DataProviders.class, groups = {"Smoke","Sanity"})
	public void loginTest(String uName, String pwd) {
		Log.startTestCase("loginTest");
		indexPage = new IndexPage();
		Log.info("User is going to click on signIn button");
		loginPage = indexPage.clickOnSignIn();
		Log.info("User enter the username and password");
//		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage = loginPage.login(uName, pwd);
		String actualUrl = homePage.getCurrentUrl();
		String expectedUrl = "http://www.automationpractice.pl/index.php?controller=my-account";
		Log.info("Verifying the user is able to login");
		Assert.assertEquals(actualUrl, expectedUrl);
		Log.info("User logged successfully");
		Log.endTestCase("loginTest");
		
	}
}
