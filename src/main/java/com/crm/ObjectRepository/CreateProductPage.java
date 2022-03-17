package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crn.GenericLibrary.WebDriverUtility;

public class CreateProductPage extends WebDriverUtility{
	
	//Declaration using @FindBy methods 
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createproductImg;
	
	@FindBy(xpath="//input[@type='text' and @name='productname']")
	private WebElement productNameTxt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//initialization using Constructor
	public CreateProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization using getters
	public WebElement getCreatProductImg() {
		return createproductImg;
	}

	public WebElement getProductNameTxt() {
		return productNameTxt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//Business Library
	
	public void createproductImg()
	{
		createproductImg.click();
	}
	public void productNmaeTxt(String proname)
	{
		productNameTxt.sendKeys(proname);
		saveBtn.click();
	}
	
	

}
