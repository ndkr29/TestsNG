package com.iasys.DataProvider;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderReturntyHashSet {
@Test(dataProvider = "dp1")
	public void TestGoogle(String[ ] s) throws Exception {
	
	  System.out.println(s[0]+ ">>"+s[1]);
	
	
	}

  @DataProvider()
  public  Iterator<String[]> dp1() {
	  Set<String[]> data = new HashSet<String[]>();
	  data.add(new String[] {"yadagiri","Reddy"});
	  data.add(new String[] {"jhon","cena"});
	
	
	 
	 return data.iterator();
	  
  }
	


}
