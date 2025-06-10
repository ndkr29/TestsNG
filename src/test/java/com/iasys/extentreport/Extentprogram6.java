package com.iasys.extentreport;

import static org.testng.Assert.fail;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Extentprogram6 {
	
	static WebDriver driver;
	public static String screenshotssubfolderName;

	public static void main(String[] args) throws IOException {
		
		ExtentReports extentreports  = new ExtentReports();
		
		File file = new File("report1.html");
		
		ExtentSparkReporter spark = new ExtentSparkReporter(file);
		
		extentreports.attachReporter(spark);
		
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://www.google.co.in/");
		
		
		
		
//		
//		extentreports
//		.createTest("Screenshot Test 1", "This is for attaching the screenshot to the test at the test level")
//		.info("This is a info msg")
//		.addScreenCaptureFromBase64String(captureScrenshot());
//		
//		extentreports
//		.createTest("Screenshot Test 2", "This is for attaching the screenshot to the test at the test level")
//		.info("This is a info msg")
//		.addScreenCaptureFromBase64String(captureScrenshot(), "Goole homepage");
//		
//		extentreports
//		.createTest("Screenshot Test 3", "This is for attaching the screenshot to the test at the test level")
//		.info("This is a info msg")
//		.addScreenCaptureFromBase64String(captureScrenshot(), "Goole homepage1")
//		.addScreenCaptureFromBase64String(captureScrenshot(), "Goole homepage2")
//		.addScreenCaptureFromBase64String(captureScrenshot(), "Goole homepage3")
//		.addScreenCaptureFromBase64String(captureScrenshot(), "Goole homepage4");
//		
//		extentreports
//		.createTest("Screenshot Test 4", "This is for attaching the screenshot to the test at the test level")
//		.info("This is a info msg")
//		.addScreenCaptureFromPath(captureScrenshot("google.png"));
//		
//		extentreports
//		.createTest("Screenshot Test 5", "This is for attaching the screenshot to the test at the test level")
//		.info("This is a info msg")
//		.addScreenCaptureFromPath(captureScrenshot("google.png"), "Goole homepage");
//		
//		extentreports
//		.createTest("Screenshot Test 6", "This is for attaching the screenshot to the test at the test level")
//		.info("This is a info msg")
//		.addScreenCaptureFromPath(captureScrenshot("google.png"), "Goole homepage1")
//		.addScreenCaptureFromPath(captureScrenshot("google.png"), "Goole homepage2")
//		.addScreenCaptureFromPath(captureScrenshot("google.png"), "Goole homepage 3")
//		.addScreenCaptureFromPath(captureScrenshot("google.png"), "Goole homepage 4");
		
		
//		extentreports
//		.createTest("Screenshot Test 7", "This is for attaching the screenshot to the test at the Log level")
//		.info("This is a info msg")
//		.fail(MediaEntityBuilder.createScreenCaptureFromBase64String(captureScrenshot()).build())
//		.fail(MediaEntityBuilder.createScreenCaptureFromBase64String(captureScrenshot(), "Goole homepage").build());
//		
//		
//		extentreports
//		.createTest("Screenshot Test 8", "This is for attaching the screenshot to the test at the Log level")
//		.info("This is a info msg")
//		.fail(MediaEntityBuilder.createScreenCaptureFromPath(captureScrenshot("google.png")).build())
//	    .fail(MediaEntityBuilder.createScreenCaptureFromPath(captureScrenshot("google.png"), "Goole homepage").build());
//		
//		extentreports
//		.createTest("Screenshot Test 9", "This is for attaching the screenshot to the test at the Log level")
//		.info("This is a info msg")
//		.fail("This is a info msg", MediaEntityBuilder.createScreenCaptureFromBase64String(captureScrenshot()).build())
//		.fail("This is a info msg", MediaEntityBuilder.createScreenCaptureFromBase64String(captureScrenshot(), "Goole homepage").build());
//		
//		
//		extentreports
//		.createTest("Screenshot Test 10", "This is for attaching the screenshot to the test at the Log level")
//		.info("This is a info msg")
//		.fail("This is a info msg", MediaEntityBuilder.createScreenCaptureFromPath(captureScrenshot("google.png")).build())
//	    .fail("This is a info msg", MediaEntityBuilder.createScreenCaptureFromPath(captureScrenshot("google.png"), "Goole homepage").build());
//		
		
		Throwable t = new Throwable("This is thorable excption");
		extentreports
		.createTest("Screenshot Test 11", "This is for attaching the screenshot to the test at the Log level")
		.info("This is a info msg")
		.fail(t, MediaEntityBuilder.createScreenCaptureFromBase64String(captureScrenshot()).build())
		.fail(t, MediaEntityBuilder.createScreenCaptureFromBase64String(captureScrenshot(), "Goole homepage").build());
		
		
		extentreports
		.createTest("Screenshot Test 12", "This is for attaching the screenshot to the test at the Log level")
		.info("This is a info msg")
		.fail(t, MediaEntityBuilder.createScreenCaptureFromPath(captureScrenshot("google.png")).build())
	    .fail(t, MediaEntityBuilder.createScreenCaptureFromPath(captureScrenshot("google.png"), "Goole homepage").build());
		
		
		
		extentreports.flush();
		driver.quit();
		Desktop.getDesktop().browse(new File("report1.html").toURI());

	}
	
 public static String captureScrenshot( String filename) throws IOException {
		
		if(screenshotssubfolderName==null) {
			LocalDateTime myDateObj = LocalDateTime.now();
		    System.out.println("Before formatting: " + myDateObj);
		    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");

		     screenshotssubfolderName = myDateObj.format(myFormatObj);
		 
			
		}
			
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		File destfile =new File("./Screenshots/"+screenshotssubfolderName+"/"+filename);
		FileUtils.copyFile(file, destfile);
		
		
		System.out.println("Screenshot");
		
		return destfile.getAbsolutePath();
		

	
	}
 
 
 public static String captureScrenshot() throws IOException {	
		
		TakesScreenshot ts = (TakesScreenshot)driver;		
		String base64 =ts.getScreenshotAs(OutputType.BASE64);		
		System.out.println("Screenshot");		
		return base64;
		

	
	}

}
