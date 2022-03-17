package com.crmPRACTICE;

import org.testng.annotations.Test;

import com.crn.GenericLibrary.JavaUtility;
import com.crn.GenericLibrary.PropertyFileUtility;

public class PracticeForGenericUtils {
	
	@Test
	
	public void practiceforgenericutils() throws Throwable
	{
		JavaUtility jlib=new JavaUtility();
		int ran = jlib.getRandomNumber();
		String da =jlib.getSystemDateInFormate();
		System.out.println(ran+""+"\t"+da);
		
		String ss=jlib.getSystemDate();
		System.out.println(ss);
		
		PropertyFileUtility plib=new PropertyFileUtility();
		String brow = plib.readDataFrompropertyFile("browser");
		System.out.println(brow);
	}

}
