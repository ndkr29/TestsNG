package com.iasys.DataProvider;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderTestNG {
@Test(dataProvider = "loginData")
	
	public void TestGoogle(String usern, String pass) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(usern);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(pass);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		String ExpextedValue = driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")).getText();
		String ActualResult = "Dashboard";
		
		assertEquals(ActualResult, ExpextedValue, "value is not match");
		
//		driver.findElement(By.linkText("My Info")).click();		
//		Thread.sleep(2000);
//		boolean value =driver.findElement(By.xpath("//h6[normalize-space()='Personal Details']")).isDisplayed();
//		sfa.assertTrue(value,"**********************data present");	
    	driver.quit();
//		sfa.assertAll();
		
	}

  @DataProvider()
  public  Object[][] loginData() {
	  Object[][] data = new Object[2][2];
	  
	  data[0][0] ="Admin";
	  data[0][1] ="admin123";
	  
	  data[1][0] ="Admin";
	  data[1][1] ="test123";
	  
	  return data;
	  
	  
  }
	


}
