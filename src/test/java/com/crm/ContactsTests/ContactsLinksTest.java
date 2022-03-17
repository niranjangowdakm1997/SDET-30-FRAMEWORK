package com.crm.ContactsTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.CreateContactPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crn.GenericLibrary.ExcelFileUtility;
import com.crn.GenericLibrary.JavaUtility;
import com.crn.GenericLibrary.PropertyFileUtility;
import com.crn.GenericLibrary.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ContactsLinksTest {
	
	@Test
	
	public void contactsLinksTest() throws Throwable
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
	    
			    //read the data from excel
			    String orgna = elib.readDataFromExcel("Contacts",1,1);
			    
			    
			    //step 4: launch the browser
			    
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
			    
			   //step 5: login to application
			    LoginPage lp=new LoginPage(driver); 
				lp.loginToApp("admin","admin");
				
				HomePage hp=new HomePage(driver);
				hp.Clickcontactalnk();
			
				CreateContactPage cp=new CreateContactPage(driver);
				cp.ClickOnCreateContact();
				cp.SendkeyLastname(orgna);
				
				//step 6: logout of the application
				hp.signoutOfApp(driver);
				driver.quit();
			    
	}

}
