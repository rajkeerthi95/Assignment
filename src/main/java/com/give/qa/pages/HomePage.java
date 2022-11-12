/*
 * @autor : 
 * 
 */
package com.give.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.give.qa.base.TestBase;

public class HomePage extends TestBase {

	//Page Factory - OR:

	@FindBy(xpath="//a[contains(text(),'File Upload')]")
	WebElement fileUploadlnk;

	@FindBy(xpath="//a[contains(text(),'Broken Images')]")
	WebElement brokenImageslnk;

	@FindBy(xpath="//a[contains(text(),'Form Authentication')]")
	WebElement formAuthenticationlnk;

	@FindBy(xpath="//a[contains(text(),'Dropdown')]")
	WebElement dropdownlnk;

	//Initializing the Page Objects:
	public HomePage(){
		PageFactory.initElements(driver, this);
	}

	//Actions:
	public HomePage clickonFileuploadLink(){
		fileUploadlnk.click();
		return new HomePage();
	}

	public HomePage clickonBrokenImagesLink(){
		brokenImageslnk.click();
		return new HomePage();
	}

	public HomePage clickonFormAuthenticationLink(){
		formAuthenticationlnk.click();
		return new HomePage();
	}

	public HomePage clickonDropDownLink(){
		dropdownlnk.click();
		return new HomePage();
	}
}