package com.iasys.DataProvider;

import java.util.Arrays;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderReturntypetjaggedarray {
@Test(dataProvider = "dp1")
	public void TestGoogle(String[] s) throws Exception {
	
	
	
	for(int i=0; i<s.length; i++) {
		
		
		System.out.println(s[i]);
		
	}
	
	 System.out.println(">>>>>>");
		
	}

  @DataProvider()
  public  String[][] dp1() {
	  String[][] data = new String[][] {
		  {"hyr","123","852","abcd"},
		  {"pqr","456"},
		  {"xyz","789","123654"}
		
	 };
	 
	 return data;
	  
  }
	


}
