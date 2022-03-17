package com.crm.ProductsTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.CreateCampaignPage;
import com.crm.ObjectRepository.CreateProductInfo;
import com.crm.ObjectRepository.CreateProductPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crn.GenericLibrary.ExcelFileUtility;
import com.crn.GenericLibrary.JavaUtility;
import com.crn.GenericLibrary.PropertyFileUtility;
import com.crn.GenericLibrary.WebDriverUtility;
import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProductswithCampaign {
	
	@Test
	
	public void createproductwithCampaign() throws Throwable
	{
		
		//step 1: launch the browser
		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
		
		WebDriverUtility wlib=new WebDriverUtility();
		ExcelFileUtility elib=new ExcelFileUtility();
		PropertyFileUtility plib=new PropertyFileUtility();
		JavaUtility jlib=new JavaUtility();
	    
	    String BROWSER =plib.readDataFrompropertyFile("browser");
	    String URL=plib.readDataFrompropertyFile("url");
	    String USERNAME =plib.readDataFrompropertyFile("username");
	    String PASSWORD =plib.readDataFrompropertyFile("password");
	    
	    String proname = elib.readDataFromExcel("Products",4,2);
	    String campname = elib.readDataFromExcel("Products",4,3);
	    
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
		hp.Clickproductslnk();
		
		CreateProductPage cp=new CreateProductPage(driver);
		cp.createproductImg();
		cp.productNmaeTxt(proname);
		
		CreateCampaignPage cCp=new CreateCampaignPage(driver);
		cCp.clickOnMorelnk(driver);
		cCp.clickOnCampaignlnk(driver);
		cCp.clickonCreatecampaignImg();
		cCp.sendKeyCampaign(campname);
		cCp.clickOnProductImg(driver,proname);
		driver.findElement(By.xpath("//a[text()='"+proname+"']")).click();
		cCp.clickonSaveBtn();
		
		hp.signoutOfApp(driver); 
		driver.quit();
		
	}
	

}
