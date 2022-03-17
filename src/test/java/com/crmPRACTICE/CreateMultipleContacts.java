package com.crmPRACTICE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.CreateContactInfo;
import com.crm.ObjectRepository.CreateContactPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crn.GenericLibrary.ExcelFileUtility;
import com.crn.GenericLibrary.JavaUtility;
import com.crn.GenericLibrary.PropertyFileUtility;
import com.crn.GenericLibrary.WebDriverUtility;

public class CreateMultipleContacts {
	
	       //Create Object for all utilities
			PropertyFileUtility plib = new PropertyFileUtility();
			ExcelFileUtility elib = new ExcelFileUtility();
			WebDriverUtility wlib = new WebDriverUtility();
			JavaUtility jlib = new JavaUtility();
			
	@Test(dataProvider="ContacttestData")
	
	public void createMultipleContacts(String contactName) throws Throwable
	{
		String BROWSER = plib.readDataFrompropertyFile("browser");
		String URL = plib.readDataFrompropertyFile("url");
		String USERNAME= plib.readDataFrompropertyFile("username");
		String PASSWORD= plib.readDataFrompropertyFile("password");
		
		String contactname=contactName+jlib.getRandomNumber();
		
		//launch the application
		WebDriver driver = null;
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
		
		//login to application
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		Reporter.log("login successful",true);
		
		//click on contact link
		HomePage hp=new HomePage(driver);
		hp.Clickcontactalnk();
		
		CreateContactPage ccp=new CreateContactPage(driver);
		ccp.ClickOnCreateContact();
		ccp.SendkeyLastname(contactname);
		Reporter.log("Contact Created Successfully",true);
		
		//validate
		CreateContactInfo cci=new CreateContactInfo(driver);
		String actHeader= cci.ContactInfoTxt();
		if (actHeader.contains(contactname))
		{
			System.out.println("passed");
		}
		else
		{
			System.out.println("failed");
		}
		Reporter.log("verification successful",true);		
		
		//logout
		hp.signoutOfApp(driver);
		
		driver.quit();
		
		
	}
	
	@DataProvider(name="ContacttestData")
	public Object[][] getData() throws Throwable
	{
		Object[][] data = elib.readmultipleDataFromExcel("MultipleContacts");
		return data;
	}

	

}
