/*
 * @autor : 
 * 
 */
package com.give.qa.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.give.qa.base.TestBase;
import com.give.qa.pages.FormAuthenticationPage;
import com.give.qa.pages.HomePage;
import com.give.qa.util.TestUtil;

public class FormAuthenticationPageTest extends TestBase{

	FormAuthenticationPage formAuthenticationPage;
	HomePage homePage;
	String sheetName = "FormAuthentication";
	String actualValue;
	String ExpectedValue;
	public FormAuthenticationPageTest(){
		super();
	}

	@BeforeMethod
	public void setUp(){
		initialization();
		homePage = new HomePage();
		formAuthenticationPage= new FormAuthenticationPage();
	}



	@Test(priority=2, dataProvider="getLoginTestData")
	public void formAuthenticationTestFromExcel(String username, String password){
		homePage.clickonFormAuthenticationLink();
		homePage = formAuthenticationPage.login(username, password);
		
		boolean flag = formAuthenticationPage.validateLoginErrorMessage();
		Assert.assertTrue(flag);

	}

	@DataProvider
	public Object[][] getLoginTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority=1)
	public void formAuthenticationTestFromPropertyfile(){
		homePage.clickonFormAuthenticationLink();
		homePage = formAuthenticationPage.login(prop.getProperty("username"), prop.getProperty("password"));
		actualValue =   formAuthenticationPage.validateWelcomeText();
		ExpectedValue = "Welcome to the Secure Area. When you are done click logout below.";

		Assert.assertEquals(actualValue,ExpectedValue);
		formAuthenticationPage.logout();
		boolean flag = formAuthenticationPage.validateLoginHeader();
		Assert.assertTrue(flag);
	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}