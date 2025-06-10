package com.iasys.dataproviderseparateClass;

import org.testng.annotations.DataProvider;

public class DataSupplier {
	
	 @DataProvider()
	  public  String[] dp1() {
		  String[] data = new String[] {
				  "Yadagiri", 
				 "Johan", 
				 "Rebecca",
				 "Smith"
				  
		  };
		 
		
		 
		 return data;
		  
	  }

	 @DataProvider()
	  public  String[] dp2() {
		  String[] data = new String[] {
				  "Sumanth", 
				  "Teju", 
				 "Cena",
				 "Robert"
				  
		  };
		 
		
		 
		 return data;
		  
	  }
}
