package com.myStore.testScripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.myStore.base.BaseClass;
import com.myStore.pageObjects.AccountCreationPage;
import com.myStore.pageObjects.IndexPage;
import com.myStore.pageObjects.LoginPage;

public class AccountCreationPageTest extends BaseClass {

	IndexPage indexPage;
	LoginPage loginPage;
	AccountCreationPage accountCreationPage;
	
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
	
	@Test(groups = "Sanity")
	public void verifyCreateAccountPageTest() {
		indexPage = new IndexPage();
		loginPage  = indexPage.clickOnSignIn();
		accountCreationPage = loginPage.createNewAccount("abcd@gmail.com");
		boolean validateAccountCreatePage = accountCreationPage.validateAccountCreatePage();
		Assert.assertTrue(validateAccountCreatePage);
	}
}
