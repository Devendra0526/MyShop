package com.myStore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myStore.actionDriver.Action;
import com.myStore.base.BaseClass;

public class OrderSummaryPage extends BaseClass {

	@FindBy(xpath = "//button[@class='button btn btn-default button-medium']")
	WebElement confirmOrderBtn;
	
	OrderSummaryPage() {
		PageFactory.initElements(driver, this);
	}
	
	public OrderConfirmationPage clickOnConfirmOrderBtn() {
		Action.click(driver, confirmOrderBtn);
		return new OrderConfirmationPage();
	}
}
