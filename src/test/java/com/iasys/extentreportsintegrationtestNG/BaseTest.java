package com.iasys.extentreportsintegrationtestNG;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.iasys.extentreport.Filedelete;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public static WebDriver driver;
	public static String screenshotssubfolderName; 
	public static ExtentReports extentReports;
	public static ExtentTest extentTest;
	
    @Parameters("browserName")
	
	@BeforeTest
	public void InitialiseBrowser(ITestContext context,@Optional("chrome") String browserName1) {
		
		switch (browserName1.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
			break;
		default:
			System.out.println("Browser is invalid");
			break;
		}
		driver.manage().window().maximize();
		 Capabilities capabilities =((RemoteWebDriver) driver).getCapabilities();
		 
		String device= capabilities.getBrowserName() +" "+capabilities.getBrowserVersion()
		.substring(0, capabilities.getBrowserVersion().indexOf("."));
		String author = context.getCurrentXmlTest().getParameter("author");
		
		
		extentTest=extentReports.createTest(context.getName());
		extentTest.assignAuthor(author);
		extentTest.assignDevice(device);
		
		try {
			BaseTest.setup();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		 
		
		
	}
    

	public static void setup() throws InterruptedException {
	
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		extentTest.info("Navigate to url");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		
	}
	


	
	
	@AfterTest
	public void teardoen() {
		driver.quit();
		
	}
	
	@BeforeSuite
	public void initialiseEXtententReports() {
		Filedelete.filedelete();
		ExtentSparkReporter sparkReporter_all = new ExtentSparkReporter("Report\\AllTests.html");
		sparkReporter_all.config().setReportName("All test Report");
		
		
		
		ExtentSparkReporter spark_failed = new ExtentSparkReporter("Report\\FailedTests.html");
		spark_failed.filter().statusFilter().as(new Status[] {Status.FAIL}).apply();
		spark_failed.config().setReportName("Failure Report");
		
		extentReports = new ExtentReports();
		extentReports.attachReporter(sparkReporter_all,spark_failed);
		
		
		
		extentReports.setSystemInfo("OS", System.getProperty("os.name"));
		extentReports.setSystemInfo("JAVA Version", System.getProperty("java.version"));
		
		
		
	}
	
	@AfterSuite
	public void generateExtentReports() throws IOException {
		extentReports.flush();
		Desktop.getDesktop().browse(new File("Report\\AllTests.html").toURI());
		Desktop.getDesktop().browse(new File("Report\\\\FailedTests.html").toURI());
		
	}
	
	@AfterMethod
	public void checkstatus(Method m,ITestResult result) throws IOException {
		if(result.getStatus() == ITestResult.FAILURE) {
			String screenshotPath = null;
			screenshotPath = captureScrenshot(result.getTestContext().getName()+ "_"+result.getMethod().getMethodName()+".png");
			extentTest.addScreenCaptureFromPath(screenshotPath);
			extentTest.fail(result.getThrowable());
		} else if(result.getStatus() == ITestResult.SUCCESS) {
			extentTest.pass(m.getName()+ "is passed");
		}
		
		extentTest.assignCategory(m.getAnnotation(Test.class).groups());
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
	

	
}