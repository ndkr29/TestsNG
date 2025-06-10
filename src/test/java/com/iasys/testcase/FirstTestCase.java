package com.iasys.testcase;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTestCase {
	
	@Test
	
	public void TestGoogle() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(10000);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		String ExpextedValue = driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")).getText();
		String ActualResult = "Dashboard1";
		SoftAssert sfa = new SoftAssert();
		sfa.assertEquals(ActualResult, ExpextedValue, "value is not match");
		Thread.sleep(2000);
		driver.findElement(By.linkText("My Info")).click();		
		Thread.sleep(2000);
		boolean value =driver.findElement(By.xpath("//h6[normalize-space()='Personal Details']")).isDisplayed();
		sfa.assertTrue(value,"**********************data present");	
		driver.quit();
		sfa.assertAll();
		
	}
	
	
	

}
