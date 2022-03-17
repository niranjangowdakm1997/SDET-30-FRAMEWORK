  package com.crn.GenericLibrary;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class consists of all generic methods related to webDriver actions   
 * @author Niranjan
 *
 */

public class WebDriverUtility {
	/**
	 * This method will maximize the window
	 * @author Niranjan
	 * 
	 */
     public void maximizeWindow(WebDriver driver)
     {
    	 driver.manage().window().maximize();
     }
     
     /**
      * This method will wait for 20 seconds for page to load
      * @param driver
      * 
      */
     public void waitForPageLoad(WebDriver driver)
     {
    	 driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
     }
     
     /**
      * This method will wait for 10 seconds for a element to be Clickable
      * @param driver
      * @param element
      */
     
     public void elementToBeClickable(WebDriver driver,WebElement element)
     {
    	 WebDriverWait wait=new WebDriverWait(driver,10);
    	 wait.until(ExpectedConditions.elementToBeClickable(element));
     }
     
     /**
      * This method will select data from drop down using visible
      * @param value
      * @param element
      */
     public void waitForElementToBeVisible(WebDriver driver,WebElement element)
     {
    	 WebDriverWait wait=new WebDriverWait(driver,10);
    	 wait.until(ExpectedConditions.visibilityOf(element));
     }
     
     /**
      * This method will select data from dropdown using  index
      * @param value
      * @param element
      */
     public void selectByIndex(WebElement element,int index)
     {
    	 Select sel=new Select(element);
    	 sel.selectByIndex(index);
     }
     
     /**
      * This method will select data from dropdown using visible text
      * @param value
      * @param element
      */
     public void selectByText(WebElement element,String text)
     {
    	 Select sel=new Select(element);
    	 sel.selectByVisibleText(text);
     }
     
     /**
      * This method will select data from drop down using  value
      * @param value
      * @param element
      */
     
     public void selectByValue(WebElement element, String value)
     {
    	 Select sel=new Select(element);
    	 sel.selectByValue(value);
     }
     
     /**
 	 * This method will perform mouse hover action
 	 * @param driver
 	 * @param element
 	 */
     public void mouseHoverAction(WebDriver driver,WebElement element)
     {
    	 Actions act=new Actions(driver);
    	 act.moveToElement(element).perform();
     }
     
     /**
 	 * This method will perform drag and drop action
 	 * @param driver
 	 * @param src
 	 * @param target
 	 */
     public void dragDrop(WebDriver driver,WebElement src,WebElement target)
     {
    	 Actions act=new Actions(driver);
    	 act.dragAndDrop(src, target).perform();
     }
     
     /**
 	 * This method will double click on element
 	 * @param driver
 	 * @param element
 	 */
     public void doubleClickAction(WebDriver driver,WebElement element)
     {
    	 Actions act=new Actions(driver);
    	 act.doubleClick(element).perform();
     }
     
     /**
 	 * This method will double click on web page
 	 * @author Niranjan
 	 */
     public void doubleClick(WebDriver driver)
     {
    	 Actions act=new Actions(driver);
    	 act.doubleClick().perform();
     }
     
     /**
 	 * This method will right click on web page
 	 * @author Niranjan
 	 */
     public void rightClick(WebDriver driver)
     {
    	 Actions act=new Actions(driver);
    	 act.contextClick().perform();
     }
     
     /**
 	 * This method will right click on element
 	 * @author Niranjan
 	 */
 	public void righClick(WebDriver driver, WebElement element)
 	{
 		Actions act = new Actions(driver);
 		act.contextClick(element).perform();
 	}
 	
 	/**
	 * This method will press enter key
	 * @param driver
	 */
	public void enterKeyPress(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}
	
	/**
	 * this method will used to press the key
	 * @param driver
	 * @throws Throwable
	 */
	public void enterKey(WebDriver driver) throws Throwable
	{
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
	}
	/**
	 * This method will release enter key
	 * @throws Throwable
	 */
	public void enterRelease() throws Throwable
	{
		Robot rb = new Robot();
		rb.keyRelease(KeyEvent.VK_ENTER);
	}
	
	/**
	 * This method will switch the frame based on index
	 * @param driver
	 * @param index
	 */
	public void switchToWindow(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
 	
	/**
	 * This method will switch the frame based on name or Id
	 * @param driver
	 * @param nameOrId
	 */
	public void switchToWindow(WebDriver driver, String nameOrId)
	{
		driver.switchTo().frame(nameOrId);
	}
	
	/**
	 * This method will switch the frame based on address of the element
	 * @param driver
	 * @param address
	 */
	public void switchToWindow(WebDriver driver,WebElement address)
	{
		driver.switchTo().frame(address);
	}
	
	/**
	 * this method will used to switch window depending on partial window title
	 * 
	 */
	public void switchToWindows(WebDriver driver, String partialwindowtitle)
	{
		//step 1: use get window handles to capture all window
		Set<String> windows = driver.getWindowHandles();
		
		//step 2: iterate through the windows
		Iterator<String> it = windows.iterator();
		
		//step 3: check whether there is a next window
		while(it.hasNext()) 
		{
			//step 4: capture current window id
			String winid = it.next();
			
			//step 5: switch to current window and capture title
			String currentwintitle = driver.switchTo().window(winid).getTitle();
			
			//step 6: check whether the current window is captured
			if(currentwintitle.contains(partialwindowtitle))
			{
				break;
			}
		}
	}
	
	/**
	 * This method will take screenshot and store it in the Screenhot file
	 * @throws Throwable 
	 * 
	 * 
	 */
	public String getScreenshot(WebDriver driver,String screenShotName) throws Throwable
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		 String path = ".\\Screenshot\\"+screenShotName+".png";
		 File dst = new File(path);
		Files.copy(src, dst);
		return dst.getAbsolutePath();
	}
	
	/**
	 * This method will perform the random scroll action
	 * 
	 */
	public void scrollAction(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500"," ");
	}
	
	/**
	 * 
	 * this method will scroll until the specified element is found
	 * 
	 */
	public void scrollAction(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		int y = element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")",element);
		//js.executeScript("argument[0].scrollIntoView()",element);
	}
	
	/**
	 * this method will accept the alert pop up
	 * @driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * this method will dismiss the alert pop up
	 * @driver
	 */
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
}
