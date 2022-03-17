package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crn.GenericLibrary.WebDriverUtility;

public class CreateProductInfo extends WebDriverUtility{
	
	//declaration using FindBy method
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement headerTxt;
	
	//initialization using constructor
	public CreateProductInfo(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization using getters
	public WebElement getHeaderTxt() {
		return headerTxt;
	}
	
	//Business library
	public String productHeader()
	{
		String productName = headerTxt.getText();
		return productName;
	}
	
	

}
