package com.ibm.test;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ibm.actions.CreateNewAccountUIActions;
import com.ibm.actions.SignInUIActions;
import com.ibm.pom.SignInPageObjects;
import com.ibm.utils.TestBase;

/**
 * 
 * @author Ritesh Mansukhani
 *
 */

public class TestCase02 extends TestBase {
	
	public static final Logger log = Logger.getLogger(TestCase02.class.getName());

	WebElement element = null;
	public String methodName = null;
	WebDriver driver = null;
	
	@BeforeClass
	public void setUP(){
		log.info("=========== Execution Started for Test Case02 =============");
		driver = init();   
	}
	@AfterClass
	public void rollOff(){

        log.info("=========== Execution Finished for Test Case02 =============");
        driver.quit();
        driver = null;
	}
	
	@BeforeMethod
	 public void beforeTestMethod(Method testMethod){
	   methodName=testMethod.getName();
	 }

	@AfterMethod
	 public void afterTestMethod (ITestResult result){
		 
		 	if(!result.isSuccess()){
		 		getScreenShotOnFailure(driver, methodName);
		 	}
	 }
	 
	 
@Test (priority =0)
public void testCase02_VerifyUserIsAbleToSearchStore() {
	
	try{
		
	
	driver.get(TestBase.getData("TestCases.Environment.URL"));
	getScreenShotOnProgress(driver, methodName);
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Integer.parseInt(TestBase.getData("TestCases.ImplicitWait.Seconds")), TimeUnit.SECONDS);

	//driver.navigate().to("javascript:document.getElementById('overridelink').click()");
	
	CreateNewAccountUIActions.clickOnSignInLink(driver);
	getScreenShotOnProgress(driver, methodName);
	
	SignInUIActions.enterEmailIDAndPasswordToSignInAndSubmit(driver);
	
	SignInUIActions.clickWomenCategory(driver);
	
	SignInUIActions.clickDiscoverStores(driver);
	getScreenShotOnProgress(driver, methodName);
	
	SignInUIActions.enterYourLocationAndClickSearch(driver);
	getScreenShotOnProgress(driver, methodName);
	
	String actualStoreNameString=SignInPageObjects.getStoreNameFromSearchResultsObject(driver).getText();
	
	String expectedStoreNameString = "Pembroke Pines";
	
	Assert.assertEquals(actualStoreNameString, expectedStoreNameString);
	
	log.info("Store Name Verified In Search Results as:"+actualStoreNameString );
	}
	catch (Exception e){
		
		log.info("Exception Occurred During Test Case Execution");
				e.printStackTrace();
		Assert.assertTrue(false, "Test Case Marked Failed Due to Exception");
	}
}
}