/*
 * @autor : 
 * 
 */
package com.give.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.give.qa.base.TestBase;

public class DropdownPage extends TestBase{

	//Page Factory - OR:
	@FindBy(id="dropdown")
	WebElement drpPleaseselectanOption;

	@FindBy(xpath="//option[contains(text(),'Option 2')]")
	WebElement drpSelectedOption;

	//Initializing the Page Objects:
	public DropdownPage(){
		PageFactory.initElements(driver, this);
	}

	//Actions:
	public boolean validateSelectedOptionFromDropDown(){
		return drpSelectedOption.isDisplayed();
	}

	public HomePage selectOptionFromDropDownUsingVisibleText(String option){
		Select select = new Select(drpPleaseselectanOption);
		select.selectByVisibleText(option);
		return new HomePage();
	}
}