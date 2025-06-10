package Ignoretestcase;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

@Ignore
public class Ignore1 {
	
	
	@Test()
	public void test1()
	{
	 System.out.println("testCase 1");	
	}
	
	@Test
	public void test2()
	{
	 System.out.println("testCase 2");	
	}
	
	@Test
	public void test3()
	{
	 System.out.println("testCase 3");	
	}

}
