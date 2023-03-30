package com.give.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.give.qa.base.BasePage;
import com.give.qa.pages.DonatePage;

public class DonatePageTest extends BasePage {

	DonatePage DonatePage;

	public DonatePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		DonatePage = new DonatePage();

	}

	@Test(priority = 1)
	public void verifyDonateTest() {
		DonatePage.Homepage();
		DonatePage.logo();
		DonatePage.Textboxamount();
		DonatePage.Givenow();
		DonatePage.Donationsummary();
		DonatePage.Continuetopay();
		DonatePage.Payment();
		DonatePage.Indiancitizen();
		DonatePage.payment(prop.getProperty("name"), prop.getProperty("mobile"), prop.getProperty("email"),
				prop.getProperty("pincode"), prop.getProperty("address"));
		DonatePage.Donate();
		DonatePage.iframe();
		DonatePage.Pop();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}