package com.myStore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myStore.actionDriver.Action;
import com.myStore.base.BaseClass;

public class OrderPage extends BaseClass {
	
	@FindBy(xpath = "//td[@class='cart_unit']//li")
	WebElement unitPrice;
	
	@FindBy(xpath = "//span[@id='total_price']")
	WebElement totalPrice;
	
	@FindBy(xpath = "//span[text()='Proceed to checkout']")
	WebElement proccedCheckoutBtn;

	public OrderPage() {
		PageFactory.initElements(driver, this);
	}
	
	public double getUnitPrice() {
		String unitPrice1 = unitPrice.getText();
		String replaceAllUnitPrice = unitPrice1.replaceAll("[^a-zA-Z0-9]","");
		double finalUnitPrice = Double.parseDouble(replaceAllUnitPrice);
		return finalUnitPrice;
	}
	
	public double getTotalPrice() {
		String totalPrice1 = totalPrice.getText();
		String replaceAllTotalPrice = totalPrice1.replaceAll("[^a-zA-Z0-9]","");
		double finalTotalPrice = Double.parseDouble(replaceAllTotalPrice);
		return finalTotalPrice;
	}
	
	public LoginPage clickOnCheckout( ) {
		Action.click(driver, proccedCheckoutBtn);
		return new LoginPage();
	}
}
