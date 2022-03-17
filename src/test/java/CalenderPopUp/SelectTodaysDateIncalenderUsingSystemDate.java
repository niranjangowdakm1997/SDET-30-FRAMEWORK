package CalenderPopUp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SelectTodaysDateIncalenderUsingSystemDate {
	
	@Test
	
	public void selectTodaysDate()
	{    
		/*String MonthandYear="March 2022";
		DateFormat d=new SimpleDateFormat("d");
		Date date=new Date();
		String newDate = d.format(date);
		String d1 = date.toString();
		String[] d2 = newDate.split(" ");
		
		String day = d2[0];
		System.out.println(day);*/
		
		WebDriver driver=new ChromeDriver();
	    driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		
		Actions actions=new Actions(driver);
		actions.moveByOffset(10,10).click().perform();
		
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		
		String datexpath="//div[@aria-label='Thu Mar 10 2022']";
		driver.findElement(By.xpath(datexpath)).click();
		
		driver.quit(); 
		}

}
