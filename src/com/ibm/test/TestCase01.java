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
import com.ibm.pom.MyAccountPageObjects;
import com.ibm.utils.TestBase;

/**
 * 
 * @author Ritesh Mansukhani
 *
 */

//@Listeners(com.ibm.utils.Listener.class)
public class TestCase01 extends TestBase {
	
	public static final Logger log = Logger.getLogger(TestCase01.class.getName());

		WebElement element = null;
		public String methodName = null;
		WebDriver driver = null;
		
		@BeforeClass
		public void setUP(){
			log.info("=========== Execution Started for Test Case01 =============");
			log.info("=========== Execution Started for Test Case01 pehle =============");
			driver = init();
			log.info("=========== Execution Started for Test Case01007 =============");
		}
		
		@AfterClass
		public void rollOff(){

	        log.info("=========== Execution Finished for Test Case01 =============");
	        driver.quit();
	        driver = null;
		}
		
		 @BeforeMethod
		 public void beforeTestMethod(Method testMethod){
		   methodName=testMethod.getName(); 
		   log.info("=========== Test Method Name is Retrieved And Saved for Logs as "+methodName+"  =============");
		 }
		 

		@AfterMethod
		 public void afterTestMethod (ITestResult result){
			if(!result.isSuccess()){
				 		getScreenShotOnFailure(driver, methodName);
				 	}
		}		 
	
	
	@Test (priority =0)
	public void testCase01_VerifyUserIsAbleToCreateAnAccountHappyPath() {
		
		try{

			driver.get(TestBase.getData("TestCases.Environment.URL"));
			getScreenShotOnProgress(driver, methodName);
		
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(TestBase.getData("TestCases.ImplicitWait.Seconds")), TimeUnit.SECONDS);

			//driver.navigate().to("javascript:document.getElementById('overridelink').click()");
		
			CreateNewAccountUIActions.clickOnSignInLink(driver);
			getScreenShotOnProgress(driver, methodName);
			
			CreateNewAccountUIActions.enterEmailIDToRegisterAndSubmit(driver);
			getScreenShotOnProgress(driver, methodName);
			
			CreateNewAccountUIActions.enterNewAccountDetailsHappyPath(driver);
			getScreenShotOnProgress(driver, methodName);
			
			CreateNewAccountUIActions.clickOnRegisterAfterEnteringDetails(driver);
			
					
			//My Account Page Verify Welcome Message On Successful Account Creation
			
			String expectedWecomeMessage= "Welcome to your account. Here you can manage all of your personal information and orders.";
			String actualWelcomeMessage= MyAccountPageObjects.getWelcomeMessage(driver).getText();
			Assert.assertEquals(actualWelcomeMessage, expectedWecomeMessage);
			log.info("Welcome Message Verified Successfully as :"+actualWelcomeMessage+" @:MyAccountPageObjects.getWelcomeMessage(driver)");		
			log.info("User was Able to Create Account Successfully @:"+methodName);
			
			getScreenShotOnProgress(driver, methodName);
			
			//driver.findElement(By.cssSelector("a.logout")).click();		
			//log.info("User Clicked On SignOut");
			
		}catch(Exception e){
			log.info("Exception Has Occurred During Test Case Execution");
			e.printStackTrace();
			
			Assert.assertTrue(false, "Test Case Marked Failed Due to Exception");
		}
		
	}
	

}
