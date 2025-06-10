package com.iasys.screenshots;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGUsingListeners extends BaseTest {
	
@Test(testName = "TestCase1")
	
	public void TestCase1() throws InterruptedException {
		String ExpextedValue = driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")).getText();
		String ActualResult = "Dashboard";	
		Assert.assertEquals(ActualResult, ExpextedValue, "value is not match");
		
		
	}

@Test(testName = "TestCase2")

public void TestCase2() throws InterruptedException {
	Thread.sleep(2000);
	driver.findElement(By.linkText("My Info")).click();		
	Thread.sleep(2000);
	boolean value =driver.findElement(By.xpath("//h6[normalize-space()='Personal Details']")).isDisplayed();
	Assert.assertFalse(value,"**********************data present");	
	

	
}

}
