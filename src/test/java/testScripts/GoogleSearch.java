package testScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleSearch {
	WebDriver driver;

	@BeforeMethod
	public void launchGoogle() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
	}

	@Test
	public void searchJava() {
		WebElement srcBox = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
		srcBox.sendKeys("Java Tutorials");
		srcBox.sendKeys(Keys.ENTER);
		Assert.assertEquals(driver.getTitle(), "Java Tutorials - Google Search");

	}
	@Test
	public void searchSelenium() {
		WebElement srcBox = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
		srcBox.sendKeys("Selenium Tutorials");
		srcBox.sendKeys(Keys.ENTER);
		Assert.assertEquals(driver.getTitle(), "Selenium Tutorials - Google Search");

	}
	@AfterMethod
	public void tearDown() {
		driver.close(); 
	}
}
