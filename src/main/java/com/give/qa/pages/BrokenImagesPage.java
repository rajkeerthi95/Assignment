/*
 * @autor : 
 * 
 */
package com.give.qa.pages;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.give.qa.base.TestBase;

public class BrokenImagesPage extends TestBase{

	//Page Factory - OR:
	
	@FindBy(id="src")
	WebElement imageSource;

	@FindBy(tagName ="img")
	List<WebElement> listofimages;

	public int brokenImageCount;

	//Initializing the Page Objects:
	public BrokenImagesPage(){
		PageFactory.initElements(driver, this);
	}

	//Actions:
	public String validateAgrichainPageTitle(){
		return driver.getTitle();
	}

	public HomePage validateBrokenImages(){
		brokenImageCount = 0;
		List<WebElement> images = listofimages;
		System.out.println("Total number of images are " + images.size());
		for (WebElement imgElement : images) {
			if (imgElement != null) {
				verifyBrokenImage(imgElement);
				
			}
		}
		//System.out.println("Total number of broken images are "	+ brokenImageCount);
		return new HomePage();
	}
	
	public void verifyBrokenImage(WebElement imgElement) {
		try {
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet(imgElement.getAttribute("src"));
			HttpResponse response = client.execute(request);
			if (response.getStatusLine().getStatusCode() != 200)
				System.out.println(imgElement.getAttribute("outerHTML") + " image is broken.");
				brokenImageCount++;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}