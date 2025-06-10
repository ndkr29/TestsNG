package com.iasys.testcase;

import org.testng.annotations.Test;

public class Priority {
	
	@Test
	public void BookTheFlight() {
		System.out.println("BookTheFlight");
		
	}
	
	@Test(priority= 1)
	public void Login() {
		System.out.println("Login");
		
	}
	
	@Test(priority = 6)
	public void Logout() {
		System.out.println("Logout");
		
	}
	
	@Test(priority = 5)
	public void SaveTheTicket() {
		System.out.println("SaveTheTicket");
		
	}
	
	@Test(priority = 3)
	public void SaerchForTheFlight() {
		System.out.println("SaerchForTheFlight");
		
	}
	
	@Test(priority = 1)
	public void Singup() {
		System.out.println("Singup");
		
	}

}
