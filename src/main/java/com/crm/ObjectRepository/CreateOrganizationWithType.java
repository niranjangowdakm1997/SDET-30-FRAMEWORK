package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crn.GenericLibrary.WebDriverUtility;

public class CreateOrganizationWithType extends WebDriverUtility {
	
	//Declaration using @FindBy
	@FindBy(name="accountname")
    private WebElement orgNametxt;
	
	@FindBy(name="industry")
	private WebElement orgWithIndtype;
	
	@FindBy(name="accounttype")
	private WebElement typeDropDown;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//initialization with constructor
	public CreateOrganizationWithType(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	//Utilization of methods using getters
	public WebElement getOrgNametxt() {
		return orgNametxt;
	}
	public WebElement getorgWithIndtype()
	{
	    return orgWithIndtype;
	}

	public WebElement getTypeDropDown() {
		return typeDropDown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//Business libraries to perform actions
	public void OrgNametxt(String orgName)
	{
		orgNametxt.sendKeys(orgName);
	}
	public void indTypeDropDown(String indType)
	{
		selectByValue(orgWithIndtype, indType);
		
	}
	public void typeDropdown(String typeName)
	{
		
		selectByValue(typeDropDown, typeName);
		saveBtn.click();
		
	}
}
