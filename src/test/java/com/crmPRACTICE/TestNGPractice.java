package com.crmPRACTICE;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestNGPractice {
	
	@Test(priority = 1 )
	public void createOrg()
	{
		System.out.println("org created");
		Reporter.log("hello",true);
	}
	
	@Test
	public void modifyOrg()
	{
		System.out.println("org modified");
	}
	
	@Test
	public  void deleteOrg()
	{
		System.out.println("org deleted");
	}

}
