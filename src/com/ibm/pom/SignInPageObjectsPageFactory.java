package com.ibm.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.ibm.utils.TestBase;


public class SignInPageObjectsPageFactory {


	
	public static WebElement getCreateAnAccountEmailAddressTextBox(WebDriver driver) {
		// TODO Auto-generated method stub
		
	
		
		
		By locator = By.cssSelector("input#email_create");
		return TestBase.explicitFindElement(locator, driver);
		
	}


	public static WebElement getCreateAnAccountSubmitButton(WebDriver driver) {
		// TODO Auto-generated method stub
		By locator = By.cssSelector("button#SubmitCreate");
		return TestBase.explicitFindElement(locator, driver);
	}


	public static WebElement getSignInEmailAddressTextBox(WebDriver driver) {
		// TODO Auto-generated method stub
		By locator = By.cssSelector("input#email");
		return TestBase.explicitFindElement(locator, driver);
	}


	public static WebElement getSignInPasswordTextBox(WebDriver driver) {
		// TODO Auto-generated method stub
		By locator = By.cssSelector("input#passwd");
		return TestBase.explicitFindElement(locator, driver);
	}


	public static WebElement getSignInButton(WebDriver driver) {
		// TODO Auto-generated method stub
		By locator = By.cssSelector("button#SubmitLogin");
		return TestBase.explicitFindElement(locator, driver);
	}


	public static WebElement getDiscoverOurStoresButton(WebDriver driver) {
		// TODO Auto-generated method stub
		
		By locator = By.xpath("//a[@title='Our stores']");
		return TestBase.explicitFindElement(locator, driver);
	}


	public static WebElement getYourLocationTextBox(WebDriver driver) {
		// TODO Auto-generated method stub
		By locator = By.cssSelector("input#addressInput");
		return TestBase.explicitFindElement(locator, driver);
	}


	public static WebElement getYourLocationSearchButton(WebDriver driver) {
		// TODO Auto-generated method stub
		By locator = By.xpath("//button[@name='search_locations']");
		return TestBase.explicitFindElement(locator, driver);
	}


	public static WebElement getStoreNameFromSearchResultsObject(
			WebDriver driver) {
		// TODO Auto-generated method stub
		By locator = By.xpath("//table[@id='stores-table']//following::tbody//following::tr[2]//following::td[1]");
		return TestBase.explicitFindElement(locator, driver);
	}


	public static WebElement getWomenCategoryButton(WebDriver driver) {
		// TODO Auto-generated method stub
		By locator = By.xpath("//a[text()='Women']");
		return TestBase.explicitFindElement(locator, driver);
	}

}
