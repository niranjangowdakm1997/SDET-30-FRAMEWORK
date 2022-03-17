package TestNGUsingAnnotations;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.CreateCampaignPage;
import com.crm.ObjectRepository.CreateProductPage;
import com.crm.ObjectRepository.HomePage;
import com.crn.GenericLibrary.BaseClass;

public class CreateProductWithCampaign extends BaseClass {
	
   @Test
	
	public void createproductwithCampaign() throws Throwable
	{
		
	    String proname = elib.readDataFromExcel("Products",4,2)+jlib.getRandomNumber();
	    String campname = elib.readDataFromExcel("Products",4,3);
	    
	    
		HomePage hp=new HomePage(driver);
		hp.Clickproductslnk();
		
		CreateProductPage cp=new CreateProductPage(driver);
		cp.createproductImg();
		cp.productNmaeTxt(proname);
		
		CreateCampaignPage cCp=new CreateCampaignPage(driver);
		cCp.clickOnMorelnk(driver);
		cCp.clickOnCampaignlnk(driver);
		cCp.clickonCreatecampaignImg();
		cCp.sendKeyCampaign(campname);
		
		cCp.clickOnProductImg( driver,proname);
		
		driver.findElement(By.xpath("//a[text()='"+proname+"']")).click();
		
		cCp.clickonSaveBtn();
		
	}

}
