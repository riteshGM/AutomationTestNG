package com.ibm.actions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import com.ibm.pom.SignInPageObjects;

public class SignInUIActions {
	
	public final static Logger log = Logger.getLogger(SignInUIActions.class.getName());
	
	
	public static void enterEmailIDAndPasswordToSignInAndSubmit(WebDriver driver){
		//Enter Email Id to Register
		SignInPageObjects.getSignInEmailAddressTextBox(driver).sendKeys("ritesh123@gmail.com");
		log.info("Entered Email ID to SignIn @:"+SignInPageObjects.getSignInEmailAddressTextBox(driver).toString());
		
		SignInPageObjects.getSignInPasswordTextBox(driver).sendKeys("123456");
		log.info("Entered Password to SignIn @:"+SignInPageObjects.getSignInPasswordTextBox(driver).toString());
		SignInPageObjects.getSignInButton(driver).click();
		log.info("Clicked On Sign-In Button ");

	}
	
	public static void clickDiscoverStores(WebDriver driver){
		
		SignInPageObjects.getDiscoverOurStoresButton(driver).click();
		log.info("Clicked On Discover Out Stores Button ");
	}

	public static void enterYourLocationAndClickSearch(WebDriver driver) {
		// TODO Auto-generated method stub
		
		SignInPageObjects.getYourLocationTextBox(driver).clear();
		SignInPageObjects.getYourLocationTextBox(driver).sendKeys("Aventura");
		log.info("Entered Store Location @:"+SignInPageObjects.getYourLocationTextBox(driver));
		
		SignInPageObjects.getYourLocationSearchButton(driver).click();
		log.info("Clicked On Search Button for Location ");
		
	
	}

	public static void clickWomenCategory(WebDriver driver) {
		// TODO Auto-generated method stub
		
		SignInPageObjects.getWomenCategoryButton(driver).click();
		log.info("Clicked On Women Category ");
		
	}

	
	

}
