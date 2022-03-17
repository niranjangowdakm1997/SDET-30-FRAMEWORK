package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crn.GenericLibrary.WebDriverUtility;

public class OrganizationInfo extends WebDriverUtility
{
    
	 //Use of FindBy method
	@FindBy(xpath ="//span[@class='dvHeaderText']")
	private WebElement headerTxt;
	
	 //initialization
	public  OrganizationInfo(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	 //Use of getters and utilization
	public WebElement getHeaderTxt() 
	{
		return headerTxt;
	}
	
	 //Business Library
	public String orgNameInfo()
	{
		String orgInfo = headerTxt.getText();
		return orgInfo;
	}
	
}
