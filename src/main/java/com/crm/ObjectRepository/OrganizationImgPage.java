package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crn.GenericLibrary.WebDriverUtility;

public class OrganizationImgPage extends WebDriverUtility
{
	
	     //use of FindBy method
        @FindBy(xpath = "//img[@title='Create Organization...']")
		private WebElement createOrganizationImg;
        
        //initialization
        public OrganizationImgPage(WebDriver driver)
        {
        	PageFactory.initElements(driver,this);
		}

		
    	//Provide getters
    	public WebElement getCreateOrganization() 
    	{
    		return createOrganizationImg;
    	}

    	//Business Library
    	 public void clickOrgImg()
         {
        	 createOrganizationImg.click();
         }

}
