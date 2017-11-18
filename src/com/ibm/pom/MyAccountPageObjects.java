package com.ibm.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ibm.utils.TestBase;

public class MyAccountPageObjects {

	public static WebElement getWelcomeMessage(WebDriver driver) {
		// TODO Auto-generated method stub
		
		By locator = By.cssSelector("p.info-account");
		return TestBase.explicitFindElement(locator, driver);
	}

}
