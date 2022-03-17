package com.crmPRACTICE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteupdate {
	
	@Test
	
	public void sampleJDBCExecuteupdate() throws SQLException
	{
		//step 1: register the database
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		
		//step 2: get connection from database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
		
		//step 3: issue create statement
		Statement state = con.createStatement();
		
		//step 4: execute query
		//insert into students values(5,'Harry','Male');
		
		int result = state.executeUpdate("insert into student values(5,'Harry','Male');");
		if(result==1)
		{
			System.out.println("data added succesfully");
		}
		else
		{
			System.out.println("data not added");
		}
		
		//step 5: close the database
		con.close();
		
		
	}

}
