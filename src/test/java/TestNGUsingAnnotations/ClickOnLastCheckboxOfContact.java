package TestNGUsingAnnotations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.HomePage;
import com.crn.GenericLibrary.BaseClass;

@Listeners(com.crn.GenericLibrary.ITestListenerImplementationClass.class)
public class ClickOnLastCheckboxOfContact extends BaseClass {
	
	@Test
	
	public void ClickOnLastCheckBox()
	{
		HomePage hp=new HomePage(driver);
		hp.Clickcontactalnk();
		Reporter.log("clicked on ContactLnk",true); 
		
	  WebElement ele = driver.findElement
	 (By.xpath("//a[text()='Gowda286']/parent::td[1]/preceding-sibling::td[3]"));
	  
	  Assert.fail();
	  
	  wlib.scrollAction(driver, ele);
	  ele.click();
	  
	 Reporter.log("elment checked at last",true);
		
	}

}
