package com.myStore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myStore.actionDriver.Action;
import com.myStore.base.BaseClass;

public class PaymentPage extends BaseClass {

	@FindBy(xpath = "//a[@title='Pay by bank wire']")
	WebElement payByBankwire;
	
	@FindBy(xpath = "//a[@title='Pay by check.']")
	WebElement payByCheck;
	
	public PaymentPage() {
		PageFactory.initElements(driver, this);
	}
	
	public OrderSummaryPage clickOnPaymentMethod() {
		Action.click(driver, payByBankwire);
		return new OrderSummaryPage();
	}
}
