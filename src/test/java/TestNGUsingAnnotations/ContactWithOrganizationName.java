package TestNGUsingAnnotations;

import org.testng.annotations.Test;

import com.crm.ObjectRepository.CreateContactInfo;
import com.crm.ObjectRepository.CreateContactPage;
import com.crm.ObjectRepository.CreateContactWithOrganizationnamePage;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OrganizationImgPage;
import com.crm.ObjectRepository.OrganizationInfo;
import com.crn.GenericLibrary.BaseClass;

public class ContactWithOrganizationName extends BaseClass {
	
	@Test
	public void createContactWithOrgTest() throws Throwable
	{
		
		//read data from excel sheet
		String Orgname = elib.readDataFromExcel("Contacts",1,2)+jlib.getRandomNumber();
		String lastname=elib.readDataFromExcel("Contacts",1,1)+jlib.getRandomNumber();
		
		/*Step 4: Navigate to Organizations Link*/
		HomePage hp=new HomePage(driver);
		hp.Clickorganizationlnk();
		
		OrganizationImgPage oip=new OrganizationImgPage(driver);
		oip.clickOrgImg();
		
		/*Step 5: click on create organization btn*/
		CreateOrganizationPage cop=new CreateOrganizationPage(driver);
		cop.sendkeyInOrgname(Orgname);
		
		OrganizationInfo oi=new OrganizationInfo(driver);
		String header = oi.orgNameInfo();
		if(header.contains(Orgname))
		{
			System.out.println(header);
			System.out.println("org created");
		}
		else
		{
			System.out.println(header);
			System.out.println("Org not created");
		}
		
		hp.Clickcontactalnk();
		CreateContactPage ccp=new CreateContactPage(driver);
		ccp.ClickOnCreateContact();
		
		CreateContactWithOrganizationnamePage ccon=new CreateContactWithOrganizationnamePage(driver);
		ccon.createcontact(driver, lastname, Orgname);
		
		/*Step 10: verify for contact*/
		CreateContactInfo cci=new CreateContactInfo(driver);
		String contactHeader = cci.ContactInfoTxt();
		if(contactHeader.contains(lastname))
		{
			System.out.println(contactHeader);
			System.out.println(" contact created");
		}
		else
		{
			System.out.println("contact not created");
		}
		
		
}

}
