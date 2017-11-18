package com.ibm.utils;

import java.util.HashMap;
import java.util.Set;

public class ZeusDataFeeder {
	
	
	public static ZeusDataObject getZeusData(String testCasedID)
	{
		 //ZeusDataRetrival dataRetrival=new ZeusDataRetrival();
		 HashMap <String,HashMap<String,String>> dataMap = DataRetrival.getTestCaseData(testCasedID,"ZEUS");
		 
		 // call getdataFromDB which is private to get Map.
		     //dataRetrival.getdataFromDB(testCaseId,"ZEUS");
		
		 //System.out.println(dataMap.keySet());
		 
		 //System.out.println(dataMap.get(testCasedID).size());
		 //System.out.println(dataMap.get(testCasedID).keySet());
		 
		 
		 
		 Set <String> keys = dataMap.get(testCasedID).keySet();
		 ZeusDataObject dataObject = new ZeusDataObject();
		 for (String key : keys)
			 
		 {
			 
			 //System.out.println(key);
			 	if (key.contentEquals("CustSysID")){
			 		
			 		dataObject.setCustSysID(dataMap.get(testCasedID).get(key));
			 	}
			 	
			 	if (key.contentEquals("ROLoginID")){
			 		
			 		dataObject.setROLoginID(dataMap.get(testCasedID).get(key));
			 	}
			 	
			 	if (key.contentEquals("CAPurpose")){
			 
			 		dataObject.setCAPurpose(dataMap.get(testCasedID).get(key));
			 	}
			 	
			 	if (key.contentEquals("ExpectedCAStatus")){
					 
			 		dataObject.setExpectedCAStatus(dataMap.get(testCasedID).get(key));
			 	}if (key.contentEquals("PostSanctionApplicationOutcome")){
			 
			 		dataObject.setPostSanctionApplicationOutcome(dataMap.get(testCasedID).get(key));
			 	}if (key.contentEquals("FurtherPostSanctionComments")){
			 
			 		dataObject.setFurtherPostSanctionComments(dataMap.get(testCasedID).get(key));
			 	}if (key.contentEquals("CASanctionDecision")){
			 
			 		dataObject.setCASanctionDecision(dataMap.get(testCasedID).get(key));
			 	}if (key.contentEquals("CASanctionerComments")){
			 
			 		dataObject.setCASanctionerComments(dataMap.get(testCasedID).get(key));
			 	}if (key.contentEquals("SecurityAssetType")){
			 
			 		dataObject.setSecurityAssetType(dataMap.get(testCasedID).get(key));
			 	}if (key.contentEquals("SecurityValuationAmount")){
			 
			 		dataObject.setSecurityValuationAmount(dataMap.get(testCasedID).get(key));
			 	}if (key.contentEquals("SecurityAmount")){
			 
			 		dataObject.setSecurityAmount(dataMap.get(testCasedID).get(key));
			 	}if (key.contentEquals("SecurityTrustee")){
			 
			 		dataObject.setSecurityTrustee(dataMap.get(testCasedID).get(key));
			 	}if (key.contentEquals("SecurityGoverningLaw")){
			 
			 		dataObject.setSecurityGoverningLaw(dataMap.get(testCasedID).get(key));
			 	}if (key.contentEquals("ExpectedSavedSecurity")){
			 
			 		dataObject.setExpectedSavedSecurity(dataMap.get(testCasedID).get(key));
			 	}
			 	
			 	
			 	
			 	
			 	
			 	
			 	
			 	
			 	//Below code is to set the keys manually
		         //dataObject.setCustSysID(dataMap.get(testCasedID).get("CustSysID"));
		         //dataObject.setROLoginID(dataMap.get(testCasedID).get("ROLoginID"));
		         //dataObject.setCAPurpose(dataMap.get(testCasedID).get("CAPurpose"));
		         
		         
		         /*
		         custInfo.setCustomerSysId(dataMap.get(testCaseId).get("Customer System Id"));
		         custInfo.setCompanyRegNo(dataMap.get(testCaseId).get("Company Reg No"));
		         custInfo.setCustomerClass(dataMap.get(testCaseId).get("Customer Class"));
		         custInfo.setCustomerStatus(dataMap.get(testCaseId).get("Customer Status"));
		         custInfo.setRelationshipOwner(dataMap.get(testCaseId).get("Relationship Owner"));
		         custInfo.setActivity(dataMap.get(testCaseId).get("Activity"));
		         custInfo.setAlwaysRefer(dataMap.get(testCaseId).get("Always Refer?"));
		         custInfo.setBicCode(dataMap.get(testCaseId).get("BIC Code"));
		         custInfo.setBusinessEstalished(dataMap.get(testCaseId).get("Business Established"));
		         custInfo.setCustmClassification(dataMap.get(testCaseId).get("Customer Classification"));
		         custInfo.setCustomerSince(dataMap.get(testCaseId).get("Customer Since"));
		         custInfo.setCustomerStatus(dataMap.get(testCaseId).get("Customer Status"));
		         //custInfo.setCustSystemId(dataMap.get("TC-02"));
		         custInfo.setDateApplied(dataMap.get(testCaseId).get("Date Applied"));
		         custInfo.setDruFlag(dataMap.get(testCaseId).get("DRU Flag"));
		         custInfo.setEntity(dataMap.get(testCaseId).get("Entity"));
		         custInfo.setExposurePolicy(dataMap.get(testCaseId).get("Exposure Policy"));
		         custInfo.setGcisId(dataMap.get(testCaseId).get("GCIS Id"));
		         custInfo.setHigh(dataMap.get(testCaseId).get("High"));
		         custInfo.setLow(dataMap.get(testCaseId).get("Low"));
		         custInfo.setMarketCapital(dataMap.get(testCaseId).get("Market Capitalisation"));
		         custInfo.setNextRevDate(dataMap.get(testCaseId).get("Next Review Date"));
		         custInfo.setRegistNumber(dataMap.get(testCaseId).get("Registration Number"));
		         custInfo.setSpecAreaMarker(dataMap.get(testCaseId).get("Specialist Area Marker")); */
		 }      
		return dataObject;
		
	}

}
