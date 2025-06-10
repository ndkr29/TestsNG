package com.iasys.DataProvider;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderReturntyHashSetwithobject {
@Test(dataProvider = "dp1")
	public void TestGoogle(String[ ] s) throws Exception {
	
	  System.out.println(s[0]+ ">>"+s[1]);
	
	
	}

  @DataProvider()
  public  Iterator<Object[]> dp1() {
	  Set<Object[]> data = new HashSet<>();
	  data.add(new Object[] {"yadagiri","Reddy"});
	  data.add(new Object[] {"jhon","cena"});
	
	
	 
	 return data.iterator();
	  
  }
	


}
