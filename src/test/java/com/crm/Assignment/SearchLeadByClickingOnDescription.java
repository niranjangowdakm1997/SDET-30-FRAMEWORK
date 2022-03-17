package com.crm.Assignment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crn.GenericLibrary.ExcelFileUtility;
import com.crn.GenericLibrary.JavaUtility;
import com.crn.GenericLibrary.PropertyFileUtility;
import com.crn.GenericLibrary.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchLeadByClickingOnDescription {
	
	@Test
	
	public void searchLeadByClickingOnDescription() throws Throwable
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
	    
	    
	    String lastname = elib.readDataFromExcel("Leads",2,2);
	    	    
	    String compname=elib.readDataFromExcel("Leads",2,3);
	    String last=elib.readDataFromExcel("Leads",1,4);
	   
	    String laname=elib.readDataFromExcel("Leads",2,4);
	    String Equal=elib.readDataFromExcel("Leads",2,5);
	   
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
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		driver.findElement(By.name("company")).sendKeys(compname);
		driver.findElement(By.name("button")).click();
		
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		driver.findElement(By.xpath("//a[text()='Go to Advanced Search']")).click();
		
		driver.findElement(By.xpath("//td[@class='dvtCellLabel']")).click();
		
		WebElement nn = driver.findElement(By.name("fcol0"));
		nn.sendKeys(laname);
		
		WebElement ss = driver.findElement(By.name("fop0"));
		ss.sendKeys(Equal);
		
		driver.findElement(By.name("fval0")).sendKeys("Test yantra");
        driver.findElement(By.xpath("(//input[@type='button' and @class='crmbutton small create' and @value=' Search Now '])[2]")).click();
        
        driver.findElement(By.xpath("//a[@title='Leads']")).click();
        
        WebElement nn1=driver.findElement(By.xpath("//div[@style='float:left;']"));
        wlib.scrollAction(driver,nn1);
        
        WebElement gg= driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wlib.mouseHoverAction(driver, gg);
		
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}

}
