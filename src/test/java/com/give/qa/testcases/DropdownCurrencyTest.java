
package com.give.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.give.qa.base.BasePage;
import com.give.qa.pages.DropdownCurrencyPage;

public class DropdownCurrencyTest extends BasePage {

	DropdownCurrencyPage dropdownPage;

	public DropdownCurrencyTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization1();

		dropdownPage = new DropdownCurrencyPage();
	}

	@Test(priority = 1)
	public void verifyDropdownCurrencyTest() {

		dropdownPage.verifydropDownitems();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}