package com.iasys.extentreport;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extentprogram7 {

	public static void main(String[] args) throws IOException {
		
		Filedelete.filedelete();
		ExtentReports extentreports  = new ExtentReports();
		

		File file = new File("Report\\report.html");
		
		ExtentSparkReporter spark = new ExtentSparkReporter(file);
		
		extentreports.attachReporter(spark);
		
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
		.pass("This is passed test");
		
		extentreports
		.createTest("TestCase 6", "Test desc")
		.assignAuthor(new String[] {"divyapraksh", "Rebeca", "Jeevan"})
		.assignCategory(new String[] {"Smoke", "Sanity"})
		.assignDevice(new String[] {"Chrome  97", "Chrome 99", "Firefox 60"})
		.pass("This is passed test");
		
		
		
		
		extentreports.flush();
		Desktop.getDesktop().browse(file.toURI());

	}

}
