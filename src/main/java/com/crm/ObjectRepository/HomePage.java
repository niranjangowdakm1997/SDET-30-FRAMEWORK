package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crn.GenericLibrary.WebDriverUtility;

public class HomePage extends WebDriverUtility
{
	
   //declaration using @findBy annotation
	
	@FindBy(xpath = "//a[text()='Leads']")
	private WebElement leadslnk;
	
	@FindBy(linkText = "Organizations")
	private WebElement organizationlnk;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactslnk;
	
	@FindBy(linkText = "Opportunities")
	private WebElement opportunitieslnk;
	
	@FindBy(linkText = "Products")
	private WebElement productslnk;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorlnk;
	
	@FindBy(xpath = "//a[@href='index.php?module=Users&action=Logout']")
	private WebElement signoutlnk;
	
    //initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	//generate getters
	
	public WebElement getLeadslnk() {
		return leadslnk;
	}
	public WebElement getOrganizationlnk() {
		return organizationlnk;
	}

	public WebElement getContactslnk() {
		return contactslnk;
	}

	public WebElement getOpportunitieslnk() {
		return opportunitieslnk;
	}

	public WebElement getProductslnk() {
		return productslnk;
	}

	public WebElement getAdministratorlnk() {
		return administratorlnk;
	}

	public WebElement getSignoutlnk() {
		return signoutlnk;
	}
	
	//business library
	public void ClickLeadslnk()
	{
		leadslnk.click();
	}
	public void Clickorganizationlnk()
	{
		organizationlnk.click();
	}
	public void Clickcontactalnk()
	{
		contactslnk.click();
	}
	public void Clickopportunities()
	{
		opportunitieslnk.click();
	}
	public void Clickproductslnk()
	{
		productslnk.click();
	}
	public void Clickadministratorlnk()
	{
		administratorlnk.click();
	}
	public void signoutOfApp(WebDriver driver)
	{
		mouseHoverAction(driver,administratorlnk);
		signoutlnk.click();
	}
	
}
