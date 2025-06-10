package com.iasys.TestDependencies;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestDependency {
	
	static String trackingNumber = null;
	@Ignore
	@Test()
	public void Createshipment()
	{  
		System.out.println(5/0);
		System.out.println("Createshipment");
		trackingNumber ="ABC12YH";
	}
	
	@Test( dependsOnMethods = {"Createshipment"},  ignoreMissingDependencies = true)
	public void TrackShipment() throws Exception
	{
		if(trackingNumber !=null) {
			System.out.println("TrackShipment");	
		}
		else
		{
			throw new Exception("invalid tacking number");
		}
		
	}
	
	@Test(dependsOnMethods = {"Createshipment", "TrackShipment"})
	public void CancleShipment() throws Exception
	{
		if(trackingNumber !=null) {
			System.out.println("CancleShipment");	
		}
		else
		{
			throw new Exception("invalid tacking number");
		}
		
	}

}
