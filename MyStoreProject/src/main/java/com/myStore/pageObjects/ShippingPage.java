package com.myStore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myStore.actionDriver.Action;
import com.myStore.base.BaseClass;

public class ShippingPage extends BaseClass {

	@FindBy(id = "cgv")
	WebElement checkBox;
	
	@FindBy(name = "processCarrier")
	WebElement proccedCheckoutBtn;
	
	public ShippingPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnCheckBox() {
		Action.click(driver, checkBox);
	}
	
	public PaymentPage clickOnProccedToCheckout() {
		Action.click(driver, proccedCheckoutBtn);
		return new PaymentPage();
	}
}
