package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateLeadPage {
	
     //Declaration using FindBy methods
	@FindBy(xpath = "//img[@title='Create Lead...']")
	private WebElement createLeadImg;
	
	@FindBy(name="lastname")
	private WebElement lastnameTxt;
	
	@FindBy(name="company")
	private WebElement companyTxt;
	
	@FindBy(name="leadsource")
	private WebElement leadDropDown;
	
	@FindBy(name="industry")
	private WebElement industryDropdown;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
    private WebElement saveBtn;	
	
	@FindBy(xpath = "//input[@title='Edit [Alt+E]']")
	private WebElement editBtn;
	
	@FindBy(xpath = "//a[text()='Go to Advanced Search']")
	private WebElement advanceSearchBtn;
	
	@FindBy(name = "fcol0")
	private WebElement salutionDropdown;
	
	@FindBy(name = "fop0")
	private WebElement noneDropdown;
	
	@FindBy(name = "fval0")
	private WebElement sendKeysTxt;
	
	@FindBy(xpath = "(//input[@type='button' and @class='crmbutton small create'])[2]")
	private WebElement searchnowBtn;
	
	@FindBy(xpath = "//a[@title='Leads']")
	private WebElement nameSelect;
	
	//initialization using constructor
	
	public CreateLeadPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization using getters
	public WebElement getCreateLeadImg() {
		return createLeadImg;
	}

	public WebElement getLastnameTxt() {
		return lastnameTxt;
	}

	public WebElement getCompanyTxt() {
		return companyTxt;
	}

	public WebElement getLeadDropDown() {
		return leadDropDown;
	}

	public WebElement getIndustryDropdown() {
		return industryDropdown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getEditBtn() {
		return editBtn;
	}

	public WebElement getAdvanceSearchBtn() {
		return advanceSearchBtn;
	}

	public WebElement getSalutionDropdown() {
		return salutionDropdown;
	}

	public WebElement getNoneDropdown() {
		return noneDropdown;
	}

	public WebElement getSendKeysTxt() {
		return sendKeysTxt;
	}

	public WebElement getSearchnowBtn() {
		return searchnowBtn;
	}

	public WebElement getNameSelect() {
		return nameSelect;
	}
	
	//business library
	public void clickonCreateImg()
	{
		createLeadImg.click();
	}
	public void sendKeysLastname(String lastname)
	{
		lastnameTxt.sendKeys(lastname);
	}
	public void sendKeysCompany(String compname)
	{
		companyTxt.sendKeys(compname);
	}
	public void clickOnSaveBtn()
	{
		saveBtn.click();
	}
	public void clickOnEditBtn()
	{
		editBtn.click();
	}
	public void clickonAdvanceSearch()
	{
		advanceSearchBtn.click();
	}
	public void sendkeysOnSalandNoneandSnd(String salname,String equal,String lastname)
	{
		salutionDropdown.sendKeys(salname);
		noneDropdown.sendKeys(equal);
		sendKeysTxt.sendKeys(lastname);
		searchnowBtn.click();
	}

}
