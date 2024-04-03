/**
 * 
 */
package com.myStore.testScripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.myStore.base.BaseClass;
import com.myStore.pageObjects.IndexPage;

/**
 * 
 */
public class IndexPageTest extends BaseClass {

	IndexPage indexPage;
	
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
	public void verifyLogo() {
		indexPage = new IndexPage();
		boolean validateLogo = indexPage.validateLogo();
		Assert.assertTrue(validateLogo);
	}
	
	@Test(groups = "Smoke")
	public void verifyTitle() {
		String actualTitle = indexPage.getMyStoreTitle();
		Assert.assertEquals(actualTitle, "My Shop");
	}
}
