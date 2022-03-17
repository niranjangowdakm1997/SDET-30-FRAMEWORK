package TestNGUsingAnnotations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.HomePage;
import com.crn.GenericLibrary.BaseClass;


@Listeners(com.crn.GenericLibrary.ITestListenerImplementationClass.class)
public class ContactCheckBoxes extends BaseClass {
	
	@Test
	
	public void checkBoxClick() throws Throwable
	{
		 
		HomePage hp=new HomePage(driver);
		hp.Clickcontactalnk();
		Reporter.log("clicked on ContactLnk",true);
		 
		Assert.fail();
		
		List<WebElement> ele = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input[@name='selected_id']"));
		
		
		for ( WebElement de : ele)
		{
			de.click();
			Thread.sleep(1000);
		}
	
	}

}
