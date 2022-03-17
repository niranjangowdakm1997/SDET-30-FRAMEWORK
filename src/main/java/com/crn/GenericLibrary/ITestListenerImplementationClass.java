package com.crn.GenericLibrary;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ITestListenerImplementationClass implements ITestListener {
	
	ExtentReports report;
	ExtentTest test;

public void onTestStart(ITestResult result) {
		
		String MethodName = result.getMethod().getMethodName();
		test=report.createTest(MethodName);
		
		
	}

	public void onTestSuccess(ITestResult result) {
		
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.PASS,MethodName+"------->passed");
		
		
	}

	public void onTestFailure(ITestResult result) {
		String path=null;
		
		String MethodName = result.getMethod().getMethodName()+"-";
		Reporter.log(MethodName + "--- TestScript Failed",true);
		
		//Step 1: Configure screenshot name
		String screenshotName = MethodName+new JavaUtility().getSystemDateInFormate();
		System.out.println(screenshotName);
		
		//Step 2: using screenshot method from webDriver Utility
		try {
			
		 path=new WebDriverUtility().getScreenshot(BaseClass.sdriver, screenshotName);
			
	
		//EventFiringWebDriver eDriver = new EventFiringWebDriver(BaseClass.sDriver);
	    //File src = eDriver.getScreenshotAs(OutputType.FILE);
		//String pa = System.getProperty("user.dir")+"/ScreenShots/"+screenshotName+".PNG";
		//String path = "./Screenshots/"+screenshotName+".png";
		//File dst = new File(pa);
		//Files.copy(src, dst);
			
		} catch (Throwable e) {
			
			e.printStackTrace();
		}
		
		test.log(Status.FAIL,MethodName+"----->failed");
		//it will capture the exception and log it in the report
		test.log(Status.FAIL,result.getThrowable());
		test.addScreenCaptureFromPath(path);
	
	}

	public void onTestSkipped(ITestResult result) {
		
		String MethodName = result.getMethod().getMethodName();
        test.log(Status.SKIP,MethodName+"------>skipped");
        //it will capture the exception and log it in the report
        test.log(Status.SKIP,result.getThrowable());
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
		
	}

	public void onStart(ITestContext context) {
		
		//Execution will start here
		//configure the report
		ExtentSparkReporter htmlReport=new ExtentSparkReporter("./ExtentReports/Reports"+new JavaUtility().getSystemDateInFormate()+".html");
		htmlReport.config().setDocumentTitle("SDET-30 Execution Report");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("Selenium Execution report");
		
		report=new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base-Browser","chrome");
		report.setSystemInfo("OS","windows");
		report.setSystemInfo("base-url","http://localhost:8888");
		report.setSystemInfo("Reporter Name","Niranjan");
		
	}

	public void onFinish(ITestContext context) {
		
		//consolidate all the parameters and generate the report
		report.flush();
		
		
	}
  
	

}
