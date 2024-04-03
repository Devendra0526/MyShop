package com.myStore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myStore.actionDriver.Action;
import com.myStore.base.BaseClass;

public class HomePage extends BaseClass {

	@FindBy(xpath = "//span[text()='My addresses']")
	WebElement firstAddressIcon;
	
	@FindBy(xpath = "//span[text()='Order history and details']")
	WebElement historyDetails;
	
	@FindBy(xpath = "//span[text()='My credit slips']")
	WebElement creditSlip;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validatefirstAddress() {
		return Action.isDisplayed(driver, firstAddressIcon);
	}
	
	public boolean validateOrderHistory() {
		return Action.isDisplayed(driver, historyDetails);
	}
	
	public boolean validateCreditSlip() {
		return Action.isDisplayed(driver, creditSlip);
	}
	
	public String getCurrentUrl() {
		String homePageUrl = driver.getCurrentUrl();
		return homePageUrl;
	}
}
