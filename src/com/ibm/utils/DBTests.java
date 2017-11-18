package com.ibm.utils;
import  java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBTests {
	
	
	
	
	
	public String checkBatchidEntry(String mfileid, String mbatchid) throws Exception {
		Connection sconn = null;
		PreparedStatement spstmt = null;
		ResultSet rs = null;
		String ssqlStr = null;
		
		int cntr = 0;
		String result = "0";

		try {
			try{
				sconn= DBUtil.getconnection("ZeusAutomation");
				ssqlStr ="SELECT COUNT(*) FROM H2H_BATCH WHERE FILE_ID=?";

				spstmt = sconn.prepareStatement(ssqlStr);
				spstmt.setString(1, mfileid);
				
				rs = spstmt.executeQuery();

				if(rs!=null){
					if(rs.next()){
						cntr =  rs.getInt(1);
						result = Integer.toString(cntr);
					}
				}

			}finally{
				try {
					if (rs != null) {
						rs.close();
						rs = null;
					}
				} catch (SQLException se) {
				
					throw se;
				}
				try {
					if (spstmt != null) {
						spstmt.close();
						spstmt = null;
					}
				} catch (SQLException se) {
					
					throw se;
				}
			}
		} catch (SQLException se) {

			
			throw new Exception();
		} finally {
			if (rs == null && spstmt == null && sconn != null) {

				sconn.close();
			}
		}
		return result;
	}
	
	public List<SampleDto> getTestData(String tcId, String applicationId) throws Exception {
		Connection sconn = null;
		PreparedStatement spstmt = null;
		ResultSet rs = null;
		String ssqlStr = null;
		
		//int cntr = 0;
		//String result = "0";
List<SampleDto> ls=new ArrayList<SampleDto>();
SampleDto s=null;
		try {
			try{
				sconn= DBUtil.getconnection("ZeusAutomation");
				ssqlStr ="SELECT * FROM TEST_DATA_TABLE WHERE TC_ID=?";

				spstmt = sconn.prepareStatement(ssqlStr);
				spstmt.setString(1, tcId);
				
				rs = spstmt.executeQuery();

				if(rs!=null){
					while (rs.next()) {
					s=new SampleDto();
					s.setFieldId(rs.getString("FIELD_ID"));
					s.setFieldValue(rs.getString("FIELD_VALUE"));
					s.setParentKey(rs.getString("PARENT_ID"));
										ls.add(s);	
					}
				}

			}finally{
				try {
					if (rs != null) {
						rs.close();
						rs = null;
					}
				} catch (SQLException se) {
				
					throw se;
				}
				try {
					if (spstmt != null) {
						spstmt.close();
						spstmt = null;
					}
				} catch (SQLException se) {
					
					throw se;
				}
			}
		} catch (SQLException se) {

			se.printStackTrace();
			throw new Exception();
		} finally {
			if (rs == null && spstmt == null && sconn != null) {

				sconn.close();
			}
		}
		return ls;
	}
}
