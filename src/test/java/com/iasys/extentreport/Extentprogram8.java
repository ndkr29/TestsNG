package com.iasys.extentreport;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Extentprogram8 {

	public static void main(String[] args) throws IOException {
		Filedelete.filedelete();
		ExtentReports extentreports  = new ExtentReports();
		

		File file = new File("Report\\report2.html");
		
		ExtentSparkReporter spark = new ExtentSparkReporter(file);
		
//		ExtentSparkReporterConfig config = spark.config();
//		
//		config.setTheme(Theme.DARK);
//		config.setReportName("Report Name");
//		config.setDocumentTitle("DOC Tile");
//		config.setTimeStampFormat("dd-MM-YYYY hh:mm:ss");
//		config.setCss(".badge-primary{background-color:#df65a3}");
//		config.setJs("document.getElementsByClassName('logo')[0].style.display='none'");
		
		//spark.loadJSONConfig(new File("./src/test/resources/extent-repots-config.json"));
		
		//spark.loadXMLConfig(new File("./src/test/resources/extent-report-config.xml"));
		spark.loadXMLConfig("./src/test/resources/extent-report-config.xml");
		
		
		extentreports.attachReporter(spark);
		 extentreports
		.createTest("TestCase1")
		.log(Status.INFO, "info1")
		.log(Status.INFO, "info2");
		
		extentreports.flush();
		Desktop.getDesktop().browse(file.toURI());

	}

}
