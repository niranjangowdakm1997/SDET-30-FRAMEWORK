package TestNGUsingAnnotations;

import org.testng.annotations.Test;

import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OrganizationImgPage;
import com.crn.GenericLibrary.BaseClass;

public class CreateOrganizationWithType extends BaseClass {

@Test
	
	public void createOrganizationWithType() throws Throwable
	{
		
	    //read the data from excel
	    String orgname = elib.readDataFromExcel("Org",1,2)+jlib.getRandomNumber();
	    
	    String type = elib.readDataFromExcel("Contacts",1,4);
		
		HomePage hp=new HomePage(driver);
		hp.Clickorganizationlnk();
		
		OrganizationImgPage oip=new OrganizationImgPage(driver);
		oip.clickOrgImg();
		
		com.crm.ObjectRepository.CreateOrganizationWithType cowt=new com.crm.ObjectRepository.CreateOrganizationWithType(driver);
		cowt.OrgNametxt(orgname);
		cowt.typeDropdown(type);
		
		 
	}

}
