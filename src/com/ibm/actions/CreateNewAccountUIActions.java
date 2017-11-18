 package com.ibm.actions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.ibm.pom.CreateAccountPageObjects;
import com.ibm.pom.HomePageObjects;
import com.ibm.pom.SignInPageObjects;

public class CreateNewAccountUIActions {
	
public final static Logger log = Logger.getLogger(CreateNewAccountUIActions.class.getName());
	
	public static void enterNewAccountDetailsHappyPath (WebDriver driver){

				
				//Create An Account Page
				
				CreateAccountPageObjects.getTitleCheckBox(driver).click();
				log.info("Clicked on Title @:"+CreateAccountPageObjects.getTitleCheckBox(driver));
				
				
				CreateAccountPageObjects.getFirstNameTextBox(driver).sendKeys("Ritesh");
				log.info("Entered First Name @:"+CreateAccountPageObjects.getFirstNameTextBox(driver));
				
				CreateAccountPageObjects.getLastNameTextBox(driver).sendKeys("Mansukhani");
				log.info("Entered Last Name @:"+CreateAccountPageObjects.getLastNameTextBox(driver));
				
				
				CreateAccountPageObjects.getPasswordTextBox(driver).sendKeys("123456");
				log.info("Entered Password @:"+CreateAccountPageObjects.getPasswordTextBox(driver));
				
				new Select (CreateAccountPageObjects.getDaysDropDown(driver)).selectByValue("1");
				log.info("Day Selected @:"+CreateAccountPageObjects.getDaysDropDown(driver));
				
				
				
				 new Select (CreateAccountPageObjects.getMonthsDropDown(driver)).selectByValue("1");
				 log.info("Month Selected @:"+CreateAccountPageObjects.getMonthsDropDown(driver));
				
				
				
				 new Select (CreateAccountPageObjects.getYearsDropDown(driver)).selectByValue("1991");
				 log.info("Year Selected @:"+CreateAccountPageObjects.getYearsDropDown(driver));
				
				 CreateAccountPageObjects.getCompanyTextBox(driver).sendKeys("IBM India Pvt Ltd");
				log.info("Entered Company Name @:"+CreateAccountPageObjects.getCompanyTextBox(driver));
				
				CreateAccountPageObjects.getAddressLine1TextBox(driver).sendKeys("A-1104 SUYASH NISARG HANDEWADI ROAD HADAPSAR");
				log.info("Entered Address Line 1 @:"+CreateAccountPageObjects.getAddressLine1TextBox(driver));
				
				
				CreateAccountPageObjects.getAddressLine2TextBox(driver).sendKeys("NEAR JSPM COLLEGE HADAPSAR");
				log.info("Entered Addres Line 2 @:"+CreateAccountPageObjects.getAddressLine2TextBox(driver));
				
				CreateAccountPageObjects.getCityTextBox(driver).sendKeys("Pune");
				log.info("Entered City @:"+CreateAccountPageObjects.getCityTextBox(driver));
				
				
				new Select (CreateAccountPageObjects.getStateDropDown(driver)).selectByValue("47");
				log.info("Selected State @:"+CreateAccountPageObjects.getStateDropDown(driver));
				
				
				CreateAccountPageObjects.getZipCodeTextBox(driver).sendKeys("20001");
				log.info("Entered Zip Code @:"+CreateAccountPageObjects.getZipCodeTextBox(driver));
				
				
				new Select (CreateAccountPageObjects.getCountryDropDown(driver)).selectByValue("21");
				log.info("Selected Country @:"+CreateAccountPageObjects.getCountryDropDown(driver));
						
				CreateAccountPageObjects.getAdditionalInformationTextBox(driver).sendKeys("Additional Automated Comments");
				log.info("Entered Additioanl Information @:"+CreateAccountPageObjects.getAdditionalInformationTextBox(driver));
				
				CreateAccountPageObjects.getHomePhoneTextBox(driver).sendKeys("02042176767");
				log.info("Entered Home Phone @:"+CreateAccountPageObjects.getHomePhoneTextBox(driver));
				
				CreateAccountPageObjects.getMobilePhoneTextBox(driver).sendKeys("9812011010");
				log.info("Entered Mobile Phone @:"+CreateAccountPageObjects.getMobilePhoneTextBox(driver));
				
				CreateAccountPageObjects.getAddressAliasTextBox(driver).sendKeys("Home");
				log.info("Entered Address Alias @:"+CreateAccountPageObjects.getAddressAliasTextBox(driver));
						
	}
	
	
	
	public static void clickOnRegisterAfterEnteringDetails(WebDriver driver){
		
		CreateAccountPageObjects.getRegisterButton(driver).click();	
		log.info("Clicked on Register Button To Create New Account");
	}
	
	public static void enterEmailIDToRegisterAndSubmit(WebDriver driver){
		//Enter Email Id to Register
		SignInPageObjects.getCreateAnAccountEmailAddressTextBox(driver).sendKeys(System.currentTimeMillis() + "@gmail.com");
		log.info("Entered Email ID for Creating New Account @:"+SignInPageObjects.getCreateAnAccountEmailAddressTextBox(driver).toString());
		
		
		SignInPageObjects.getCreateAnAccountSubmitButton(driver).click();
		log.info("Clicked On Submit Button To Create New Account @:"+SignInPageObjects.getCreateAnAccountSubmitButton(driver).toString());

	}
	
	public static void clickOnSignInLink (WebDriver driver){
		
		HomePageObjects.getSignInButton(driver).click();
		log.info("Clicked On Sign In Button From Home Page @:"+HomePageObjects.getSignInButton(driver).toString());
	}
	
}
