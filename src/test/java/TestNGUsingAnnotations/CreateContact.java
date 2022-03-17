package TestNGUsingAnnotations;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.CreateContactPage;
import com.crm.ObjectRepository.HomePage;
import com.crn.GenericLibrary.BaseClass;

@Listeners(com.crn.GenericLibrary.ITestListenerImplementationClass.class)
public class CreateContact extends BaseClass {
	
    @Test(groups = "smoke suite")
	
	public void contactsLinksTest() throws Throwable
	{
		
			    //read the data from excel
			    String orgna = elib.readDataFromExcel("Contacts",1,1);
			    
			    
			    
				HomePage hp=new HomePage(driver);
				hp.Clickcontactalnk();
				Reporter.log("clicked on ContactLnk");
			
				CreateContactPage cp=new CreateContactPage(driver);
				cp.ClickOnCreateContact();
				
				Assert.fail();
				
				cp.SendkeyLastname(orgna);
				Reporter.log("contact Created");
				
	}

}
