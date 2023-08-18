package testScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleTest1 {
	  @Test
	  public void searchCypress() {
		  WebDriver driver = new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		  driver.get("https://www.google.com/");
		  driver.manage().window().maximize();
		  WebElement srcBox = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
		  srcBox.sendKeys("Cypress");
		  srcBox.sendKeys(Keys.ENTER);
		  Assert.assertEquals(driver.getTitle(), "Cypress - Google Search");
		 
	  }
}
