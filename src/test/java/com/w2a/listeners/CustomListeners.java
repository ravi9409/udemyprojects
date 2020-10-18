package com.w2a.listeners;

import com.relevantcodes.extentreports.LogStatus;
import com.w2a.base.TestBase;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;


public class CustomListeners extends TestBase implements ITestListener {

	public void onFinish(ITestContext context) {
		
	}
	public void onStart(ITestContext context) {
		
	}
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}
	
	public void onTestFailure(ITestResult result) {
		
		//System.setProperty("org.uncommons.reportng.escape-output","false");
		//Reporter.log("<br>Capturing Screenshot<br>");
		//Reporter.log("<br>Login sucessfully executed<br>");
		//Reporter.log("<a target=\"blank\" href=\"H:\\selenium practise\\error.jpg\">Screenshot</a>");
		//test.log(LogStatus.FAIL, result.getName().toUpperCase()+"Failed with exception");
		//rep.endTest(test);
		//rep.flush();
	}
	
	public void onTestSkipped(ITestResult result) {
		
	}
	
	public void onTestStart(ITestResult result) {
		
	}

	public void onTestSuccess(ITestResult result) {
		//test.log(LogStatus.PASS, result.getName().toUpperCase()+"PASS");
		//rep.endTest(test);
		//rep.flush();
	}
}
