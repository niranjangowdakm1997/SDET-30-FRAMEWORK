package TestNGUsingAnnotations;

import org.testng.annotations.Test;

import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OrganizationImgPage;
import com.crn.GenericLibrary.BaseClass;

public class CreateOrganization extends BaseClass {

    @Test
	
	public void createOrganizationTest() throws Throwable
	{
		
	    String orgname = elib.readDataFromExcel("Org",1,2)+jlib.getRandomNumber();
	    
        //Stp 1: navigate organization link
		HomePage hp=new HomePage(driver);
		hp.Clickorganizationlnk();
		
		//step 2: click on create organization link
		OrganizationImgPage op=new OrganizationImgPage(driver);
		op.clickOrgImg();
		
		//step 3: create org with mandatory fields
		CreateOrganizationPage cp=new CreateOrganizationPage(driver);
		cp.sendkeyInOrgname(orgname);
		
		
	}

}
