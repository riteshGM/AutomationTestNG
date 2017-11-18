package TestStub;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.ibm.utils.TestBase;

public class ExceptionTestStub extends TestBase {
	
	@Test
	public void testMethod(){
		
		
		try {
			openBrowser();
			driver.get("www.google.co.in");
			assertTrue(false);
			
			
		}catch (Exception e){
		
			System.out.println("Exception Occurred"+e.getMessage());
		}
		finally{
			System.out.println("Finally Block Executed");
			try{
			driver.close();
			System.out.println("Finally Block Executed after driver close()");
			}catch(Exception e2){
				System.out.println("Exception in Finally"+e2);
			}
			
		}
	}

}
