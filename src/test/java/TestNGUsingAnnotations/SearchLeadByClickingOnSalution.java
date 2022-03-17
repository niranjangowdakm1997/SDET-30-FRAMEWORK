package TestNGUsingAnnotations;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.CreateLeadPage;
import com.crm.ObjectRepository.HomePage;
import com.crn.GenericLibrary.BaseClass;


public class SearchLeadByClickingOnSalution extends BaseClass {
	
    @Test(groups = "regression suite")
	
	public void searchLeadByClickingOnSalution() throws Throwable
	{
		
	    
	    String compname = elib.readDataFromExcel("Leads",2,2);
	    
	    String last=elib.readDataFromExcel("Leads",1,4);
	    String Lastname=elib.readDataFromExcel("Leads",2,3);	    
	    
	    String Equal=elib.readDataFromExcel("Leads",2,5);
	   	    
		HomePage hp=new HomePage(driver);
		hp.ClickLeadslnk();
		
		
		CreateLeadPage clp=new CreateLeadPage(driver);
		clp.clickonCreateImg();
		clp.sendKeysLastname(Lastname);
		clp.sendKeysCompany(compname);
		clp.clickOnSaveBtn();
		Reporter.log("lead created with lastname"); 
		
		hp.ClickLeadslnk();
		clp.clickonAdvanceSearch();

		clp.sendkeysOnSalandNoneandSnd(last, Equal, Lastname);
		Reporter.log("lead as been successfully found");
		

       }
    
    

}
