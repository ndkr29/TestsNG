package com.iasys.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHrm {
	WebDriver driver;
	
	@Parameters("browserName")
	
	@BeforeTest
	public void InitialiseBrowser(String browserName1) {
		
		switch (browserName1.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			break;
		default:
			System.out.println("Browser is invalid");
			break;
		}
		
		
	}
	
	@AfterTest
	public void Teardown() {
		driver.quit();
		
	}
	@Parameters("url")
	@Test
	public void LanchApp(String url) throws InterruptedException {
		driver.get(url);
		
		
	}
	
	@Parameters({"username", "password"})
	@Test()
	public void EnterLoginDetails(String un, String pw) throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(un);	
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(pw);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		
		
	}
	
	@Test
	public void VerifyLogin() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")).isDisplayed());
		
		
	}
	
	@Test
	public void NaviagateToMYInfo() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.linkText("My Info")).click();	
		
		
	}
	
	@Test
	public void VerifyMYInfo() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//h6[normalize-space()='Personal Details']")).isDisplayed());
		
		
	}

}
