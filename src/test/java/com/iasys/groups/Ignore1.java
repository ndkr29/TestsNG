package com.iasys.groups;

import org.testng.annotations.Test;

@Test(groups = {"all"})
public class Ignore1 {
	
	
	@Test(groups = {"Smoke", "windoes.smoke"})
	public void test1()
	{
	 System.out.println("testCase 1");	
	}
	
	@Test(groups = {"Smoke", "functional", "sanity","windoes.functional"})
	public void test2()
	{
	 System.out.println("testCase 2");	
	}
	
	@Test(groups = { "functional", "regression"})
	public void test3()
	{
	 System.out.println("testCase 3");	
	}
	
	@Test
	public void test8()
	{
	 System.out.println("testCase 8");	
	}

}
