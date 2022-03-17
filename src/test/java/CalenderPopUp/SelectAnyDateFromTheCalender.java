package CalenderPopUp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SelectAnyDateFromTheCalender {
	
	@Test
	
	public void selectAnyDateFromCalender()
	{
		String date="12";
		String MonthandYear="June 2022";
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		Actions actions=new Actions(driver);
		actions.moveByOffset(10,10).click().perform();
		
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		
		String arrowpath="//span[@aria-label='Next Month']";
		String datexpath="//div[text()='"+MonthandYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='12']";
		
		for(;;)
		{
		try {
		driver.findElement(By.xpath(datexpath)).click();
		break;
		
		}
		catch(Exception e){
			
		driver.findElement(By.xpath(arrowpath)).click();
		}
		}
		driver.quit();
	}

}
