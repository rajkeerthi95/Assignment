/*
 * @autor : 
 * 
 */
package com.give.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.give.qa.base.TestBase;

public class FileUploaderPage extends TestBase{

	//Page Factory - OR:
	@FindBy(id="file-upload")
	WebElement choosefileBtn;

	@FindBy(id="file-submit")
	WebElement uploadBtn;

	@FindBy(xpath="//h3[contains(text(),'File Uploaded!')]")
	WebElement fileUploadedText;

	@FindBy(id="uploaded-files")
	WebElement uploadedfileName;

	//Initializing the Page Objects:
	public FileUploaderPage(){
		PageFactory.initElements(driver, this);
	}

	//Actions:
	public boolean validateFileUploadedText(){
		return fileUploadedText.isDisplayed();
	}

	public String validateUploadedFilenameText(){
		return uploadedfileName.getText();
	}

	public HomePage uploadFile(String filePath){
		choosefileBtn.sendKeys(filePath);
		uploadBtn.click();
		return new HomePage();
	}
}