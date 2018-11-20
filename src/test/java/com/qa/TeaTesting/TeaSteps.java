package com.qa.TeaTesting;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TeaSteps {
	

	
	WebDriver driver;
	HomePage homePage;
	MenuPage menuPage;
	CheckoutPage checkoutPage;
	
	TeaTest runner = new TeaTest();

	@Before
	public void setUp() {
		
					
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		
	}

	@Given("^the correct web address$")
	public void the_correct_web_address() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.get("http://www.practiceselenium.com/welcome.html");

	}

	@When("^I navigate to the 'Menu' page$")
	public void i_navigate_to_the_Menu_page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.clickMenuButton();
		
		
	}

	@Then("^I can browse a list of the available products\\.$")
	public void i_can_browse_a_list_of_the_available_products() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		runner.test = runner.report.startTest("Browse available products");
		
		if(menuPage.browseItems() == "Green Tea") 
		{
			runner.test.log(LogStatus.PASS, "Amen");
			
		}
		
		else
		{
			runner.test.log(LogStatus.FAIL, "Need to fix the button");
			
		}
	
	
		Assert.assertEquals("Green Tea", menuPage.browseItems());
		
		

	}

	@When("^I click the checkout button$")
	public void i_click_the_checkout_button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		

		//menuPage.clickCheckOutButton();
	}

	@Then("^I am taken to the checkout page$")
	public void i_am_taken_to_the_checkout_page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		checkoutPage = PageFactory.initElements(driver, CheckoutPage.class);
		
		runner.test = runner.report.startTest("Checkout page");
		
		
		if(checkoutPage.verifyTheCheckout() == "Enter your billing information") 
		{
			runner.test.log(LogStatus.PASS, "The billing information was on the page");
			
		}
		
		else
		{
			runner.test.log(LogStatus.FAIL, "Need to fix it pronto");
			
		}
		Assert.assertEquals("Enter your billing information", checkoutPage.verifyTheCheckout());
	}

	@After
	public void tearDown() {
		runner.report.endTest(runner.test);
		driver.quit();
	}
}
