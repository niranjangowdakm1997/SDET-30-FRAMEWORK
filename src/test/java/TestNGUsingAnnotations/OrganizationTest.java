package TestNGUsingAnnotations;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OrganizationImgPage;
import com.crm.ObjectRepository.OrganizationInfo;
import com.crn.GenericLibrary.BaseClass;

@Listeners(com.crn.GenericLibrary.ITestListenerImplementationClass.class)

public class OrganizationTest extends BaseClass {
	
    @Test(groups = "smoke suite")
	
	public void organizationTest() throws Throwable 
	{
		
	    //read the data from excel
	  String orgName = elib.readDataFromExcel("Org",1,2)+jlib.getRandomNumber();
	   
	  		//navigate organization link
	  		HomePage hp=new HomePage(driver);
	  		hp.Clickorganizationlnk();
		
	  		OrganizationImgPage op=new OrganizationImgPage(driver);
			op.clickOrgImg();
	
			Assert.fail();
			
			CreateOrganizationPage cp=new CreateOrganizationPage(driver);
			cp.sendkeyInOrgname(orgName);
			
	        OrganizationInfo oi=new OrganizationInfo(driver);
	        String header = oi.orgNameInfo();
			if(header.contains(orgName))
			{
				System.out.println(header);
				System.out.println("org created");
			}
			else
			{
				System.out.println(header);
				System.out.println("Org not created");
			}
			
		
	}

   
}
