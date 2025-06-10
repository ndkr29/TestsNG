package com.iasys.dataproviderseparateClass;

import org.testng.annotations.Test;

public class BaseTest {
	
	@Test(dataProvider = "dp1" , dataProviderClass = DataSupplier.class)
	public void TestGoogle(String s) throws Exception {
	
	  System.out.println(s);
	
	
	}

 

}
