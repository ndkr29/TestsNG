package com.iasys.paralleltest;

import org.testng.annotations.Test;

public class ParallelTestCase1 {
	
	@Test
	public void testMethod1() {
		System.out.println("TestClass1 >> testMethod1>>" +Thread.currentThread().getId());
	}
	
	@Test
	public void testMethod2() {
		System.out.println("TestClass2 >> testMethod2>>" +Thread.currentThread().getId());
	}

	@Test
	public void testMethod3() {
		System.out.println("TestClass3 >> testMethod4>>" +Thread.currentThread().getId());
	}

	@Test
	public void testMethod4() {
		System.out.println("TestClass4 >> testMethod4>>" +Thread.currentThread().getId());
	}


}
