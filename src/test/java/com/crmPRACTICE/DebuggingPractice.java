package com.crmPRACTICE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.LoginPage;

public class DebuggingPractice  {
	
	@Test
	
	public void debugPractice()
	{
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp("admin","admin");
		
	}
			

}
