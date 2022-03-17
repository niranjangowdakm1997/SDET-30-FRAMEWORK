package TestNGUsingAnnotations;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.CreateLeadInfo;
import com.crm.ObjectRepository.CreateLeadPage;
import com.crm.ObjectRepository.HomePage;
import com.crn.GenericLibrary.BaseClass;

public class EditLeadByClickingOnEditOption extends BaseClass{
	
    @Test
	
	public void editLeadByClickingOnEditOption() throws Throwable
	{
	    
	   String leadname = elib.readDataFromExcel("Leads",2,2);
	    String lname = elib.readDataFromExcel("Leads",2,3);
		
		HomePage hp=new HomePage(driver);
		hp.ClickLeadslnk();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		CreateLeadPage clp=new CreateLeadPage(driver);
		clp.sendKeysLastname(leadname);
		clp.sendKeysCompany(lname);
		clp.clickOnSaveBtn();
		clp.clickOnEditBtn();
		
		
		CreateLeadInfo cli=new CreateLeadInfo(driver);
		String header = cli.verifyHeader();
		if(header.contains(leadname))
		{
			System.out.println("Header");
			System.out.println(leadname);
		}
		else
		{
			System.out.println("not valid name");
		}
		
		clp.clickOnSaveBtn();
		
	}

}
