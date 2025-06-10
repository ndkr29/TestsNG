package com.iasys.DataProvider;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderReturntype {
@Test(dataProvider = "dp1")
	
	public void TestGoogle(String s) throws InterruptedException {
	System.out.println(s);
	
		
	}

  @DataProvider()
  public  String[] dp1() {
	 String[] data = new String[] {
		"abcd",
		"xyz",
		"pqr"
	 };
	 
	 return data;
	  
  }
	


}
