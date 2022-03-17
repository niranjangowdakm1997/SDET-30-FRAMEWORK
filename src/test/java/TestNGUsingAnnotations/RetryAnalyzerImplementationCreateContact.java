package TestNGUsingAnnotations;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.ObjectRepository.CreateContactPage;
import com.crm.ObjectRepository.HomePage;
import com.crn.GenericLibrary.BaseClass;

@Listeners(com.crn.GenericLibrary.ITestListenerImplementationClass.class)

public class RetryAnalyzerImplementationCreateContact extends BaseClass{
	
	 @Test(retryAnalyzer = com.crn.GenericLibrary.RetryAnalyzerImplementation.class)
		
		public void contactsLinksTest() throws Throwable
		{
			
				    //read the data from excel
				    String orgna = elib.readDataFromExcel("Contacts",1,1);
				    
				    SoftAssert sa=new SoftAssert();
				    
					HomePage hp=new HomePage(driver);
					hp.Clickcontactalnk();
					String expHeader="Contacts";
					String actHeader=driver.findElement(By.xpath("//a[@class='hdrLink']")).getText();
				    sa.assertEquals(actHeader, expHeader);
				    System.out.println("clicking on contact");
				    
					
					CreateContactPage cp=new CreateContactPage(driver);
					cp.ClickOnCreateContact();
					String expHeader1="Creating New Contact";
					String actHeader1=driver.findElement(By.xpath("//span[text()='Creating New Contact']")).getText();
					Assert.assertEquals(actHeader1,expHeader1);
					Reporter.log("Creating new contact",true);
					
					cp.SendkeyLastname(orgna);
					Reporter.log("contact Created",true);
					
					
		}

}
