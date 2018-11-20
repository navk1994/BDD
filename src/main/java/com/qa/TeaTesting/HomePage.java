package com.qa.TeaTesting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import junit.framework.Assert;

public class HomePage {

	@FindBy(xpath = "//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[3]/a")
	private WebElement menuWebLink;

	public void clickMenuButton() {
		menuWebLink.click();

	}

}
