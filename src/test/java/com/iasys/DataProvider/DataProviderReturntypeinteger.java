package com.iasys.DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderReturntypeinteger {
@Test(dataProvider = "dp1")
	public void TestGoogle(Object s) throws InterruptedException {
	System.out.println(s);
	
		
	}

  @DataProvider()
  public  Object[] dp1() {
	 Object[] data = new Object[] {
		1,
		"hello",
		3
	 };
	 
	 return data;
	  
  }
	


}
