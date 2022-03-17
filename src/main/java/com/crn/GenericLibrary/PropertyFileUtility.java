package com.crn.GenericLibrary;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * this class will read the data from property file and return it to user
 * @author User
 *
 */

public class PropertyFileUtility {
	
	/**
	 * This method will read the data from property file for the key given by user
	 * and return value to user
	 * @param
	 * @return
	 * @throws Throwable 
	 * 
	 */
	
	public String readDataFrompropertyFile(String key) throws Throwable
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData");
		Properties plib = new Properties();
		plib.load(fis);
		String value = plib.getProperty(key);
	    return value;
	   
	}

}
