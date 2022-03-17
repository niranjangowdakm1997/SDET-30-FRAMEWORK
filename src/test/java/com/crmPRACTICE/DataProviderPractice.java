package com.crmPRACTICE;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
	
	@Test(dataProvider="getData")
	
	public void sampleDataProvider(String Name,String Model,int Number)
	{
		System.out.println(Name+"..."+Model+"..."+Number+"");
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] obj = new Object[4][3];
		
		obj[0][0]="vivo";
		obj[0][1]="Z1 PRO";
		obj[0][2]=25;
		
		obj[1][0]="Lenovo";
		obj[1][1]="VIBE K5";
		obj[1][2]=30;
		
		obj[2][0]="Micromax";
		obj[2][1]="Zen";
		obj[2][2]=15;
		
		obj[3][0]="Redmi";
		obj[3][1]="Not 5 Pro";
		obj[3][2]=0;
		
		return obj;
	}
	
    @Test(dataProvider="getData1")
	
	public void sampleDataProvider62(String Name,String Model)
	{
		System.out.println(Name+"..."+Model+"...");
	}
	
	@DataProvider
	public Object[][] getData1()
	{
		Object[][] obj = new Object[6][2];
		
		obj[0][0]="Oppo";
		obj[0][1]="Z1 PRO";
		
		obj[1][0]="Poco";
		obj[1][1]="VIBE K5";
		
		obj[2][0]="Apple";
		obj[2][1]="Zen";
		
		obj[3][0]="xiomi";
		obj[3][1]="Note 5 Pro";
		
		obj[4][0]="Samsung";
		obj[4][1]="Note 5";
		
		obj[5][0]="Panasonic";
		obj[5][1]="6 Pro";
		
		
		return obj;
	}

}