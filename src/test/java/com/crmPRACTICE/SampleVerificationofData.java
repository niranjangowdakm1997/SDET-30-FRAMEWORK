package com.crmPRACTICE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleVerificationofData {
	
	@Test
	
	public void SampleVerificationofData() throws SQLException
	{
		     String actudata = "Niranjan";
		       //step 1: register the database
				Driver driverref= new Driver();
				DriverManager.registerDriver(driverref);
				
				//Step 2: get connector from database-provide database name
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
				
				//issue create statement
				Statement state = con.createStatement();
				
				//step 4: execute query provide table name
				ResultSet result = state.executeQuery("select * from student;");
				
				while(result.next())
				{
				   String expdata = result.getString(2);
				   if(expdata.equalsIgnoreCase(actudata))
				   {
					   System.out.println(actudata+"   data verified");
					   break;
				   }
		
			 }
				
				//step 5: close the database
				con.close();
	}

}
