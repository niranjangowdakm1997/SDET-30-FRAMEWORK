package com.crmPRACTICE;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.testng.annotations.Test;

public class PropertyFilePractice {
	
	@Test
	
	public void propertyFilePractce() throws Throwable
	{
		//step 1: read the file
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData");
		
		//step 2: create obj of properties
		Properties pobj=new Properties();
		pobj.load(fis);
		
		//step 3:read the data
		String URL = pobj.getProperty("username");
		
		//Verification
		System.out.println(URL);
	}

}
