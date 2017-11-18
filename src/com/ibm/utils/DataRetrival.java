package com.ibm.utils;

import java.util.HashMap;
import java.util.List;



public class DataRetrival {
	
	@SuppressWarnings("unused")
	private  HashMap<String,HashMap<String,String>> dataMap=new HashMap<String,HashMap<String,String>>();

	
	/*(public List<SampleDto> getRecords()
	{
		return null;
		/* List<SampleDto> s=new ArrayList<SampleDto>();
		 
		 for(int i=0;i<4;i++)
		 {
			 SampleDto s1=new SampleDto();
			 s1.setKey("KT"+i);
			 s1.setValue("VT"+i);
			 s1.setParentKey("T1");
			 s.add(s1);
		 }
		 for(int i=0;i<4;i++)
		 {
			 SampleDto s1=new SampleDto();
			 s1.setKey("KT"+i);
			 s1.setValue("VT"+i);
			 s1.setParentKey("T2");
			 s.add(s1);
		 }
		 for(int i=1;i<3;i++)
		 {
			 SampleDto s1=new SampleDto();
			 s1.setKey("T"+i);
			 s1.setValue("DV");
			 s1.setParentKey("B");
			 s.add(s1);
		 }
		 for(int i=0;i<4;i++)
		 {
			 SampleDto s1=new SampleDto();
			 s1.setKey("KB"+i);
			 s1.setValue("VB"+i);
			 s1.setParentKey("B");
			 s.add(s1);
		 }
		 for(int i=0;i<1;i++)
		 {
			 SampleDto s1=new SampleDto();
			 s1.setKey("B");
			 s1.setValue("DV");
			 s1.setParentKey("TC");
			 s.add(s1);
		 }
		 for(int i=0;i<5;i++)
		 {
			 SampleDto s1=new SampleDto();
			 s1.setKey("TC"+i);
			 s1.setValue("DV"+i);
			 s1.setParentKey("TC");
			 s.add(s1);
		 }
		 for(int i=0;i<1;i++)
		 {
			 SampleDto s1=new SampleDto();
			 s1.setKey("TC");
			 s1.setValue("DV");
			 s1.setParentKey("SFG");
			 s.add(s1);
		 }
		return s;
		
	}  */
	
	
	///private HashMap<String,HashMap<String,String>> getdataFromDB(String testCaseId,String appId)
	//private void getdataFromDB(String testCaseId,String appId)
	private List<SampleDto> getdataFromDB(String testCaseId,String appId)
	{
		///DataRetrival dataRetrival=new DataRetrival();
		//List s2 = dataRetrival.getRecords();
		DBTests dbTests = new DBTests();
		List<SampleDto> s2=null;
		try {
			s2 = dbTests.getTestData(testCaseId, appId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//dataMap= dataRetrival.fullMap(s2);
		
		///HashMap<String,HashMap<String,String>> dataMap1 =dataRetrival.fullMap(s2);
		
		///return dataMap1;
		
		return s2;
		
		
	}
	
	/*public static void main(String args[])
	{
		DataRetrival dataRetrival=new DataRetrival();
		//List s2 = dataRetrival.getRecords();
		//DBTests dbTests = new DBTests();
		//List<SampleDto> s2=null;
		//try {
		//	s2 = dbTests.getTestData("TC-01", "ZEUS");
		//} catch (Exception e) {
			
		//	e.printStackTrace();
		//}
		//HashMap<String,HashMap<String,String>> ht=dataRetrival.fullMap(s2);  
		
		dataMap = dataRetrival.getdataFromDB("TC-01", "ZEUS");
		dataRetrival.verify(dataMap);
	} */
	
	private HashMap<String,HashMap<String,String>> fullMap(List<SampleDto> n)
	{
	//HashMap child=new HashMap();
	
	HashMap<String,HashMap<String,String>> child = new HashMap<String,HashMap<String,String>>();
	  for(SampleDto p:n){ 
		  if(child.containsKey(p.getParentKey()))
		  {
			  HashMap<String, String>  hs = (HashMap<String, String>) child.get(p.getParentKey());
			  hs.put(p.getFieldId(), p.getFieldValue());
			  //System.out.println(">>"+p.getFieldId()+"::" +p.getFieldValue());
		  }
		  else
		  {
			  //System.out.println(">>Inelse"+p.getParentKey());
			  HashMap <String, String> hs1=new HashMap<String, String>();
			  hs1.put(p.getFieldId(), p.getFieldValue());
			  child.put(p.getParentKey(), hs1);
		  }
	  }
	  return child;
	}
	
	@SuppressWarnings("unused")
	private void verify (HashMap<String,HashMap<String,String>> d)
	{
		System.out.println("!!"+d.get("TC-01").size());
		 System.out.println("!!"+d.get("TC-01").keySet());
		 
		 //System.out.println(d.get("TC-01").get("Customer Name"));
		 /*System.out.println("!!"+d.get("Batch1").keySet());
		 System.out.println("!!"+d.get("Trans1").keySet());
		 System.out.println("!!"+d.get("Trans2").keySet()); */
		 
		 System.out.println("!!"+d.get("TC-01").size());
		 System.out.println("!!"+d.get("TC-01").get("loginId"));
		 /*System.out.println("!!"+d.get("Batch1").get("batchType"));
		 System.out.println("!!"+d.get("Trans1").get("transType"));
		 System.out.println("!!"+d.get("Trans2").get("transId"));
		 
	*/
		
	}
	
/* This is working
	public static String getTestCaseData(String testCasedId1, String fieldId)
	{
		DataRetrival dataRetrival=new DataRetrival();

		List<SampleDto> s= dataRetrival.getdataFromDB(testCasedId1 , "ZEUS");
		
		HashMap<String,HashMap<String,String>> dataMap =dataRetrival.fullMap(s);
		String value = dataMap.get(testCasedId1).get(fieldId);
		return value;
				
	}  */
	
	
	public static  HashMap<String, HashMap<String, String>> getTestCaseData(String testCasedId1, String appID)
	{
		DataRetrival dataRetrival=new DataRetrival();
		List<SampleDto> s= dataRetrival.getdataFromDB(testCasedId1 , appID);
		HashMap<String,HashMap<String,String>> dataMap =dataRetrival.fullMap(s);
		return dataMap;
				
	}
	
	
	
	/*
	public String getBatchTestData(String testCaseId,String batchIdentifier,String fieldId)
	{
		Set S=dataMap.get(testCaseId).keySet();
		Iterator i= S.iterator();
		String str=null;
		while (i.hasNext())
		{
			str=(String)i.next();			
			if(str.startsWith(batchIdentifier))
			{
				return dataMap.get(str).get(fieldId);				
			}
		}
		return null;
	}
	
	*/
	
	/*
	public String getTransTestData(String batchIdentifier,String transactiondentifier,String fieldId)
	{
		Set S=dataMap.get(batchIdentifier).keySet();
		Iterator i= S.iterator();
		String str=null;
		while (i.hasNext())
		{
			str=(String)i.next();
			if(str.startsWith(transactiondentifier))
			{
				 return dataMap.get(str).get(fieldId);
			}
		}
		return null;
	}
	
	*/

}
