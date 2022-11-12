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
import com.give.qa.pages.FileUploaderPage;
import com.give.qa.pages.HomePage;
import com.give.qa.util.TestUtil;

public class FileUploaderPageTest extends TestBase{
	HomePage homePage;
	FileUploaderPage fileUploaderPage;
	String actualValue;
	String ExpectedValue;
	
	public FileUploaderPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		fileUploaderPage = new FileUploaderPage();
		homePage = new HomePage();
	}
	
	@Test(priority=1)
	public void verifyUploadFileTest(){
		homePage.clickonFileuploadLink();
		homePage = fileUploaderPage.uploadFile(TestUtil.image_path);
		boolean flag = fileUploaderPage.validateFileUploadedText();
		Assert.assertTrue(flag);
		actualValue =   fileUploaderPage.validateUploadedFilenameText();
		ExpectedValue = "image.jpg";
		
		Assert.assertEquals(actualValue,ExpectedValue);
	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}