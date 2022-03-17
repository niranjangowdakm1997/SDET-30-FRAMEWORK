package com.crmPRACTICE;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.crn.GenericLibrary.ITestListenerImplementationClass.class)

public class RetryAnalyzerPractice
{
    
	@Test(retryAnalyzer = com.crn.GenericLibrary.RetryAnalyzerImplementation.class)
	
	public void sampleTest()
	{
		System.out.println("pass the test case 1");
		Assert.fail();
		System.out.println("pass the test case 2");
	}
	
}
