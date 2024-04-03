/**
 * 
 */
package com.myStore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myStore.actionDriver.Action;
import com.myStore.base.BaseClass;

/**
 * 
 */
public class AddToCartPage extends BaseClass {

	@FindBy(id = "quantity_wanted")
	WebElement addQuantity;
	
	@FindBy(name = "group_1")
	WebElement selectSize;
	
	@FindBy(xpath = "//span[text()='Add to cart']")
	WebElement addToCartBtn;
	
	@FindBy(xpath = "//div[@id='layer_cart']/div[1]/div[1]/h2")
	WebElement productAddedSuccessfully;
	
	@FindBy(xpath = "//div[@id='layer_cart']//a")
	WebElement proccedToCheckoutBtn;
	
	public AddToCartPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void enterQuantity(String quantity) {
		Action.type(addQuantity, quantity);
	}
	
	public void sizeSelect(String size) {
		Action.selectByVisibleText(size, selectSize);
	}
	
	public void clickOnAddToCart() {
		Action.click(driver, addToCartBtn);
	}
	
	public boolean vlidateProductAddeddIntoAddToCart() {
		Action.fluentWait(driver, productAddedSuccessfully, 10);
		return Action.isDisplayed(driver, productAddedSuccessfully);
	}
	
	public OrderPage clickOnProccedToCheckoutBtn() {
		Action.fluentWait(driver, proccedToCheckoutBtn, 10);
		Action.JSClick(driver, proccedToCheckoutBtn);
		return new OrderPage();
	}
}
