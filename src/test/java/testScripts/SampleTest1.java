package testScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class SampleTest1 {
	
	WebDriver driver;
	
	@Parameters("browser")
	@BeforeMethod
	public void setUp(String strBrowser) {
		
		if(strBrowser.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();	
		}
		else if (strBrowser.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		  
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		  driver.get("https://www.google.com/");
	}
	  @Test(retryAnalyzer = RetryAnalyzer.class)
	  public void searchCypress() {

		  driver.manage().window().maximize();
		  WebElement srcBox = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
		  srcBox.sendKeys("Cypress");
		  srcBox.sendKeys(Keys.ENTER);
		  Assert.assertEquals(driver.getTitle(), "Cypress - Google Search page");
		  
	  }
	  @AfterMethod
	  public void tearDown() {
		  driver.close();
	  }
}
