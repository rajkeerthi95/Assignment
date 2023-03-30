package com.give.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.give.qa.base.BasePage;

public class DropdownCurrencyPage extends BasePage {

	@FindBy(css = "#demo-customized-select-native")
	WebElement dropDown;

	// Initializing
	public DropdownCurrencyPage() {
		PageFactory.initElements(driver, this);
	}

	public void verifydropDownitems() {

		String arr[] = { "AED(د.إ)", "AMD(֏)", "AUD(A$)", "BBD(Bds$)", "BDT(৳)", "BGN(лв.)", "CAD($)", "CNY(¥)",
				"CRC(₡)", "CZK(Kč)", "DKK(Kr.)", "EUR(€)", "GBP(£)", "HKD(HK$)", "INR(₹)", "JPY(¥)", "KES(KSh)",
				"KRW(₩)", "MUR(MUR)", "MYR(RM)", "NOK(kr)", "NPR(रु)", "PGK(K)", "QAR(QAR)", "RUB(₽)", "SEK(kr)",
				"SGD(S$)", "THB(฿)", "TWD(NT$)", "USD($)" };
		Select select = new Select(dropDown);
		List<WebElement> options = select.getOptions();
		boolean match = false;
		for (int i = 0; i < options.size(); i++) {
			System.out.println(options.get(i).getText() + " == " + arr[i]);
			if (options.get(i).getText().equals(arr[i])) {
				match = true;
			} else {
				match = false;
				break;
			}
		}
		Assert.assertTrue(match);
	}

}