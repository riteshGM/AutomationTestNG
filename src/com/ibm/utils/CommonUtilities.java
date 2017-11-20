package library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidOperationException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class CommonUtilities {
	
	private static Logger log = Logger.getLogger("CommonUtilities.class");
	
	private static Properties objectMapProps;
	private static XSSFSheet sheet;
	private static WebDriver driver;
	private static String baseURL;
	private static String screenshotsFolder;
	
	
	public static void sleepTime(int timeInMilis) {
		try {
			Thread.sleep(timeInMilis);
			log.info("Waiting for time period : "+timeInMilis+" MiliSeconds");
		}catch(InterruptedException ie) {
			log.info("Interrupted during sleep : "+ie.getMessage());
		}
	}
	
	public static void launchBrowser(String browser,String driverPath) {
		log.info("Initiating browser for the test");
		String driverSrc = System.getProperty("user.dir")+driverPath;
		if(browser.toLowerCase().endsWith("firefox")) {
			System.setProperty("webdriver.gecko.driver", driverSrc);
			driver = new FirefoxDriver();
			log.info("Test is started with the browser "+browser);
		}
		if(browser.toLowerCase().endsWith("explorer")) {
			System.setProperty("webdriver.ie.driver", driverSrc);
			driver = new InternetExplorerDriver();		
			log.info("Test is started with the browser "+browser);
		}
		if(browser.toLowerCase().endsWith("chrome")){
			System.setProperty("webdriver.chrome.driver", driverSrc);
			driver = new ChromeDriver();			
			log.info("Test is started with the browser "+browser);
		}
		driver.manage().window().maximize();
	}

	public static WebDriver getDriver() {
		return driver;
	}
	public static void launchURL(String url) {
		baseURL=url;
		driver.get(url);
		log.info("Successfully navigated to the URL "+url);
	}
	
	public static void gotToBaseURL() {
		if(!(driver.getCurrentUrl()).equals(baseURL)) 
			driver.get(baseURL);
	}
	
	public static void closeBrowser() {
		log.info("Closing the browser.");
		driver.close();
	}
	public static void quiteBrowser() {
		log.info("Browser quite started for the test.");
		driver.close();
	}

	public static void setTimeOut(int pageLoadTimeInSec, int implicitTimeInSec) {
		driver.manage().timeouts().pageLoadTimeout(pageLoadTimeInSec, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(implicitTimeInSec, TimeUnit.SECONDS);
	}
	
	public static void switchToDefaultContent() {
		try {
			driver.switchTo().defaultContent();
			log.info("Switched to default content successfully");
		}catch(Exception e) {
			log.info("Unable to navigate to default content"+e.getMessage());
		}
	}

	public static void switchToFrame(String id) {
		try {
		driver.switchTo().frame(getObjectValue(id));
		log.info("Navigated to frame with id " + id);
		}
		catch(NoSuchFrameException ne) {
			log.info("Unable to locate the frame with frame id :"+id+"And error is "+ne.getMessage());
		}
		catch(Exception e) {
			log.info("Unable to switch to the frame with frame id :"+id+"Error is "+e.getMessage());
		}
	}

	public static void switchToParentFrame() {
		log.info("Switching to parent frame started");
		driver.switchTo().parentFrame();
		log.info("Switching to parent frame done");
	}

	public static final void setObjectMapFile(String configFilePath) {
		log.info("Object map data file loading started");
		objectMapProps = new Properties();
		InputStream fis;
		try {
			fis = new FileInputStream(configFilePath);
			objectMapProps.load(fis);
			log.info("ObjectMap file loaded successfully.");
		}
		catch(FileNotFoundException fnf) {
			log.info("Object map file not found at the directory"+configFilePath+". Eerror message :"+fnf.getMessage());
		}
		catch(SecurityException se) {
			log.info("Unable to access the file due to security."+se.getMessage());
		}
		catch(IOException ie) {
			log.info(ie.getMessage());
		}
		catch(Exception e) {
			log.info("Problem occured during file read."+e.getMessage());
		}
		
	}

	public static String getObjectValue(String objectName) {
		log.info("Page element fetched from the objectmap file: "+objectName);
		return objectMapProps.getProperty(objectName);
	}
	
	public static void setTestDataFile(String testDataFilePath) {
		log.info("Loding test data started from path : "+testDataFilePath);
		try {
			XSSFWorkbook workBook = new XSSFWorkbook(testDataFilePath);
			sheet = workBook.getSheetAt(0);
			log.info("TestData sheet is loaded successfully.");
			workBook.close();
		}catch(FileNotFoundException fnf) {
			log.info("Test Data File not found at path: "+testDataFilePath);
			log.info(fnf.getMessage());
		}
		catch(IOException ie) {
			log.info("Problem occured during testDataFile loading");
			log.info(ie.getMessage());
		}
		catch(InvalidOperationException ioe) {
			log.info("Invalid operation over the testData file");
			log.info(ioe.getMessage());
		}
		catch(Exception e) {
			log.info("Problem occured during testDataFile reading");
			log.info(e.getMessage());
		}
	}
	
	public static ArrayList<String> getTestData(String testCaseName){
		log.info("Fetching test Data for the test Case : "+testCaseName);
		ArrayList<String> testData = new ArrayList<String>();
		
		Iterator<Row> itr = sheet.rowIterator();
		while(itr.hasNext()) {
			Row row = itr.next();
			Iterator<Cell> cite = row.cellIterator();
			while(cite.hasNext()) {
				Cell cell = cite.next();
				testData.add(cell.toString());
			}
			if(testData.get(0).equalsIgnoreCase(testCaseName)) {
				log.info("Test data fethched for the test case :"+testCaseName);
				testData.remove(0);
				log.info("Fetched test data: "+testData);
				return testData;
			}
			testData = null;
			testData = new ArrayList<String>();
		}
		return testData;
	}


	@SuppressWarnings("deprecation")
	public static String getTestDataValue(String testCaseName, String columnName) {
		log.info("Fetching testData for"+testCaseName+" and fieldName "+columnName);
		XSSFRow row;
		XSSFCell cell;
		int targetRow=0;
		int targetColumn=0;
		
		row = sheet.getRow(0);
		for(int i=0; i<row.getLastCellNum();i++) {
			if(row.getCell(i).getStringCellValue().trim().equalsIgnoreCase(columnName))
				targetColumn=i;
		}
		for(int i=0; i<sheet.getLastRowNum()+1;i++) {
			if(sheet.getRow(i).getCell(0).getStringCellValue().trim().equalsIgnoreCase(testCaseName))
				targetRow=i;
		}
		
		cell = sheet.getRow(targetRow).getCell(targetColumn);
		String cellValue = null;
		if(cell.getCellType()==XSSFCell.CELL_TYPE_STRING)
			cellValue = cell.getStringCellValue();
		if(cell.getCellType()==XSSFCell.CELL_TYPE_NUMERIC)
			cellValue = NumberToTextConverter.toText(cell.getNumericCellValue());
		if(cell.getCellType()==XSSFCell.CELL_TYPE_BOOLEAN)
			cellValue = String.valueOf(cell.getBooleanCellValue());
		if(cell.getCellType()==XSSFCell.CELL_TYPE_BLANK)
			return null;
		if(cell.getCellType()==XSSFCell.CELL_TYPE_ERROR)
			return null;
		if(cell.getCellType()==XSSFCell.CELL_TYPE_FORMULA)
			return null;
		
		log.info("TestData fetched for"+testCaseName+" and fieldName "+columnName+" and found data is "+cellValue);
		
		return cellValue;
	}
	
	public static void setScreenShotFolder(String screenShotFolder) {
		screenshotsFolder = screenShotFolder;
	}
	
	public static void captureScreenShot(String screenShotName) {
		String fileName = screenshotsFolder+"/"+screenshotsFolder+System.currentTimeMillis()+".png";
		try {
			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile, new File(fileName));
			log.info("Screenshot saved with name: "+screenShotName);
		}
		catch(IOException ie) {
			log.info(ie.getMessage());
		}
		catch(NullPointerException npe) {
			log.info(npe.getMessage());
		}
		catch(WebDriverException wde) {
			log.info(wde.getMessage());
		}
	}

	public static void click(String locatorName) {
		getPageElement(locatorName).click();
		log.info("Successfully clicked on the element "+locatorName);
	}
	
	public static void sendKeys(String locator, String value) {
		WebElement element = getPageElement(locator);
		element.clear();
		element.sendKeys(value);
		log.info("Sendkeys has successfully done for value: "+value);
	}
	
	public static void selectByText(String locator, String value) {
		Select select = new Select(getPageElement(locator));
		select.selectByVisibleText(value);
		log.info("Succefully selected the element "+value+" from dropdown.");
	}

	public static void selectValue(String locator, String value){
		Select select = new Select(getPageElement(locator));
		select.selectByValue(value);
		log.info("Succefully selected the element "+value+" from dropdown.");
	}
	
	public static void selectByIndexValue(String locator, int index) {
		Select select = new Select(getPageElement(locator));
		select.selectByIndex(index);
		log.info("Succefully selected the element at index "+index+" from dropdown.");
	}

	public static String getSelectedValue(String locator) {
		WebElement element = getPageElement(locator);
		Select select = new Select(element);
		WebElement selectedElement = select.getFirstSelectedOption();
		log.info("Selected value from dropdown is : "+selectedElement.getText());
		return selectedElement.getText();
	}
	
	public static List<WebElement> getSelectedValues(String locator) {
		WebElement element = getPageElement(locator);
		Select select = new Select(element);
		List<WebElement> selectedElements = select.getAllSelectedOptions();
		log.info("Selected values are : "+selectedElements);
		return selectedElements;
	}
	
	public static String getPageText(String locator) {
		log.info("Fetching the text of element "+locator);
		return getPageElement(locator).getText();
	}
	
	public static void checkPageTitle(String expectedTitle) {
		log.info("Fetching page title started");
		String actualTitle = driver.getTitle();
		try {
		Assert.assertEquals(actualTitle, expectedTitle);
		log.info("Page title verification passed. Actual title: "+actualTitle+" and expected title: "+expectedTitle);
		}catch(Exception e) {
			log.info("Page title verification failed. Actual Page title : "+actualTitle+" and expected page title."+expectedTitle);
		}
	}
	
	public static String getPageURL() {
		log.info("Fetching current page URL");
		return driver.getCurrentUrl();
	}
	
	private static final void softAssert(String actual, String expected) {
	
		SoftAssert assertion = new SoftAssert();
		log.info("Assertion started for the test");
		assertion.assertEquals(actual, expected);
		log.info("Assertion completed for the test");
		assertion.assertAll();
	}
	
	public static void isElementDisplayed(String locator,String expectedVisibility){
		String actualVisibility=null;
			log.info("Checking for the element, if displayed in page.");
			actualVisibility = String.valueOf(getPageElement(locator).isDisplayed());
			log.info("Actual visibility status found in the page : "+actualVisibility);
			Assert.assertEquals(actualVisibility.toLowerCase(), expectedVisibility.toLowerCase());
			softAssert(actualVisibility.toLowerCase(), expectedVisibility.toLowerCase());
			log.info("Vesibility verification of the element is PASSED. Actual found :"+actualVisibility+" And expected: "+expectedVisibility);
		}
	
	public static void isElementEnabled(String locator, String expectedEnableStatus) {
		String actualEnableStatus=null;
		log.info("Checking started for the element in WebPage.");
		actualEnableStatus = String.valueOf(getPageElement(locator).isEnabled());
		log.info("Actual enabled status found in the page is "+actualEnableStatus);
		if(actualEnableStatus.equalsIgnoreCase(expectedEnableStatus))
			log.info("Enable verification for the element is PASSED. Actual status found: "+actualEnableStatus+"Expected enabling status found is "+expectedEnableStatus);
		else {
			log.info("Enable verification for the element is FAILED. Actual status found: "+actualEnableStatus+"Expected enabling status found is "+expectedEnableStatus);
		}
	}
	
	public static void isElementSelected(String locator, String expected) {
		String actualStatus=null;
		try{
			log.info("Checking for Selected status of the page element"+locator);
			actualStatus = String.valueOf(getPageElement(locator).isSelected());
			log.info("Actual selection status found in page is: "+actualStatus);
			Assert.assertEquals(actualStatus, expected);
			log.info("Seleted status verification is PASSED. Actual status found: "+actualStatus+"Expected selected status: "+expected);
		}
		finally{
			log.info("Seleted status verification is FAILED. Actual status found: "+actualStatus+"Expected selected status: "+expected);
		}
	}
	
	
	public static WebElement getPageElement(String locator) {
		log.info("Fetching the element with object "+locator);
			if(locator.toLowerCase().endsWith("_id")) {
				return driver.findElement(By.id(getObjectValue(locator)));
			}
			if(locator.toLowerCase().endsWith("_name"))
				return driver.findElement(By.name(getObjectValue(locator)));

			if(locator.toLowerCase().endsWith("_class"))
				return driver.findElement(By.className(getObjectValue(locator)));

			if(locator.toLowerCase().endsWith("_css"))
				return driver.findElement(By.cssSelector(getObjectValue(locator)));

			if(locator.toLowerCase().endsWith("_link"))
				return driver.findElement(By.linkText(getObjectValue(locator)));

			if(locator.toLowerCase().endsWith("_partiallink"))
				return driver.findElement(By.partialLinkText(getObjectValue(locator)));

			if(locator.toLowerCase().endsWith("_xpath"))
				return driver.findElement(By.xpath(getObjectValue(locator)));
			
			if(locator.toLowerCase().endsWith("_tag"))
				return driver.findElement(By.tagName(getObjectValue(locator)));
			
			throw new RuntimeException("Invalid locator: " + locator);
		
	}

	public static List<WebElement> getPageElements(String locator) {
		
			if(locator.toLowerCase().endsWith("_id")) {
				return driver.findElements(By.id(getObjectValue(locator)));
			}
			if(locator.toLowerCase().endsWith("_name"))
				return driver.findElements(By.name(getObjectValue(locator)));

			if(locator.toLowerCase().endsWith("_class"))
				return driver.findElements(By.className(getObjectValue(locator)));

			if(locator.toLowerCase().endsWith("_css"))
				return driver.findElements(By.cssSelector(getObjectValue(locator)));

			if(locator.toLowerCase().endsWith("_link"))
				return driver.findElements(By.linkText(getObjectValue(locator)));

			if(locator.toLowerCase().endsWith("_partiallink"))
				return driver.findElements(By.partialLinkText(getObjectValue(locator)));

			if(locator.toLowerCase().endsWith("_xpath"))
				return driver.findElements(By.xpath(getObjectValue(locator)));
			
			if(locator.toLowerCase().endsWith("_tag"))
				return driver.findElements(By.tagName(getObjectValue(locator)));
			
			throw new RuntimeException("Invalid locator: " + locator);
	}
	
	public static void assertion(String locator, String expectedText) {
		log.info("Assertion started for the locator "+locator);
		try {
		String actualText=getPageText(locator);
		log.info("Actual text found in the webPage is: "+actualText);
		Assert.assertEquals(actualText, expectedText);
		log.info("Assertion passed and completed. Actual text: "+actualText+" and expected text: "+expectedText);
		}catch(Exception e) {
			log.info("Exception occured during assertion."+e.getMessage());
		}
	}
	
	public static String getAlertMessage() {
		log.info("Fetching the text from alert in page is started");
		String alertMsg =null;
		try {
			alertMsg= driver.switchTo().alert().getText();
		}
		catch(NoAlertPresentException npe) {
			log.info("No alert find in this step..."+npe.getMessage());
		}
		return alertMsg;
	}
	
	public static void alertAccept() {
		try {
			log.info("Switch to alert to accept");
			driver.switchTo().alert().accept();
		}catch(NoAlertPresentException nap) {
			log.info("No such alert present this time"+nap.getMessage());
		}
	}
	
	public static void alertDismiss() {
		try {
			log.info("Switch to alert to accept");
			driver.switchTo().alert().dismiss();
		}
		catch(NoAlertPresentException nap) {
			log.info("No such alert present this time"+nap.getMessage());
		}
	}
}