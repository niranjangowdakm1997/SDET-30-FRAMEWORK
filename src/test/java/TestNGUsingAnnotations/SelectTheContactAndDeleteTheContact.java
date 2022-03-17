package TestNGUsingAnnotations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.HomePage;
import com.crn.GenericLibrary.BaseClass;

public class SelectTheContactAndDeleteTheContact extends BaseClass {

	
	@Test
	
	public void deleteTheContact()
	{
		HomePage hp=new HomePage(driver);
		hp.Clickcontactalnk();
		Reporter.log("clicked on ContactLnk",true);
		
		driver.findElement(By.xpath("//table[@class='lvtBg']/tbody/tr[*]/td[1]//input[@id='7']")).click();
		Reporter.log("element got checked successfully");
		
		  WebElement ele = driver.findElement
		(By.xpath("//table[@class='lvtBg']/tbody/tr[*]/td[1]//a[@href='javascript:confirmdelete(\"index.php%3Fmodule%3DContacts%26action%3DDelete%26record%3D6%26return_module%3DContacts%26return_action%3Dindex%26parenttab%3DMarketing%26return_viewname%3D7\")']"));
		ele.click();
		
		wlib.acceptAlert(driver);
		
		Reporter.log("contact deleted successfully",true);
		
	}
}
