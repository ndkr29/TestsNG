package com.iasys.extentreport;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;

public class Extentprogram11 {

	public static void main(String[] args) throws IOException {
		
		Filedelete.filedelete();
		ExtentReports extentreports  = new ExtentReports();
		
		
		ExtentSparkReporter spark_all = new ExtentSparkReporter("Report\\AllTests.html");
		
		// failed test case filter 
		
		ExtentSparkReporter spark_failed = new ExtentSparkReporter("Report\\FailedTests.html");
		spark_failed.filter().statusFilter().as(new Status[] {Status.FAIL}).apply();
		

		
		// Skip and waring test case filter 
		
		ExtentSparkReporter spark_Skipandwaring = new ExtentSparkReporter("Report\\SkipandwaringTests.html");
		
		spark_Skipandwaring.filter().statusFilter().as(new Status[] {
				Status.SKIP,
				Status.WARNING
				
		}).apply();
		
	
		extentreports.attachReporter(spark_all, spark_failed, spark_Skipandwaring);
		
		try {
			int i =5/0;
			
		}catch(Exception e) {
			extentreports.createTest("Exception Test 1")
			.fail(e);
			
		}
		
		Throwable t = new RuntimeException("thsi is a custom excption");
		extentreports.createTest("Exception Test 2")
		.fail(t);
		
		extentreports.createTest("Exception Test 3")
		.fail(t);
		
		extentreports
		.createTest("TestCase 1", "Test desc")
		.assignAuthor("divyapraksh")
		.assignCategory("Smoke")
		.assignDevice("chrome 99")
		.pass("This is passed test");
		
		extentreports
		.createTest("TestCase 2", "Test desc")
		.assignAuthor("divyapraksh")
		.assignCategory("Sanity")
		.assignDevice("Edge 99")
		.pass("This is passed test");
		
		
		extentreports
		.createTest("TestCase 3", "Test desc")
		.assignCategory("Sanity")
		.assignDevice("Edge 99")
		.assignAuthor("divyapraksh")
		
		.fail("This is passed test");
		
		extentreports
		.createTest("TestCase 4", "Test desc")
		.assignAuthor("divyapraksh")
		.assignAuthor("Praksh")
		.assignCategory("Sanity")
		.assignCategory("Regression")
		.assignDevice("Chrome 97")
		.assignDevice("Chrome  99")
		
		.fail("This is passed test");
		
		extentreports
		.createTest("TestCase 5", "Test desc")
		.assignAuthor("divyapraksh", "Rebeca", "Jeevan")
		.assignCategory("Smoke", "Regression", "Sanity")
		.assignDevice("Chrome  97", "Chrome 99", "Firefox 60")
		.skip("This is passed test");
		
		
		extentreports
		.createTest("TestCase 6", "Test desc")
		.assignAuthor(new String[] {"divyapraksh", "Rebeca", "Jeevan"})
		.assignCategory(new String[] {"Smoke", "Sanity"})
		.assignDevice(new String[] {"Chrome  97", "Chrome 99", "Firefox 60"})
		.warning("This is passed test");
		
		
		
		
		extentreports.flush();
		Desktop.getDesktop().browse(new File("Report\\AllTests.html").toURI());
		Desktop.getDesktop().browse(new File("Report\\FailedTests.html").toURI());
		Desktop.getDesktop().browse(new File("Report\\SkipandwaringTests.html").toURI());


	}

}
