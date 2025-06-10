package com.iasys.DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderReturntypetwodimensionalarray {
@Test(dataProvider = "dp1")
	public void TestGoogle(String username, String pass ) throws InterruptedException {
	System.out.println(username+ ">>>"+pass);
	
		
	}

  @DataProvider()
  public  String[][] dp1() {
	  String[][] data = new String[][] {
		  {"hyr","123"},
		  {"pqr","456"},
		  {"xyz","789"}
		
	 };
	 
	 return data;
	  
  }
	


}
