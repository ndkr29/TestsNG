package com.iasys.screenshots;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utils {
	
	public static void captureScrenshot(WebDriver driver, String filename) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("./Screenshots/"+filename+""));
		
//		String base64 =ts.getScreenshotAs(OutputType.BASE64);
//		byte[] byteArr = Base64.getDecoder().decode(base64);
		
//		byte[] byteArr = ts.getScreenshotAs(OutputType.BYTES);
//		FileOutputStream fos =new FileOutputStream(new File("./Screenshots/Imgae3.png"));
//		fos.write(byteArr);
	
	}

}
