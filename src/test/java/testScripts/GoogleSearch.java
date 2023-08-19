package testScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class GoogleSearch {
	WebDriver driver;

	//@BeforeMethod
	@BeforeTest
	public void launchGoogle() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
	}

	@Test(priority =0)
	public void searchJava() {
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(driver.getTitle(),"Google Page");
		WebElement srcBox = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
		srcBox.clear();
		srcBox.sendKeys("Java Tutorials");
		srcBox.sendKeys(Keys.ENTER);
		softassert.assertEquals(driver.getTitle(), "Java Tutorials - Google Search");
		softassert.assertAll();
	}
	@Test(priority =1)
	public void searchAppium() {
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(driver.getTitle(),"Google Page");
		WebElement srcBox = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
		srcBox.clear();
		srcBox.sendKeys("Appium Tutorials");
		srcBox.sendKeys(Keys.ENTER);
		softassert.assertEquals(driver.getTitle(), "Appium Tutorials - Google Search");
		softassert.assertAll();
	}
	@Test(priority = 2)
	public void searchCucumber() {
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(driver.getTitle(),"Google Page");
		WebElement srcBox = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
		srcBox.clear();
		srcBox.sendKeys("Cucumber Tutorials");
		srcBox.sendKeys(Keys.ENTER);
		softassert.assertEquals(driver.getTitle(), "Cucumber Tutorials - Google Search");
		softassert.assertAll();
	}
	@Test(enabled=false)
	public void searchSelenium() {
		WebElement srcBox = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
		srcBox.clear();
		srcBox.sendKeys("Selenium Tutorials");
		srcBox.sendKeys(Keys.ENTER);
		Assert.assertEquals(driver.getTitle(), "selenium Tutorials - Google Search");

	}
	//@AfterMethod
	@AfterTest
	public void tearDown() {
		driver.close(); 
	}
}
