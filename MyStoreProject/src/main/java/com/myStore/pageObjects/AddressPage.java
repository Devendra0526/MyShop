package com.myStore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myStore.actionDriver.Action;
import com.myStore.base.BaseClass;

public class AddressPage extends BaseClass {

	@FindBy(xpath = "//span[text()='Proceed to checkout']")
	WebElement proccedToCheckout;
	
	public AddressPage() {
		PageFactory.initElements(driver, this);
	}
	
	public ShippingPage clickOnCheckout() {
		Action.click(driver, proccedToCheckout);
		return new ShippingPage();
	}
}
