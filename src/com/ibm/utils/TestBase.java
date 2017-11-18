package com.ibm.utils;

import org.openqa.selenium.JavascriptExecutor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.apache.log4j.Logger;

/**
 * 
 * @author Ritesh Mansukhani
 *
 *
 * TestBase Class Acts As Test Base for Framework. It contains all the common methods() which will be utilized by all the Test Cases throughout Execution
 * E.g. Tasks like WebDriver Initialisation, Taking ScreenShots, Read-Write from property/flat files.
 * Define all you commonly used method() in TestBase Class and extend all your TestCase Java Classes to TestBase to use the utility methods from TestBase Class
 *
 */

public class TestBase{
	

	
	public WebDriver driver;
	//public EventFiringWebDriver driver;
	public URL hubURL = null;
	public static WebDriver ListenerWebDriver = null;
	private static String TestCaseID = null;
	static Properties properties;
	public ITestResult Result;
	public static int explicitWaitTimer = Integer.parseInt(getData("explicitWaitTimer"));
	public static final Logger log = Logger.getLogger(TestBase.class.getName());
	
	
	
	 public  WebDriver getDriver() {
			return driver;
		}
	
	public static String getTestCaseID (){
		return TestCaseID;
	 }
	 
	 public static void setTestCaseID (String TestCaseID1){
		 TestCaseID = TestCaseID1;
	 }
	 
	
	
	
	public WebDriver init(){
		
		//Initiaze Date for Log file naming 
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
        System.setProperty("current.date.time", dateFormat.format(new Date()));
      
		
		//Register Log4j
		String log4jConfPath = "log4j.properties";
	  	PropertyConfigurator.configure(log4jConfPath);
	  
		//Initialise Result for Test Case, This will Hold current Pass/Fail Value of @Test
	  	Result = Reporter.getCurrentTestResult();
	  	//Initialise Driver
	  	openBrowser();
		
		return driver;
	}
	
	
	
	public WebDriver openBrowser(){

		Boolean remoteSwitch = Boolean.parseBoolean(TestBase.getData("DriverFactory.RemoteSwitch"));
		String browserName = TestBase.getData("TestCases.BrowserName");
		
		log.info("Browser Name Retrieved as :"+browserName);
		
		//Switch Block to Open Session as per Browser Name in Config.properties --Ritesh Mansukhani
		switch (browserName) {
		
			case "internet explorer":
		
		
		
				if (!remoteSwitch){
			
							//Modified the code to take WebDriver Exe from Project Workspace location to Remove Dependencies --Ritesh Mansukhani
							
					
					try{
					DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
					capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
					true); 
					
						String service = System.getProperty("user.dir")+TestBase.getData("IE.Driver.Server.Location");
							System.setProperty("webdriver.ie.driver", service);
							//driver = new InternetExplorerDriver();
							 driver = new InternetExplorerDriver(capabilities);
							//ListenerWebDriver will hold current WebDriver's Reference for Listener Class Till End of Test Execution
							//ListenerWebDriver = driver;
							log.info("Value of WebDriver in TestBase "+driver);
							//log.info("Value of ListnerWebDriver in TestBase "+ListenerWebDriver);
							log.info("Test is Running in Local Machine");
							return driver;
					}catch(Exception e){
						log.error("Exception Occurred in Opening Broswer"+e);
						return null;
					}
							
				}
				else {
			
					try {

						hubURL = new URL(TestBase.getData("TestCases.Hub.URL"));
					
					//Modified the code to take WebDriver Exe from Project Workspace location to Remove Dependencies --Ritesh Mansukhani
					String service = System.getProperty("user.dir")+TestBase.getData("IE.Driver.Server.Location");
				
					System.setProperty("webdriver.ie.driver", service);
					DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
					//capability.setBrowserName("internet explorer");
					capability.setBrowserName(browserName);
			
					capability.setPlatform(Platform.WINDOWS);
					driver = new RemoteWebDriver(hubURL, capability);
					log.info("Test is Running in Remote Machines");
				
					log.info("Value of WebDriver in TestBase "+driver);
					return driver;
					}catch (MalformedURLException e) {
						
						log.error("Exception Occured in Accessing Hub URL"+e);
						return null;
					}catch(Exception e){
						log.error("Exception Occurred in Opening Broswer"+e);
						return null;
					}
		
				}
				//break;
				
		
		case "firefox":	
				
				if (!remoteSwitch){
					try{
					//Modified the code to take WebDriver Exe from Project Workspace location to Remove Dependencies --Ritesh Mansukhani
					String service = System.getProperty("user.dir")+TestBase.getData("Firefox.Driver.Server.Location");
					System.setProperty("webdriver.firefox.marionette", service);
					driver = new FirefoxDriver();
					//ListenerWebDriver will hold current WebDriver's Reference for Listener Class Till End of Test Execution
					//ListenerWebDriver = driver;
					return driver;
					}catch(Exception e){
						log.error("Exception Occurred in Opening Broswer"+e.getMessage());
						return null;
					}
				}
				else {
	
					try {

						hubURL = new URL(TestBase.getData("TestCases.Hub.URL"));
					//Modified the code to take WebDriver Exe from Project Workspace location to Remove Dependencies --Ritesh Mansukhani
					String service = System.getProperty("user.dir")+TestBase.getData("Firefox.Driver.Server.Location");
					System.setProperty("webdriver.firefox.marionette", service);
					
					DesiredCapabilities capability = DesiredCapabilities.firefox();
					//capability.setBrowserName("firefox");
					capability.setBrowserName(browserName);
	
					capability.setPlatform(Platform.WINDOWS);
					driver = new RemoteWebDriver(hubURL, capability); 
					//ListenerWebDriver = driver;
					log.info("Value of WebDriver in TestBase "+driver);
					
					//log.info("Value of ListnerWebDriver in TestBase "+ListenerWebDriver);
					return driver;
				}catch (MalformedURLException e) {
					
					log.error("Exception Occured in Accessing Hub URL"+e.getMessage());
					return null;
				}catch(Exception e){
					log.error("Exception Occurred in Opening Broswer"+e.getMessage());
					return null;
				}
					
	
				} //Else Ends Here
				
	 
		case "chrome":	
			
			if (!remoteSwitch){
				try{
				String service = System.getProperty("user.dir")+TestBase.getData("Chrome.Driver.Server.Location");
				System.setProperty("webdriver.chrome.driver", service);
				
				driver = new ChromeDriver();
				log.info("Value of WebDriver in TestBase "+driver);
				return driver;
				
				}catch(Exception e){
					log.error("Exception Occurred in Opening Broswer"+e.getMessage());
					return null;
				}
				
			}
			else {

				try {

					hubURL = new URL(TestBase.getData("TestCases.Hub.URL"));
	
				//Modified the code to take WebDriver Exe from Project Workspace location to Remove Dependencies --Ritesh Mansukhani
				String service = System.getProperty("user.dir")+TestBase.getData("Chrome.Driver.Server.Location");
				System.setProperty("webdriver.chrome.driver", service);
				
				DesiredCapabilities capability = DesiredCapabilities.chrome();
				//capability.setBrowserName("chrome");
				capability.setBrowserName(browserName);

				capability.setPlatform(Platform.WINDOWS);
				driver = new RemoteWebDriver(hubURL, capability); 
				//ListenerWebDriver = driver;
				log.info("Value of WebDriver in TestBase "+driver);
				
				//log.info("Value of ListnerWebDriver in TestBase "+ListenerWebDriver);
				
				return driver;
			}catch (MalformedURLException e) {
				
				log.error("Exception Occured in Accessing Hub URL"+e.getMessage());
				return null;
			}catch(Exception e){
				log.error("Exception Occurred in Opening Broswer"+e.getMessage());
				return null;
			}

			} //Else Ends Here
			//break;
				
		default:
			log.info("Invalid Browser Name : Please check Config.properties");
			return null;
			
			
		} //Case Ends Here
		
	}//Open Browser() ends here
	
	
	private static void loadData() throws IOException {
		properties = new Properties ();
		File file = new File(System.getProperty("user.dir")+"\\src\\resources\\config.properties");
		
		
			FileReader reader = new FileReader(file);
			properties.load(reader);
			
			File file1 = new File(System.getProperty("user.dir")+"\\src\\resources\\anotherfile.properties");
			reader.close();
			
			FileReader reader1 = new FileReader(file1);
			properties.load(reader1);
			reader1.close();
			//System.out.println("Configurations are Loaded for Usage");
			
			//code added by karam for Data Retrieval from Properties file
			File file2 = new File(System.getProperty("user.dir")+"\\src\\resources\\testData.properties");
			FileReader reader2 = new FileReader(file2);
			properties.load(reader2);
			reader2.close();
			
		
	}
	
	private static void saveData() throws IOException {
		
		File file = new File(System.getProperty("user.dir")+"\\src\\resources\\test.properties");
		//file.getParentFile().mkdirs();
		//file.createNewFile(); //If file already present it does nothing
		
			FileOutputStream writer = new FileOutputStream(file,true);
			properties.store(writer,"Ritesh Mansukhani");
			System.out.println("Property is Saved");
			
			writer.close();
			
	
		
	}
	
	public static String getData (String key){
		try {
			loadData();
			String value = properties.getProperty(key);
			

			
			/*Set <String> names = properties.stringPropertyNames();
			for(String name : names)
				System.out.println("Property Names "+name);*/
			return value;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Could Not Get Property Please check getData() in Utils");
			return null;
		}
		
		
		
	}
	
	public static void setData (String key, String value) throws IOException{
		
		properties = new Properties ();
		properties.setProperty(key, value);
		saveData();
	}
	
	
	/*public static WebElement explicitWaitHelper(WebDriver driver, By locator, int seconds){
		
		System.out.println("Retrying To Find Element with location" +locator);
	
		/*try {
		Thread.sleep(seconds);
		} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		return driver.findElement(locator); // end star comment till this
		
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return element;
	
	} **/
	
public static WebElement explicitWaitHelper(WebDriver driver, By locator, int seconds){
		
		log.info("Retrying To Find Element with location " +locator);
	
		WebElement element = null;
		for (int i=1; i<=seconds; i++){
			try {
				element = driver.findElement(locator);
				break;
			}
			catch (Exception e){
				log.info("Waiting for Element to Appear on Page..Retry#"+i);
				try {
					Thread.sleep(1000);
					} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					log.error("InterruptedException Occurred"+e1.getMessage());
					}
			}
		
		}
		
		if (element==null){
			log.error("Could Not Find Element with Location "+locator);
			log.error("Terminating Current Test Case Execution . .");
			log.error("Broswer Session Closed");
			
		}
		return element;
	
	}
	
 /*public static WebElement frameExplicitWaitHelper(WebDriver driver, By locator, int seconds){
		
		System.out.println("Retrying To Find Element with location" +locator);
	
		/*try {
		Thread.sleep(seconds);
		} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		return driver.findElement(locator);
		
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		WebElement element = wait.until(ExpectedConditions.(locator));
		return element;
	
	}*/
	
	@AfterSuite
		public void rollOffSuiteCompletion(){
		//DriverFactory.makeInstancenull();
		System.out.println("Execution of Suite Completed");
		}
	
	
	
	public void getScreenShotOnProgress(WebDriver driver, String methodName){
		
		if (Boolean.parseBoolean(getData("TestBase.TakeScreenShotSwitch"))){
		
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		
			//String methodName = result.getName();
		
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "\\src\\screenshots\\";
				File destFile = new File((String) reportDirectory + "/success_screenshots/" + methodName + "_" + formater.format(calendar.getTime()) + ".png");
			
				FileUtils.copyFile(scrFile, destFile);
			
				Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
			
			} catch (IOException e) {
				e.printStackTrace();
				}
		}	
	}	
	
	
	public void getScreenShotOnFailure(WebDriver driver, String methodName){
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		
		//String methodName = result.getName();

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "\\src\\screenshots\\";
			File destFile = new File((String) reportDirectory + "/failure_screenshots/" + methodName + "_" + formater.format(calendar.getTime()) + ".png");
			
			FileUtils.copyFile(scrFile, destFile);
			Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
			log.error("Failure Occured in Method @:"+methodName);
			
			
		} catch (IOException e) {
			
			log.info("Exception Occured While Capturing Failure Screen Shot in getScreenShotOnFailure() -> TestBase Class"+e.getMessage());
		}
	}
	
	public static WebElement explicitFindElement(By locator, WebDriver driver){
		try{
			
		return driver.findElement(locator);
		}
		catch(NoSuchElementException e){
			
			log.error("Exception Occurred ReSearching Element :"+locator.toString());
			return explicitWaitHelper(driver, locator, explicitWaitTimer );
		}
		
	}
	
	
	
	public void highlightMe(WebDriver driver, WebElement element) throws InterruptedException {
		// Creating JavaScriptExecuter Interface
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Execute javascript
		js.executeScript("arguments[0].style.border='4px solid yellow'", element);
		Thread.sleep(3000);
		js.executeScript("arguments[0].style.border=''", element);
	}
	
}
