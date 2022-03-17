package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateLeadInfo {
	
	//initialization
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement headerTxt;
	
	//declaration using constructor
	public CreateLeadInfo(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization using getters
	public WebElement getHeaderTxt() {
		return headerTxt;
	}
	
	//business library
	public String verifyHeader()
	{
		String header = headerTxt.getText();
		return header;
	}

}
