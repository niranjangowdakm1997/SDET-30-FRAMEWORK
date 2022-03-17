package com.crn.GenericLibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;

import com.mysql.cj.jdbc.Driver;

/**
 * 
 * This method contains generic method to read the data from database
 * @author User
 *
 */
     
public class DataBaseUtility {
	
	/**
	 * 
	 * This method will register the driver and establish the connection with DB
	 * @param driver
	 * @param url
	 * @throws Throwable
	 */
	Connection con=null;
	
	public void connectToDataBase() throws Throwable
	{
		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);
		con = DriverManager.getConnection(IPathConstants.dbUrl,IPathConstants.dbUserName,IPathConstants.dbPassword);
		
	}
	/**
	 * 
	 * This method used to close the dataBase
	 * @throws Throwable
	 */
	public void closeDB() throws Throwable
	{
	   con.close();
	}
	
	/**
	 * 
	 * This method used to execute the query and get the data
	 * @throws Throwable 
	 */
	
	public String executeQueryandGetData(String query,int clolumnIndex,String expData) throws Throwable
	{
		String data=null;
		boolean flag=false;
		ResultSet st = con.createStatement().executeQuery(query);
		while(st.next())
		{
			data=st.getString(clolumnIndex);
			if(data.equalsIgnoreCase(expData))
			{
				flag=true;
				break;
			}
		}
		if(flag==true)
		{
			System.out.println(data+"  data is verified");
			return expData;
		}
		else
		{
		  System.out.println("data is not verified");
		  return "";
		}
		}
		
	}
	


