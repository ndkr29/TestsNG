package com.iasys.screenshots;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Screenshots {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		String ExpextedValue = driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")).getText();
		String ActualResult = "Dashboard";
	    Assert.assertEquals(ActualResult, ExpextedValue, "value is not match");
	    
	    Utils.captureScrenshot(driver, "Img.png");
		//TakesScreenshot ts = (TakesScreenshot)driver;
//		File file = ts.getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(file, new File("./Screenshots/Imgae1.png"));
		
//		String base64 =ts.getScreenshotAs(OutputType.BASE64);
//		byte[] byteArr = Base64.getDecoder().decode(base64);
		
//		byte[] byteArr = ts.getScreenshotAs(OutputType.BYTES);
//		FileOutputStream fos =new FileOutputStream(new File("./Screenshots/Imgae3.png"));
//		fos.write(byteArr);
//		fos.close();
		
		driver.quit();
		

	}

}
