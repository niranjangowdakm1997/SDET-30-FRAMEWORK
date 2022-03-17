package com.crm.ContactsTests;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.CreateContactInfo;
import com.crm.ObjectRepository.CreateContactPage;
import com.crm.ObjectRepository.CreateContactWithOrganizationnamePage;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crn.GenericLibrary.ExcelFileUtility;
import com.crn.GenericLibrary.JavaUtility;
import com.crn.GenericLibrary.PropertyFileUtility;
import com.crn.GenericLibrary.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ContactslinksWithOrganizationname {
	
		@Test
		public void createContactWithOrgTest() throws Throwable
		{
			WebDriverManager.chromedriver().setup();
			WebDriverManager.firefoxdriver().setup();
			
			//To read the data from generic library
			WebDriverUtility wlib=new WebDriverUtility();
			ExcelFileUtility elib=new ExcelFileUtility();
			PropertyFileUtility plib=new PropertyFileUtility();
			JavaUtility jlib=new JavaUtility();
			
		    int ran = jlib.getRandomNumber();
		    String BROWSER =plib.readDataFrompropertyFile("browser");
		    String URL=plib.readDataFrompropertyFile("url");
		    String USERNAME =plib.readDataFrompropertyFile("username");
		    String PASSWORD =plib.readDataFrompropertyFile("password");
		    
			//read data from excel sheet
			String Orgname = elib.readDataFromExcel("Contacts",1,2);
			String lastname=elib.readDataFromExcel("Contacts",1,1);
			
			
			/*Step 2: launch the browser*/
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
			
			/*Step 3: login to application*/
			LoginPage lp=new LoginPage(driver);
			lp.loginToApp(USERNAME, PASSWORD);
			
			/*Step 4: Navigate to Organizations Link*/
			HomePage hp=new HomePage(driver);
			hp.Clickorganizationlnk();
			
			
			/*Step 5: click on create organization btn*/
			CreateOrganizationPage cop=new CreateOrganizationPage(driver);
			cop.sendkeyInOrgname(Orgname);
			
			/*Step 7:verify for orgaqnization*/
			
			CreateContactInfo ccp=new CreateContactInfo(driver);
			String header = ccp.ContactInfoTxt();
			if(header.contains(Orgname))
			{
				System.out.println(header);
				System.out.println("org created");
			}
			else
			{
				System.out.println(header);
				System.out.println("Org not created");
			}
			
			/*step 8: navigate to contacts link*/
			CreateContactPage ccp1=new CreateContactPage(driver);
			ccp1.SendkeyLastname(lastname);
	        
			
			CreateContactWithOrganizationnamePage ccop=new CreateContactWithOrganizationnamePage(driver);
			ccop.createcontact(driver, lastname, Orgname);
			/*Step 10: verify for contact*/
			CreateContactInfo cci=new CreateContactInfo(driver);
			String contactHeader = cci.ContactInfoTxt();
			if(contactHeader.contains(lastname))
			{
				System.out.println(contactHeader);
				System.out.println(" contact created");
			}
			else
			{
				System.out.println("contact not created");
			}
			
			/*Step 11: logout and close the browser*/
			hp.signoutOfApp(driver);
			driver.quit();
			
	}

}
