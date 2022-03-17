package TestNGUsingAnnotations;

import org.testng.annotations.Test;

import com.crm.ObjectRepository.CreateLeadPage;
import com.crm.ObjectRepository.HomePage;
import com.crn.GenericLibrary.BaseClass;

public class LeadByAdvanceSearch extends BaseClass {
	
    @Test
	
	public void searchleadByAdvancesearch() throws Throwable
	{
		
	    String leadname = elib.readDataFromExcel("Leads",2,2);
	    String campname = elib.readDataFromExcel("Leads",2,3);
	    
	    String lastname=elib.readDataFromExcel("Leads",2,4);
	    String equal=elib.readDataFromExcel("Leads",2,5);
	
		HomePage hp=new HomePage(driver);
		hp.ClickLeadslnk();
		
		CreateLeadPage clp=new CreateLeadPage(driver);
	    clp.clickonCreateImg();
		clp.sendKeysLastname(lastname);
		clp.sendKeysCompany(campname);
		clp.clickOnSaveBtn();
		
		hp.ClickLeadslnk();
		clp.clickonAdvanceSearch();
		clp.sendkeysOnSalandNoneandSnd(campname, equal, lastname);
		
	}
    
   

}
