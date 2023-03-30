
package com.give.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.give.qa.base.BasePage;

public class DonatePage extends BasePage {

	// Page Factory - OR:

	@FindBy(css = "div.App:nth-child(1) div.home_page_carousel_arrow:nth-child(2) div.slick-slider.btn-slider.slick-initialized div.slick-list:nth-child(2) div.slick-track div.slick-slide.slick-active.slick-current:nth-child(2) div:nth-child(1) div:nth-child(1) > a:nth-child(1)")
	WebElement banner;

	@FindBy(xpath = "//div[@class=\"MuiBox-root jss144 jss36\"]//img")
	WebElement Givelogo;

	@FindBy(xpath = "(//input[@id=\"other\"])[2]")
	WebElement EnterAmount;

	@FindBy(xpath = "(//button[@type=\"submit\"])[2]")
	WebElement Givenowbutton;

	@FindBy(xpath = "//span[contains(text(),'Donation summary')]	")
	WebElement Donationsummarypage;

	@FindBy(xpath = "//span[contains(text(),'Continue to pay')]")
	WebElement Continuetopaybutton;

	@FindBy(xpath = "//span[contains(text(),'Payment')]")
	WebElement Paymentpage;

	@FindBy(xpath = "(//input[@type=\"radio\"])[1]")
	WebElement Indiancitizenradio;

	@FindBy(xpath = "//input[@placeholder='Enter full name']")
	WebElement Enterfullname;

	@FindBy(xpath = "//input[@placeholder='1 (702) 123-4567']")
	WebElement MobileNumber;

	@FindBy(xpath = "//input[@name=\"email\"]")
	WebElement Email;

	@FindBy(xpath = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained payment-donate MuiButton-containedPrimary MuiButton-containedSizeLarge MuiButton-sizeLarge']")
	WebElement Country;

	@FindBy(xpath = "//input[@name=\"pincode\"]")
	WebElement Pincode;

	@FindBy(xpath = "//input[@placeholder='Enter Address']")
	WebElement EnterAddress;

	@FindBy(xpath = "(//button[@type='button'])[5]")
	WebElement Donatebutton;

	@FindBy(css = "iframe.razorpay-checkout-frame")
	WebElement iframe;

	@FindBy(xpath = "//div[@class=\"header-title-wrapper svelte-f8jo93\"]//p[@title=\"Give Fundraisers\"]")
	WebElement Popup;

	// Initializing the Page Objects:
	public DonatePage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public void Homepage() {
		banner.click();
		String PagetitleExpected = driver.getTitle();
		String PagetitleActual = "Help real-life hero Dr Somarajan to rescue abandoned elderly from a life on the streets | Give";
		System.out.println(PagetitleExpected);
		if (PagetitleExpected.equals(PagetitleActual)) {
			System.out.println("The real-life hero Dr Somarajan page Displayed");
		} else {
			System.out.println("The real-life hero Dr Somarajan page not Displayed");
		}
		Assert.assertEquals(PagetitleExpected, PagetitleActual);
	}

	public void logo() {
		Assert.assertTrue(Givelogo.isDisplayed(), "Logo is not displayed");
	}

	public void Textboxamount() {

		EnterAmount.sendKeys("1000");

	}

	public void Givenow() {

		Givenowbutton.click();
	}

	public void Donationsummary() {

		String Page = Donationsummarypage.getText();
		System.out.println(Donationsummarypage.getText());
		Assert.assertEquals(Page, "Donation summary");

	}

	public void Continuetopay() {

		Continuetopaybutton.click();
	}

	public void Payment() {

		String Page1 = Paymentpage.getText();
		System.out.println(Paymentpage.getText());
		Assert.assertEquals(Page1, "Payment");

	}

	public void Indiancitizen() {

		Indiancitizenradio.click();
	}

	public void payment(String name, String mobile, String email, String pincode, String address) {
		Enterfullname.sendKeys(name);

		MobileNumber.sendKeys(mobile);

		Email.sendKeys(email);

		Pincode.sendKeys(pincode);

		EnterAddress.sendKeys("Hyderabad");

		Enterfullname.sendKeys(address);

	}

	public void Donate() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", Donatebutton);
		// Donatebutton.click();
	}

	public void iframe() {

		driver.switchTo().frame(iframe);
	}

	public void Pop() {

		String Page2 = Popup.getText();
		System.out.println(Popup.getText());
		Assert.assertEquals(Page2, "Give Fundraisers");
	}
}
