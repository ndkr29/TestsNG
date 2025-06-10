package com.iasys.extentreport;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Extentprogram9 {

	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		  Capabilities capabilities =((RemoteWebDriver) driver).getCapabilities();
		  
//		  System.out.println(capabilities.getBrowserName());// get the browser name
//		  
//		  System.out.println(capabilities.getBrowserVersion());// get the browser version
		  
	//	  System.getProperties().list(System.out); // get the all the properties
		  
	//	 System.out.println(System.getProperty("os.name"));
		// System.out.println(System.getProperty("java.version"));
		
		 Filedelete.filedelete();
			ExtentReports extentreports  = new ExtentReports();
			

			File file = new File("Report\\report2.html");
			
			ExtentSparkReporter spark = new ExtentSparkReporter(file);
			
		ExtentSparkReporterConfig config = spark.config();
		config.setTheme(Theme.DARK);
		config.setReportName("Report Name");
		config.setDocumentTitle("DOC Tile");
		config.setTimeStampFormat("dd-MM-YYYY hh:mm:ss");
		config.setCss(".badge-primary{background-color:#df65a3}");
		config.setJs("document.getElementsByClassName('logo')[0].style.display='none'");
		
		extentreports.setSystemInfo("OS", System.getProperty("os.name"));
		extentreports.setSystemInfo("JAVA Version", System.getProperty("java.version"));
		extentreports.setSystemInfo("Browser and version", capabilities.getBrowserName() +" "+capabilities.getBrowserVersion() );
		extentreports.setSystemInfo("User Name", "divyaprakash.singh@iasys.co.in");
		extentreports.setSystemInfo("Password", "1234");
		
		
		extentreports.attachReporter(spark);
		 extentreports
		.createTest("TestCase1")
		.log(Status.INFO, "info1")
		.log(Status.INFO, "info2");
		
		extentreports.flush();
		Desktop.getDesktop().browse(file.toURI());


			

	}

}
