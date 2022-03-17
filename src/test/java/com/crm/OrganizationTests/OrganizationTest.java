package com.crm.OrganizationTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganizationImgPage;
import com.crn.GenericLibrary.ExcelFileUtility;
import com.crn.GenericLibrary.JavaUtility;
import com.crn.GenericLibrary.PropertyFileUtility;
import com.crn.GenericLibrary.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrganizationTest {

	@Test
	
	public void organizationTest() throws Throwable 
	{
		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
		
		WebDriverUtility wlib=new WebDriverUtility();
		ExcelFileUtility elib=new ExcelFileUtility();
		PropertyFileUtility plib=new PropertyFileUtility();
		JavaUtility jlib=new JavaUtility();
	    
	    //step 3:read the data
	    String BROWSER =plib.readDataFrompropertyFile("browser");
	    String URL=plib.readDataFrompropertyFile("url");
	    String USERNAME =plib.readDataFrompropertyFile("username");
	    String PASSWORD =plib.readDataFrompropertyFile("password");
	    
	    //read the data from excel
	  String orgName = elib.readDataFromExcel("Org",1,2)+jlib.getRandomNumber();
	   
	    //step 4: launch the browser
	     WebDriver driver=null;
	    if(BROWSER.equalsIgnoreCase("chrome"))
	    {
	    	driver= new ChromeDriver();
	    }
	    else if(BROWSER.equalsIgnoreCase("firefox"))
	    {
	    	driver= new FirefoxDriver();
	    }
	    else
	    {
	    	System.out.println("invalid browser");
	    }
	    
	    wlib.waitForPageLoad(driver);
	    wlib.maximizeWindow(driver);
	    driver.get(URL);
	    
	  //step 2: login to application
	  		LoginPage lp=new LoginPage(driver);
	  		lp.loginToApp("admin","admin");
	  		
	  		//Stp 3: navigate organization link
	  		HomePage hp=new HomePage(driver);
	  		hp.Clickorganizationlnk();
		
	  		OrganizationImgPage op=new OrganizationImgPage(driver);
			op.clickOrgImg();
		
			CreateOrganizationPage cp=new CreateOrganizationPage(driver);
			cp.sendkeyInOrgname(orgName);
			
			//STEP 6:click on save
		    hp.signoutOfApp(driver);
			driver.quit();
	    
	    
	}
	
}
