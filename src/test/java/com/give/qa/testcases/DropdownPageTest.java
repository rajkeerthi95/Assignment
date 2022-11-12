/*
 * @autor : 
 * 
 */
package com.give.qa.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.give.qa.base.TestBase;
import com.give.qa.pages.DropdownPage;
import com.give.qa.pages.HomePage;


public class DropdownPageTest extends TestBase{
	HomePage homePage;
	DropdownPage dropdownPage;
	String actualValue;
	String ExpectedValue;
	
	public DropdownPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		homePage = new HomePage();
		dropdownPage = new DropdownPage();
	}
	
	@Test(priority=1)
	public void verifyDropdownTest(){
		
		homePage.clickonDropDownLink();
		homePage = dropdownPage.selectOptionFromDropDownUsingVisibleText("Option 2");
		
		boolean flag = dropdownPage.validateSelectedOptionFromDropDown();
		Assert.assertTrue(flag);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}