package com.ibm.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ibm.utils.TestBase;


public class HomePageObjects {

	
	
	
	public static WebElement getSignInButton(WebDriver driver) {
		// TODO Auto-generated method stub
		
		By locator = By.cssSelector("a.login");
		return TestBase.explicitFindElement(locator, driver);
		
	}

}
