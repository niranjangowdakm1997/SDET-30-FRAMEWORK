package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crn.GenericLibrary.WebDriverUtility;

public class CreateOrganizationPage extends WebDriverUtility 
{
	
	//use of FindBy method
	@FindBy(name="accountname")
	private WebElement organizationName;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveOrganization;
	
	@FindBy(name="industry")
	private WebElement orgWithIndtype;

	//initialization

	public CreateOrganizationPage(WebDriver driver) 
	{
		PageFactory.initElements(driver,this);
	}

	//Use of Getters
	public WebElement getOrganizationName()
	{
		return organizationName;
	}

	public WebElement getSaveOrganization() 
	{
		return saveOrganization;
	}
	
	public WebElement getorgWithIndtype()
	{
	    return orgWithIndtype;
	}
	
	//Business Library
     public void sendkeyInOrgname(String orgname)
     {
    	 organizationName.sendKeys(orgname);
    	 saveOrganization.click();
     }
     
     public void sendkeyOrgWithIndtype(String orgname,String indtype)
     {
    	 organizationName.sendKeys(orgname);
    	 selectByValue(orgWithIndtype, indtype);
    	 saveOrganization.click();
     }
     
     
}
