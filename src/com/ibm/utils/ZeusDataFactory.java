package com.ibm.utils;

public class ZeusDataFactory {

    private static ZeusDataObject data = null;
    private static ZeusDataFactory instance=null;
    //private static String TestCaseID = null;
	/*protected String service = "C:\\jars\\IEDriverServer_Win32_2.53.0\\IEDriverServer.exe";
	protected System.setProperty("webdriver.ie.driver", service); */
    
private ZeusDataFactory(){
	
	 if (data==null){
		 data = ZeusDataFeeder.getZeusData(TestBase.getTestCaseID());
		 }	
}


 public ZeusDataObject getZeusData(){       

        return data;
        }
 
 /*
 
 private String getTestCaseID (){
	return TestCaseID;
 }
 
 private static void setTestCaseID (String TestCaseID1){
	 TestCaseID = TestCaseID1;
 }
 */
 public static ZeusDataFactory getInstance(){
        		if(instance==null){
        			
            	instance = new ZeusDataFactory();
             // setTestCaseID(TestCaseID2);
       	}
        return instance;
    }
    
    public static void makeInstancenull(){
                    instance = null;
        
    }
 
	
}
