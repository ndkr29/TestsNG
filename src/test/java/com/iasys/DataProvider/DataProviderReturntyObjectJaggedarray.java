package com.iasys.DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderReturntyObjectJaggedarray {
@Test(dataProvider = "dp1")
	public void TestGoogle(Object[] s) throws Exception {
	
	
	
	for(int i=0; i<s.length; i++) {
		
		
		System.out.println(s[i]);
		
	}
	
	 System.out.println(">>>>>>");
		
	}

  @DataProvider()
  public  Object[][] dp1() {
	  Object[][] data = new Object[][] {
		  {"hyr",123,852,"abcd"},
		  {"pqr",456},
		  {"xyz",789,123654}
		
	 };
	 
	 return data;
	  
  }
	


}
