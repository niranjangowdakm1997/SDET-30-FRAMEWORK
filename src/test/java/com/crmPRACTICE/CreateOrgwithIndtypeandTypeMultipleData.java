package com.crmPRACTICE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.CreateOrganizationWithType;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganizationImgPage;
import com.crm.ObjectRepository.OrganizationInfo;
import com.crn.GenericLibrary.ExcelFileUtility;
import com.crn.GenericLibrary.JavaUtility;
import com.crn.GenericLibrary.PropertyFileUtility;
import com.crn.GenericLibrary.WebDriverUtility;

public class CreateOrgwithIndtypeandTypeMultipleData {
	//Create Object for all utilities
		PropertyFileUtility plib = new PropertyFileUtility();
		ExcelFileUtility elib = new ExcelFileUtility();
		WebDriverUtility wlib = new WebDriverUtility();
		JavaUtility jlib = new JavaUtility();
		
	
	@Test(dataProvider="OrgtestData")
	
	public void createOrgWithIndtypeandTypemultipleData(String orgName,String indType,String typeName) throws Throwable
	{
		String BROWSER = plib.readDataFrompropertyFile("browser");
		String URL = plib.readDataFrompropertyFile("url");
		String USERNAME= plib.readDataFrompropertyFile("username");
		String PASSWORD= plib.readDataFrompropertyFile("password");
		
		String orgname = orgName+jlib.getRandomNumber();
		
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
		
		//navigate to organization
		HomePage hp = new HomePage(driver);
		hp.Clickorganizationlnk();
		Reporter.log("navigated to org link",true);
		
		//create Org
		CreateOrganizationPage cop= new CreateOrganizationPage(driver);
		
		Reporter.log("click on create org link",true);
		
		//create new org
		OrganizationImgPage oip=new OrganizationImgPage(driver);
		oip.clickOrgImg();
		
	   CreateOrganizationWithType cot=new CreateOrganizationWithType(driver);
	   cot.OrgNametxt(orgname);
	   cot.indTypeDropDown(indType);
	   cot.typeDropdown(typeName);
		Reporter.log("create org with insustry type",true);
		
		//validate
		OrganizationInfo oi = new OrganizationInfo(driver);
		String actHeader = oi.orgNameInfo();
		
		if (actHeader.contains(orgname))
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
	
	@DataProvider(name = "OrgtestData")
	public Object[][] getData() throws Throwable 
	{
	   Object[][] data = elib.readmultipleDataFromExcel("OrgMultipleData");
	   return data;
		
	}

}


