package com.iasys.screenshots;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class ITestLlistenersClass extends BaseTest implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
			try {
				captureScrenshot(result.getTestContext().getName()+ "_"+result.getMethod().getMethodName()+".png");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}

	

}
