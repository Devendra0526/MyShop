package com.myStore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myStore.actionDriver.Action;
import com.myStore.base.BaseClass;

public class AccountCreationPage extends BaseClass {

	@FindBy(xpath = "//button[@id='SubmitCreate']")
	WebElement headingOfCreateAccount;
	
	public AccountCreationPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateAccountCreatePage() {
		return Action.isDisplayed(driver, headingOfCreateAccount);
	}
}
