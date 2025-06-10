package com.iasys.extentreport;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extentprogram1 {

	public static void main(String[] args) throws IOException {
		ExtentReports extentreports  = new ExtentReports();
		
		File file = new File("report1.html");
		
		ExtentSparkReporter spark = new ExtentSparkReporter(file);
		
		extentreports.attachReporter(spark);
		ExtentTest test1 = extentreports.createTest("TestCase1");
		test1.pass("This test is pass");
		
		ExtentTest test2= extentreports.createTest("TestCase2");
		test2.log(Status.FAIL, "This is a fiald ");
		
		extentreports.createTest("TestCase3").skip("This method is skip");
		extentreports.flush();
		Desktop.getDesktop().browse(new File("report1.html").toURI());

	}

}
