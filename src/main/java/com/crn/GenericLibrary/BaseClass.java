 package com.crn.GenericLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	
    public DataBaseUtility dblib=new DataBaseUtility();
	public PropertyFileUtility plib = new PropertyFileUtility();
	public ExcelFileUtility elib = new ExcelFileUtility();
	public WebDriverUtility wlib = new WebDriverUtility();
	public JavaUtility jlib = new JavaUtility();
	public WebDriver driver=null;
	public static WebDriver sdriver; 
	
	@BeforeSuite(groups = {"smoke suite","regression suite"})
	public void connectToDataBase() throws Throwable
	{
		//dblib.connectToDataBase();
		Reporter.log("...DB connection successfull...",true);
	}
  
	 @BeforeClass(groups = {"smoke suite","regression suite"})
	@Parameters("browser")
	//@BeforeTest
	public void launchtheBrowser() throws Throwable
	{
		//read the data from property file
		String BROWSER = plib.readDataFrompropertyFile("browser");
		String URL=plib.readDataFrompropertyFile("url");
		
		//create run time PolyMorphism
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("invalid browser");
		}
		
		sdriver=driver;
		wlib.maximizeWindow(driver);
		wlib.waitForPageLoad(driver);
		driver.get(URL);
		Reporter.log("...browser launch successfull...",true);
	}
	
	@BeforeMethod(groups = {"smoke suite","regression suite"})
		public void login() throws Throwable
		{
		    String USERNAME = plib.readDataFrompropertyFile("username");
		    String PASSWORD = plib.readDataFrompropertyFile("password");
		    
		    LoginPage lp=new LoginPage(driver);
		    lp.loginToApp(USERNAME, PASSWORD);
		    Reporter.log("...login is successfull...",true);
		
		}
	
	@AfterMethod(groups = {"smoke suite","regression suite"})
	public void logout()
	{
		HomePage hp=new HomePage(driver);
		hp.signoutOfApp(driver);
		Reporter.log("...logout is successfull...",true);
	}
	
   @AfterClass(groups = {"smoke suite","regression suite"})
	//@AfterTest
	public void closebrowser()
	{
		driver.quit();
		Reporter.log("...browser closed succesfully...",true);
	}
	
	@AfterSuite(groups = {"smoke suite","regression suite"})
	public void closedb()
	{
		//dblib.closeDB();
		Reporter.log("...database closed successfully...",true);
	}
}
