package com.qa.TeaTesting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuPage {

	@FindBy(xpath = "//*[@id=\"wsb-element-00000000-0000-0000-0000-000453230000\"]/div/p/span/span/strong")
	private WebElement items;

	@FindBy(xpath = "/html/body/div/div/div[1]/div/div[16]/div/a/span")
	private WebElement checkoutButton;

	public String browseItems() {
		return items.getText();
	}

	public void clickCheckOutButton() {
		checkoutButton.click();
	}
}
