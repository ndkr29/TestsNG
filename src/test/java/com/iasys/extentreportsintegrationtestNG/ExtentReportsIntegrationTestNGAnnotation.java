package com.iasys.extentreportsintegrationtestNG;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExtentReportsIntegrationTestNGAnnotation extends BaseTest {
	
@Test(testName = "TestCase1", groups = "smoke")
	
	public void TestCase1()  {
		String ExpextedValue = driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")).getText();
		String ActualResult = "Dashboard";	
		Assert.assertEquals(ActualResult, ExpextedValue, "value is not match");
		extentTest.pass("Test Case passed");
		
		
	}

@Test(testName = "TestCase2" , groups = {"smoke", "regression"})

public void TestCase2() throws InterruptedException {
	Thread.sleep(2000);
	driver.findElement(By.linkText("My Info")).click();		
	Thread.sleep(3000);
	System.out.println(driver.findElement(By.xpath("//h6[normalize-space()='Personal Details']")).isDisplayed());
	boolean value =driver.findElement(By.xpath("//h6[normalize-space()='Personal Details']")).isDisplayed();
	Assert.assertTrue(value,"**********************data present");	
	extentTest.pass("Test Case passed");
	

	
}

@Test(testName = "TestCase3",groups = "sanity")

public void TestCase3() throws InterruptedException {
	Thread.sleep(2000);
	driver.findElement(By.linkText("Directory")).click();		
	Thread.sleep(2000);
	boolean value =driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")).isDisplayed();
	Assert.assertFalse(value,"**********************data present");
	extentTest.pass("Test Case passed");
	

	
}

}
