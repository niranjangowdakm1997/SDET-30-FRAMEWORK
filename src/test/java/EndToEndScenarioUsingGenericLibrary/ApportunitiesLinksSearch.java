package EndToEndScenarioUsingGenericLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.CreateCampaignPage;
import com.crm.ObjectRepository.CreateContactPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crn.GenericLibrary.ExcelFileUtility;
import com.crn.GenericLibrary.JavaUtility;
import com.crn.GenericLibrary.PropertyFileUtility;
import com.crn.GenericLibrary.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ApportunitiesLinksSearch {
	
	@Test
	
	public void apportunitiesLinks() throws Throwable
	{
		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
		
		//To read the data from generic library
		WebDriverUtility wlib=new WebDriverUtility();
		ExcelFileUtility elib=new ExcelFileUtility();
		PropertyFileUtility plib=new PropertyFileUtility();
		JavaUtility jlib=new JavaUtility();
		
		//To read the data from Excel sheet
		String oppname= elib.readDataFromExcel("Opportunities",1,2);
		String lastname = elib.readDataFromExcel("Opportunities",1,4);
		String contname=elib.readDataFromExcel("Opportunities",1,3);
		String campname=elib.readDataFromExcel("Opportunities",1,5);
		String ename=elib.readDataFromExcel("Opportunities",1,6);
		
		//To read the data from the property file
		String BROWSER =plib.readDataFrompropertyFile("browser");
	    String URL=plib.readDataFrompropertyFile("url");
	    String USERNAME =plib.readDataFrompropertyFile("username");
	    String PASSWORD =plib.readDataFrompropertyFile("password");
	    
	    //to specify the drivers
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
	   
	    //To maximize the window
	    wlib.maximizeWindow(driver);
	    
	    //use of implicit wait
	    wlib.waitForPageLoad(driver);
	    driver.get(URL);
	    
	   //To pass the data inside user name and password and click on login
	   LoginPage lp=new LoginPage(driver);
	   lp.loginToApp(USERNAME, PASSWORD);
	   
	   //To create a contacts
	   HomePage hp=new HomePage(driver);
	   hp.Clickcontactalnk();
	   CreateContactPage ccp=new CreateContactPage(driver);
	   ccp.ClickOnCreateContact();
	   ccp.SendkeyLastname(lastname);
	  
		//To perform mouse hover action
		WebElement hh = driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
		wlib.mouseHoverAction(driver, hh);
		
		
		//To click on the Campaigns
		CreateCampaignPage ccp1=new CreateCampaignPage(driver);
		ccp1.clickOnCampaignlnk(driver);
		ccp1.clickonCreatecampaignImg();
		ccp1.sendKeyCampaign(campname);
		ccp1.clickonSaveBtn();
		
		//Click on opportunities major tab
	   hp.Clickopportunities();
		
	    //To pass data inside opportunity name
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.name("potentialname")).sendKeys(oppname);
		
		//switch to contact drop down
		WebElement ele = driver.findElement(By.name("related_to_type"));
		wlib.selectByValue(ele,contname);
	
		//Switch to contacts Window
		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		wlib.switchToWindows(driver,"Contacts&action");
		Thread.sleep(1000);
		WebElement app = driver.findElement(By.name("search_text"));
		app.sendKeys(lastname);
		
		driver.findElement(By.xpath("//a[@href='javascript:window.close();']")).click();
		driver.findElement(By.xpath("//input[@class='crmbutton small create']")).click();
		
		driver.findElement(By.name("leadsource")).click();
		WebElement kk = driver.findElement(By.name("leadsource"));
		wlib.selectByValue(kk,ename);
		
		//Switch to campaign source
		driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[2]")).click();
		
		wlib.switchToWindows(driver, "Campaigns&action=Popup&html");
		driver.findElement(By.name("search_text")).sendKeys(campname);
		
		driver.findElement(By.name("search_text")).click();
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
		//Logout the application
		hp.signoutOfApp(driver);
		driver.quit();
	}

}
