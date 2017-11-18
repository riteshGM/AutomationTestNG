package com.ibm.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ibm.utils.TestBase;



public class CreateAccountPageObjects {

	public static WebElement getTitleCheckBox(WebDriver driver) {
		// TODO Auto-generated method stub
		By locator = By.cssSelector("input#id_gender1");
		return TestBase.explicitFindElement(locator, driver);
	}

	public static WebElement getFirstNameTextBox(WebDriver driver) {
		// TODO Auto-generated method stub
		By locator = By.cssSelector("input#customer_firstname");
		return TestBase.explicitFindElement(locator, driver);
	}

	public static WebElement getLastNameTextBox(WebDriver driver) {
		// TODO Auto-generated method stub
		By locator = By.cssSelector("input#customer_lastname");
		return TestBase.explicitFindElement(locator, driver);
	}

	public static WebElement getPasswordTextBox(WebDriver driver) {
		// TODO Auto-generated method stub
		By locator = By.cssSelector("input#passwd");
		return TestBase.explicitFindElement(locator, driver);
	}

	public static WebElement getDaysDropDown(WebDriver driver) {
		// TODO Auto-generated method stub
		By locator = By.cssSelector("select#days");
		return TestBase.explicitFindElement(locator, driver);
	}

	public static WebElement getMonthsDropDown(WebDriver driver) {
		// TODO Auto-generated method stub
		By locator = By.cssSelector("select#months");
		return TestBase.explicitFindElement(locator, driver);
	}

	public static WebElement getYearsDropDown(WebDriver driver) {
		// TODO Auto-generated method stub
		By locator = By.cssSelector("select#years");
		return TestBase.explicitFindElement(locator, driver); 
		
	}

	public static WebElement getCompanyTextBox(WebDriver driver) {
		// TODO Auto-generated method stub
		By locator = By.cssSelector("input#company");
		return TestBase.explicitFindElement(locator, driver); 
	}

	public static WebElement getAddressLine1TextBox(WebDriver driver) {
		// TODO Auto-generated method stub
		By locator = By.cssSelector("input#address1");
		return TestBase.explicitFindElement(locator, driver); 
	}

	public static WebElement getAddressLine2TextBox(WebDriver driver) {
		// TODO Auto-generated method stub
		By locator = By.cssSelector("input#address2");
		return TestBase.explicitFindElement(locator, driver); 
		
	}

	public static WebElement getCityTextBox(WebDriver driver) {
		// TODO Auto-generated method stub
		By locator = By.cssSelector("input#city");
		return TestBase.explicitFindElement(locator, driver); 
	}

	public static WebElement getStateDropDown(WebDriver driver) {
		// TODO Auto-generated method stub
		By locator = By.cssSelector("select#id_state");
		return TestBase.explicitFindElement(locator, driver);
	}

	public static WebElement getCountryDropDown(WebDriver driver) {
		
		// TODO Auto-generated method stub
		By locator = By.cssSelector("select#id_country");
		return TestBase.explicitFindElement(locator, driver);
		
	}

	public static WebElement getZipCodeTextBox(WebDriver driver) {
		// TODO Auto-generated method stub
		By locator = By.cssSelector("input#postcode");
		return TestBase.explicitFindElement(locator, driver);
	}

	public static WebElement getAdditionalInformationTextBox(WebDriver driver) {
		// TODO Auto-generated method stub
		By locator = By.cssSelector("textarea#other");
		
		return TestBase.explicitFindElement(locator, driver);
	}

	public static WebElement getHomePhoneTextBox(WebDriver driver) {
		// TODO Auto-generated method stub
		By locator = By.cssSelector("input#phone");
		return TestBase.explicitFindElement(locator, driver);
	}
	
	

	public static WebElement getMobilePhoneTextBox(WebDriver driver) {
		// TODO Auto-generated method stub
		By locator = By.cssSelector("input#phone_mobile");
		return TestBase.explicitFindElement(locator, driver);
	}
	
	public static WebElement getAddressAliasTextBox(WebDriver driver) {
		// TODO Auto-generated method stub
		By locator = By.cssSelector("input#alias");
		return TestBase.explicitFindElement(locator, driver);
	}

	public static WebElement getRegisterButton(WebDriver driver) {
		// TODO Auto-generated method stub
		By locator = By.cssSelector("button#submitAccount");
		return TestBase.explicitFindElement(locator, driver);
	}
	
	
	
	

}
