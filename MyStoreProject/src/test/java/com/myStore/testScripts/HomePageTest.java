package com.myStore.testScripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.myStore.base.BaseClass;
import com.myStore.pageObjects.HomePage;
import com.myStore.pageObjects.IndexPage;
import com.myStore.pageObjects.LoginPage;

public class HomePageTest extends BaseClass {

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
	
	@Test(groups = "Smoke")
	public void adderessPageTest() {
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		boolean validatefirstAddress = homePage.validatefirstAddress();
		Assert.assertTrue(validatefirstAddress);
	}
	
	@Test(groups = "Smoke")
	public void orderHistoryTest() {
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		boolean validateOrderHistory = homePage.validateOrderHistory();
		Assert.assertTrue(validateOrderHistory);
	}
	
	@Test
	public void salarySlipTest() {
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		boolean validateCreditSlip = homePage.validateCreditSlip();
		Assert.assertTrue(validateCreditSlip);
	}
}
