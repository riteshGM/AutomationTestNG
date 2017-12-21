package com.ibm.test;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class TablesRND {


	//public static final Logger log = Logger.getLogger(FindColmnRND.class.getName());

	WebElement element = null;
	public String methodName = null;
	WebDriver driver;



	@Test (priority =0)
	public void testColum() {

		try{
			String service = System.getProperty("user.dir")+"\\drivers\\IEDriverServer_32.exe";
			System.setProperty("webdriver.ie.driver", service);
			driver = new InternetExplorerDriver();
			driver.get("http://toolsqa.com/automation-practice-table/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15000, TimeUnit.SECONDS);
			By locator = By.xpath("//table[@class='tsc_table_s13']/tbody/tr/td[5]");
			//getColumn(driver,locator,"getText:String","All",1, "key");
			getColumn(driver,locator,"getText:Integer","Min",1, "key");
			getColumn(driver,locator,"getText:Integer","Min",2, "key");
			getColumn(driver,locator,"getText:Integer","Max",2, "key");
			getColumn(driver,locator,"getText:Double","Max",1, "key");
			//List<String> tableData = getColumn("By.xpath("//table[@class='dataTable']/tbody/tr/td[3]")",)
		}catch(Exception e){
			e.printStackTrace();
		}
	}//@Test Ends Here

	ArrayList getColumn(WebDriver driver, By eleLocator , String actionType, String returnFuncType, int returnCount, String dataKey){
		List<WebElement> element = driver.findElements(eleLocator);
		ArrayList columnDataListRaw = new ArrayList();
		ArrayList columnDataListFinal = new ArrayList();
		switch(actionType) {
		case "getText:Double" :
			for (WebElement ele: element){
				columnDataListRaw.add(Double.parseDouble(ele.getText()));
			}
			break; // optional
		case "getText:Integer" :
			for (WebElement ele: element){
				columnDataListRaw.add(Integer.parseInt(ele.getText()));
			}
			break; // optional
		default :
			System.out.println("Invalid ActionType: Please Check ActionType and Retry");
		}
		System.out.println("Before Sorting"+columnDataListRaw);
		if (returnFuncType.equalsIgnoreCase("min")){
			Collections.sort(columnDataListRaw);
			if(returnCount>0){
				for (int i = 0 ; i<returnCount ; i++){
					columnDataListFinal.add((columnDataListRaw.get(i)));
				}
				System.out.println(returnCount+" Minimum Column Value Retrived from Screen as"+columnDataListFinal);
			}else{
				System.out.println("Return Count Entered as "+returnCount+" please check function call again");
			}
		}else if(returnFuncType.equalsIgnoreCase("max")){
			Collections.sort(columnDataListRaw, Collections.reverseOrder());
			if(returnCount>0){
				for (int i = 0 ; i<returnCount ; i++){
					columnDataListFinal.add((columnDataListRaw.get(i)));
				}
				System.out.println(returnCount+" Max Column Value Retrived from Screen as"+columnDataListFinal);
			}else{
				System.out.println("Return Count Entered as "+returnCount+" please check function call again");
			}
		}else if (returnFuncType.equalsIgnoreCase("all")){
			Collections.sort(columnDataListRaw);
			columnDataListFinal=columnDataListRaw;
			System.out.println("All Column Values Sorted in Ascending Order are"+columnDataListFinal);
		}else{
			System.out.println("Invalid Actiontype Passed as "+actionType+" Please check function call again");
		}
		return columnDataListFinal;
	}


}//Class Ends Here


