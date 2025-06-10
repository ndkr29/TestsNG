package com.iasys.timeout;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExpectedException {
	
	@Test(expectedExceptions = {NoSuchElementException.class})
	public void testmethod1() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.iasys.co.in/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.id("abcd")).click();
		driver.quit();
	}

}
