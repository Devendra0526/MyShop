package com.myStore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myStore.actionDriver.Action;
import com.myStore.base.BaseClass;

public class LoginPage extends BaseClass {

	@FindBy(id = "email")
	WebElement userNameTxt;
	
	@FindBy(name = "passwd")
	WebElement passwordTxt;
	
	@FindBy(xpath = "//i[@class='icon-lock left']")
	WebElement lockSignInBtn;
	
	@FindBy(name = "email_create")
	WebElement createEmailBox;
	
	@FindBy(xpath = "//i[@class='icon-user left']")
	WebElement newAccountCreateBtn;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public HomePage login(String uname, String pwd) {
		Action.type(userNameTxt, uname);
		Action.type(passwordTxt, pwd);
		Action.click(driver, lockSignInBtn);
		return new HomePage();
	}
	
	public AddressPage login1(String uname, String pwd) {
		Action.type(userNameTxt, uname);
		Action.type(passwordTxt, pwd);
		Action.click(driver, lockSignInBtn);
		return new AddressPage();
	}
	
	public AccountCreationPage createNewAccount(String newEmail) {
		Action.type(createEmailBox, newEmail);
		Action.click(driver, newAccountCreateBtn);
		return new AccountCreationPage();
	}
}
