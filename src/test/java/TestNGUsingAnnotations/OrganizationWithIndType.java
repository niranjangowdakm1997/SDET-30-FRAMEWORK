package TestNGUsingAnnotations;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OrganizationImgPage;
import com.crm.ObjectRepository.OrganizationInfo;
import com.crn.GenericLibrary.BaseClass;

@Listeners(com.crn.GenericLibrary.ITestListenerImplementationClass.class)

public class OrganizationWithIndType  extends BaseClass {
	
   @Test(retryAnalyzer = com.crn.GenericLibrary.RetryAnalyzerImplementation.class)
	
	public void organizationWithIndustryTest() throws Throwable
	{
		      
			    //read the data from excel
			    String orgname = elib.readDataFromExcel("Org", 2,1)+jlib.getRandomNumber();
			    
			    String indtype = elib.readDataFromExcel("Contacts",1,3);
			    
			   
				HomePage hp=new HomePage(driver);
				hp.Clickorganizationlnk();
				
				OrganizationImgPage op=new OrganizationImgPage(driver);
				op.clickOrgImg();
				
			   CreateOrganizationPage cop=new CreateOrganizationPage(driver);
			   cop.sendkeyOrgWithIndtype(orgname, indtype);
			   
			   OrganizationInfo ioginfo=new OrganizationInfo(driver);
			   String actHeader = ioginfo.orgNameInfo();
			   if(actHeader.contains(orgname))
			   {
				   System.out.println(actHeader);
				   System.out.println("Organization name created");
			   }
			   else
			   {
				   System.out.println("Organization name not created");
			   }
			   
               
	}

}
