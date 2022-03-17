package com.crm.OrganizationTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.CreateOrganizationWithType;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganizationImgPage;
import com.crn.GenericLibrary.ExcelFileUtility;
import com.crn.GenericLibrary.JavaUtility;
import com.crn.GenericLibrary.PropertyFileUtility;
import com.crn.GenericLibrary.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationWthType{
 
	@Test
	
	public void createOrganizationWithType() throws Throwable
	{
		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
		
		WebDriverUtility wlib=new WebDriverUtility();
		ExcelFileUtility elib=new ExcelFileUtility();
		PropertyFileUtility plib=new PropertyFileUtility();
		JavaUtility jlib=new JavaUtility();
	    
	    //step 3:read the data
	    String BROWSER =plib.readDataFrompropertyFile("browser");
	    String URL =plib.readDataFrompropertyFile("url");
	    String USERNAME =plib.readDataFrompropertyFile("username");
	    String PASSWORD =plib.readDataFrompropertyFile("password");
	    
	    //read the data from excel
	    String orgname = elib.readDataFromExcel("Org",1,2)+jlib.getRandomNumber();
	    
	    String type = elib.readDataFromExcel("Contacts",1,4);
	    
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
	    
	    LoginPage lp=new LoginPage(driver);
		lp.loginToApp("admin","admin"); 
		
		HomePage hp=new HomePage(driver);
		hp.Clickorganizationlnk();
		
		OrganizationImgPage oip=new OrganizationImgPage(driver);
		oip.clickOrgImg();
		
		CreateOrganizationWithType cop=new CreateOrganizationWithType(driver);
		cop.OrgNametxt(orgname);
		cop.typeDropdown(type);
		 
		 hp.signoutOfApp(driver);
		 driver.quit();
	}
}
