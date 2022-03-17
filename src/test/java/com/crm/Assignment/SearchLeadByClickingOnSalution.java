package com.crm.Assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.CreateLeadPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crn.GenericLibrary.ExcelFileUtility;
import com.crn.GenericLibrary.JavaUtility;
import com.crn.GenericLibrary.PropertyFileUtility;
import com.crn.GenericLibrary.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchLeadByClickingOnSalution {
	
	@Test
	
	public void searchLeadByClickingOnSalution() throws Throwable
	{
		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
		
		//To read the data from generic library
		WebDriverUtility wlib=new WebDriverUtility();
		ExcelFileUtility elib=new ExcelFileUtility();
		PropertyFileUtility plib=new PropertyFileUtility();
		JavaUtility jlib=new JavaUtility();
	    
	    String BROWSER =plib.readDataFrompropertyFile("browser");
	    String URL=plib.readDataFrompropertyFile("url");
	    String USERNAME =plib.readDataFrompropertyFile("username");
	    String PASSWORD =plib.readDataFrompropertyFile("password");
	    
	    
	    String compname = elib.readDataFromExcel("Leads",2,2);
	    
	    
	    String last=elib.readDataFromExcel("Leads",1,4);
	    String Lastname=elib.readDataFromExcel("Leads",2,3);	    
	    
	    String Equal=elib.readDataFromExcel("Leads",2,5);
	   	    
	    WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("invalid browser");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(URL);
		
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		HomePage hp=new HomePage(driver);
		hp.ClickLeadslnk();
		
		CreateLeadPage clp=new CreateLeadPage(driver);
		clp.clickonCreateImg();
		clp.sendKeysLastname(Lastname);
		clp.sendKeysCompany(compname);
		clp.clickOnSaveBtn();
		
		hp.ClickLeadslnk();
		clp.clickonAdvanceSearch();

		clp.sendkeysOnSalandNoneandSnd(last, Equal, Lastname);
		
		
		hp.signoutOfApp(driver);
		

       }
}
