package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crn.GenericLibrary.WebDriverUtility;

public class CreateContactInfo extends WebDriverUtility
{
	
	//Declaration of FindBy methods
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement contactinfoHeader;
	
	//initialization with constructor
	public CreateContactInfo(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization with using getters
	public WebElement getContactinfo() {
		return contactinfoHeader;
	}
	
	//business library
	public String ContactInfoTxt()
	{
		String contactinfo = contactinfoHeader.getText();
		return contactinfo;
	}
	
	
	
	

}
