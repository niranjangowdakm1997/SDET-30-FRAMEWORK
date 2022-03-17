package com.crn.GenericLibrary;

import java.util.Date;
import java.util.Random;

/**
 * 
 * @author Niranjan
 *
 */

public class JavaUtility {
	
	/**
	 * This method will generate random number and return it to user
	 * @author Niranjan
	 * 
	 */
	
	public int getRandomNumber()
	{
		Random ran=new Random();
		int random = ran.nextInt(300);
		return random;
	}
	
	/**
	 * This method will generate current system date and return it to user
	 * @author User
	 * 
	 */
	public  String getSystemDate()
	{
		Date date=new Date();
		String d1 = date.toString();
		return d1;
	}
	
	public String getSystemDateInFormate()
	{
		Date date=new Date();
		String d1 = date.toString();
        String[] d2 = d1.split(" ");
		
		String mon = d2[1];
		String day = d2[2];
		String time= d2[3].replace(":","-");
		String year= d2[5];
		
		String Dateformate =day+" - "+mon+" - "+year+" - "+time;
		return Dateformate;
		
 	}

}
