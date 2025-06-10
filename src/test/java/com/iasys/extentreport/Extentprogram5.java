package com.iasys.extentreport;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extentprogram5 {

	public static void main(String[] args) throws IOException {
		ExtentReports extentreports = new ExtentReports();

		Filedelete.filedelete();

		File file = new File("\\Report\\report.html");

		ExtentSparkReporter spark = new ExtentSparkReporter(file);

		extentreports.attachReporter(spark);
//		extentreports.createTest("Text based test").log(Status.INFO, "info1").log(Status.INFO, "<b>info2</b>")// --->Bold
//				.log(Status.INFO, "<i>info3</i>")// -->Italic
//				.log(Status.INFO, "<b><i>info4</i></b>");// -->Bold and Italic
//
//		// --------------XML and JON data----------------------
//		String xmlData = "<employees>\r\n" + "  <employee>\r\n"
//				+ "    <firstName>John</firstName> <lastName>Doe</lastName>\r\n" + "  </employee>\r\n"
//				+ "  <employee>\r\n" + "    <firstName>Anna</firstName> <lastName>Smith</lastName>\r\n"
//				+ "  </employee>\r\n" + "  <employee>\r\n"
//				+ "    <firstName>Peter</firstName> <lastName>Jones</lastName>\r\n" + "  </employee>\r\n"
//				+ "</employees>";
//
//		String jsonData = "{\"employees\":[\r\n" + "  { \"firstName\":\"John\", \"lastName\":\"Doe\" },\r\n"
//				+ "  { \"firstName\":\"Anna\", \"lastName\":\"Smith\" },\r\n"
//				+ "  { \"firstName\":\"Peter\", \"lastName\":\"Jones\" }\r\n" + "]}";
//
//		extentreports.createTest("XML based Test")
//				// .log(Status.INFO, xmlData);//XML data is not displayed in the extent report
//
//				// Using the code below, the XML data is displayed in the extent report,
//				.info(MarkupHelper.createCodeBlock(xmlData, CodeLanguage.XML));
//
//		extentreports.createTest("JSON based Test")
//				// .log(Status.INFO, jsonData);//JSON data is not displayed in the correct
//				// format in the extent report.
//
//				// Using the code below, the XML data is displayed in the extent report,
//				.log(Status.INFO, MarkupHelper.createCodeBlock(jsonData, CodeLanguage.JSON));
//		
		
		//Collection Data(List ,Set and Map)
		
//		List<String> listDData = new ArrayList<>();
//		listDData.add("yadagiri");
//		listDData.add("Jeevan");
//		listDData.add("Raj");
//		
//		Map<Integer,String> mapData = new HashMap<>();
//		mapData.put(101, "yadagiri");
//		mapData.put(102, "Jeevan");
//		mapData.put(103, "Raj");
//		
//		Set<Integer> setData = mapData.keySet();
//		
//		extentreports.createTest("List based Test")
//		.info(MarkupHelper.createOrderedList(listDData))
//		.info(MarkupHelper.createUnorderedList(listDData));
//		
//		extentreports.createTest("Set based Test")
//		.info(MarkupHelper.createOrderedList(setData))
//		.info(MarkupHelper.createUnorderedList(setData));
//		
//		extentreports.createTest("MA based Test")
//		.info(MarkupHelper.createOrderedList(mapData))
//		.info(MarkupHelper.createUnorderedList(mapData));
//		
//		extentreports.createTest("Highight Log Test")
//		.info("This is not  highlighted message")
//		.info(MarkupHelper.createLabel("This is not  highlighted message", ExtentColor.RED));
		
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
		
	

		extentreports.flush();
		Desktop.getDesktop().browse(file.toURI());

	}

}
