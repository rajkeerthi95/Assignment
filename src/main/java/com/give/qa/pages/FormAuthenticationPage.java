/*
 * @autor : 
 * 
 */
package com.give.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.give.qa.base.TestBase;

public class FormAuthenticationPage extends TestBase{

	//Page Factory - OR:
	@FindBy(id="username")
	WebElement username;

	@FindBy(id="password")
	WebElement password;

	@FindBy(xpath="//i[contains(text(),'Login')]")
	WebElement loginBtn;

	@FindBy(xpath="//h4[contains(text(),'Welcome to the Secure Area. When you are done clic')]")
	WebElement welcomeText;

	@FindBy(xpath="//*[contains(text(),' Logout')]")
	WebElement logoutBtn;

	@FindBy(xpath="//h2[contains(text(),'Login Page')]")
	WebElement loginHeader;

	@FindBy(xpath="//*[contains(text(),' Your username is invalid!')]")
	WebElement loginerrorMessage;


	//Initializing the Page Objects:
	public FormAuthenticationPage(){
		PageFactory.initElements(driver, this);
	}

	//Actions:
	public String validateWelcomeText(){
		return welcomeText.getText();
	}

	public boolean validateLoginErrorMessage(){
		return loginerrorMessage.isDisplayed();
	}

	public boolean validateLoginHeader(){
		return loginHeader.isDisplayed();
	}

	public HomePage login(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();	
		return new HomePage();
	}

	public HomePage logout(){
		logoutBtn.click(); 	
		return new HomePage();
	}
}