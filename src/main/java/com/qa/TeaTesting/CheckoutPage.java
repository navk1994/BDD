package com.qa.TeaTesting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage {

	@FindBy(xpath = "//*[@id=\"wsb-element-00000000-0000-0000-0000-000453230000\"]/div/p/span/span/strong")
	private WebElement items;

	public String verifyTheCheckout() {
		return items.getText();
	}
}
