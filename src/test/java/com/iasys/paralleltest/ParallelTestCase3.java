package com.iasys.paralleltest;

import org.testng.annotations.Test;

public class ParallelTestCase3 {
	
	@Test
	public void testMethod8() {
		System.out.println("TestClass8 >> testMethod8>>" +Thread.currentThread().getId());
	}
	
	@Test
	public void testMethod9() {
		System.out.println("TestClass9 >> testMethod9>>" +Thread.currentThread().getId());
	}

	@Test
	public void testMethod10() {
		System.out.println("TestClass10 >> testMethod10>>" +Thread.currentThread().getId());
	}
	
	@Test
	public void testMethod11() {
		System.out.println("TestClass11 >> testMethod11>>" +Thread.currentThread().getId());
	}



}
