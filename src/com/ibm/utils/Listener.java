package com.ibm.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;


/**
 * 
 * @author Ritesh Mansukhani
 *
 */
public class Listener extends TestBase implements ITestListener{

	
	
	
	
	//Take Instance of The Current WebDriver for Listener Class
	
	
	
	
	public void onFinish(ITestContext arg0) {
		Reporter.log("Test is finished:" + arg0.getName());
		
		
		//DriverFactory.makeInstancenullDriver(driver);
		
		//System.out.println("Test is finished:" + arg0.getName());
	}

	public void onStart(ITestContext arg0) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {

		if(!result.isSuccess()){
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
			
			String methodName = result.getName();
			log.info("Value of ListnerWebDriver in Listner "+ListenerWebDriver);
			File scrFile = ((TakesScreenshot) ListenerWebDriver).getScreenshotAs(OutputType.FILE);
			try {
				String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "\\src\\screenshots\\";
				File destFile = new File((String) reportDirectory + "/failure_screenshots/" + methodName + "_" + formater.format(calendar.getTime()) + ".png");
				
				FileUtils.copyFile(scrFile, destFile);
				
				Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
				log.error("Message From Listener onTestFailure for :"+methodName);
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		}
		
	}


	public void onTestSkipped(ITestResult arg0) {
		Reporter.log("Test is skipped:" + arg0.getMethod().getMethodName());
		
	}

	public void onTestStart(ITestResult arg0) {
		
		
		log.info("Message From Listner -- On Start of Execution");
	}

	public void onTestSuccess(ITestResult result) {

		if(result.isSuccess()){
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
			
			String methodName = result.getName();

			File scrFile = ((TakesScreenshot) ListenerWebDriver).getScreenshotAs(OutputType.FILE);
			try {
				String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "\\src\\screenshots\\";
				File destFile = new File((String) reportDirectory + "/success_screenshots/" + methodName + "_" + formater.format(calendar.getTime()) + ".png");
				
				FileUtils.copyFile(scrFile, destFile);
				
				Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
				System.out.println();
				log.info("Message from Listner onTestSuccess for :"+methodName);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		}

}
}