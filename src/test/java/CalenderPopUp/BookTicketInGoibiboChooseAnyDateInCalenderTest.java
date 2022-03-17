package CalenderPopUp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class BookTicketInGoibiboChooseAnyDateInCalenderTest {
	
	@Test
	
	public void bookTicketInGoibibo()
	{
		String MonthandYear="March 2022";
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.goibibo.com/flights/");
		
		Actions actions=new Actions(driver);
		actions.moveByOffset(10,10).click().perform();
		
	    driver.findElement(By.xpath("//span[text()='From']/parent::div[@class='sc-bkkeKt gAqCbJ fswFld ']")).click();

		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Bangalore");
		driver.findElement(By.xpath("//span[@class='autoCompleteTitle ']")).click();
		
		
		driver.findElement(By.xpath("//div[@class='sc-cidDSM dOEpbS']//input[@type='text']")).sendKeys("Del");
		driver.findElement(By.xpath("//span[@class='autoCompleteTitle ']")).click();
		
		String departure="//div[@class='sc-bkkeKt gAqCbJ fswFld ']/parent::div[@class='sc-jJoQJp iPfLQ']";
		driver.findElement(By.xpath(departure)).click();
		
		for(;;) {
		try {
		driver.findElement(By.xpath("//div[@class='DayPicker-Months']/ancestor::div[@class='DayPicker-wrapper']/descendant::div[text()='"+MonthandYear+"']")).click();
		break;
		
	}
      catch(Exception e)
		{
    	  driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
    	  driver.findElement(By.xpath("//span[text()='Done']")).click();
		}
		}
        driver.findElement(By.xpath("//span[text()='Done']")).click();
		
	    driver.findElement(By.xpath("//a[@class='sc-dtMgUX daltrV']")).click();
		
		driver.quit();
}
}
