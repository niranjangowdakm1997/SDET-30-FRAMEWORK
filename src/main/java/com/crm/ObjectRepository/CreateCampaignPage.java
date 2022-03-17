package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crn.GenericLibrary.WebDriverUtility;

public class CreateCampaignPage extends WebDriverUtility{
	
	
	//Declaration using FindBy
	@FindBy(xpath = "//a[@href='javascript:;']")
	private WebElement morelnk;
	
	@FindBy(xpath = "//a[text()='Campaigns']")
	private WebElement campaignlnk;
	
	@FindBy(xpath = "//img[@title='Create Campaign...']")
	private WebElement createCampImg;
	
	@FindBy(name = "campaignname")
	private WebElement campaignTxt;
	
	@FindBy(xpath ="//img[@alt='Select']")
	private WebElement productImg;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(id="search_txt")
	private WebElement searchTxt;
	
	@FindBy(name="search")
	private WebElement searchBtn;
	
	//initialization using constructor 
	
	public CreateCampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//Utilization using getters
	public WebElement getMorelnk() {
		return morelnk;
	}

	public WebElement getCampaignlnk() {
		return campaignlnk;
	}

	public WebElement getCreateCampImg() {
		return createCampImg;
	}

	public WebElement getCampaignTxt() {
		return campaignTxt;
	}

	public WebElement getProductImg() {
		return productImg;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public WebElement getSearchTxt() {
		return searchTxt;
	}
	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	
	//Business library to perform click actions
	public void clickOnMorelnk(WebDriver driver)
	{
		mouseHoverAction(driver,morelnk);
		morelnk.click();
	}
	public void clickOnCampaignlnk(WebDriver driver)
	{
		campaignlnk.click();
	}
	public void sendKeyCampaign(String campName)
	{
		campaignTxt.sendKeys(campName);
	}
	public void clickonCreatecampaignImg()
	{
		createCampImg.click();
	}
	public void clickOnProductImg(WebDriver driver,String campName)
	{
		productImg.click();
		switchToWindows(driver,"Products&action");
		searchTxt.sendKeys(campName);
		searchBtn.click();
		switchToWindows(driver,"Campaigns");
		
	}
	public void clickonSaveBtn()
	{
		saveBtn.click();
	}

}
