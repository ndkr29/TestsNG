package com.iasys.paralleltest;

import org.testng.annotations.Test;

public class ParallelTestCase2 {
	
	@Test
	public void testMethod5() {
		System.out.println("TestClass5 >> testMethod5>>" +Thread.currentThread().getId());
	}
	
	@Test
	public void testMethod6() {
		System.out.println("TestClass6 >> testMethod6>>" +Thread.currentThread().getId());
	}

	@Test
	public void testMethod7() {
		System.out.println("TestClass7 >> testMethod7>>" +Thread.currentThread().getId());
	}



}
