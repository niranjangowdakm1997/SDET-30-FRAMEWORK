package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crn.GenericLibrary.WebDriverUtility;

public class CreateContactWithOrganizationnamePage extends WebDriverUtility
{
    //declaration using FindBy methods
	@FindBy(name="lastname")
	private WebElement lastnametxt;
	
	@FindBy(xpath="//img[@language='javascript']")
	private WebElement organizationnameImg;
	
	@FindBy(name="search_text")
	private WebElement searchtxt;
	
	@FindBy(name="search")
	private WebElement searchBtn;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//Initialization using Constructor
	public CreateContactWithOrganizationnamePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	
	//Utilization using Getters
	public WebElement getLastnametxt() {
		return lastnametxt;
	}

	public WebElement getOrganizationnameImg() {
		return organizationnameImg;
	}

	public WebElement getSearchtxt() {
		return searchtxt;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	public WebElement getSaveBtn() 
	{
		return saveBtn;
	}

	//Generic library to create contact and orgname and switching windows
	
	public void createcontact( WebDriver driver, String lastname,String orgName)
	{
		lastnametxt.sendKeys(lastname);
		organizationnameImg.click();
		switchToWindows(driver,"Accounts&action");
		searchtxt.sendKeys(orgName);
		searchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		switchToWindows(driver, "Contacts&action");
		saveBtn.click();
		
	}
	
}
