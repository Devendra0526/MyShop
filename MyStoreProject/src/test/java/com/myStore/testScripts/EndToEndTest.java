package com.myStore.testScripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.myStore.base.BaseClass;
import com.myStore.pageObjects.AddToCartPage;
import com.myStore.pageObjects.AddressPage;
import com.myStore.pageObjects.IndexPage;
import com.myStore.pageObjects.LoginPage;
import com.myStore.pageObjects.OrderConfirmationPage;
import com.myStore.pageObjects.OrderPage;
import com.myStore.pageObjects.OrderSummaryPage;
import com.myStore.pageObjects.PaymentPage;
import com.myStore.pageObjects.SearchResultPage;
import com.myStore.pageObjects.ShippingPage;

public class EndToEndTest extends BaseClass {

	LoginPage loginPage;
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;
	AddressPage addressPage;
	ShippingPage shippingPage;
	PaymentPage paymentPage;
	OrderSummaryPage orderSummaryPage;
	OrderConfirmationPage confirmationPage;
	
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
	public void endToEndTest() {
		indexPage = new IndexPage();
		searchResultPage = indexPage.searchProduct("t-shirt");
		addToCartPage = searchResultPage.clickOnProduct();
		addToCartPage.sizeSelect("L");
		addToCartPage.enterQuantity("2");
		addToCartPage.clickOnAddToCart();
		orderPage = addToCartPage.clickOnProccedToCheckoutBtn();
		loginPage = orderPage.clickOnCheckout();
		addressPage = loginPage.login1(prop.getProperty("username"), prop.getProperty("password"));
		shippingPage = addressPage.clickOnCheckout();
		shippingPage.clickOnCheckBox();
		paymentPage = shippingPage.clickOnProccedToCheckout();
		orderSummaryPage = paymentPage.clickOnPaymentMethod();
		confirmationPage = orderSummaryPage.clickOnConfirmOrderBtn();
		String actualMessage = confirmationPage.validateConfirmMessage();
		System.out.println(actualMessage);
		String expectedMessage = "Your order on My Shop is complete.";
		Assert.assertEquals(actualMessage, expectedMessage);
	}
}
