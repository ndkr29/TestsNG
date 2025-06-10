package com.iasys.groups;

import org.testng.annotations.Test;

public class Ignore2 {
	
	@Test(groups = {"Smoke", "sanity"})
	public void test4()
	{
	 System.out.println("testCase 4");	
	}
	
	@Test(groups = {"regression","", "windoes.sanity"})
	public void test5()
	{
	 System.out.println("testCase 5");	
	}
	
	@Test(groups = {"functional"})
	public void test6()
	{
	 System.out.println("testCase 6");	
	}

}
