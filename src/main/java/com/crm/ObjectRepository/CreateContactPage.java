package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {
	
	//usage of FindBy
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createContactImg;
	
	@FindBy(name="lastname")
	private WebElement lastNameTxt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveOrganization;
	
	
	//initialization
	public CreateContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	//usage of getters
	public WebElement getCreateContactImg() {
		return createContactImg;
	}

	public WebElement getLastNameTxt() {
		return lastNameTxt;
	}
	
	public WebElement getsaveOrganization()
	{
	
		return saveOrganization;
	}
	
	//Utilization
	public void ClickOnCreateContact()
	{
		createContactImg.click();
	}
	
	public void SendkeyLastname(String lastname)
	{
		lastNameTxt.sendKeys(lastname);
		saveOrganization.click();
	}

}
