package com.iasys.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderReturntyIterator {
@Test(dataProvider = "dp1")
	public void TestGoogle(String s) throws Exception {
	
	  System.out.println(s);
	
	
	}

  @DataProvider()
  public  Iterator<String> dp1() {
	  List<String> data = new ArrayList<String>();
	  data.add("yadagiri");
	  data.add("Reddy");
		
	
	 
	 return data.iterator();
	  
  }
	


}
