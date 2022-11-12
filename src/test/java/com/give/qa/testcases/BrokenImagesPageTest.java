/*
 * @autor : 
 * 
 */
package com.give.qa.testcases;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.give.qa.base.TestBase;
import com.give.qa.pages.BrokenImagesPage;
import com.give.qa.pages.HomePage;

public class BrokenImagesPageTest extends TestBase{
	HomePage homePage;
	BrokenImagesPage brokenImagesPage;

	public BrokenImagesPageTest(){
		super();
	}

	@BeforeMethod
	public void setUp(){
		initialization();
		brokenImagesPage = new BrokenImagesPage();
		homePage = new HomePage();
	}

	@Test(priority=1)
	public void verifyBrokenImagesTest(){

		homePage.clickonBrokenImagesLink();
		homePage = brokenImagesPage.validateBrokenImages();
	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}