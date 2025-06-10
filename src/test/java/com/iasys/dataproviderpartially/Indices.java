package com.iasys.dataproviderpartially;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Indices {
	
	@Test(dataProvider = "dp1")
	public void TestGoogle(String s) throws Exception {
	
	  System.out.println(s);
	
	
	}

  @DataProvider(indices = {0,2})
  public  String[] dp1() {
	  String[] data = new String[] {
			  "Yadagiri", 
			 "Johan", 
			 "Rebecca",
			 "Smith"
			  
	  };
	 
	
	 
	 return data;
	  
  }

}
