package com.ibm.utils;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {

    private static WebDriver driver;
    private static DriverFactory instance=null;
    private static URL hubURL = null;
	/*protected String service = "C:\\jars\\IEDriverServer_Win32_2.53.0\\IEDriverServer.exe";
	protected System.setProperty("webdriver.ie.driver", service); */
    
private DriverFactory(){
	
    		/*String service = "C:\\jars\\IEDriverServer_Win32_2.53.0\\IEDriverServer.exe";
    		System.setProperty("webdriver.ie.driver", service);
    		driver = new InternetExplorerDriver();*/
    		
    		
    		
    		Boolean remoteSwitch = Boolean.parseBoolean(TestBase.getData("DriverFactory.RemoteSwitch"));
    		
    		if (!remoteSwitch){
    			String service = TestBase.getData("IE.Driver.Server.Location");
        		System.setProperty("webdriver.ie.driver", service);
        		driver = new InternetExplorerDriver();
    		}
    		else {
    			
    			try {
    				// get hub URL specified in the TestNG XML test suite file
    				// if not provided then use default http://localhost:4444/wd/hub
    				//hubURL = new URL("http://10.44.203.156:4445/wd/hub");
    				
    				//Removed Below Link to Use from Properties files
    				//hubURL = new URL("http://localhost:4445/wd/hub");
    				
    				hubURL = new URL(TestBase.getData("TestCases.Hub.URL"));
    				} catch (MalformedURLException e) {
    				System.out.println("ex:\n" + e.getMessage() + "");
    				e.printStackTrace();
    				}
    			
    				//String service = "C:\\jars\\IEDriverServer_Win32_2.53.0\\IEDriverServer.exe";
    			
    				String service = TestBase.getData("IE.Driver.Server.Location");
    				System.setProperty("webdriver.ie.driver", service);
    				DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
    				//capability.setBrowserName("internet explorer");
    				capability.setBrowserName(TestBase.getData("TestCases.BrowserName"));
    			
    				capability.setPlatform(Platform.WINDOWS);
    				driver = new RemoteWebDriver(hubURL, capability); 
    			
    				//WebDriver driver = RemoteDriverFactory.createInstance(hubURL, browserName);
    				//DriverManager.setWebDriver(driver); 
    			
    			}
    		
    		}
    

 public WebDriver openBrowser(){       
    	
        return driver;
        
        
        }
 
 
 public static DriverFactory getInstance(){
        		if(instance==null){
            	instance = new DriverFactory();
            
       	}
        return instance;
    }
    
    public static void makeInstancenull(){
                    driver.quit();
                    driver = null;
                    instance = null;
        
    }
    
    public static void makeInstancenullDriver(WebDriver driver ){
    	
    	System.out.println("Listner Log : makeInstancenullDriver   ");
        driver.close();
        driver = null;
        instance = null;

}
 
	
}