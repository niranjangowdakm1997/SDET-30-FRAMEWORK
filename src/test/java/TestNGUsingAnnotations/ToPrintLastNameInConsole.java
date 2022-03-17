package TestNGUsingAnnotations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.HomePage;
import com.crn.GenericLibrary.BaseClass;

public class ToPrintLastNameInConsole extends BaseClass {
	
	@Test
	
	public void toPrintLastName()
	{
		HomePage hp=new HomePage(driver);
		hp.Clickcontactalnk();
		Reporter.log("clicked on ContactLnk",true);
		
		List<WebElement> ele = driver.findElements(By.xpath("//table[@class='lvtBg']/tbody/tr[*]/td[1]//a[@title='Contacts']"));
		
		for (WebElement sh: ele) 
		{
			String text = sh.getText();
			System.out.println(text);
		}
		
	}

}
