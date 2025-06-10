package com.iasys.extentreport;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extentprogram4 {

	public static void main(String[] args) throws IOException {
		Filedelete.filedelete();
		ExtentReports extentreports  = new ExtentReports();
		

		File file = new File("Report\\report.html");
		
		ExtentSparkReporter spark = new ExtentSparkReporter(file);
		
		extentreports.attachReporter(spark);
		 extentreports
		.createTest("TestCase1")
		.log(Status.INFO, "info1")
		.log(Status.INFO, "info2");
		
		extentreports.flush();
		Desktop.getDesktop().browse(file.toURI());

	}

}
