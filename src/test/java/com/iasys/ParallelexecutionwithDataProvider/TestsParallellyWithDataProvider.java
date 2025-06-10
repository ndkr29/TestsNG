package com.iasys.ParallelexecutionwithDataProvider;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestsParallellyWithDataProvider {
@Test(dataProvider = "loginData")
	
	public void TestGoogle(String usern, String pass) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(usern);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(pass);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		String ExpextedValue = driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")).getText();
		String ActualResult = "Dashboard";
		
		assertEquals(ActualResult, ExpextedValue, "value is not match");
		
    	driver.quit();

	}

  @DataProvider(parallel = true)
  public  Object[][] loginData() {
	  Object[][] data = new Object[6][2];
	  
	  data[0][0] ="Admin";
	  data[0][1] ="admin123";
	  
	  data[1][0] ="Admin";
	  data[1][1] ="test123";
	  
	  data[2][0] ="Admin";
	  data[2][1] ="admin123";
	  
	  data[3][0] ="Admin";
	  data[3][1] ="test123";
	  
	  data[4][0] ="Admin";
	  data[4][1] ="admin123";
	  
	  data[5][0] ="Admin";
	  data[5][1] ="test123";
	  
	  return data;
	  
	  
  }
	


}
