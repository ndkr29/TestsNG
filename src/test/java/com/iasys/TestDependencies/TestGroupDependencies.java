package com.iasys.TestDependencies;

import org.testng.annotations.Test;

public class TestGroupDependencies {
	
	@Test(groups = "smoke")
	public void test1() {
		System.out.println("smoke1");
		
	}
	
	@Test(groups = "smoke")
	public void test2() {
		System.out.println("smoke2");
		
	}
	
	@Test(groups = "smoke")
	public void test3() {
		System.out.println(5/0);
		
	}
	
	@Test(groups = "sanit")
	public void test4() {
		System.out.println("sanit4");
		
	}
	
	@Test(groups = "sanit")
	public void test5() {
		System.out.println("sanit5");
		
	}
	
	@Test(groups = "regression")
	public void test6() {
		System.out.println("regression6");
		
	}
	
	@Test(groups = "regression")
	public void test7() {
		System.out.println("regression7");
		
	}
//	@Test(dependsOnGroups = {"smoke", "sanit", "regression"} )
//	public void test0() {
//		System.out.println("main test");
//		
//	}

}
