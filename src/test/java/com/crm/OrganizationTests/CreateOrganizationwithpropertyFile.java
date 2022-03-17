package com.crm.OrganizationTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crn.GenericLibrary.ExcelFileUtility;
import com.crn.GenericLibrary.JavaUtility;
import com.crn.GenericLibrary.PropertyFileUtility;
import com.crn.GenericLibrary.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationwithpropertyFile {
	@Test
	
	public void createOrganizationwithpropertyFile() throws Throwable
	{
		
		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
		
		WebDriverUtility wlib=new WebDriverUtility();
		ExcelFileUtility elib=new ExcelFileUtility();
		PropertyFileUtility plib=new PropertyFileUtility();
		JavaUtility jlib=new JavaUtility();
		
	    String BROWSER = plib.readDataFrompropertyFile("browser");
		String URL = plib.readDataFrompropertyFile("url");
		String USERNAME = plib.readDataFrompropertyFile("username");
		String PASSWORD = plib.readDataFrompropertyFile("password");
		
		//step 2: launch browserk
		WebDriver driver=null;
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("invalid browser");
		}
		
		wlib.maximizeWindow(driver);
		wlib.waitForPageLoad(driver);
		driver.get(URL);
		
		//step 3: login to application
				driver.findElement(By.name("user_name")).sendKeys("admin");
				driver.findElement(By.name("user_password")).sendKeys("admin");
				driver.findElement(By.id("submitButton")).click();
				
				//Stp 4: navigate organization link
				driver.findElement(By.linkText("Organizations")).click();
				
				//step 5: click on create organization link
				driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
				
				//step 6: create org with mandatory fields
				driver.findElement(By.name("accountname")).sendKeys("ALL STATES");
				
				//STEP 7:click on save
				driver.findElement(By.name("button")).click();
				driver.quit();
		}

}
