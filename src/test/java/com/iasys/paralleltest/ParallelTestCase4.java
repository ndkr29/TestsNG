package com.iasys.paralleltest;

import org.testng.annotations.Test;

public class ParallelTestCase4 {
	
	@Test
	public void testMethod12() {
		System.out.println("TestClass12 >> testMethod12>>" +Thread.currentThread().getId());
	}
	
	@Test
	public void testMethod13() {
		System.out.println("TestClass13 >> testMethod13>>" +Thread.currentThread().getId());
	}

	@Test
	public void testMethod14() {
		System.out.println("TestClass14 >> testMethod14>>" +Thread.currentThread().getId());
	}

	@Test
	public void testMethod15() {
		System.out.println("TestClass15 >> testMethod16>>" +Thread.currentThread().getId());
	}


}
