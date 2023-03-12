package com.crm.Assignment;

import org.openqa.selenium.WebDriver;
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

public class SearchLeadByAdvanceSearch {
	
	@Test
	
	public void searchleadByAdvancesearch() throws Throwable
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
	    
	    String leadname = elib.readDataFromExcel("Leads",2,2);
	    String campname = elib.readDataFromExcel("Leads",2,3);
	    
	    String lastname=elib.readDataFromExcel("Leads",2,4);
	    String equal=elib.readDataFromExcel("Leads",2,5);
	   	    
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
		
		wlib.maximizeWindow(driver);
		wlib.waitForPageLoad(driver);
		driver.get(URL);
		
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
	
		HomePage hp=new HomePage(driver);
		hp.ClickLeadslnk();
		
		CreateLeadPage clp=new CreateLeadPage(driver);
	    clp.clickonCreateImg();
		clp.sendKeysLastname(lastname);
		clp.sendKeysCompany(campname);
		clp.clickOnSaveBtn();
		
		hp.ClickLeadslnk();
		clp.clickonAdvanceSearch();
		clp.sendkeysOnSalandNoneandSnd(campname, equal, lastname);
		
		hp.signoutOfApp(driver);
		
	}

}
