package com.myStore.testScripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.myStore.base.BaseClass;
import com.myStore.pageObjects.AddToCartPage;
import com.myStore.pageObjects.IndexPage;
import com.myStore.pageObjects.OrderPage;
import com.myStore.pageObjects.SearchResultPage;

public class OrderPageTest extends BaseClass {

	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;
	
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
	
	@Test(groups = "Regression")
	public void verifyTotalPrice() {
		indexPage = new IndexPage();
		searchResultPage = indexPage.searchProduct("t-shirt");
		addToCartPage = searchResultPage.clickOnProduct();
		addToCartPage.sizeSelect("L");
		addToCartPage.enterQuantity("2");
		addToCartPage.clickOnAddToCart();
		orderPage = addToCartPage.clickOnProccedToCheckoutBtn();
		double unitPrice = orderPage.getUnitPrice();
		double totalPrice = orderPage.getTotalPrice();
		double totalExpectedPrice = (unitPrice*2)+7;  //$7 shipping price
		System.out.println("Unit price: "+unitPrice);
		System.out.println("Total price: "+totalPrice);
		System.out.println("(unitPrice*quantity+shippingPrice) Total Expected: "+totalExpectedPrice);
		Assert.assertEquals(totalPrice, totalExpectedPrice);
		
	}
}
